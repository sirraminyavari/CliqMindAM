package ir.cliqmind.am.domain;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@Entity(name = "Coupon")
@Table(name = "coupons")
public class Coupon implements Serializable {

  @Id
  private String code;

  @Column(name = "percentage_based", nullable = false)
  private Boolean percentageBased;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "maximum_amount")
  private Double maximumAmount;

  @Column(name = "currency", length = 10, nullable = false)
  private String currency;

  @Column(name = "expiration_date")
  private Date expirationDate;

  @Column(name = "time", nullable = false)
  private Timestamp time;

  @Column(name = "allow_concurrent_coupons", nullable = false)
  private Boolean allowConcurrentCoupons;

  @Column(name = "allow_secondary_price", nullable = false)
  private Boolean allowSecondaryPrice;

  @Column(name = "maximum_usage_limit")
  private Integer maximumUsageLimit;

  @Column(name = "maximum_usage_limit_per_user")
  private Integer maximumUsageLimitPerUser;

  @ElementCollection(fetch=FetchType.EAGER)
  @CollectionTable(name = "coupon_target_users", joinColumns = @JoinColumn(name = "code"))
  @Column(name = "target_id", nullable = false)
  private List<UUID> targetUsers;

  @Transient
  private List<PlanCoupon> plans;

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

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public Boolean getAllowConcurrentCoupons() {
    return allowConcurrentCoupons;
  }

  public void setAllowConcurrentCoupons(Boolean allowConcurrentCoupons) {
    this.allowConcurrentCoupons = allowConcurrentCoupons;
  }

  public Boolean getAllowSecondaryPrice() {
    return allowSecondaryPrice;
  }

  public void setAllowSecondaryPrice(Boolean allowSecondaryPrice) {
    this.allowSecondaryPrice = allowSecondaryPrice;
  }

  public Integer getMaximumUsageLimit() {
    return maximumUsageLimit;
  }

  public void setMaximumUsageLimit(Integer maximumUsageLimit) {
    this.maximumUsageLimit = maximumUsageLimit;
  }

  public Integer getMaximumUsageLimitPerUser() {
    return maximumUsageLimitPerUser;
  }

  public void setMaximumUsageLimitPerUser(Integer maximumUsageLimitPerUser) {
    this.maximumUsageLimitPerUser = maximumUsageLimitPerUser;
  }

  public List<UUID> getTargetUsers() {
    return targetUsers;
  }

  public void setTargetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
  }

  public List<PlanCoupon> getPlans() {
    return plans;
  }

  public void setPlans(List<PlanCoupon> plans) {
    this.plans = plans;
  }

  @Override
  public String toString() {
    return "Coupon{" +
            "code='" + code + '\'' +
            ", percentageBased=" + percentageBased +
            ", amount=" + amount +
            ", maximumAmount=" + maximumAmount +
            ", currency='" + currency + '\'' +
            ", expirationDate=" + expirationDate +
            ", time=" + time +
            ", allowConcurrentCoupons=" + allowConcurrentCoupons +
            ", allowSecondaryPrice=" + allowSecondaryPrice +
            ", maximumUsageLimit=" + maximumUsageLimit +
            ", maximumUsageLimitPerUser=" + maximumUsageLimitPerUser +
            ", targetUsers=" + targetUsers +
            ", plans=" + plans +
            '}';
  }
}

