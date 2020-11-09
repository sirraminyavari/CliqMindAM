package ir.cliqmind.am.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlanCouponId implements Serializable {

    @Column(name = "plan_id")
    private Integer planId;

    @Column(name = "code")
    private String couponCode;

    public PlanCouponId(){}

}
