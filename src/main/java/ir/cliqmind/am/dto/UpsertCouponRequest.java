package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpsertCouponRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")




public class UpsertCouponRequest   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("percentage_based")
  private Boolean percentageBased = null;

  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("maximum_amount")
  private Double maximumAmount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("expiration_date")
  private OffsetDateTime expirationDate = null;

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

  public UpsertCouponRequest code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public UpsertCouponRequest percentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
    return this;
  }

  /**
   * Get percentageBased
   * @return percentageBased
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isPercentageBased() {
    return percentageBased;
  }

  public void setPercentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
  }

  public UpsertCouponRequest amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public UpsertCouponRequest maximumAmount(Double maximumAmount) {
    this.maximumAmount = maximumAmount;
    return this;
  }

  /**
   * Get maximumAmount
   * @return maximumAmount
  **/
  @ApiModelProperty(value = "")


  public Double getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(Double maximumAmount) {
    this.maximumAmount = maximumAmount;
  }

  public UpsertCouponRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Pattern(regexp="[A-Z][A-Z][A-Z]") 
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public UpsertCouponRequest expirationDate(OffsetDateTime expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(OffsetDateTime expirationDate) {
    this.expirationDate = expirationDate;
  }

  public UpsertCouponRequest allowConcurrentCoupons(Boolean allowConcurrentCoupons) {
    this.allowConcurrentCoupons = allowConcurrentCoupons;
    return this;
  }

  /**
   * Get allowConcurrentCoupons
   * @return allowConcurrentCoupons
  **/
  @ApiModelProperty(value = "")


  public Boolean isAllowConcurrentCoupons() {
    return allowConcurrentCoupons;
  }

  public void setAllowConcurrentCoupons(Boolean allowConcurrentCoupons) {
    this.allowConcurrentCoupons = allowConcurrentCoupons;
  }

  public UpsertCouponRequest allowSecondaryPrice(Boolean allowSecondaryPrice) {
    this.allowSecondaryPrice = allowSecondaryPrice;
    return this;
  }

  /**
   * Get allowSecondaryPrice
   * @return allowSecondaryPrice
  **/
  @ApiModelProperty(value = "")


  public Boolean isAllowSecondaryPrice() {
    return allowSecondaryPrice;
  }

  public void setAllowSecondaryPrice(Boolean allowSecondaryPrice) {
    this.allowSecondaryPrice = allowSecondaryPrice;
  }

  public UpsertCouponRequest maximumUsageLimit(Integer maximumUsageLimit) {
    this.maximumUsageLimit = maximumUsageLimit;
    return this;
  }

  /**
   * Get maximumUsageLimit
   * @return maximumUsageLimit
  **/
  @ApiModelProperty(value = "")


  public Integer getMaximumUsageLimit() {
    return maximumUsageLimit;
  }

  public void setMaximumUsageLimit(Integer maximumUsageLimit) {
    this.maximumUsageLimit = maximumUsageLimit;
  }

  public UpsertCouponRequest maximumUsageLimitPerUser(Integer maximumUsageLimitPerUser) {
    this.maximumUsageLimitPerUser = maximumUsageLimitPerUser;
    return this;
  }

  /**
   * Get maximumUsageLimitPerUser
   * @return maximumUsageLimitPerUser
  **/
  @ApiModelProperty(value = "")


  public Integer getMaximumUsageLimitPerUser() {
    return maximumUsageLimitPerUser;
  }

  public void setMaximumUsageLimitPerUser(Integer maximumUsageLimitPerUser) {
    this.maximumUsageLimitPerUser = maximumUsageLimitPerUser;
  }

  public UpsertCouponRequest limitToPlans(List<Integer> limitToPlans) {
    this.limitToPlans = limitToPlans;
    return this;
  }

  public UpsertCouponRequest addLimitToPlansItem(Integer limitToPlansItem) {
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
  @ApiModelProperty(value = "")


  public List<Integer> getLimitToPlans() {
    return limitToPlans;
  }

  public void setLimitToPlans(List<Integer> limitToPlans) {
    this.limitToPlans = limitToPlans;
  }

  public UpsertCouponRequest exceptPlans(List<Integer> exceptPlans) {
    this.exceptPlans = exceptPlans;
    return this;
  }

  public UpsertCouponRequest addExceptPlansItem(Integer exceptPlansItem) {
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
  @ApiModelProperty(value = "")


  public List<Integer> getExceptPlans() {
    return exceptPlans;
  }

  public void setExceptPlans(List<Integer> exceptPlans) {
    this.exceptPlans = exceptPlans;
  }

  public UpsertCouponRequest targetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
    return this;
  }

  public UpsertCouponRequest addTargetUsersItem(UUID targetUsersItem) {
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
  @ApiModelProperty(value = "")

  @Valid

  public List<UUID> getTargetUsers() {
    return targetUsers;
  }

  public void setTargetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpsertCouponRequest upsertCouponRequest = (UpsertCouponRequest) o;
    return Objects.equals(this.code, upsertCouponRequest.code) &&
        Objects.equals(this.percentageBased, upsertCouponRequest.percentageBased) &&
        Objects.equals(this.amount, upsertCouponRequest.amount) &&
        Objects.equals(this.maximumAmount, upsertCouponRequest.maximumAmount) &&
        Objects.equals(this.currency, upsertCouponRequest.currency) &&
        Objects.equals(this.expirationDate, upsertCouponRequest.expirationDate) &&
        Objects.equals(this.allowConcurrentCoupons, upsertCouponRequest.allowConcurrentCoupons) &&
        Objects.equals(this.allowSecondaryPrice, upsertCouponRequest.allowSecondaryPrice) &&
        Objects.equals(this.maximumUsageLimit, upsertCouponRequest.maximumUsageLimit) &&
        Objects.equals(this.maximumUsageLimitPerUser, upsertCouponRequest.maximumUsageLimitPerUser) &&
        Objects.equals(this.limitToPlans, upsertCouponRequest.limitToPlans) &&
        Objects.equals(this.exceptPlans, upsertCouponRequest.exceptPlans) &&
        Objects.equals(this.targetUsers, upsertCouponRequest.targetUsers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, percentageBased, amount, maximumAmount, currency, expirationDate, allowConcurrentCoupons, allowSecondaryPrice, maximumUsageLimit, maximumUsageLimitPerUser, limitToPlans, exceptPlans, targetUsers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpsertCouponRequest {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

