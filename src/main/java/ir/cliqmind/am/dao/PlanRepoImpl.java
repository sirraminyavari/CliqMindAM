package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Feature;
import ir.cliqmind.am.domain.Plan;
import ir.cliqmind.am.domain.PlanFeature;
import ir.cliqmind.am.domain.PlanFeatureId;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PlanRepoImpl implements PlanRepoCustom {

    private static final Logger log = LoggerFactory.getLogger(PlanRepoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void edit(Plan plan) {
        Session session = em.unwrap(Session.class);

        Plan currentPlan = em.getReference(Plan.class, plan.getId());

        em.createQuery("DELETE FROM PlanFeature pf WHERE pf.plan=:plan")
                .setParameter("plan", plan)
                .executeUpdate();

        em.createQuery("DELETE FROM PlanPrice pp WHERE pp.plan=:plan")
                .setParameter("plan", plan)
                .executeUpdate();

        if(plan.getPlanFeatures()!=null){
            plan.getPlanFeatures().forEach(pf -> {
                pf.setPlan(currentPlan);
                pf.setFeature(em.getReference(Feature.class, pf.getId().getFeatureId()));
                session.saveOrUpdate(pf);
            });
        }

        if(plan.getPlanPrice()!=null){
            plan.getPlanPrice().forEach(pp -> {
                pp.setPlan(plan);
                session.saveOrUpdate(pp);
            });
        }

        session.update(plan);
    }
}
