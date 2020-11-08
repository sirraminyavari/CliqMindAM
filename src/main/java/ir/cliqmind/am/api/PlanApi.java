/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
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
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")

@Api(value = "plan", description = "the plan API")
@RequestMapping(value = "/api/v1")
public interface PlanApi {

    @ApiOperation(value = "Activate Plan", nickname = "activatePlan", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan activated", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/activate",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> activatePlan(@ApiParam(value = "activate plan" ,required=true )  @Valid @RequestBody ActivatePlanRequest body);


    @ApiOperation(value = "Add Plan", nickname = "addPlan", notes = "This can only be done by the unknown user.", response = Plan.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan added", response = Plan.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/add",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Plan> addPlan(@ApiParam(value = "add plan" ,required=true )  @Valid @RequestBody AddPlanRequest body);


    @ApiOperation(value = "Buy Plan", nickname = "buyPlan", notes = "This can only be done by the unknown user.", response = Transaction.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan bought", response = Transaction.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/buy",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Transaction> buyPlan(@ApiParam(value = "buy plan" ,required=true )  @Valid @RequestBody BuyPlanRequest body);


    @ApiOperation(value = "Calculate Plan Price", nickname = "calculatePlanPrice", notes = "This can only be done by the unknown user.", response = CalculatePlanPriceResponse.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan price calculated", response = CalculatePlanPriceResponse.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/price/calculate",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CalculatePlanPriceResponse> calculatePlanPrice(@ApiParam(value = "calculate plan price" ,required=true )  @Valid @RequestBody CalculatePlanPriceRequest body);


    @ApiOperation(value = "Calculate Plan Renewal Price", nickname = "calculatePlanRenewalPrice", notes = "This can only be done by the unknown user.", response = CalculatePlanRenewalPriceResponse.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan renewal price calculated", response = CalculatePlanRenewalPriceResponse.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/price/renewal/calculate",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CalculatePlanRenewalPriceResponse> calculatePlanRenewalPrice(@ApiParam(value = "calculate plan renewal price" ,required=true )  @Valid @RequestBody CalculatePlanRenewalPriceRequest body);


    @ApiOperation(value = "Calculate Plan Upgrade Price", nickname = "calculatePlanUpgradePrice", notes = "This can only be done by the unknown user.", response = Transaction.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan upgrade price calculated", response = Transaction.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/price/upgrade/calculate",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Transaction> calculatePlanUpgradePrice(@ApiParam(value = "calculate plan upgrade price" ,required=true )  @Valid @RequestBody CalculatePlanUpgradeRequest body);


    @ApiOperation(value = "Deactivate Plan", nickname = "deactivatePlan", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan deactivated", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/deactivate",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> deactivatePlan(@ApiParam(value = "deactivate plan" ,required=true )  @Valid @RequestBody DeactivatePlanRequest body);


    @ApiOperation(value = "Edit Plan", nickname = "editPlan", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan edition", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/edit",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> editPlan(@ApiParam(value = "edit plan" ,required=true )  @Valid @RequestBody EditPlanRequest body);


    @ApiOperation(value = "Get Plan Activation History", nickname = "getPlanActivationHistory", notes = "This can only be done by the unknown user.", response = GetPlanActivationHistoryResponse.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan activation history returned", response = GetPlanActivationHistoryResponse.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/history/activation",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<GetPlanActivationHistoryResponse> getPlanActivationHistory(@ApiParam(value = "get plan activation history" ,required=true )  @Valid @RequestBody GetPlanActivationHistoryRequest body);


    @ApiOperation(value = "Get Plans", nickname = "getPlans", notes = "This can only be done by the unknown user.", response = GetPlansResponse.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plans returned", response = GetPlansResponse.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/get",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<GetPlansResponse> getPlans(@ApiParam(value = "get plans" ,required=true )  @Valid @RequestBody GetPlansRequest body);


    @ApiOperation(value = "Renew Plans", nickname = "renewPlans", notes = "This can only be done by the unknown user.", response = Transaction.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plans renewed", response = Transaction.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/renew",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Transaction> renewPlans(@ApiParam(value = "renew plans" ,required=true )  @Valid @RequestBody RenewPlansRequest body);


    @ApiOperation(value = "Set Plan Features", nickname = "setPlanFeatures", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan features set", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/features/set",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> setPlanFeatures(@ApiParam(value = "set plan features" ,required=true )  @Valid @RequestBody SetPlanFeaturesRequest body);


    @ApiOperation(value = "Set Plan Price", nickname = "setPlanPrice", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan price set", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/price/set",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> setPlanPrice(@ApiParam(value = "set plan price" ,required=true )  @Valid @RequestBody SetPlanPriceRequest body);


    @ApiOperation(value = "Upgrade Plans", nickname = "upgradePlan", notes = "This can only be done by the unknown user.", response = Transaction.class, tags={ "plan", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful plan upgraded", response = Transaction.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/plan/upgrade",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Transaction> upgradePlan(@ApiParam(value = "upgrade plan" ,required=true )  @Valid @RequestBody UpradePlanRequest body);

}
