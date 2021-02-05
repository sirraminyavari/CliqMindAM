package ir.cliqmind.am.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlanPriceId implements Serializable {

    @Column(name = "plan_id")
    private Integer planId;

    @Column(name = "currency", length = 10)
    private String currency;

    public PlanPriceId(){}

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PlanPriceId{" +
                "planId=" + planId +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanPriceId that = (PlanPriceId) o;
        return planId.equals(that.planId) &&
                currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, currency);
    }
}
