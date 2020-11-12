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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")

@Controller
public class FeatureApiController implements FeatureApi {

    private static final Logger log = LoggerFactory.getLogger(FeatureApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FeatureApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ResponseMessage> activateFeature(@ApiParam(value = "activate feature" ,required=true )  @Valid @RequestBody ActivateFeatureRequest body) {
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

    public ResponseEntity<Feature> addFeature(@ApiParam(value = "add feature" ,required=true )  @Valid @RequestBody AddFeatureRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Feature>(objectMapper.readValue("{  \"amount\" : 6,  \"name\" : \"name\",  \"description\" : \"description\",  \"active\" : true,  \"id\" : 0}", Feature.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Feature>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Feature>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseMessage> deactivateFeature(@ApiParam(value = "deactivate feature" ,required=true )  @Valid @RequestBody DeactivateFeatureRequest body) {
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

    public ResponseEntity<ResponseMessage> editFeature(@ApiParam(value = "edit feature" ,required=true )  @Valid @RequestBody EditFeatureRequest body) {
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

    public ResponseEntity<GetActiveFeaturesResponse> getActiveFeatures(@ApiParam(value = "get active features" ,required=true )  @Valid @RequestBody GetActiveFeaturesRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetActiveFeaturesResponse>(objectMapper.readValue("{  \"features\" : [ {    \"amount\" : 6,    \"name\" : \"name\",    \"description\" : \"description\",    \"active\" : true,    \"id\" : 0  }, {    \"amount\" : 6,    \"name\" : \"name\",    \"description\" : \"description\",    \"active\" : true,    \"id\" : 0  } ],  \"total_count\" : 0}", GetActiveFeaturesResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetActiveFeaturesResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetActiveFeaturesResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetFeaturesResponse> getFeatures(@ApiParam(value = "get features" ,required=true )  @Valid @RequestBody GetFeaturesRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetFeaturesResponse>(objectMapper.readValue("{  \"features\" : [ {    \"amount\" : 6,    \"name\" : \"name\",    \"description\" : \"description\",    \"active\" : true,    \"id\" : 0  }, {    \"amount\" : 6,    \"name\" : \"name\",    \"description\" : \"description\",    \"active\" : true,    \"id\" : 0  } ],  \"total_count\" : 0}", GetFeaturesResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetFeaturesResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetFeaturesResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
