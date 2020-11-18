package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Coupon;

import java.util.List;

public interface CouponRepoCustom {

    List<Coupon> get(ir.cliqmind.am.dto.GetCouponsRequest body);

    void add(Coupon coupon);

    void edit(Coupon coupon);

}
