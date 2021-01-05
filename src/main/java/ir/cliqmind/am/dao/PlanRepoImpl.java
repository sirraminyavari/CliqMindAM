package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Feature;
import ir.cliqmind.am.domain.Plan;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlanRepoImpl implements PlanRepoCustom {

    private static final Logger log = LoggerFactory.getLogger(PlanRepoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Plan add(Plan plan) {
        log.debug("addPlan");
        Session session = em.unwrap(Session.class);

        Integer id = (Integer) session.save(plan);
        plan.setId(id);

        setFeatures(session, plan);

        setPrice(session, plan);

        return plan;
    }

    @Transactional
    @Override
    public void edit(Plan plan) {
        log.debug("editPlan id = {}", plan.getId());
        Session session = em.unwrap(Session.class);

        setFeatures(session, plan);

        setPrice(session, plan);

        session.update(plan);
    }

    @Transactional
    @Override
    public void setFeatures(Plan plan) {
        Session session = em.unwrap(Session.class);
        setFeatures(session, plan);
    }

    @Transactional
    @Override
    public void setPrice(Plan plan) {
        Session session = em.unwrap(Session.class);
        setPrice(session, plan);
    }

    private void setFeatures(Session session, Plan plan){
        log.debug("setPlanFeatures id = {} features = {}", plan.getId(), plan.getPlanFeatures());
        Plan currentPlan = em.getReference(Plan.class, plan.getId());
        em.createQuery("DELETE FROM PlanFeature pf WHERE pf.plan=:plan")
                .setParameter("plan", plan)
                .executeUpdate();
        if(plan.getPlanFeatures()!=null){
            plan.getPlanFeatures().forEach(pf -> {
                pf.setPlan(currentPlan);
                pf.setFeature(em.getReference(Feature.class, pf.getId().getFeatureId()));
                session.saveOrUpdate(pf);
            });
        }
    }

    private void setPrice(Session session, Plan plan){
        log.debug("setPlanPrice id = {} price = {}", plan.getId(), plan.getPlanPrice());
        em.createQuery("DELETE FROM PlanPrice pp WHERE pp.plan=:plan")
                .setParameter("plan", plan)
                .executeUpdate();
        if (plan.getPlanPrice() != null) {
            plan.getPlanPrice().forEach(pp -> {
                pp.setPlan(plan);
                session.saveOrUpdate(pp);
            });
        }
    }
}
