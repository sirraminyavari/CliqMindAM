package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.*;
import ir.cliqmind.am.domain.*;
import ir.cliqmind.am.dto.CalculatePlanPriceRequest;
import ir.cliqmind.am.dto.CalculatePlanRenewalPriceRequest;
import ir.cliqmind.am.dto.CalculatePlanUpgradeRequest;
import ir.cliqmind.am.error.NokException;
import ir.cliqmind.am.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class PlanServiceBusiness {

    private static final Logger log = LoggerFactory.getLogger(PlanServiceBusiness.class);

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private PlanPriceRepo planPriceRepo;

    @Autowired
    private PlanFeatureRepo planFeatureRepo;

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private PlanActivationHistoryRepo planActivationHistoryRepo;

    public double calculatePrice(CalculatePlanPriceRequest body, Plan plan){
        Iterable<ir.cliqmind.am.domain.Coupon> coupons = null;
        if(body.getCoupons()!=null && body.getCoupons().size()>0) {
            coupons = couponRepo.findAllByIdAndCurrency(body.getCoupons(), body.getCurrency());
            Map<String, List<PlanCoupon>> mapped =
                    couponRepo.getIds(new ir.cliqmind.am.dto.GetCouponsRequest()
                            .exceptPlan(body.getPlanId())
                            .limitedToPlan(body.getPlanId()));
            log.debug("calculatePlanPrice mappedCoupons = {}", mapped);
            if(mapped!=null && coupons!=null){
                coupons.forEach(c -> {
                    c.setPlans(mapped.get(c.getCode()));
                });
            }
            log.debug("calculatePlanPrice coupons = {}", coupons);
        }
        List<ir.cliqmind.am.domain.PlanActivationHistory> activatedPlans = planActivationHistoryRepo.findByOwnerId(body.getOwnerId());
        log.debug("calculatePlanPrice activated plans = {}", activatedPlans);

        boolean useSecondaryPrice = Optional.ofNullable(body.isUseSecondaryPrice()).orElse(false);
        Integer amount = body.getAmount();
        String currency = body.getCurrency();
        UUID ownerId = body.getOwnerId();
        int durationInMonths = plan.getDurationInMonths();
        AtomicReference<Integer> diffDay = new AtomicReference<>();
        Date today = DateUtil.today();
        if(useSecondaryPrice && plan.getPlanPrice()!=null){
            AtomicReference<Boolean> checked = new AtomicReference<>(false);
            plan.getPlanPrice().forEach(pp -> {
                log.debug("calculatePrice, plan price = {}", pp);
                if(!isAnyNull(pp.getSecondaryPrice(), pp.getSecondaryPriceExpirationDate(),
                        pp.getSecondaryPriceFirstDate())){
                    log.debug("calculatePrice, plan price is not null");
                    if(DateUtil.dateIsInRange(today, pp.getSecondaryPriceFirstDate(), pp.getSecondaryPriceExpirationDate())){
                        log.debug("calculatePrice, plan price is checked with date");
                        checked.set(true);
                    }
                }
            });
            if(!checked.get()){
                log.debug("calculatePrice, ignore use secondary price");
                useSecondaryPrice = false;
            }
        }
        if(!Optional.ofNullable(plan.getEnableAmount()).orElse(false)){
            log.debug("calculatePrice, ignore amount");
            amount = null;
        }
        if(body.getCoupons()!=null){
            AtomicInteger fetchedCouponsSize = new AtomicInteger();
            if(coupons!=null) {
                coupons.forEach(c -> {
                    fetchedCouponsSize.incrementAndGet();
                });
            }
            if(coupons!=null) {
                for (Coupon c : coupons) {
                    validate(c, currency, ownerId);
                    log.debug("coupon validated : {}", c.getCode());

                    if (!c.getAllowSecondaryPrice()) {
                        useSecondaryPrice = false;
                    }
                }
                if (fetchedCouponsSize.get() > 1) {
                    coupons.forEach(c -> {
                        if (!Optional.ofNullable(c.getAllowConcurrentCoupons()).orElse(true)) {
                            throw new NokException(String.format("Invalid concurrent coupon %s", c.getCode()));
                        }
                    });
                }
            }
            log.debug("check coupons successfully, coupons fetched size = {}", fetchedCouponsSize.get());
        }
        if(amount!=null && amount > plan.getMaximumAmount()){
            throw new NokException(String.format("Invalid amount %s for plan %s", amount, plan.getId()));
        }
        if(activatedPlans!=null && plan.getPlanFeatures()!=null){
            activatedPlans.forEach(ap -> {
                if(featureIsIn(plan.getPlanFeatures(), ap.getPlan().getPlanFeatures())){
                    throw new NokException(String.format("a feature is already activated in %s", ap.getPlan().getName()));
                }
                if(ap.getExpirationDate().after(today)){
                    diffDay.set(Math.min(
                            DateUtil.diffDay(ap.getExpirationDate(), today),
                            Optional.ofNullable(diffDay.get()).orElse(Integer.MAX_VALUE)
                    ));
                }
            });
        }
        double totalPrice = 0;
        for(PlanPrice planPrice : plan.getPlanPrice()){
            if(planPrice.getId().getCurrency().equals(currency)) {
                double price = planPrice.getPrice();
                if(useSecondaryPrice) {
                    if (DateUtil.dateIsInRange(today, planPrice.getSecondaryPriceFirstDate(),
                            planPrice.getSecondaryPriceExpirationDate())) {
                        if (planPrice.getSecondaryPrice() != null) {
                            if(planPrice.getSecondaryPrice() < price) {
                                price -= planPrice.getSecondaryPrice();
                            }
                        }
                    }
                }
                totalPrice += price;
            }
        }
        if(coupons!=null){
            double cpercent = 0;
            double camount = 0;
            for(Coupon coupon : coupons){
                if(coupon.getPercentageBased()){
                    cpercent += coupon.getAmount();
                }
                else{
                    camount += coupon.getAmount();
                }
            }
            if(cpercent > 0) {
                totalPrice = totalPrice * (100 - cpercent) / 100;
            }
            if(camount > 0){
                totalPrice = totalPrice - camount;
            }
        }
        return totalPrice;
    }

    public Double calculateRenewalPrice(CalculatePlanRenewalPriceRequest body, List<Plan> plans, List<PlanActivationHistory> activatedPlans) {
        Iterable<ir.cliqmind.am.domain.Coupon> coupons = null;
        List<Integer> planIds = plans.stream().map(p -> p.getId()).collect(Collectors.toList());
        if(body.getCoupons()!=null && body.getCoupons().size()>0) {
            coupons = couponRepo.findAllByIdAndCurrency(body.getCoupons(), body.getCurrency());
            Map<String, List<PlanCoupon>> mapped =
                    couponRepo.getIds(planIds);
            log.debug("calculateRenewalPrice mappedCoupons = {}", mapped);
            if(mapped!=null && coupons!=null){
                coupons.forEach(c -> {
                    c.setPlans(mapped.get(c.getCode()));
                });
            }
            log.debug("calculateRenewalPrice coupons = {}", coupons);
        }
        log.debug("calculateRenewalPrice activated plans = {}", activatedPlans);
        double totalPrice = 0;

        int maxDurationInMonths = plans.stream().map(p -> p.getDurationInMonths()).max(Integer::compareTo).orElse(1);

        for(Plan plan : plans){
            double planTotalPrice = 0;
            Map<String, Object> map = (Map<String, Object>) body.getPlans().get(String.valueOf(plan.getId()));
            boolean useSecondaryPrice = (Boolean) map.getOrDefault("use_secondary_price", false);
            Integer amount = (Integer) map.getOrDefault("amount", 0);
            String currency = body.getCurrency();
            UUID ownerId = body.getOwnerId();
            int durationInMonths = plan.getDurationInMonths();
            AtomicReference<Integer> diffDay = new AtomicReference<>();
            Date today = DateUtil.today();
            if(useSecondaryPrice && plan.getPlanPrice()!=null){
                AtomicReference<Boolean> checked = new AtomicReference<>(false);
                plan.getPlanPrice().forEach(pp -> {
                    log.debug("calculatePrice, plan price = {}", pp);
                    if(!isAnyNull(pp.getSecondaryPrice(), pp.getSecondaryPriceExpirationDate(),
                            pp.getSecondaryPriceFirstDate())){
                        log.debug("calculatePrice, plan price is not null");
                        if(DateUtil.dateIsInRange(today, pp.getSecondaryPriceFirstDate(), pp.getSecondaryPriceExpirationDate())){
                            log.debug("calculatePrice, plan price is checked with date");
                            checked.set(true);
                        }
                    }
                });
                if(!checked.get()){
                    log.debug("calculatePrice, ignore use secondary price");
                    useSecondaryPrice = false;
                }
            }
            if(!Optional.ofNullable(plan.getEnableAmount()).orElse(false)){
                log.debug("calculatePrice, ignore amount");
                amount = null;
            }
            if(body.getCoupons()!=null){
                AtomicInteger fetchedCouponsSize = new AtomicInteger();
                if(coupons!=null) {
                    coupons.forEach(c -> {
                        fetchedCouponsSize.incrementAndGet();
                    });
                }
                if(coupons!=null) {
                    for (Coupon c : coupons) {
                        validate(c, currency, ownerId);
                        log.debug("coupon validated : {}", c.getCode());

                        if (!c.getAllowSecondaryPrice()) {
                            useSecondaryPrice = false;
                        }
                    }
                    if (fetchedCouponsSize.get() > 1) {
                        coupons.forEach(c -> {
                            if (!Optional.ofNullable(c.getAllowConcurrentCoupons()).orElse(true)) {
                                throw new NokException(String.format("Invalid concurrent coupon %s", c.getCode()));
                            }
                        });
                    }
                }
                log.debug("check coupons successfully, coupons fetched size = {}", fetchedCouponsSize.get());
            }
            if(amount!=null && amount > plan.getMaximumAmount()){
                throw new NokException(String.format("Invalid amount %s for plan %s", amount, plan.getId()));
            }
            if(activatedPlans!=null && plan.getPlanFeatures()!=null){
                activatedPlans.forEach(ap -> {
                    if(featureIsIn(plan.getPlanFeatures(), ap.getPlan().getPlanFeatures())){
                        throw new NokException(String.format("a feature is already activated in %s", ap.getPlan().getName()));
                    }
                    if(ap.getExpirationDate().after(today)){
                        diffDay.set(Math.min(
                                DateUtil.diffDay(ap.getExpirationDate(), today),
                                Optional.ofNullable(diffDay.get()).orElse(Integer.MAX_VALUE)
                        ));
                    }
                });
            }
            for(PlanPrice planPrice : plan.getPlanPrice()){
                if(planPrice.getId().getCurrency().equals(currency)) {
                    double price = planPrice.getPrice();
                    if(useSecondaryPrice) {
                        if (DateUtil.dateIsInRange(today, planPrice.getSecondaryPriceFirstDate(),
                                planPrice.getSecondaryPriceExpirationDate())) {
                            if (planPrice.getSecondaryPrice() != null) {
                                if(planPrice.getSecondaryPrice() < price) {
                                    price -= planPrice.getSecondaryPrice();
                                }
                            }
                        }
                    }
                    planTotalPrice += price;
                }
            }
            if(coupons!=null){
                double cpercent = 0;
                double camount = 0;
                for(Coupon coupon : coupons){
                    if(coupon.getPercentageBased()){
                        cpercent += coupon.getAmount();
                    }
                    else{
                        camount += coupon.getAmount();
                    }
                }
                if(cpercent > 0) {
                    planTotalPrice = totalPrice * (100 - cpercent) / 100;
                }
                if(camount > 0){
                    planTotalPrice = totalPrice - camount;
                }
            }
            totalPrice += planTotalPrice * durationInMonths / maxDurationInMonths;
        }

        return totalPrice;
    }

    public Double calculateUpgradePrice(CalculatePlanUpgradeRequest body, Plan planFrom,
                                        Plan planTo, List<PlanActivationHistory> activatedPlans) {
        Iterable<ir.cliqmind.am.domain.Coupon> coupons = null;
        if(body.getCoupons()!=null && body.getCoupons().size()>0) {
            coupons = couponRepo.findAllByIdAndCurrency(body.getCoupons(), body.getCurrency());
            Map<String, List<PlanCoupon>> mapped =
                    couponRepo.getIds(new ir.cliqmind.am.dto.GetCouponsRequest());
            log.debug("calculateUpgradePrice mappedCoupons = {}", mapped);
            if(mapped!=null && coupons!=null){
                coupons.forEach(c -> {
                    c.setPlans(mapped.get(c.getCode()));
                });
            }
            log.debug("calculateUpgradePrice coupons = {}", coupons);
        }

        log.debug("calculateUpgradePrice activated plans = {}", activatedPlans);

        boolean useSecondaryPrice = Optional.ofNullable(body.isUseSecondaryPrice()).orElse(false);
        Integer amount = body.getAmount();
        String currency = body.getCurrency();
        UUID ownerId = body.getOwnerId();
        AtomicReference<Integer> diffDay = new AtomicReference<>();
        Date today = DateUtil.today();
        if(body.getCoupons()!=null){
            AtomicInteger fetchedCouponsSize = new AtomicInteger();
            if(coupons!=null) {
                coupons.forEach(c -> {
                    fetchedCouponsSize.incrementAndGet();
                });
            }
            if(coupons!=null) {
                for (Coupon c : coupons) {
                    validate(c, currency, ownerId);
                    log.debug("coupon validated : {}", c.getCode());

                    if (!c.getAllowSecondaryPrice()) {
                        useSecondaryPrice = false;
                    }
                }
                if (fetchedCouponsSize.get() > 1) {
                    coupons.forEach(c -> {
                        if (!Optional.ofNullable(c.getAllowConcurrentCoupons()).orElse(true)) {
                            throw new NokException(String.format("Invalid concurrent coupon %s", c.getCode()));
                        }
                    });
                }
            }
            log.debug("check coupons successfully, coupons fetched size = {}", fetchedCouponsSize.get());
        }
        double totalPriceNew = 0;
        for(PlanPrice planPrice : planTo.getPlanPrice()){
            if(planPrice.getId().getCurrency().equals(currency)) {
                double price = planPrice.getPrice();
                if(useSecondaryPrice) {
                    if (DateUtil.dateIsInRange(today, planPrice.getSecondaryPriceFirstDate(),
                            planPrice.getSecondaryPriceExpirationDate())) {
                        if (planPrice.getSecondaryPrice() != null) {
                            if(planPrice.getSecondaryPrice() < price) {
                                price -= planPrice.getSecondaryPrice();
                            }
                        }
                    }
                }
                totalPriceNew += price;
            }
        }
        if(coupons!=null){
            double cpercent = 0;
            double camount = 0;
            for(Coupon coupon : coupons){
                if(coupon.getPercentageBased()){
                    cpercent += coupon.getAmount();
                }
                else{
                    camount += coupon.getAmount();
                }
            }
            if(cpercent > 0) {
                totalPriceNew = totalPriceNew * (100 - cpercent) / 100;
            }
            if(camount > 0){
                totalPriceNew = totalPriceNew - camount;
            }
        }
        return totalPriceNew;
    }

    private boolean featureIsIn(List<PlanFeature> l1, List<PlanFeature> l2) {
        List<Integer> features = l1.stream().map(pf -> pf.getId().getFeatureId()).collect(Collectors.toList());
        return l2.stream().map(pf -> pf.getId().getFeatureId()).anyMatch(id -> features.contains(id));
    }

    private void validate(Coupon c, String currency, UUID ownerId) {
        Date today = DateUtil.today();
        if(today.after(c.getExpirationDate())) {
            throw new NokException(String.format("coupon is expired %s - code = %s", c.getExpirationDate(), c.getCode()));
        }
        if(!StringUtils.equals(c.getCurrency(), currency)){
            throw new NokException(String.format("coupon differs in currency %s - code = %s", currency, c.getCode()));
        }
        if(c.getTargetUsers()!=null){
            log.debug("validating coupon target users");
            if(!c.getTargetUsers().contains(ownerId)){
                throw new NokException(String.format("coupon differs does not belong to owner %s - code = %s", ownerId, c.getCode()));
            }
        }
        if(c.getPlans()!=null){
            log.debug("validating coupon plans");
            c.getPlans().forEach(p->{
                if(p.getDeny()){
                    throw new NokException(String.format("coupon is denied to be dedicated to this plan - code = %s", ownerId, c.getCode()));
                }
            });
        }
    }

    private boolean isAnyNull(Object ... objs){
        for(Object o : objs){
            if(o==null){
                return true;
            }
        }
        return false;
    }

}
