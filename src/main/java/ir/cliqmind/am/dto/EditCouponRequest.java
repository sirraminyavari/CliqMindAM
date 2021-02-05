package ir.cliqmind.am.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * AddCouponRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")


public class EditCouponRequest {

  @JsonProperty("percentage_based")
  private Boolean percentageBased = null;

  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("maximum_amount")
  private Double maximumAmount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("expiration_date")
  private LocalDate expirationDate = null;

  @JsonProperty("allow_concurrent_coupons")
  private Boolean allowConcurrentCoupons = null;

  @JsonProperty("allow_secondary_price")
  private Boolean allowSecondaryPrice = null;

  @JsonProperty("maximum_usage_limit")
  private Integer maximumUsageLimit = null;

  @JsonProperty("maximum_usage_limit_per_user")
  private Integer maximumUsageLimitPerUser = null;

  @JsonProperty("limit_to_plans")
  @Valid
  private List<Integer> limitToPlans = null;

  @JsonProperty("except_plans")
  @Valid
  private List<Integer> exceptPlans = null;

  @JsonProperty("target_users")
  @Valid
  private List<UUID> targetUsers = null;


  public EditCouponRequest percentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
    return this;
  }

  /**
   * Get percentageBased
   * @return percentageBased
   **/
      @NotNull

    public Boolean isPercentageBased() {
    return percentageBased;
  }

  public void setPercentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
  }

  public EditCouponRequest amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
      @NotNull

    public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public EditCouponRequest maximumAmount(Double maximumAmount) {
    this.maximumAmount = maximumAmount;
    return this;
  }

  /**
   * Get maximumAmount
   * @return maximumAmount
   **/
  
    public Double getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(Double maximumAmount) {
    this.maximumAmount = maximumAmount;
  }

  public EditCouponRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
      @NotNull

  @Pattern(regexp="[A-Z][A-Z][A-Z]")   public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public EditCouponRequest expirationDate(LocalDate expirationDate) {
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

  public EditCouponRequest allowConcurrentCoupons(Boolean allowConcurrentCoupons) {
    this.allowConcurrentCoupons = allowConcurrentCoupons;
    return this;
  }

  /**
   * Get allowConcurrentCoupons
   * @return allowConcurrentCoupons
   **/
  
  
    public Boolean isAllowConcurrentCoupons() {
    return allowConcurrentCoupons;
  }

  public void setAllowConcurrentCoupons(Boolean allowConcurrentCoupons) {
    this.allowConcurrentCoupons = allowConcurrentCoupons;
  }

  public EditCouponRequest allowSecondaryPrice(Boolean allowSecondaryPrice) {
    this.allowSecondaryPrice = allowSecondaryPrice;
    return this;
  }

  /**
   * Get allowSecondaryPrice
   * @return allowSecondaryPrice
   **/
  
  
    public Boolean isAllowSecondaryPrice() {
    return allowSecondaryPrice;
  }

  public void setAllowSecondaryPrice(Boolean allowSecondaryPrice) {
    this.allowSecondaryPrice = allowSecondaryPrice;
  }

  public EditCouponRequest maximumUsageLimit(Integer maximumUsageLimit) {
    this.maximumUsageLimit = maximumUsageLimit;
    return this;
  }

  /**
   * Get maximumUsageLimit
   * @return maximumUsageLimit
   **/
  
  
    public Integer getMaximumUsageLimit() {
    return maximumUsageLimit;
  }

  public void setMaximumUsageLimit(Integer maximumUsageLimit) {
    this.maximumUsageLimit = maximumUsageLimit;
  }

  public EditCouponRequest maximumUsageLimitPerUser(Integer maximumUsageLimitPerUser) {
    this.maximumUsageLimitPerUser = maximumUsageLimitPerUser;
    return this;
  }

  /**
   * Get maximumUsageLimitPerUser
   * @return maximumUsageLimitPerUser
   **/
  
  
    public Integer getMaximumUsageLimitPerUser() {
    return maximumUsageLimitPerUser;
  }

  public void setMaximumUsageLimitPerUser(Integer maximumUsageLimitPerUser) {
    this.maximumUsageLimitPerUser = maximumUsageLimitPerUser;
  }

  public EditCouponRequest limitToPlans(List<Integer> limitToPlans) {
    this.limitToPlans = limitToPlans;
    return this;
  }

  public EditCouponRequest addLimitToPlansItem(Integer limitToPlansItem) {
    if (this.limitToPlans == null) {
      this.limitToPlans = new ArrayList<Integer>();
    }
    this.limitToPlans.add(limitToPlansItem);
    return this;
  }

  /**
   * Get limitToPlans
   * @return limitToPlans
   **/
  
  
    public List<Integer> getLimitToPlans() {
    return limitToPlans;
  }

  public void setLimitToPlans(List<Integer> limitToPlans) {
    this.limitToPlans = limitToPlans;
  }

  public EditCouponRequest exceptPlans(List<Integer> exceptPlans) {
    this.exceptPlans = exceptPlans;
    return this;
  }

  public EditCouponRequest addExceptPlansItem(Integer exceptPlansItem) {
    if (this.exceptPlans == null) {
      this.exceptPlans = new ArrayList<Integer>();
    }
    this.exceptPlans.add(exceptPlansItem);
    return this;
  }

  /**
   * Get exceptPlans
   * @return exceptPlans
   **/
  
  
    public List<Integer> getExceptPlans() {
    return exceptPlans;
  }

  public void setExceptPlans(List<Integer> exceptPlans) {
    this.exceptPlans = exceptPlans;
  }

  public EditCouponRequest targetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
    return this;
  }

  public EditCouponRequest addTargetUsersItem(UUID targetUsersItem) {
    if (this.targetUsers == null) {
      this.targetUsers = new ArrayList<UUID>();
    }
    this.targetUsers.add(targetUsersItem);
    return this;
  }

  /**
   * Get targetUsers
   * @return targetUsers
   **/
  
      @Valid
    public List<UUID> getTargetUsers() {
    return targetUsers;
  }

  public void setTargetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EditCouponRequest addCouponRequest = (EditCouponRequest) o;
    return
        Objects.equals(this.percentageBased, addCouponRequest.percentageBased) &&
        Objects.equals(this.amount, addCouponRequest.amount) &&
        Objects.equals(this.maximumAmount, addCouponRequest.maximumAmount) &&
        Objects.equals(this.currency, addCouponRequest.currency) &&
        Objects.equals(this.expirationDate, addCouponRequest.expirationDate) &&
        Objects.equals(this.allowConcurrentCoupons, addCouponRequest.allowConcurrentCoupons) &&
        Objects.equals(this.allowSecondaryPrice, addCouponRequest.allowSecondaryPrice) &&
        Objects.equals(this.maximumUsageLimit, addCouponRequest.maximumUsageLimit) &&
        Objects.equals(this.maximumUsageLimitPerUser, addCouponRequest.maximumUsageLimitPerUser) &&
        Objects.equals(this.limitToPlans, addCouponRequest.limitToPlans) &&
        Objects.equals(this.exceptPlans, addCouponRequest.exceptPlans) &&
        Objects.equals(this.targetUsers, addCouponRequest.targetUsers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(percentageBased, amount, maximumAmount, currency, expirationDate, allowConcurrentCoupons, allowSecondaryPrice, maximumUsageLimit, maximumUsageLimitPerUser, limitToPlans, exceptPlans, targetUsers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddCouponRequest {\n");
    
    sb.append("    percentageBased: ").append(toIndentedString(percentageBased)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    maximumAmount: ").append(toIndentedString(maximumAmount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    allowConcurrentCoupons: ").append(toIndentedString(allowConcurrentCoupons)).append("\n");
    sb.append("    allowSecondaryPrice: ").append(toIndentedString(allowSecondaryPrice)).append("\n");
    sb.append("    maximumUsageLimit: ").append(toIndentedString(maximumUsageLimit)).append("\n");
    sb.append("    maximumUsageLimitPerUser: ").append(toIndentedString(maximumUsageLimitPerUser)).append("\n");
    sb.append("    limitToPlans: ").append(toIndentedString(limitToPlans)).append("\n");
    sb.append("    exceptPlans: ").append(toIndentedString(exceptPlans)).append("\n");
    sb.append("    targetUsers: ").append(toIndentedString(targetUsers)).append("\n");
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
