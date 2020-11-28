package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.*;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

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
    public Transaction performBuyTransaction(ir.cliqmind.am.dto.BuyPlanRequest buyPlanRequest, Plan plan, java.sql.Date expirationDate) {
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
        transaction.setTime(new Timestamp(System.currentTimeMillis()));
        if(buyPlanRequest.getCoupons()!=null && buyPlanRequest.getCoupons().size()>0) {
            List<Coupon> coupons = couponRepo.find(buyPlanRequest.getCoupons());
            if(coupons==null || coupons.size()!=buyPlanRequest.getCoupons().size()){
                throw new ValidationException("there are some invalid coupons in the request");
            }
            transaction.setCoupons(coupons);
        }
        transaction = transactionRepo.save(transaction);

        Date today = DateUtil.todaySql();
        Date expiration = (expirationDate == null ?
                DateUtil.addMonthSql(today, plan.getDurationInMonths()) : expirationDate);

        PlanActivationHistory planActivationHistory = new PlanActivationHistory();
        planActivationHistory.setActivatedBy(buyPlanRequest.getUserId());
        planActivationHistory.setAmount(buyPlanRequest.getAmount());
        planActivationHistory.setStartDate(today);
        planActivationHistory.setExpirationDate(expiration);
        planActivationHistory.setOwnerId(buyPlanRequest.getOwnerId());
        planActivationHistory.setTime(new Timestamp(System.currentTimeMillis()));
        planActivationHistory.setTransactionId(transaction.getId());
        planActivationHistory.setPlan(plan);
        planActivationHistoryRepo.save(planActivationHistory);

        return transaction;
    }
}
