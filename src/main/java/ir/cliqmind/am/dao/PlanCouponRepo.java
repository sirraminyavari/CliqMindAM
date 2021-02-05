package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.PlanCoupon;
import ir.cliqmind.am.domain.PlanCouponId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanCouponRepo extends JpaRepository<PlanCoupon, PlanCouponId> {

}
