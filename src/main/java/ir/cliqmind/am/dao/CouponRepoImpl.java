package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Coupon;
import ir.cliqmind.am.domain.Feature;
import ir.cliqmind.am.domain.Plan;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CouponRepoImpl implements CouponRepoCustom {

    private static final Logger log = LoggerFactory.getLogger(CouponRepoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Coupon> get(ir.cliqmind.am.dto.GetCouponsRequest body){
        return null;
    }

    @Transactional
    @Override
    public void add(Coupon coupon) {
        log.debug("addCoupon id = {}", coupon.getCode());
        upsert(coupon, false);
    }

    @Transactional
    @Override
    public void edit(Coupon coupon) {
        log.debug("editCoupon id = {}", coupon.getCode());
        upsert(coupon, true);
    }

    private void upsert(Coupon coupon, boolean update){
        Session session = em.unwrap(Session.class);

        Coupon currentCoupon = em.getReference(Coupon.class, coupon.getCode());

        em.createQuery("DELETE FROM PlanCoupon pc WHERE pc.coupon=:coupon")
                .setParameter("coupon", coupon)
                .executeUpdate();

        if(update) {
            session.update(coupon);
        }
        else{
            session.save(coupon);
        }
        
        if(coupon.getPlans()!=null){
            coupon.getPlans().forEach(pc -> {
                pc.setCoupon(currentCoupon);
                pc.setPlan(em.getReference(Plan.class, pc.getId().getPlanId()));
                session.saveOrUpdate(pc);
            });
        }

    }

}
