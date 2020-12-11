package ir.cliqmind.am.dao;

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
public interface PlanActivationHistoryRepo extends CrudRepository<PlanActivationHistory, Long>, PlanActivationHistoryRepoCustom{

    @Transactional(readOnly = false)
    @Query(value = "SELECT p FROM PlanActivationHistory p WHERE p.ownerId=:ownerId")
    List<PlanActivationHistory> findByOwnerId(UUID ownerId);

    @Transactional(readOnly = false)
    @Query(value = "SELECT p FROM PlanActivationHistory p WHERE p.ownerId=:ownerId AND p.plan.id=:planId")
    List<PlanActivationHistory> findByOwnerIdAndPlan(UUID ownerId, Integer planId);

    @Transactional(readOnly = false)
    @Query(value = "SELECT p FROM PlanActivationHistory p WHERE p.ownerId=:ownerId AND p.plan.id in (:planIds)")
    List<PlanActivationHistory> findAll(UUID ownerId, List<Integer> planIds);
}
