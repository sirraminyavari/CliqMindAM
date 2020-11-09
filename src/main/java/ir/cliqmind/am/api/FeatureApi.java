/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package ir.cliqmind.am.api;

import ir.cliqmind.am.dto.ActivateFeatureRequest;
import ir.cliqmind.am.dto.AddFeatureRequest;
import ir.cliqmind.am.dto.DeactivateFeatureRequest;
import ir.cliqmind.am.dto.EditFeatureRequest;
import ir.cliqmind.am.dto.Feature;
import ir.cliqmind.am.dto.GetActiveFeaturesRequest;
import ir.cliqmind.am.dto.GetActiveFeaturesResponse;
import ir.cliqmind.am.dto.GetFeaturesRequest;
import ir.cliqmind.am.dto.GetFeaturesResponse;
import ir.cliqmind.am.dto.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")

@Api(value = "feature", description = "the feature API")
@RequestMapping(value = "/api/v1")
public interface FeatureApi {

    @ApiOperation(value = "Activate Feature", nickname = "activateFeature", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "feature", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful feature activated", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/feature/activate",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> activateFeature(@ApiParam(value = "activate feature" ,required=true )  @Valid @RequestBody ActivateFeatureRequest body);


    @ApiOperation(value = "Add Feature", nickname = "addFeature", notes = "This can only be done by the unknown user.", response = Feature.class, tags={ "feature", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful feature added", response = Feature.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/feature/add",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Feature> addFeature(@ApiParam(value = "add feature" ,required=true )  @Valid @RequestBody AddFeatureRequest body);


    @ApiOperation(value = "Deactivate Feature", nickname = "deactivateFeature", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "feature", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful feature deactivated", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/feature/deactivate",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> deactivateFeature(@ApiParam(value = "deactivate feature" ,required=true )  @Valid @RequestBody DeactivateFeatureRequest body);


    @ApiOperation(value = "Edit Feature", nickname = "editFeature", notes = "This can only be done by the unknown user.", response = ResponseMessage.class, tags={ "feature", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful feature edition", response = ResponseMessage.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/feature/edit",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> editFeature(@ApiParam(value = "edit feature" ,required=true )  @Valid @RequestBody EditFeatureRequest body);


    @ApiOperation(value = "Get Active Features", nickname = "getActiveFeatures", notes = "This can only be done by the unknown user.", response = GetActiveFeaturesResponse.class, tags={ "feature", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful active features returned", response = GetActiveFeaturesResponse.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/feature/active/get",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<GetActiveFeaturesResponse> getActiveFeatures(@ApiParam(value = "get active features" ,required=true )  @Valid @RequestBody GetActiveFeaturesRequest body);


    @ApiOperation(value = "Get Features", nickname = "getFeatures", notes = "This can only be done by the unknown user.", response = GetFeaturesResponse.class, tags={ "feature", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful features returned", response = GetFeaturesResponse.class),
        @ApiResponse(code = 400, message = "Invalid request format "),
        @ApiResponse(code = 401, message = "Authorization error") })
    @RequestMapping(value = "/feature/get",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<GetFeaturesResponse> getFeatures(@ApiParam(value = "get features" ,required=true )  @Valid @RequestBody GetFeaturesRequest body);

}
