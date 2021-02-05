package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, String>, CouponRepoCustom {

    @Transactional(readOnly = true)
    @Query(value = "SELECT c FROM Coupon c WHERE c.code in (:ids)")
    List<Coupon> find(List<String> ids);

    @Transactional(readOnly = true)
    @Query(value = "SELECT c FROM Coupon c WHERE c.currency=:currency AND c.code in (:ids)")
    List<Coupon> findAllByIdAndCurrency(List<String> ids, String currency);

    @Transactional(readOnly = true)
    @Query(
            value = "SELECT * FROM coupons WHERE code in (:ids)",
            countQuery = "SELECT COUNT(*) FROM coupons WHERE code in (:ids)",
            nativeQuery = true
    )
    Page<Coupon> findAllByIds(Set<String> ids, Pageable pageable);
}
