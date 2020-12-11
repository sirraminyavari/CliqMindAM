package ir.cliqmind.am;

import ir.cliqmind.am.dao.CouponRepo;
import ir.cliqmind.am.domain.Coupon;
import ir.cliqmind.am.dto.GetCouponsRequest;
import ir.cliqmind.am.service.CouponService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountManagementApplicationTests {

	@MockBean(CouponRepo.class)
	private CouponRepo couponRepo;

	@Autowired
	private CouponService couponService;

	private List<Coupon> coupons = new ArrayList<>();

	@Test
	public void test1() throws Exception {

		coupons.add(new Coupon().code("c"));

		given(this.couponRepo.findAll()).willReturn(coupons);

		System.out.println("all - "+this.couponRepo.findAll());
		System.out.println("c = "+couponService.get(new GetCouponsRequest().code("c")));

		//assertTrue(couponService.get(new GetCouponsRequest()
		//	.code("c")).equals(coupons.get(0)));
	}

}
