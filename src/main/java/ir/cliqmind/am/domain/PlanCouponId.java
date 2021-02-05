package ir.cliqmind.am.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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

    public PlanCouponId planId(Integer planId) {
        this.planId = planId;
        return this;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public PlanCouponId couponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    @Override
    public String toString() {
        return "PlanCouponId{" +
                "planId=" + planId +
                ", couponCode='" + couponCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanCouponId that = (PlanCouponId) o;
        return planId.equals(that.planId) &&
                couponCode.equals(that.couponCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, couponCode);
    }
}
