package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "PlanFeature")
@Table(name = "plan_feature")
public class PlanFeature implements Serializable {

    @EmbeddedId
    private PlanFeatureId id = new PlanFeatureId();

    @ManyToOne
    @MapsId("planId")
    private Plan plan;

    @ManyToOne
    @MapsId("featureId")
    private Feature feature;

    @Column(name = "amount", nullable = false)
    private Double amount;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
