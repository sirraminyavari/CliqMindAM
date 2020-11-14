package ir.cliqmind.am.api;

import ir.cliqmind.am.dto.AddTransactionRequest;
import ir.cliqmind.am.dto.GetTransactionsRequest;
import ir.cliqmind.am.dto.ResponseMessage;
import ir.cliqmind.am.dto.RollbackTransactionRequest;
import ir.cliqmind.am.dto.Transaction;
import ir.cliqmind.am.dto.Transactions;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import ir.cliqmind.am.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")

@Controller
public class TransactionApiController implements TransactionApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionApiController.class);

    private final HttpServletRequest request;

    @Autowired
    private TransactionService transactionService;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<Transaction> addTransaction(@ApiParam(value = "add transaction object" ,required=true )  @Valid @RequestBody AddTransactionRequest body) {
        return new ResponseEntity<Transaction>(transactionService.addTransaction(body), HttpStatus.OK);
    }

    public ResponseEntity<Transactions> getTransactions(@ApiParam(value = "get transaction objects" ,required=true )  @Valid @RequestBody GetTransactionsRequest body) {
        return new ResponseEntity<Transactions>(transactionService.getTransactions(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> rollbackTransaction(@ApiParam(value = "rollback transaction object" ,required=true )  @Valid @RequestBody RollbackTransactionRequest body) {
        return new ResponseEntity<ResponseMessage>(transactionService.rollbackTransaction(body), HttpStatus.OK);
    }

}
