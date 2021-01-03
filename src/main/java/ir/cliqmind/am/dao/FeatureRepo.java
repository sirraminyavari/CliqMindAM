package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Feature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "res_ftr", path = "res_ftr")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface FeatureRepo extends CrudRepository<Feature, Integer>, FeatureRepoCustom {

    @Transactional(readOnly = true)
    @Query(value = "SELECT f FROM Feature f WHERE (:active IS NULL OR f.active=:active) AND ((:ids) IS NULL OR f.id in (:ids))")
    List<Feature> find(List<Integer> ids, Boolean active);

}
