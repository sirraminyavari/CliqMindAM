package ir.cliqmind.am.api;

import ir.cliqmind.am.dao.TransactionRepo;
import ir.cliqmind.am.domain.Transaction;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NokException;
import ir.cliqmind.am.mapper.TransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/credit")
public class CreditApiController {

    @Autowired
    private TransactionRepo transactionRepo;

    private TransactionMapper transactionMapper;

    @Autowired
    public CreditApiController(){
        transactionMapper = new TransactionMapper();
    }

    @Transactional(readOnly = true)
    @GetMapping("/balance")
    public ResponseEntity<GetCreditBalanceResponse> getCreditBalance(GetCreditBalanceRequest body) {
        Map<String, Double> balance = transactionRepo.getCreditBalance(body.getUserId(), body.getCurrency());
        ir.cliqmind.am.dto.GetCreditBalanceResponse result = new ir.cliqmind.am.dto.GetCreditBalanceResponse();
        if(balance != null){
            result.putAll(balance);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/transfer")
    public ResponseEntity<Transactions> transferBalance(@Valid @RequestBody TransferCreditRequest body) {
        double balance = transactionRepo.getCreditBalance(body.getFromUserId(), body.getCurrency()).getOrDefault(body.getCurrency(), 0d);
        if(balance < body.getAmount()){
            throw new NokException("Credit is lower than balance");
        }
        List<Transaction> transactions = transactionMapper.transferBalance(body);
        ir.cliqmind.am.dto.Transactions result = new ir.cliqmind.am.dto.Transactions();
        transactionRepo.saveAll(transactions).forEach(t -> result.add(transactionMapper.transaction(t)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
