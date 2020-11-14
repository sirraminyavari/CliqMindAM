package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.TransactionRepo;
import ir.cliqmind.am.mapper.TransactionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepo transactionRepo;

    private TransactionBuilder transactionBuilder;

    @Autowired
    public TransactionServiceImpl(){
        transactionBuilder = new TransactionBuilder();
    }

    @Override
    public ir.cliqmind.am.dto.Transaction addTransaction(ir.cliqmind.am.dto.AddTransactionRequest body) {
        ir.cliqmind.am.domain.Transaction saved = transactionRepo.save(transactionBuilder.addTransactionRequest(body));
        return transactionBuilder.addTransactionRequest(saved);
    }

    @Override
    public ir.cliqmind.am.dto.Transactions getTransactions(ir.cliqmind.am.dto.GetTransactionsRequest body) {
        return transactionBuilder.getTransactions(transactionRepo.getTransactionsRequest(body));
    }

    @Override
    public ir.cliqmind.am.dto.ResponseMessage rollbackTransaction(ir.cliqmind.am.dto.RollbackTransactionRequest body) {
        return new ir.cliqmind.am.dto.ResponseMessage();
    }
}
