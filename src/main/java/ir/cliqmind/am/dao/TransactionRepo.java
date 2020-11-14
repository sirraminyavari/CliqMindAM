package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "res_trnx", path = "res_trnx")
@CrossOrigin( methods = RequestMethod.GET, allowCredentials = "false", origins = "*")
public interface TransactionRepo extends CrudRepository<Transaction, Long>, TransactionsRepoCustom{

    @Transactional(readOnly = false)
    @Modifying
    @Query(value = "UPDATE Transaction t SET t.rollbacked=true, t.rollbackTime=?4, t.rollbackByUserId=?2, t.rollbackDescription=?3 WHERE t.id = ?1")
    void rollback(Long id, UUID doneByUserId, String description, Timestamp time);

}
