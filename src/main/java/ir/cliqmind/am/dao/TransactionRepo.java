package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "res_trnx", path = "res_trnx")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface TransactionRepo extends CrudRepository<Transaction, Long>, TransactionsRepoCustom{

}
