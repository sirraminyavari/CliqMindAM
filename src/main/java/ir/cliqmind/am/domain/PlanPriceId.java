package ir.cliqmind.am.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

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
}
