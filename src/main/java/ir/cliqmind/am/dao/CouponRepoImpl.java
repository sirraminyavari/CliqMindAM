package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Coupon;
import ir.cliqmind.am.domain.Plan;
import ir.cliqmind.am.domain.PlanCoupon;
import ir.cliqmind.am.domain.PlanCouponId;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CouponRepoImpl implements CouponRepoCustom {

    private static final Logger log = LoggerFactory.getLogger(CouponRepoImpl.class);

    @PersistenceContext
    private EntityManager em;

    private final static String GET_COUPON_ID_SQL = "SELECT c.code, p.plan_id, p.deny FROM coupons AS c LEFT OUTER JOIN coupon_target_users AS u ON u.code=c.code LEFT OUTER JOIN coupon_target_plans AS p ON p.code=c.code WHERE %s";

    @Override
    public Map<String, List<PlanCoupon>> getIds(ir.cliqmind.am.dto.GetCouponsRequest request){

        List<String> where = new ArrayList<>();

        Optional.ofNullable(request.getCode()).ifPresent(p -> where.add(String.format("c.code='%s'", p)));
        Optional.ofNullable(request.getCurrency()).ifPresent(p -> where.add(String.format("c.currency='%s'", p)));
        Optional.ofNullable(request.isPercentageBased()).ifPresent(p -> where.add(String.format("c.percentage_based=%s", p)));
        Optional.ofNullable(request.getFromAmount()).ifPresent(p -> where.add(String.format("c.amount>=%s", p)));
        Optional.ofNullable(request.getToAmount()).ifPresent(p -> where.add(String.format("c.amount<%s", p)));
        Optional.ofNullable(request.getFromDate()).ifPresent(p -> where.add(String.format("c.time>='%s'", p)));
        Optional.ofNullable(request.getToDate()).ifPresent(p -> where.add(String.format("c.time<'%s'", p)));
        Optional.ofNullable(request.getTargetUser()).ifPresent(p -> where.add(String.format("u.target_id='%s'", p)));

        List<String> where2 = new ArrayList<>();
        Optional.ofNullable(request.getExceptPlan()).ifPresent(p -> where2.add(String.format("p.plan_id=%s AND p.deny=%s", p, "true")));
        Optional.ofNullable(request.getLimitedToPlan()).ifPresent(p -> where2.add(String.format("p.plan_id=%s AND p.deny=%s", p, "false")));
        if(where2.size() > 0) {
            where.add(where2.stream().collect(Collectors.joining(" OR ")));
        }

        String sql = String.format(GET_COUPON_ID_SQL,
                where.stream().collect(Collectors.joining(" AND ")));

        Query q = em.createNativeQuery(sql);
        Map<String, List<PlanCoupon>> resultList = new HashMap<>();
        q.getResultList().forEach(r -> {
            Object[] a = (Object[])r;
            String code = (String) a[0];
            PlanCoupon pc = new PlanCoupon();
            PlanCouponId pcid = new PlanCouponId();
            pcid.setPlanId((Integer) a[1]);
            pcid.setCouponCode(code);
            pc.setId(pcid);
            pc.setDeny((Boolean) a[2]);
            List<PlanCoupon> l = resultList.get(code);
            if(l == null){
                l = new ArrayList<>();
            }
            l.add(pc);
            resultList.put(code, l);
        });
        log.debug("getIds , size = {}", resultList.size());
        return resultList;
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
