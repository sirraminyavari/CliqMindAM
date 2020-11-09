package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Plan")
@Table(name = "plan")
public class Plan {

    @Id
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "user_based", nullable = false)
    private Boolean userBased;

    @Column(name = "enable_amount", nullable = false)
    private Boolean enableAmount;

    @Column(name = "maximum_amount", nullable = false)
    private Integer maximumAmount;

    @Column(name = "duration_in_months", nullable = false)
    private Integer durationInMonths;

    private PlanActivation planActivation;

    @OneToMany(mappedBy = "feature")
    private Set<PlanFeature> planFeatures = new HashSet<>();

    @ElementCollection(fetch=FetchType.EAGER)
    private List<Double> prices;

    public Plan(){

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

    public PlanActivation getPlanActivation() {
        return planActivation;
    }

    public void setPlanActivation(PlanActivation planActivation) {
        this.planActivation = planActivation;
    }

    public Set<PlanFeature> getPlanFeatures() {
        return planFeatures;
    }

    public void setPlanFeatures(Set<PlanFeature> planFeatures) {
        this.planFeatures = planFeatures;
    }
}
