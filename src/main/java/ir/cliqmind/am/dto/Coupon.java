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
 * Coupon
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class Coupon   {
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

  @JsonProperty("except_plans")
  @Valid
  private List<Integer> exceptPlans = null;

  @JsonProperty("target_users")
  @Valid
  private List<UUID> targetUsers = null;

  public Coupon code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Coupon percentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
    return this;
  }

  /**
   * Get percentageBased
   * @return percentageBased
  **/
  @ApiModelProperty(value = "")


  public Boolean isPercentageBased() {
    return percentageBased;
  }

  public void setPercentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
  }

  public Coupon amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Coupon maximumAmount(Double maximumAmount) {
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

  public Coupon currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="[A-Z][A-Z][A-Z]") 
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Coupon expirationDate(OffsetDateTime expirationDate) {
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

  public Coupon exceptPlans(List<Integer> exceptPlans) {
    this.exceptPlans = exceptPlans;
    return this;
  }

  public Coupon addExceptPlansItem(Integer exceptPlansItem) {
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

  public Coupon targetUsers(List<UUID> targetUsers) {
    this.targetUsers = targetUsers;
    return this;
  }

  public Coupon addTargetUsersItem(UUID targetUsersItem) {
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
    Coupon coupon = (Coupon) o;
    return Objects.equals(this.code, coupon.code) &&
        Objects.equals(this.percentageBased, coupon.percentageBased) &&
        Objects.equals(this.amount, coupon.amount) &&
        Objects.equals(this.maximumAmount, coupon.maximumAmount) &&
        Objects.equals(this.currency, coupon.currency) &&
        Objects.equals(this.expirationDate, coupon.expirationDate) &&
        Objects.equals(this.exceptPlans, coupon.exceptPlans) &&
        Objects.equals(this.targetUsers, coupon.targetUsers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, percentageBased, amount, maximumAmount, currency, expirationDate, exceptPlans, targetUsers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coupon {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    percentageBased: ").append(toIndentedString(percentageBased)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    maximumAmount: ").append(toIndentedString(maximumAmount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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

