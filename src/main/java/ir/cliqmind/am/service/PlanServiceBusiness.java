package ir.cliqmind.am.service;

import ir.cliqmind.am.domain.*;
import ir.cliqmind.am.dto.CalculatePlanPriceRequest;
import ir.cliqmind.am.error.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class PlanServiceBusiness {

    private static final Logger log = LoggerFactory.getLogger(PlanServiceBusiness.class);

    public double calculatePrice(CalculatePlanPriceRequest body, Plan plan, Iterable<Coupon> coupons, List<PlanActivationHistory> activatedPlans){
        boolean useSecondaryPrice = Optional.ofNullable(body.isUseSecondaryPrice()).orElse(false);
        Integer amount = body.getAmount();
        String currency = body.getCurrency();
        UUID ownerId = body.getOwnerId();
        int durationInMonths = plan.getDurationInMonths();
        AtomicReference<Integer> diffDay = new AtomicReference<>();
        Date today = today();
        if(useSecondaryPrice && plan.getPlanPrice()!=null){
            AtomicReference<Boolean> checked = new AtomicReference<>(false);
            plan.getPlanPrice().forEach(pp -> {
                log.debug("calculatePrice, plan price = {}", pp);
                if(!isAnyNull(pp.getSecondaryPrice(), pp.getSecondaryPriceExpirationDate(),
                        pp.getSecondaryPriceFirstDate())){
                    log.debug("calculatePrice, plan price is not null");
                    if(dateIsInRange(today, pp.getSecondaryPriceFirstDate(), pp.getSecondaryPriceExpirationDate())){
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
            if(fetchedCouponsSize.get() !=body.getCoupons().size()){
                throw new ValidationException("Invalid coupons, some coupons does not exist");
            }
            for(Coupon c : coupons){
                validate(c, currency, ownerId);
                log.debug("coupon validated : {}", c.getCode());

                if(!c.getAllowSecondaryPrice()){
                    useSecondaryPrice = false;
                }
            }
            if(fetchedCouponsSize.get() > 1){
                coupons.forEach(c -> {
                    if(!Optional.ofNullable(c.getAllowConcurrentCoupons()).orElse(true)){
                        throw new ValidationException(String.format("Invalid concurrent coupon %s", c.getCode()));
                    }
                });
            }
            log.debug("check coupons successfully, coupons fetched size = {}", fetchedCouponsSize.get());
        }
        if(amount!=null && amount > plan.getMaximumAmount()){
            throw new ValidationException(String.format("Invalid amount %s for plan %s", amount, plan.getId()));
        }
        if(activatedPlans!=null && plan.getPlanFeatures()!=null){
            activatedPlans.forEach(ap -> {
                if(featureIsIn(plan.getPlanFeatures(), ap.getPlan().getPlanFeatures())){
                    throw new ValidationException(String.format("a feature is already activated in %s", ap.getPlan().getName()));
                }
                if(ap.getExpirationDate().after(today)){
                    diffDay.set(Math.min(
                            diffDay(ap.getExpirationDate(), today),
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
                    if (dateIsInRange(today, planPrice.getSecondaryPriceFirstDate(),
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
            for(Coupon coupon : coupons){
                
            }
        }
        return totalPrice;
    }

    private boolean featureIsIn(List<PlanFeature> l1, List<PlanFeature> l2) {
        List<Integer> features = l1.stream().map(pf -> pf.getId().getFeatureId()).collect(Collectors.toList());
        return l2.stream().map(pf -> pf.getId().getFeatureId()).anyMatch(id -> features.contains(id));
    }

    private void validate(Coupon c, String currency, UUID ownerId) {
        Date today = today();
        if(today.after(c.getExpirationDate())) {
            throw new ValidationException(String.format("coupon is expired %s - code = %s", c.getExpirationDate(), c.getCode()));
        }
        if(!StringUtils.equals(c.getCurrency(), currency)){
            throw new ValidationException(String.format("coupon differs in currency %s - code = %s", currency, c.getCode()));
        }
        if(c.getTargetUsers()!=null){
            log.debug("validating coupon target users");
            if(!c.getTargetUsers().contains(ownerId)){
                throw new ValidationException(String.format("coupon differs does not belong to owner %s - code = %s", ownerId, c.getCode()));
            }
        }
        if(c.getPlans()!=null){
            log.debug("validating coupon plans");
            c.getPlans().forEach(p->{
                if(p.getDeny()){
                    throw new ValidationException(String.format("coupon is denied to be dedicated to this plan - code = %s", ownerId, c.getCode()));
                }
            });
        }
    }

    private boolean dateIsInRange(Date date, Date start, Date end) {
        if(start == null && end == null){
            return true;
        }
        if(start==null){
            return date.equals(end) || date.before(end);
        }
        if(end == null){
            return date.equals(start) || date.after(start);
        }
        return date.equals(start) || date.equals(end) || (date.after(start) && date.before(end);
    }

    private boolean isAnyNull(Object ... objs){
        for(Object o : objs){
            if(o==null){
                return true;
            }
        }
        return false;
    }

    private Date today(){
        Date today = new Date(1000 * (System.currentTimeMillis() / 1000));
        today.setHours(0);
        today.setMinutes(0);
        today.setSeconds(0);
        return today;
    }

    private int diffDay(Date d1, Date d2){
        return Math.abs((int) ((d1.getTime() - d2.getTime()) / MILLIS_IN_DAY));
    }

    private final static long MILLIS_IN_DAY = 24 * 60 * 60 * 1000;

}
