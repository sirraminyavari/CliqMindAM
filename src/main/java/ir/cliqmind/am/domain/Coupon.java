package ir.cliqmind.am.domain;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@Entity(name = "Coupon")
@Table(name = "coupon")
public class Coupon implements Serializable {

  @Id
  private String code;

  @Column(name = "percentage_based", nullable = false)
  private Boolean percentageBased;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "maximum_amount", nullable = false)
  private Double maximumAmount;

  @Column(name = "currency")
  @ColumnDefault("'IRR'")
  private String currency;

  @Column(name = "expiration_date", nullable = false)
  private Timestamp expirationDate;

  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name = "plan_coupons",
          joinColumns = @JoinColumn(name = "coupon_id"),
          inverseJoinColumns = @JoinColumn(name = "plan_id")
  )
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Plan> exceptPlans;

  @ElementCollection(fetch=FetchType.EAGER)
  private List<UUID> targetUsers;

  public Coupon(){

  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getPercentageBased() {
    return percentageBased;
  }

  public void setPercentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(Double maximumAmount) {
    this.maximumAmount = maximumAmount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Timestamp getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Timestamp expirationDate) {
    this.expirationDate = expirationDate;
  }

  public List<Plan> getExceptPlans() {
    return exceptPlans;
  }

  public void setExceptPlans(List<Plan> exceptPlans) {
    this.exceptPlans = exceptPlans;
  }

  public List<UUID> getTargetUsers() {
    return targetUsers;
  }

  public void setTargetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
  }
}

