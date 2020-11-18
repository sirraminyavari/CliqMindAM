package ir.cliqmind.am.api;

import ir.cliqmind.am.dto.GenerateCouponCodeResponse;
import ir.cliqmind.am.dto.GetCouponsRequest;
import ir.cliqmind.am.dto.GetCouponsResponse;
import ir.cliqmind.am.dto.ResponseMessage;
import ir.cliqmind.am.dto.UpsertCouponRequest;
import io.swagger.annotations.*;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.service.CouponService;
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
public class CouponApiController implements CouponApi {

    private static final Logger log = LoggerFactory.getLogger(CouponApiController.class);

    private CouponService couponService;

    private ResponseMessageBuilder responseMessageBuilder;

    @Autowired
    public CouponApiController(CouponService couponService) {
        this.couponService = couponService;
        responseMessageBuilder = new ResponseMessageBuilder();
    }

    public ResponseEntity<ResponseMessage> addCoupon(@ApiParam(value = "add coupon" ,required=true )  @Valid @RequestBody UpsertCouponRequest body) {
        log.info("addCoupon {}", body);
        couponService.add(body);
        return new ResponseEntity<ResponseMessage>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> editCoupon(@ApiParam(value = "edit coupon" ,required=true )  @Valid @RequestBody UpsertCouponRequest body) {
        log.info("editCoupon {}", body);
        couponService.edit(body);
        return new ResponseEntity<ResponseMessage>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    public ResponseEntity<GenerateCouponCodeResponse> generateCouponCode() {
        GenerateCouponCodeResponse result = couponService.generate();
        log.info("generateCouponCode {}", result);
        return new ResponseEntity<GenerateCouponCodeResponse>(result, HttpStatus.OK);
    }

    public ResponseEntity<GetCouponsResponse> getCoupons(@ApiParam(value = "get coupons" ,required=true )  @Valid @RequestBody GetCouponsRequest body) {
        log.info("getCoupons {}", body);
        GetCouponsResponse result = couponService.get(body);
        log.debug("getCoupons result = {}", result);
        return new ResponseEntity<GetCouponsResponse>(result, HttpStatus.OK);
    }

}
