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

    public PlanCouponId getId() {
        return id;
    }

    public void setId(PlanCouponId id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Boolean getDeny() {
        return deny;
    }

    public void setDeny(Boolean deny) {
        this.deny = deny;
    }

    @Override
    public String toString() {
        return "PlanCoupon{" +
                "id=" + id +
                ", plan=" + plan +
                ", coupon=" + coupon +
                ", deny=" + deny +
                '}';
    }

    public PlanCoupon id(PlanCouponId id) {
        this.id = id;
        return this;
    }

    public PlanCoupon coupon(Coupon coupon) {
        this.coupon = coupon;
        return this;
    }
}
