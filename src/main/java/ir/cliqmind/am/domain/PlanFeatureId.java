package ir.cliqmind.am.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlanFeatureId implements Serializable {

    private Integer planId;

    private Integer featureId;

    public PlanFeatureId(){}

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    @Override
    public String toString() {
        return "PlanFeatureId{" +
                "planId=" + planId +
                ", featureId=" + featureId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanFeatureId that = (PlanFeatureId) o;
        return planId.equals(that.planId) &&
                featureId.equals(that.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, featureId);
    }
}
