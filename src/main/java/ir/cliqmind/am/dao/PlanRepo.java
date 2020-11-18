package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Feature;
import ir.cliqmind.am.domain.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "res_pln", path = "res_pln")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface PlanRepo extends CrudRepository<Plan, Integer>, PlanRepoCustom {

}