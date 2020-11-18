package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "PlanFeature")
@Table(name = "plan_features")
public class PlanFeature implements Serializable {

    @EmbeddedId
    private PlanFeatureId id = new PlanFeatureId();

    @ManyToOne
    @MapsId("planId")
    private Plan plan;

    @ManyToOne
    @MapsId("featureId")
    private Feature feature;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "maximum_amount")
    private Integer maximumAmount;

    public PlanFeature(){}

    public PlanFeatureId getId() {
        return id;
    }

    public void setId(PlanFeatureId id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Integer maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    @Override
    public String toString() {
        return "PlanFeature{" +
                "id=" + id +
                ", amount=" + amount +
                ", maximumAmount=" + maximumAmount +
                '}';
    }
}
