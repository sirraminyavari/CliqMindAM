package ir.cliqmind.am.api;

import ir.cliqmind.am.dao.CouponRepo;
import ir.cliqmind.am.dao.PlanCouponRepo;
import ir.cliqmind.am.domain.PlanCoupon;
import ir.cliqmind.am.domain.PlanCouponId;
import ir.cliqmind.am.dto.*;
import ir.cliqmind.am.mapper.CouponMapper;
import ir.cliqmind.am.mapper.ResponseMessageBuilder;
import ir.cliqmind.am.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponApiController {

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private PlanCouponRepo planCouponRepo;

    private CouponMapper couponMapper;

    private ResponseMessageBuilder responseMessageBuilder;

    public CouponApiController() {
        responseMessageBuilder = new ResponseMessageBuilder();
        couponMapper = new CouponMapper();
    }

    @Transactional
    @PostMapping("")
    public ResponseEntity<ResponseMessage> addCoupon(@Valid @RequestBody AddCouponRequest body) {
        ir.cliqmind.am.domain.Coupon entity = couponMapper.add(body);
        couponRepo.save(entity);
        return new ResponseEntity<>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("{code}")
    public ResponseEntity<ResponseMessage> editCoupon(@PathVariable("code") String code, @Valid @RequestBody EditCouponRequest body) {
        ir.cliqmind.am.domain.Coupon entity = couponMapper.edit(code, body);
        planCouponRepo.deleteAll(
                planCouponRepo.findAll(
                        Example.of(
                                new PlanCoupon().id(
                                        new PlanCouponId().couponCode(entity.getCode())
                                )
                        )
                )
        );
        couponRepo.save(entity);
        return new ResponseEntity<>(responseMessageBuilder.success(), HttpStatus.OK);
    }

    @PostMapping("/generate")
    public ResponseEntity<GenerateCouponCodeResponse> generateCouponCode() {
        GenerateCouponCodeResponse result = couponMapper.generate();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("")
    public ResponseEntity<Coupons> getCoupons(GetCouponsRequest body, Pageable pageable) {
        Map<String, List<ir.cliqmind.am.domain.PlanCoupon>> ids = couponRepo.getIds(body, pageable);
        Set<String> idsKeyset = ids.keySet();
        if(idsKeyset==null){
            idsKeyset = new HashSet();
        }
        Page<ir.cliqmind.am.domain.Coupon> page = couponRepo.findAllByIds(idsKeyset, pageable);
        page.getContent().forEach(c -> {c.setPlans(ids.get(c.getCode()));});
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(couponMapper.coupon(page.getContent()));
    }

}
