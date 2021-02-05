package ir.cliqmind.am.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PlanActivationItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanActivationItem   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("owner_id")
  private UUID ownerId = null;

  @JsonProperty("plan")
  private Plan plan = null;

  @JsonProperty("upgraded_from_plan")
  private Plan upgradedFromPlan = null;

  @JsonProperty("transaction")
  private Transaction transaction = null;

  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("time")
  private Instant time = null;

  @JsonProperty("start_date")
  private LocalDate startDate = null;

  @JsonProperty("expiration_date")
  private LocalDate expirationDate = null;

  @JsonProperty("activated_by_user_id")
  private UUID activatedByUserId = null;

  @JsonProperty("is_expired")
  private Boolean isExpired = null;

  @JsonProperty("is_active")
  private Boolean isActive = null;

  public PlanActivationItem id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PlanActivationItem ownerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
   **/
  
  
    @Valid
    public UUID getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
  }

  public PlanActivationItem plan(Plan plan) {
    this.plan = plan;
    return this;
  }

  /**
   * Get plan
   * @return plan
   **/
  
  
    @Valid
    public Plan getPlan() {
    return plan;
  }

  public void setPlan(Plan plan) {
    this.plan = plan;
  }

  public PlanActivationItem upgradedFromPlan(Plan upgradedFromPlan) {
    this.upgradedFromPlan = upgradedFromPlan;
    return this;
  }

  /**
   * Get upgradedFromPlan
   * @return upgradedFromPlan
   **/
  
  
    @Valid
    public Plan getUpgradedFromPlan() {
    return upgradedFromPlan;
  }

  public void setUpgradedFromPlan(Plan upgradedFromPlan) {
    this.upgradedFromPlan = upgradedFromPlan;
  }

  public PlanActivationItem transaction(Transaction transaction) {
    this.transaction = transaction;
    return this;
  }

  /**
   * Get transaction
   * @return transaction
   **/
  
  
    @Valid
    public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }

  public PlanActivationItem amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  
  
    public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public PlanActivationItem time(Instant time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   **/
  
  
    @Valid
    public Instant getTime() {
    return time;
  }

  public void setTime(Instant time) {
    this.time = time;
  }

  public PlanActivationItem startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   **/
  
  
    @Valid
    public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public PlanActivationItem expirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
   **/
  
  
    @Valid
    public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  public PlanActivationItem activatedByUserId(UUID activatedByUserId) {
    this.activatedByUserId = activatedByUserId;
    return this;
  }

  /**
   * Get activatedByUserId
   * @return activatedByUserId
   **/
  
  
    @Valid
    public UUID getActivatedByUserId() {
    return activatedByUserId;
  }

  public void setActivatedByUserId(UUID activatedByUserId) {
    this.activatedByUserId = activatedByUserId;
  }

  public PlanActivationItem isExpired(Boolean isExpired) {
    this.isExpired = isExpired;
    return this;
  }

  /**
   * Get isExpired
   * @return isExpired
   **/
  
  
    public Boolean isIsExpired() {
    return isExpired;
  }

  public void setIsExpired(Boolean isExpired) {
    this.isExpired = isExpired;
  }

  public PlanActivationItem isActive(Boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Get isActive
   * @return isActive
   **/
  
  
    public Boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanActivationItem planActivationItem = (PlanActivationItem) o;
    return Objects.equals(this.id, planActivationItem.id) &&
        Objects.equals(this.ownerId, planActivationItem.ownerId) &&
        Objects.equals(this.plan, planActivationItem.plan) &&
        Objects.equals(this.upgradedFromPlan, planActivationItem.upgradedFromPlan) &&
        Objects.equals(this.transaction, planActivationItem.transaction) &&
        Objects.equals(this.amount, planActivationItem.amount) &&
        Objects.equals(this.time, planActivationItem.time) &&
        Objects.equals(this.startDate, planActivationItem.startDate) &&
        Objects.equals(this.expirationDate, planActivationItem.expirationDate) &&
        Objects.equals(this.activatedByUserId, planActivationItem.activatedByUserId) &&
        Objects.equals(this.isExpired, planActivationItem.isExpired) &&
        Objects.equals(this.isActive, planActivationItem.isActive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ownerId, plan, upgradedFromPlan, transaction, amount, time, startDate, expirationDate, activatedByUserId, isExpired, isActive);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanActivationItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    plan: ").append(toIndentedString(plan)).append("\n");
    sb.append("    upgradedFromPlan: ").append(toIndentedString(upgradedFromPlan)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    activatedByUserId: ").append(toIndentedString(activatedByUserId)).append("\n");
    sb.append("    isExpired: ").append(toIndentedString(isExpired)).append("\n");
    sb.append("    isActive: ").append(toIndentedString(isActive)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
