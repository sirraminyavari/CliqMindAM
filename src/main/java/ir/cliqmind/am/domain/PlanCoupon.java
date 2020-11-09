package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "PlanCoupon")
@Table(name = "coupon_target_plans")
public class PlanCoupon implements Serializable {

    @EmbeddedId
    private PlanCouponId id = new PlanCouponId();

    @ManyToOne
    @MapsId("planId")
    private Plan plan;

    @ManyToOne
    @MapsId("couponCode")
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Coupon coupon;

    @Column(name = "deny", nullable = false)
    private Boolean deny;

    public PlanCoupon(){}

}
