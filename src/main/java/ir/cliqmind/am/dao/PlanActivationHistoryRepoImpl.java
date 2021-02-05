package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.*;
import ir.cliqmind.am.dto.GetPlanActivationHistoryRequest;
import ir.cliqmind.am.dto.RenewPlansRequest;
import ir.cliqmind.am.dto.UpradePlanRequest;
import ir.cliqmind.am.error.ValidationException;
import ir.cliqmind.am.service.PlanServiceBusiness;
import ir.cliqmind.am.utils.DateUtil;
import ir.cliqmind.am.utils.RandomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class PlanActivationHistoryRepoImpl implements PlanActivationHistoryRepoCustom {

    private static final Logger log = LoggerFactory.getLogger(PlanActivationHistoryRepoImpl.class);

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private PlanActivationHistoryRepo planActivationHistoryRepo;

    @Autowired
    private PlanServiceBusiness planServiceBusiness;

    private RandomGenerator randomGenerator;

    @PostConstruct
    public void init(){
        randomGenerator = new RandomGenerator();
    }

    @Transactional
    @Override
    public Transaction performBuyTransaction(ir.cliqmind.am.dto.BuyPlanRequest buyPlanRequest, Plan plan, LocalDate expirationDate) {
        Transaction transaction = new Transaction();
        transaction.setDeposit(false);
        transaction.setUserId(buyPlanRequest.getUserId());
        transaction.setTransactionCode(randomGenerator.generateAlphaNumeric(10));
        double price = planServiceBusiness.calculatePrice(
                new ir.cliqmind.am.dto.CalculatePlanPriceRequest()
                .coupons(buyPlanRequest.getCoupons())
                .amount(buyPlanRequest.getAmount())
                .currency(buyPlanRequest.getCurrency())
                .ownerId(buyPlanRequest.getOwnerId())
                .planId(buyPlanRequest.getPlanId())
                .useSecondaryPrice(buyPlanRequest.isUseSecondaryPrice())
                , plan
        );
        log.debug("calculated price = {}", price);
        transaction.setAmount(price);
        transaction.setCurrency(buyPlanRequest.getCurrency());
        transaction.setType(Transaction.TransactionType.BUY);
        transaction.setTime(Instant.now());
        if(buyPlanRequest.getCoupons()!=null && buyPlanRequest.getCoupons().size()>0) {
            List<Coupon> coupons = couponRepo.find(buyPlanRequest.getCoupons());
            if(coupons==null || coupons.size()!=buyPlanRequest.getCoupons().size()){
                throw new ValidationException("there are some invalid coupons in the request");
            }
            transaction.setCoupons(coupons);
        }
        transaction = transactionRepo.save(transaction);

        LocalDate today = LocalDate.now();
        LocalDate expiration = (expirationDate == null ?
                DateUtil.addMonth(today, plan.getDurationInMonths()) : expirationDate);

        PlanActivationHistory planActivationHistory = new PlanActivationHistory();
        planActivationHistory.setActivatedBy(buyPlanRequest.getUserId());
        planActivationHistory.setAmount(buyPlanRequest.getAmount());
        planActivationHistory.setStartDate(today);
        planActivationHistory.setExpirationDate(expiration);
        planActivationHistory.setOwnerId(buyPlanRequest.getOwnerId());
        planActivationHistory.setTime(Instant.now());
        planActivationHistory.setTransactionId(transaction.getId());
        planActivationHistory.setPlan(plan);
        planActivationHistoryRepo.save(planActivationHistory);

        return transaction;
    }

    @Override
    public Transaction performRenewTransaction(RenewPlansRequest renewPlansRequest, List<Plan> plans, List<PlanActivationHistory> activatedPlans) {
        Transaction transaction = new Transaction();
        transaction.setDeposit(false);
        transaction.setUserId(renewPlansRequest.getUserId());
        transaction.setTransactionCode(randomGenerator.generateAlphaNumeric(10));
        double price = planServiceBusiness.calculateRenewalPrice(
                new ir.cliqmind.am.dto.CalculatePlanRenewalPriceRequest()
                        .coupons(renewPlansRequest.getCoupons())
                        .plans(renewPlansRequest.getPlans())
                        .currency(renewPlansRequest.getCurrency())
                        .ownerId(renewPlansRequest.getOwnerId())
                , plans,
                activatedPlans);
        log.debug("calculated renewal price = {}", price);
        transaction.setAmount(price);
        transaction.setCurrency(renewPlansRequest.getCurrency());
        transaction.setType(Transaction.TransactionType.RENEW);
        transaction.setTime(Instant.now());
        if(renewPlansRequest.getCoupons()!=null && renewPlansRequest.getCoupons().size()>0) {
            List<Coupon> coupons = couponRepo.find(renewPlansRequest.getCoupons());
            if(coupons==null || coupons.size()!=renewPlansRequest.getCoupons().size()){
                throw new ValidationException("there are some invalid coupons in the request");
            }
            transaction.setCoupons(coupons);
        }
        transaction = transactionRepo.save(transaction);
        Long transactionId = transaction.getId();

        LocalDate expiration = Stream.concat(
                Stream.of(LocalDate.now()),
                activatedPlans.stream().map(ap -> ap.getExpirationDate()))
                .max(LocalDate::compareTo).get();

        activatedPlans.forEach(planActivationHistory -> {
            planActivationHistory.setActivatedBy(renewPlansRequest.getUserId());
            planActivationHistory.setExpirationDate(expiration);
            planActivationHistory.setOwnerId(renewPlansRequest.getOwnerId());
            planActivationHistory.setTime(Instant.now());
            planActivationHistory.setTransactionId(transactionId);
            planActivationHistoryRepo.save(planActivationHistory);
        });

        return transaction;
    }

    @Override
    public List<PlanActivationHistory> findAll(GetPlanActivationHistoryRequest body) {
        return planActivationHistoryRepo.findAll(body.getOwnerId(), body.getPlanIds());
    }

    @Override
    public Transaction performUpgradeTransaction(UpradePlanRequest upradePlanRequest, Plan planFrom, Plan planTo, List<PlanActivationHistory> activatedPlans) {
        Transaction transaction = new Transaction();
        transaction.setDeposit(false);
        transaction.setUserId(upradePlanRequest.getUserId());
        transaction.setTransactionCode(randomGenerator.generateAlphaNumeric(10));
        double price = planServiceBusiness.calculateUpgradePrice(
                new ir.cliqmind.am.dto.CalculatePlanUpgradeRequest()
                        .coupons(upradePlanRequest.getCoupons())
                        .fromPlanId(planFrom.getId())
                        .toPlanId(planTo.getId())
                        .currency(upradePlanRequest.getCurrency())
                        .ownerId(upradePlanRequest.getOwnerId())
                , planFrom, planTo,
                activatedPlans);
        log.debug("calculated upgrade price = {}", price);
        transaction.setAmount(price);
        transaction.setCurrency(upradePlanRequest.getCurrency());
        transaction.setType(Transaction.TransactionType.UPGRADE);
        transaction.setTime(Instant.now());
        if(upradePlanRequest.getCoupons()!=null && upradePlanRequest.getCoupons().size()>0) {
            List<Coupon> coupons = couponRepo.find(upradePlanRequest.getCoupons());
            if(coupons==null || coupons.size()!=upradePlanRequest.getCoupons().size()){
                throw new ValidationException("there are some invalid coupons in the request");
            }
            transaction.setCoupons(coupons);
        }
        transaction = transactionRepo.save(transaction);
        Long transactionId = transaction.getId();

        LocalDate expiration = Stream.concat(
                Stream.of(LocalDate.now()),
                activatedPlans.stream().map(ap -> ap.getExpirationDate()))
                .max(LocalDate::compareTo).get();

        activatedPlans.forEach(planActivationHistory -> {
            planActivationHistory.setActivatedBy(upradePlanRequest.getUserId());
            planActivationHistory.setExpirationDate(expiration);
            planActivationHistory.setOwnerId(upradePlanRequest.getOwnerId());
            planActivationHistory.setTime(Instant.now());
            planActivationHistory.setTransactionId(transactionId);
            planActivationHistoryRepo.save(planActivationHistory);
        });

        return transaction;
    }
}
