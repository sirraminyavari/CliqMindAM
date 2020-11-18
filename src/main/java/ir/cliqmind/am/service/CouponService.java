package ir.cliqmind.am.service;

import ir.cliqmind.am.dto.*;

public interface CouponService {

    void add(UpsertCouponRequest body);

    void edit(UpsertCouponRequest body);

    GenerateCouponCodeResponse generate();

    GetCouponsResponse get(GetCouponsRequest body);

}
