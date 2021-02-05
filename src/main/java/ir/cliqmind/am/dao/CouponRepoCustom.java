package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.PlanCoupon;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CouponRepoCustom {

    Map<String, List<PlanCoupon>> getIds(ir.cliqmind.am.dto.GetCouponsRequest request, Pageable pageable);

    Map<String, List<PlanCoupon>> getIds(List<Integer> planIds);

}
