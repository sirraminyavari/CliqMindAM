package ir.cliqmind.am.mapper;

import ir.cliqmind.am.dto.AddCouponRequest;
import ir.cliqmind.am.dto.EditCouponRequest;
import ir.cliqmind.am.utils.RandomGenerator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class CouponMapper {

    private RandomGenerator randomGenerator;

    public CouponMapper(){
        randomGenerator = new RandomGenerator();
    }

    public ir.cliqmind.am.domain.Coupon edit(String code, EditCouponRequest input) {
        ir.cliqmind.am.domain.Coupon result = new ir.cliqmind.am.domain.Coupon();
        result.setCode(code);
        result.setAllowConcurrentCoupons(input.isAllowConcurrentCoupons());
        result.setAllowSecondaryPrice(input.isAllowSecondaryPrice());
        result.setAmount(input.getAmount());
        result.setCurrency(input.getCurrency());
        result.setExpirationDate(input.getExpirationDate());
        result.setMaximumAmount(input.getMaximumAmount());
        result.setMaximumUsageLimit(input.getMaximumUsageLimit());
        result.setMaximumUsageLimitPerUser(input.getMaximumUsageLimitPerUser());
        result.setPercentageBased(input.isPercentageBased());
        result.setTime(Instant.now());
        if(input.getLimitToPlans()!=null || input.getExceptPlans()!=null){
            result.setPlans(new ArrayList<>());
            if(input.getLimitToPlans()!=null){
                input.getLimitToPlans().forEach(planId -> {
                    ir.cliqmind.am.domain.PlanCoupon pc = new ir.cliqmind.am.domain.PlanCoupon();
                    pc.setId(new ir.cliqmind.am.domain.PlanCouponId(planId, code));
                    pc.setDeny(false);
                    result.getPlans().add(pc);
                });
            }
            if(input.getExceptPlans()!=null){
                input.getExceptPlans().forEach(planId -> {
                    ir.cliqmind.am.domain.PlanCoupon pc = new ir.cliqmind.am.domain.PlanCoupon();
                    pc.setId(new ir.cliqmind.am.domain.PlanCouponId(planId, code));
                    pc.setDeny(true);
                    result.getPlans().add(pc);
                });
            }
        }
        result.setTargetUsers(input.getTargetUsers());
        return result;
    }

    public ir.cliqmind.am.domain.Coupon add(AddCouponRequest input) {
        String code = input.getCode();
        ir.cliqmind.am.domain.Coupon result = new ir.cliqmind.am.domain.Coupon();
        result.setCode(code);
        result.setAllowConcurrentCoupons(input.isAllowConcurrentCoupons());
        result.setAllowSecondaryPrice(input.isAllowSecondaryPrice());
        result.setAmount(input.getAmount());
        result.setCurrency(input.getCurrency());
        result.setExpirationDate(input.getExpirationDate());
        result.setMaximumAmount(input.getMaximumAmount());
        result.setMaximumUsageLimit(input.getMaximumUsageLimit());
        result.setMaximumUsageLimitPerUser(input.getMaximumUsageLimitPerUser());
        result.setPercentageBased(input.isPercentageBased());
        result.setTime(Instant.now());
        if(input.getLimitToPlans()!=null || input.getExceptPlans()!=null){
            result.setPlans(new ArrayList<>());
            if(input.getLimitToPlans()!=null){
                input.getLimitToPlans().forEach(planId -> {
                    ir.cliqmind.am.domain.PlanCoupon pc = new ir.cliqmind.am.domain.PlanCoupon();
                    pc.setId(new ir.cliqmind.am.domain.PlanCouponId(planId, code));
                    pc.setDeny(false);
                    result.getPlans().add(pc);
                });
            }
            if(input.getExceptPlans()!=null){
                input.getExceptPlans().forEach(planId -> {
                    ir.cliqmind.am.domain.PlanCoupon pc = new ir.cliqmind.am.domain.PlanCoupon();
                    pc.setId(new ir.cliqmind.am.domain.PlanCouponId(planId, code));
                    pc.setDeny(true);
                    result.getPlans().add(pc);
                });
            }
        }
        result.setTargetUsers(input.getTargetUsers());
        return result;
    }

    public ir.cliqmind.am.dto.Coupon coupon(ir.cliqmind.am.domain.Coupon input) {
        return new ir.cliqmind.am.dto.Coupon()
                .code(input.getCode())
                .percentageBased(input.getPercentageBased())
                .amount(input.getAmount())
                .maximumAmount(input.getMaximumAmount())
                .time(input.getTime())
                .expirationDate(input.getExpirationDate())
                .allowConcurrentCoupons(input.getAllowConcurrentCoupons())
                .allowSecondaryPrice(input.getAllowSecondaryPrice())
                .maximumUsageLimit(input.getMaximumUsageLimit())
                .maximumUsageLimitPerUser(input.getMaximumUsageLimitPerUser())
                .targetUsers(input.getTargetUsers())
                .exceptPlans(input.getPlans() == null ? null :
                        input.getPlans().stream().filter(pc -> pc.getDeny()!=null && pc.getDeny())
                                .map(pc -> planCoupon(pc)).collect(Collectors.toList()))
                .limitedToPlans(input.getPlans() == null ? null :
                        input.getPlans().stream().filter(pc -> pc.getDeny()!=null && !pc.getDeny())
                                .map(pc -> planCoupon(pc)).collect(Collectors.toList()));
    }

    public ir.cliqmind.am.dto.Plan planCoupon(ir.cliqmind.am.domain.PlanCoupon input) {
        return new ir.cliqmind.am.dto.Plan()
                .id(input.getId().getPlanId());
    }

    public ir.cliqmind.am.dto.Coupons coupon(Iterable<ir.cliqmind.am.domain.Coupon> input) {
        ir.cliqmind.am.dto.Coupons result = new ir.cliqmind.am.dto.Coupons();
        if(input != null){
            Iterator<ir.cliqmind.am.domain.Coupon> it = input.iterator();
            while(it.hasNext()){
                result.add(coupon(it.next()));
            }
        }
        return result;
    }

    public ir.cliqmind.am.dto.GenerateCouponCodeResponse generate(){
        String code = randomGenerator.generateAlphaNumeric(10);
        return new ir.cliqmind.am.dto.GenerateCouponCodeResponse()
                .code(code);
    }

}
