package ir.cliqmind.am.dao;

import ir.cliqmind.am.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>, TransactionRepoCustom {

    @Transactional(readOnly = true)
    @Modifying
    @Query(value = "UPDATE Transaction t SET t.rollbacked=true, t.rollbackTime=:time, t.rollbackByUserId=:doneByUserId, t.rollbackDescription=:description WHERE t.transactionCode in (:codes)")
    void rollback(List<String> codes, UUID doneByUserId, String description, Instant time);

    @Transactional
    @Query("SELECT t FROM Transaction t WHERE t.transactionCode=:code OR t.transactionCode=concat(:code, '_t')")
    List<Transaction> findByCode(@Param("code") String code);

}
