package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Plan;
import ir.cliqmind.am.domain.PlanActivationHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "res_pah", path = "res_pah")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface PlanActivationHistoryRepo extends CrudRepository<PlanActivationHistory, Long>{

    @Transactional(readOnly = false)
    @Query(value = "SELECT p.plan FROM PlanActivationHistory p WHERE p.ownerId=:ownerId")
    List<Plan> findPlansByOwnerId(UUID ownerId);

}
