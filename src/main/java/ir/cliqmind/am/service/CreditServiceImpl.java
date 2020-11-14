package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.TransactionRepo;
import ir.cliqmind.am.mapper.TransactionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CreditServiceImpl implements CreditService{


    private static final Logger log = LoggerFactory.getLogger(CreditServiceImpl.class);

    @Autowired
    private TransactionRepo transactionRepo;

    private TransactionBuilder transactionBuilder;

    @Autowired
    public CreditServiceImpl(){
        transactionBuilder = new TransactionBuilder();
    }

    @Override
    public ir.cliqmind.am.dto.GetCreditBalanceResponse getCreditBalance(ir.cliqmind.am.dto.GetCreditBalanceRequest body) {
        Map<String, Double> balance = transactionRepo.getCreditBalance(body.getUserId(), body.getCurrency());
        ir.cliqmind.am.dto.GetCreditBalanceResponse result = new ir.cliqmind.am.dto.GetCreditBalanceResponse();
        if(balance != null){
            result.putAll(balance);
        }
        return result;
    }

    @Override
    public ir.cliqmind.am.dto.Transactions transferBalance(ir.cliqmind.am.dto.TransferCreditRequest body) {
        List<ir.cliqmind.am.domain.Transaction> transactions = transactionRepo.transferBalance(body);
        ir.cliqmind.am.dto.Transactions result = new ir.cliqmind.am.dto.Transactions();
        if(transactions!=null){
            transactions.forEach(t -> result.addTransactionsItem(transactionBuilder.transaction(t)));
            result.totalCount(transactions.size());
        }
        return result;
    }
}
