package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.TransactionRepo;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.mapper.TransactionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepo transactionRepo;

    private TransactionBuilder transactionBuilder;

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public TransactionServiceImpl(){
        transactionBuilder = new TransactionBuilder();
        responseMessageBuilder = new ResponseMessageBuilder();
    }

    @Override
    public ir.cliqmind.am.dto.Transaction add(ir.cliqmind.am.dto.AddTransactionRequest body) {
        /*List<ir.cliqmind.am.domain.Transaction> old = transactionRepo.findByCode(body.getCode());
        if(old!=null && old.size()>0){
            throw new DuplicateException("cannot process add transaction request due to duplicate transaction code");
        }*/
        ir.cliqmind.am.domain.Transaction saved = transactionRepo.save(transactionBuilder.addTransactionRequest(body));
        return transactionBuilder.addTransactionRequest(saved);
    }

    @Override
    public ir.cliqmind.am.dto.Transactions get(ir.cliqmind.am.dto.GetTransactionsRequest body) {
        return transactionBuilder.getTransactions(transactionRepo.getTransactionsRequest(body));
    }

    @Override
    public ir.cliqmind.am.dto.ResponseMessage rollback(ir.cliqmind.am.dto.RollbackTransactionRequest body) {
        ir.cliqmind.am.domain.Transaction current = transactionRepo.findById(body.getId()).orElse(null);
        if(current==null){
            throw new NotFoundException("not valid transaction found to be rollbacked");
        }
        List<String> codes = new ArrayList<>();
        String code = current.getTransactionCode();
        codes.add(code);
        if(current.getType()==ir.cliqmind.am.domain.Transaction.TransactionType.TRANSFER){
            if(code.endsWith("_t")){
                codes.add(code.substring(0, code.length()-2));
            }
            else{
                codes.add(code+"_t");
            }
        }
        transactionRepo.rollback(codes, body.getDoneByUserId(), body.getDescription(), new Timestamp(System.currentTimeMillis()));
        return responseMessageBuilder.success();
    }
}
