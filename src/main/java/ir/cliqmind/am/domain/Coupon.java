package ir.cliqmind.am.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
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
  private LocalDate expirationDate;

  @Column(name = "time", nullable = false)
  private Instant time;

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

  public Coupon code(String code) {
    this.code = code;
    return this;
  }

  public Boolean getPercentageBased() {
    return percentageBased;
  }

  public void setPercentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
  }

  public Coupon percentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
    return this;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Coupon amount(Double amount) {
    this.amount = amount;
    return this;
  }

  public Double getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(Double maximumAmount) {
    this.maximumAmount = maximumAmount;
  }

  public Coupon maximumAmount(Double maximumAmount) {
    this.maximumAmount = maximumAmount;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Coupon currency(String currency) {
    this.currency = currency;
    return this;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Coupon expirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  public Instant getTime() {
    return time;
  }

  public void setTime(Instant time) {
    this.time = time;
  }

  public Coupon time(Instant time) {
    this.time = time;
    return this;
  }

  public Boolean getAllowConcurrentCoupons() {
    return allowConcurrentCoupons;
  }

  public void setAllowConcurrentCoupons(Boolean allowConcurrentCoupons) {
    this.allowConcurrentCoupons = allowConcurrentCoupons;
  }

  public Coupon allowConcurrentCoupons(Boolean allowConcurrentCoupons) {
    this.allowConcurrentCoupons = allowConcurrentCoupons;
    return this;
  }

  public Boolean getAllowSecondaryPrice() {
    return allowSecondaryPrice;
  }

  public void setAllowSecondaryPrice(Boolean allowSecondaryPrice) {
    this.allowSecondaryPrice = allowSecondaryPrice;
  }

  public Coupon allowSecondaryPrice(Boolean allowSecondaryPrice) {
    this.allowSecondaryPrice = allowSecondaryPrice;
    return this;
  }

  public Integer getMaximumUsageLimit() {
    return maximumUsageLimit;
  }

  public void setMaximumUsageLimit(Integer maximumUsageLimit) {
    this.maximumUsageLimit = maximumUsageLimit;
  }

  public Coupon maximumUsageLimit(Integer maximumUsageLimit) {
    this.maximumUsageLimit = maximumUsageLimit;
    return this;
  }

  public Integer getMaximumUsageLimitPerUser() {
    return maximumUsageLimitPerUser;
  }

  public void setMaximumUsageLimitPerUser(Integer maximumUsageLimitPerUser) {
    this.maximumUsageLimitPerUser = maximumUsageLimitPerUser;
  }

  public Coupon maximumUsageLimitPerUser(Integer maximumUsageLimitPerUser) {
    this.maximumUsageLimitPerUser = maximumUsageLimitPerUser;
    return this;
  }

  public List<UUID> getTargetUsers() {
    return targetUsers;
  }

  public void setTargetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
  }

  public Coupon targetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
    return this;
  }

  public List<PlanCoupon> getPlans() {
    return plans;
  }

  public void setPlans(List<PlanCoupon> plans) {
    this.plans = plans;
  }

  public Coupon plans(List<PlanCoupon> plans) {
    this.plans = plans;
    return this;
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

