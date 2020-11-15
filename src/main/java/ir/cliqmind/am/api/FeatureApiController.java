package ir.cliqmind.am.api;

import ir.cliqmind.am.dto.*;
import io.swagger.annotations.*;
import ir.cliqmind.am.service.FeatureService;
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
public class FeatureApiController implements FeatureApi {

    private static final Logger log = LoggerFactory.getLogger(FeatureApiController.class);

    @Autowired
    private FeatureService featureService;

    public ResponseEntity<ResponseMessage> activateFeature(@ApiParam(value = "activate feature" ,required=true )  @Valid @RequestBody ActivateFeatureRequest body) {
        return new ResponseEntity<ResponseMessage>(featureService.activate(body), HttpStatus.OK);
    }

    public ResponseEntity<Feature> addFeature(@ApiParam(value = "add feature" ,required=true )  @Valid @RequestBody AddFeatureRequest body) {
        return new ResponseEntity<Feature>(featureService.add(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> deactivateFeature(@ApiParam(value = "deactivate feature" ,required=true )  @Valid @RequestBody DeactivateFeatureRequest body) {
        return new ResponseEntity<ResponseMessage>(featureService.deactivate(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> editFeature(@ApiParam(value = "edit feature" ,required=true )  @Valid @RequestBody EditFeatureRequest body) {
        return new ResponseEntity<ResponseMessage>(featureService.edit(body), HttpStatus.OK);
    }

    public ResponseEntity<GetActiveFeaturesResponse> getActiveFeatures(@ApiParam(value = "get active features" ,required=true )  @Valid @RequestBody GetActiveFeaturesRequest body) {
        return new ResponseEntity<GetActiveFeaturesResponse>(featureService.getActive(body), HttpStatus.OK);
    }

    public ResponseEntity<GetFeaturesResponse> getFeatures(@ApiParam(value = "get features" ,required=true )  @Valid @RequestBody GetFeaturesRequest body) {
        return new ResponseEntity<GetFeaturesResponse>(featureService.get(body), HttpStatus.OK);
    }

}
