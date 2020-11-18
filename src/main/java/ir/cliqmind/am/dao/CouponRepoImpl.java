package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Coupon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponRepoImpl implements CouponRepoCustom {

    public List<Coupon> get(ir.cliqmind.am.dto.GetCouponsRequest body){
        return null;
    }

    @Override
    public void add(Coupon coupon) {

    }

    @Override
    public void edit(Coupon coupon) {

    }

}
