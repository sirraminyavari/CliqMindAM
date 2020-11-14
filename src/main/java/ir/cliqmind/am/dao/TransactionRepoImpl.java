package ir.cliqmind.am.dao;

import ir.cliqmind.am.dto.GetTransactionsRequest;
import ir.cliqmind.am.domain.Transaction;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TransactionRepoImpl implements TransactionsRepoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Transaction> getTransactionsRequest(GetTransactionsRequest request) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);

        Root<Transaction> root = cq.from(Transaction.class);

        List<Predicate> where = new ArrayList<>();

        Optional.ofNullable(request.getIds()).ifPresent(p -> {
            if(p.size()>0)
                where.add(root.get("id").in(p));
        });
        Optional.ofNullable(request.getUserId()).ifPresent(p -> where.add(cb.equal(root.get("userId"), p)));
        Optional.ofNullable(request.getCurrency()).ifPresent(p -> where.add(cb.equal(root.get("currency"), p)));
        Optional.ofNullable(request.isIsDeposit()).ifPresent(p -> where.add(cb.equal(root.get("isDeposit"), p)));
        Optional.ofNullable(request.isRollbacked()).ifPresent(p -> where.add(cb.equal(root.get("rollbacked"), p)));
        Optional.ofNullable(request.getFromDate()).ifPresent(p -> where.add(cb.greaterThanOrEqualTo(root.get("time"), p)));
        Optional.ofNullable(request.getToDate()).ifPresent(p -> where.add(cb.lessThan(root.get("time"), p)));
        Optional.ofNullable(request.getFromAmount()).ifPresent(p -> where.add(cb.greaterThanOrEqualTo(root.get("amount"), p)));
        Optional.ofNullable(request.getToAmount()).ifPresent(p -> where.add(cb.lessThan(root.get("amount"), p)));

        cq.where(where.toArray(new Predicate[where.size()]));

        TypedQuery<Transaction> query = em.createQuery(cq);

        Optional.ofNullable(request.getCountFrom()).ifPresent(p -> query.setFirstResult(p));
        Optional.ofNullable(request.getCount()).ifPresent(p -> query.setMaxResults(p));

        return query.getResultList();
    }
}
