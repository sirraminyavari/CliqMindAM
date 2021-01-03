package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "res_pln", path = "res_pln")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface PlanRepo extends CrudRepository<Plan, Integer>, PlanRepoCustom {

    @Transactional(readOnly = true)
    @Query(value = "SELECT p FROM Plan p WHERE (:active IS NULL OR p.active=:active) AND ((:ids) IS NULL OR p.id in (:ids))")
    List<Plan> find(List<Integer> ids, Boolean active);

    @Transactional(readOnly = true)
    @Query(value = "SELECT p.maximumAmount FROM Plan p WHERE p.id in (SELECT pf.id.planId FROM PlanFeature pf WHERE pf.id.featureId in (:ids))")
    List<Integer> findMaximumAmountByFeatureIds(List<Integer> ids);
}
