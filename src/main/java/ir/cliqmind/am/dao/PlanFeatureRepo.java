package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Plan;
import ir.cliqmind.am.domain.PlanFeature;
import ir.cliqmind.am.domain.PlanPrice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "res_pft", path = "res_pft")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface PlanFeatureRepo extends CrudRepository<PlanFeature, Integer> {

    @Transactional(readOnly = false)
    @Query(value = "SELECT pf FROM PlanFeature pf WHERE pf.plan in (:plans)")
    List<PlanFeature> find(Iterable<Plan> plans);

    @Transactional(readOnly = false)
    @Query(value = "SELECT pf FROM PlanFeature pf WHERE pf.plan=:plan")
    List<PlanFeature> find(Plan plan);

}
