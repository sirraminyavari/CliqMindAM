package ir.cliqmind.am.dao;

import ir.cliqmind.am.dto.GetTransactionsRequest;
import ir.cliqmind.am.domain.Transaction;
import ir.cliqmind.am.dto.TransferCreditRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TransactionRepoImpl implements TransactionsRepoCustom {

    private static final Logger log = LoggerFactory.getLogger(TransactionRepoImpl.class);

    @PersistenceContext
    private EntityManager em;

    private final String getCreditBalanceSql = "SELECT currency, sum(amount * pos) FROM (select * , (case is_deposit when true then 1 else -1 end) as pos FROM public.transactions) AS t2 where %s group by currency";

    @Override
    @Transactional(readOnly = true)
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

    @Override
    @Transactional(readOnly = true)
    public Map<String, Double> getCreditBalance(UUID userId, String currency) {
        List<String> where = new ArrayList<>();
        where.add("(rollbacked=false or rollbacked is null)");
        where.add(String.format("user_id='%s'", userId));
        if(currency != null){
            where.add(String.format("currency='%s'", currency));
        }
        String sql = String.format(getCreditBalanceSql,
                where.stream().collect(Collectors.joining(" AND ")));
        Query q = em.createNativeQuery(sql);
        Map<String, Double> result = new HashMap<>();
        q.getResultList().forEach(r -> {
            Object[] a = (Object[])r;
            result.put((String) a[0], (Double) a[1]);
        });
        return result;
    }

}
