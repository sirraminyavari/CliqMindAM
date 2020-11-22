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

    public PlanCouponId(Integer planId, String couponCode){
        this.planId = planId;
        this.couponCode = couponCode;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "PlanCouponId{" +
                "planId=" + planId +
                ", couponCode='" + couponCode + '\'' +
                '}';
    }
}
