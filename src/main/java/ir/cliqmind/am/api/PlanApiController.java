package ir.cliqmind.am.api;

import ir.cliqmind.am.dto.*;
import io.swagger.annotations.*;
import ir.cliqmind.am.service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")

@Controller
public class PlanApiController implements PlanApi {

    private static final Logger log = LoggerFactory.getLogger(PlanApiController.class);

    @Autowired
    private PlanService planService;

    public ResponseEntity<ResponseMessage> activatePlan(@ApiParam(value = "activate plan" ,required=true )  @Valid @RequestBody ActivatePlanRequest body) {
        return new ResponseEntity<ResponseMessage>(planService.activate(body), HttpStatus.OK);
    }

    public ResponseEntity<Plan> addPlan(@ApiParam(value = "add plan" ,required=true )  @Valid @RequestBody AddPlanRequest body) {
        return new ResponseEntity<Plan>(planService.add(body), HttpStatus.OK);
    }

    public ResponseEntity<Transaction> buyPlan(@ApiParam(value = "buy plan" ,required=true )  @Valid @RequestBody BuyPlanRequest body) {
        return new ResponseEntity<Transaction>(planService.buy(body), HttpStatus.OK);
    }

    public ResponseEntity<CalculatePlanPriceResponse> calculatePlanPrice(@ApiParam(value = "calculate plan price" ,required=true )  @Valid @RequestBody CalculatePlanPriceRequest body) {
        return new ResponseEntity<CalculatePlanPriceResponse>(planService.calculatePrice(body), HttpStatus.OK);
    }

    public ResponseEntity<CalculatePlanRenewalPriceResponse> calculatePlanRenewalPrice(@ApiParam(value = "calculate plan renewal price" ,required=true )  @Valid @RequestBody CalculatePlanRenewalPriceRequest body) {
        return new ResponseEntity<CalculatePlanRenewalPriceResponse>(planService.calculateRenewalPrice(body), HttpStatus.OK);
    }

    public ResponseEntity<CalculatePlanUpgradePriceResponse> calculatePlanUpgradePrice(@ApiParam(value = "calculate plan upgrade price" ,required=true )  @Valid @RequestBody CalculatePlanUpgradeRequest body) {
        return new ResponseEntity<CalculatePlanUpgradePriceResponse>(planService.calculateUpgradePrice(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> deactivatePlan(@ApiParam(value = "deactivate plan" ,required=true )  @Valid @RequestBody DeactivatePlanRequest body) {
        return new ResponseEntity<ResponseMessage>(planService.deactivate(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> editPlan(@ApiParam(value = "edit plan" ,required=true )  @Valid @RequestBody EditPlanRequest body) {
        return new ResponseEntity<ResponseMessage>(planService.edit(body), HttpStatus.OK);
    }

    public ResponseEntity<GetPlanActivationHistoryResponse> getPlanActivationHistory(@ApiParam(value = "get plan activation history" ,required=true )  @Valid @RequestBody GetPlanActivationHistoryRequest body) {
        return new ResponseEntity<GetPlanActivationHistoryResponse>(planService.getActivationHistory(body), HttpStatus.OK);
    }

    public ResponseEntity<GetPlansResponse> getPlans(@ApiParam(value = "get plans" ,required=true )  @Valid @RequestBody GetPlansRequest body) {
        return new ResponseEntity<GetPlansResponse>(planService.get(body), HttpStatus.OK);
    }

    public ResponseEntity<Transaction> renewPlans(@ApiParam(value = "renew plans" ,required=true )  @Valid @RequestBody RenewPlansRequest body) {
        return new ResponseEntity<Transaction>(planService.renew(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> setPlanFeatures(@ApiParam(value = "set plan features" ,required=true )  @Valid @RequestBody SetPlanFeaturesRequest body) {
        return new ResponseEntity<ResponseMessage>(planService.setFeatures(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> setPlanPrice(@ApiParam(value = "set plan price" ,required=true )  @Valid @RequestBody SetPlanPriceRequest body) {
        return new ResponseEntity<ResponseMessage>(planService.setPrice(body), HttpStatus.OK);
    }

    public ResponseEntity<Transaction> upgradePlan(@ApiParam(value = "upgrade plan" ,required=true )  @Valid @RequestBody UpradePlanRequest body) {
        return new ResponseEntity<Transaction>(planService.upgrade(body), HttpStatus.OK);
    }

}
