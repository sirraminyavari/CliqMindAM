package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Coupon;
import ir.cliqmind.am.domain.PlanCoupon;

import java.util.List;
import java.util.Map;

public interface CouponRepoCustom {

    Map<String, List<PlanCoupon>> getIds(ir.cliqmind.am.dto.GetCouponsRequest body);

    void add(Coupon coupon);

    void edit(Coupon coupon);

}
