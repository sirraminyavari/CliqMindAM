package ir.cliqmind.am.api;

import ir.cliqmind.am.model.AddTransactionRequest;
import ir.cliqmind.am.model.GetTransactionsRequest;
import ir.cliqmind.am.model.ResponseMessage;
import ir.cliqmind.am.model.RollbackTransactionRequest;
import ir.cliqmind.am.model.Transaction;
import ir.cliqmind.am.model.Transactions;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")

@Controller
public class TransactionApiController implements TransactionApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Transaction> addTransaction(@ApiParam(value = "add transaction object" ,required=true )  @Valid @RequestBody AddTransactionRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Transaction>(objectMapper.readValue("{  \"transaction_code\" : \"transaction_code\",  \"amount\" : 6.027456183070403,  \"user_id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"currency\" : \"currency\",  \"id\" : 0,  \"type\" : \"type\",  \"is_deposit\" : true}", Transaction.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Transaction>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Transaction>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transactions> getTransactions(@ApiParam(value = "get transaction objects" ,required=true )  @Valid @RequestBody GetTransactionsRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Transactions>(objectMapper.readValue("{  \"total_count\" : 0,  \"transactions\" : [ {    \"transaction_code\" : \"transaction_code\",    \"amount\" : 6.027456183070403,    \"user_id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"currency\" : \"currency\",    \"id\" : 0,    \"type\" : \"type\",    \"is_deposit\" : true  }, {    \"transaction_code\" : \"transaction_code\",    \"amount\" : 6.027456183070403,    \"user_id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"currency\" : \"currency\",    \"id\" : 0,    \"type\" : \"type\",    \"is_deposit\" : true  } ]}", Transactions.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Transactions>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Transactions>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseMessage> rollbackTransaction(@ApiParam(value = "rollback transaction object" ,required=true )  @Valid @RequestBody RollbackTransactionRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseMessage>(objectMapper.readValue("{  \"result\" : \"result\",  \"message\" : \"message\"}", ResponseMessage.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ResponseMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseMessage>(HttpStatus.NOT_IMPLEMENTED);
    }

}
