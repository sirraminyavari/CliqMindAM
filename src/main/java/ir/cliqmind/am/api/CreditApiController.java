package ir.cliqmind.am.api;

import ir.cliqmind.am.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import ir.cliqmind.am.service.CreditService;
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
public class CreditApiController implements CreditApi {

    private static final Logger log = LoggerFactory.getLogger(CreditApiController.class);

    @Autowired
    private CreditService creditService;

    public ResponseEntity<GetCreditBalanceResponse> getCreditBalance(@ApiParam(value = "get credit balance" ,required=true )  @Valid @RequestBody GetCreditBalanceRequest body) {
        return new ResponseEntity<GetCreditBalanceResponse>(creditService.getCreditBalance(body), HttpStatus.OK);
    }

    public ResponseEntity<Transactions> transferBalance(@ApiParam(value = "transfer credit" ,required=true )  @Valid @RequestBody TransferCreditRequest body) {
        return new ResponseEntity<Transactions>(creditService.transferBalance(body), HttpStatus.OK);
    }

}
