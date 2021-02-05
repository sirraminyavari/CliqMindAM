package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.PlanActivationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlanActivationHistoryRepo extends JpaRepository<PlanActivationHistory, Long>, PlanActivationHistoryRepoCustom{

    @Transactional(readOnly = true)
    @Query(value = "SELECT p FROM PlanActivationHistory p WHERE p.ownerId=:ownerId")
    List<PlanActivationHistory> findByOwnerId(UUID ownerId);

    @Transactional(readOnly = true)
    @Query(value = "SELECT p FROM PlanActivationHistory p WHERE p.ownerId=:ownerId AND p.plan.id=:planId")
    List<PlanActivationHistory> findByOwnerIdAndPlan(UUID ownerId, Integer planId);

    @Transactional(readOnly = true)
    @Query(value = "SELECT p FROM PlanActivationHistory p WHERE p.ownerId=:ownerId AND p.plan.id in (:planIds)")
    List<PlanActivationHistory> findAll(UUID ownerId, List<Integer> planIds);
}
