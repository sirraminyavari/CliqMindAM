package ir.cliqmind.am.service;

import ir.cliqmind.am.dao.CouponRepo;
import ir.cliqmind.am.dto.GenerateCouponCodeResponse;
import ir.cliqmind.am.dto.GetCouponsRequest;
import ir.cliqmind.am.dto.GetCouponsResponse;
import ir.cliqmind.am.dto.UpsertCouponRequest;
import ir.cliqmind.am.mapper.CouponBuilder;
import ir.cliqmind.am.utils.RandomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService{

    private static final Logger log = LoggerFactory.getLogger(CouponServiceImpl.class);

    @Autowired
    private CouponRepo couponRepo;

    private CouponBuilder couponBuilder;

    private RandomGenerator randomGenerator;

    @Autowired
    public CouponServiceImpl(){
        couponBuilder = new CouponBuilder();
        randomGenerator = new RandomGenerator();
    }

    @Override
    public void add(UpsertCouponRequest body) {
        ir.cliqmind.am.domain.Coupon entity = couponBuilder.addEdit(body);
        couponRepo.add(entity);
    }

    @Override
    public void edit(UpsertCouponRequest body) {
        ir.cliqmind.am.domain.Coupon entity = couponBuilder.addEdit(body);
        couponRepo.edit(entity);
    }

    @Override
    public GenerateCouponCodeResponse generate() {
        String code = randomGenerator.generateAlphaNumeric(10);
        log.debug("generateCouponCode {}", code);
        return couponBuilder.generate(code);
    }

    @Override
    public GetCouponsResponse get(GetCouponsRequest body) {
        return couponBuilder.get(couponRepo.get(body));
    }

}
