package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "PlanActivationHistory")
@Table(name = "plan_activation_history", indexes = {
        @Index(columnList = "owner_id,plan_id", name = "plan_activation_history_owner_id")
})
public class PlanActivationHistory implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Plan plan;

    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;

    @Column(name = "upgraded_from_plan_id")
    private Integer upgradedFromPlanId;

    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "time", nullable = false)
    private Timestamp time;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "activated_by_user_id", nullable = false)
    private UUID activatedBy;


    public PlanActivationHistory(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getUpgradedFromPlanId() {
        return upgradedFromPlanId;
    }

    public void setUpgradedFromPlanId(Integer upgradedFromPlanId) {
        this.upgradedFromPlanId = upgradedFromPlanId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public UUID getActivatedBy() {
        return activatedBy;
    }

    public void setActivatedBy(UUID activatedBy) {
        this.activatedBy = activatedBy;
    }

}
