package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FeatureRepoImpl implements FeatureRepoCustom {

    private static final Logger log = LoggerFactory.getLogger(FeatureRepoImpl.class);

    @PersistenceContext
    private EntityManager em;

    private final String getActiveSql = "SELECT f.id, f.active, f.description, f.name, t.amount FROM features AS f, plan_features AS pf, (SELECT pf.plan_id, SUM(pf.amount) AS amount FROM plan_features AS pf, plan_activation_history AS pah WHERE pah.owner_id = '%s' AND pah.plan_id = pf.plan_id GROUP BY pf.plan_id) AS t WHERE pf.feature_id = f.id AND pf.plan_id=t.plan_id";

    @Override
    @Transactional(readOnly = true)
    public List<Feature> getActive(UUID ownerId) {
        String sql = String.format(getActiveSql, ownerId);
        log.debug("getActiveFeatures , sql = {}", sql);
        Query q = em.createNativeQuery(sql);
        List<Feature> result = new ArrayList<>();
        q.getResultList().forEach(r -> {
            Object[] a = (Object[])r;
            Feature f = new Feature();
            f.setId((Integer)a[0]);
            f.setActive((Boolean) a[1]);
            f.setDescription((String)a[2]);
            f.setName((String)a[3]);
            f.setAmount((Integer)a[4]);
            result.add(f);
        });
        log.debug("getActiveFeatures, size = "+result.size());
        return result;
    }
}
