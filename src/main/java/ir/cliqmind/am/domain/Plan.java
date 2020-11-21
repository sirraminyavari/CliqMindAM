package ir.cliqmind.am.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Plan")
@Table(name = "plans", indexes = {
        @Index(columnList = "name", name = "plans_name_idx")
})
public class Plan {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "user_based", nullable = false)
    private Boolean userBased;

    @Column(name = "enable_amount", nullable = false)
    private Boolean enableAmount;

    @Column(name = "maximum_amount")
    private Integer maximumAmount;

    @Column(name = "duration_in_months")
    private Integer durationInMonths;

    @Transient
    private List<PlanFeature> planFeatures = new ArrayList<>();

    @Transient
    private List<PlanPrice> planPrice = new ArrayList<>();

    @Column(name = "active")
    @ColumnDefault("true")
    private Boolean active;

    public Plan(){

    }

    public Plan(Integer planId) {
        this.id = planId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUserBased() {
        return userBased;
    }

    public void setUserBased(Boolean userBased) {
        this.userBased = userBased;
    }

    public Boolean getEnableAmount() {
        return enableAmount;
    }

    public void setEnableAmount(Boolean enableAmount) {
        this.enableAmount = enableAmount;
    }

    public Integer getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Integer maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public List<PlanFeature> getPlanFeatures() {
        return planFeatures;
    }

    public void setPlanFeatures(List<PlanFeature> planFeatures) {
        this.planFeatures = planFeatures;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<PlanPrice> getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(List<PlanPrice> planPrice) {
        this.planPrice = planPrice;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userBased=" + userBased +
                ", enableAmount=" + enableAmount +
                ", maximumAmount=" + maximumAmount +
                ", durationInMonths=" + durationInMonths +
                ", planFeatures=" + planFeatures +
                ", planPrice=" + planPrice +
                ", active=" + active +
                '}';
    }
}
