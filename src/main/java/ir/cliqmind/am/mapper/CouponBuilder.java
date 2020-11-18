package ir.cliqmind.am.mapper;

import java.util.List;

public class CouponBuilder {

    public ir.cliqmind.am.domain.Coupon addEdit(ir.cliqmind.am.dto.UpsertCouponRequest input) {
        ir.cliqmind.am.domain.Coupon result = new ir.cliqmind.am.domain.Coupon();
        result.setCode(input.getCode());
        result.setAllowConcurrentCoupons(input.isAllowConcurrentCoupons());
        result.setAllowSecondaryPrice(input.isAllowSecondaryPrice());
        result.setAmount(input.getAmount());
        result.setCurrency(input.getCurrency());
        result.setExpirationDate(DateMapper.convertDate(input.getExpirationDate()));
        result.setMaximumAmount(input.getMaximumAmount());
        result.setMaximumUsageLimit(input.getMaximumUsageLimit());
        result.setMaximumUsageLimitPerUser(input.getMaximumUsageLimitPerUser());
        result.setPercentageBased(input.isPercentageBased());
        result.setTime(DateMapper.now());
        return result;
    }

    public ir.cliqmind.am.dto.GetCouponsResponse get(List<ir.cliqmind.am.domain.Coupon> input) {
        ir.cliqmind.am.dto.GetCouponsResponse result = new ir.cliqmind.am.dto.GetCouponsResponse();
        return result;
    }

    public ir.cliqmind.am.dto.GenerateCouponCodeResponse generate(String code){
        return new ir.cliqmind.am.dto.GenerateCouponCodeResponse()
                .code(code);
    }

}
