package ir.cliqmind.am.api;

import ir.cliqmind.am.dao.TransactionRepo;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.error.NotFoundException;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionApiController {

    @Autowired
    private TransactionRepo transactionRepo;

    private TransactionMapper transactionMapper;

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public TransactionApiController(){
        transactionMapper = new TransactionMapper();
        responseMessageBuilder = new ResponseMessageBuilder();
    }

    @Transactional
    @PostMapping("")
    public ResponseEntity<Transaction> addTransaction(@Valid @RequestBody AddTransactionRequest body) {
        ir.cliqmind.am.domain.Transaction saved = transactionRepo.save(transactionMapper.addTransactionRequest(body));
        ir.cliqmind.am.dto.Transaction response = transactionMapper.addTransactionRequest(saved);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("")
    public ResponseEntity<Transactions> getTransactions(GetTransactionsRequest body) {
        ir.cliqmind.am.dto.Transactions response = transactionMapper.getTransactions(transactionRepo.getTransactionsRequest(body));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{id}/rollback")
    public ResponseEntity<ResponseMessage> rollbackTransaction(@PathVariable("id") Long id, @Valid @RequestBody RollbackTransactionRequest body) {
        ir.cliqmind.am.domain.Transaction current = transactionRepo.findById(id).orElseThrow(() -> new NotFoundException("not valid transaction found to be rollbacked"));
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
        transactionRepo.rollback(codes, body.getDoneByUserId(), body.getDescription(), Instant.now());
        return new ResponseEntity<>(responseMessageBuilder.success(), HttpStatus.OK);
    }

}
