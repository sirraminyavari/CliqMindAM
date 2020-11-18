package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "res_cpn", path = "res_cpn")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface CouponRepo extends CrudRepository<Coupon, String>, CouponRepoCustom {

}
