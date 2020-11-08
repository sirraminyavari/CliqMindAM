package ir.cliqmind.am.api;

import ir.cliqmind.am.model.ActivatePlanRequest;
import ir.cliqmind.am.model.AddPlanRequest;
import ir.cliqmind.am.model.BuyPlanRequest;
import ir.cliqmind.am.model.CalculatePlanPriceRequest;
import ir.cliqmind.am.model.CalculatePlanPriceResponse;
import ir.cliqmind.am.model.CalculatePlanRenewalPriceRequest;
import ir.cliqmind.am.model.CalculatePlanRenewalPriceResponse;
import ir.cliqmind.am.model.CalculatePlanUpgradeRequest;
import ir.cliqmind.am.model.DeactivatePlanRequest;
import ir.cliqmind.am.model.EditPlanRequest;
import ir.cliqmind.am.model.GetPlanActivationHistoryRequest;
import ir.cliqmind.am.model.GetPlanActivationHistoryResponse;
import ir.cliqmind.am.model.GetPlansRequest;
import ir.cliqmind.am.model.GetPlansResponse;
import ir.cliqmind.am.model.Plan;
import ir.cliqmind.am.model.RenewPlansRequest;
import ir.cliqmind.am.model.ResponseMessage;
import ir.cliqmind.am.model.SetPlanFeaturesRequest;
import ir.cliqmind.am.model.SetPlanPriceRequest;
import ir.cliqmind.am.model.Transaction;
import ir.cliqmind.am.model.UpradePlanRequest;
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
public class PlanApiController implements PlanApi {

    private static final Logger log = LoggerFactory.getLogger(PlanApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlanApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ResponseMessage> activatePlan(@ApiParam(value = "activate plan" ,required=true )  @Valid @RequestBody ActivatePlanRequest body) {
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

    public ResponseEntity<Plan> addPlan(@ApiParam(value = "add plan" ,required=true )  @Valid @RequestBody AddPlanRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Plan>(objectMapper.readValue("{  \"duration_in_months\" : 1,  \"user_based\" : true,  \"name\" : \"name\",  \"description\" : \"description\",  \"maximum_amount\" : 6,  \"id\" : 0,  \"enable_amount\" : true}", Plan.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Plan>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Plan>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transaction> buyPlan(@ApiParam(value = "buy plan" ,required=true )  @Valid @RequestBody BuyPlanRequest body) {
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

    public ResponseEntity<CalculatePlanPriceResponse> calculatePlanPrice(@ApiParam(value = "calculate plan price" ,required=true )  @Valid @RequestBody CalculatePlanPriceRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CalculatePlanPriceResponse>(objectMapper.readValue("{  \"price\" : 0.8008281904610115}", CalculatePlanPriceResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CalculatePlanPriceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CalculatePlanPriceResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CalculatePlanRenewalPriceResponse> calculatePlanRenewalPrice(@ApiParam(value = "calculate plan renewal price" ,required=true )  @Valid @RequestBody CalculatePlanRenewalPriceRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CalculatePlanRenewalPriceResponse>(objectMapper.readValue("{  \"price\" : 0.8008281904610115}", CalculatePlanRenewalPriceResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CalculatePlanRenewalPriceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CalculatePlanRenewalPriceResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transaction> calculatePlanUpgradePrice(@ApiParam(value = "calculate plan upgrade price" ,required=true )  @Valid @RequestBody CalculatePlanUpgradeRequest body) {
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

    public ResponseEntity<ResponseMessage> deactivatePlan(@ApiParam(value = "deactivate plan" ,required=true )  @Valid @RequestBody DeactivatePlanRequest body) {
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

    public ResponseEntity<ResponseMessage> editPlan(@ApiParam(value = "edit plan" ,required=true )  @Valid @RequestBody EditPlanRequest body) {
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

    public ResponseEntity<GetPlanActivationHistoryResponse> getPlanActivationHistory(@ApiParam(value = "get plan activation history" ,required=true )  @Valid @RequestBody GetPlanActivationHistoryRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetPlanActivationHistoryResponse>(objectMapper.readValue("{  \"total_count\" : 0,  \"items\" : [ {    \"datetime\" : \"2000-01-23T04:56:07.000+00:00\",    \"active\" : true,    \"id\" : 6  }, {    \"datetime\" : \"2000-01-23T04:56:07.000+00:00\",    \"active\" : true,    \"id\" : 6  } ]}", GetPlanActivationHistoryResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetPlanActivationHistoryResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetPlanActivationHistoryResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetPlansResponse> getPlans(@ApiParam(value = "get plans" ,required=true )  @Valid @RequestBody GetPlansRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetPlansResponse>(objectMapper.readValue("{  \"total_count\" : 0,  \"plans\" : [ {    \"duration_in_months\" : 1,    \"user_based\" : true,    \"name\" : \"name\",    \"description\" : \"description\",    \"maximum_amount\" : 6,    \"id\" : 0,    \"enable_amount\" : true  }, {    \"duration_in_months\" : 1,    \"user_based\" : true,    \"name\" : \"name\",    \"description\" : \"description\",    \"maximum_amount\" : 6,    \"id\" : 0,    \"enable_amount\" : true  } ]}", GetPlansResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetPlansResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetPlansResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transaction> renewPlans(@ApiParam(value = "renew plans" ,required=true )  @Valid @RequestBody RenewPlansRequest body) {
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

    public ResponseEntity<ResponseMessage> setPlanFeatures(@ApiParam(value = "set plan features" ,required=true )  @Valid @RequestBody SetPlanFeaturesRequest body) {
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

    public ResponseEntity<ResponseMessage> setPlanPrice(@ApiParam(value = "set plan price" ,required=true )  @Valid @RequestBody SetPlanPriceRequest body) {
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

    public ResponseEntity<Transaction> upgradePlan(@ApiParam(value = "upgrade plan" ,required=true )  @Valid @RequestBody UpradePlanRequest body) {
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

}
