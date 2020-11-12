package ir.cliqmind.am.api;

import ir.cliqmind.am.dto.GenerateCouponCodeResponse;
import ir.cliqmind.am.dto.GetCouponsRequest;
import ir.cliqmind.am.dto.GetCouponsResponse;
import ir.cliqmind.am.dto.ResponseMessage;
import ir.cliqmind.am.dto.UpsertCouponRequest;
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
public class CouponApiController implements CouponApi {

    private static final Logger log = LoggerFactory.getLogger(CouponApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CouponApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ResponseMessage> addCoupon(@ApiParam(value = "add coupon" ,required=true )  @Valid @RequestBody UpsertCouponRequest body) {
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

    public ResponseEntity<ResponseMessage> editCoupon(@ApiParam(value = "edit coupon" ,required=true )  @Valid @RequestBody UpsertCouponRequest body) {
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

    public ResponseEntity<GenerateCouponCodeResponse> generateCouponCode() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GenerateCouponCodeResponse>(objectMapper.readValue("{  \"code\" : \"code\"}", GenerateCouponCodeResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GenerateCouponCodeResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GenerateCouponCodeResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetCouponsResponse> getCoupons(@ApiParam(value = "get coupons" ,required=true )  @Valid @RequestBody GetCouponsRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetCouponsResponse>(objectMapper.readValue("{  \"coupons\" : [ {    \"amount\" : 6.027456183070403,    \"code\" : \"code\",    \"except_plans\" : [ {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    }, {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    } ],    \"allow_secondary_price\" : true,    \"allow_concurrent_coupons\" : true,    \"maximum_usage_limit_per_user\" : 5,    \"maximum_amount\" : 1.4658129805029452,    \"target_users\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ],    \"expiration_date\" : \"2000-01-23\",    \"percentage_based\" : true,    \"limited_to_plans\" : [ {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    }, {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    } ],    \"currency\" : \"currency\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"maximum_usage_limit\" : 5  }, {    \"amount\" : 6.027456183070403,    \"code\" : \"code\",    \"except_plans\" : [ {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    }, {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    } ],    \"allow_secondary_price\" : true,    \"allow_concurrent_coupons\" : true,    \"maximum_usage_limit_per_user\" : 5,    \"maximum_amount\" : 1.4658129805029452,    \"target_users\" : [ \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" ],    \"expiration_date\" : \"2000-01-23\",    \"percentage_based\" : true,    \"limited_to_plans\" : [ {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    }, {      \"duration_in_months\" : 1,      \"features\" : [ {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      }, {        \"amount\" : 6,        \"name\" : \"name\",        \"description\" : \"description\",        \"active\" : true,        \"id\" : 0      } ],      \"user_based\" : true,      \"price\" : [ {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      }, {        \"secondary_price\" : {          \"price\" : 5.637376656633329,          \"expiration_date\" : \"2000-01-23\",          \"first_date\" : \"2000-01-23\"        },        \"price\" : 5.962133916683182,        \"currency\" : \"currency\"      } ],      \"name\" : \"name\",      \"description\" : \"description\",      \"active\" : true,      \"maximum_amount\" : 6,      \"id\" : 0,      \"enable_amount\" : true    } ],    \"currency\" : \"currency\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"maximum_usage_limit\" : 5  } ],  \"total_count\" : 0}", GetCouponsResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetCouponsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetCouponsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
