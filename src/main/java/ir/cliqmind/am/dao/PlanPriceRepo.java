package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Plan;
import ir.cliqmind.am.domain.PlanPrice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "res_pprc", path = "res_pprc")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface PlanPriceRepo extends CrudRepository<PlanPrice, Integer> {

    @Transactional(readOnly = false)
    @Query(value = "SELECT pp FROM PlanPrice pp WHERE pp.plan in (:plans)")
    List<PlanPrice> find(Iterable<Plan> plans);

}
