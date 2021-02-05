package ir.cliqmind.am.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetCouponsRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCouponsRequest   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("percentage_based")
  private Boolean percentageBased = null;

  @JsonProperty("from_amount")
  private Double fromAmount = null;

  @JsonProperty("to_amount")
  private Double toAmount = null;

  @JsonProperty("limited_to_plan")
  private Integer limitedToPlan = null;

  @JsonProperty("except_plan")
  private Integer exceptPlan = null;

  @JsonProperty("target_user")
  private UUID targetUser = null;

  @JsonProperty("from_date")
  private LocalDate fromDate = null;

  @JsonProperty("to_date")
  private LocalDate toDate = null;

  public GetCouponsRequest code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public GetCouponsRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  
  
  @Pattern(regexp="[A-Z][A-Z][A-Z]")   public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public GetCouponsRequest percentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
    return this;
  }

  /**
   * Get percentageBased
   * @return percentageBased
   **/
  
  
    public Boolean isPercentageBased() {
    return percentageBased;
  }

  public void setPercentageBased(Boolean percentageBased) {
    this.percentageBased = percentageBased;
  }

  public GetCouponsRequest fromAmount(Double fromAmount) {
    this.fromAmount = fromAmount;
    return this;
  }

  /**
   * Get fromAmount
   * @return fromAmount
   **/
  

    public Double getFromAmount() {
    return fromAmount;
  }

  public void setFromAmount(Double fromAmount) {
    this.fromAmount = fromAmount;
  }

  public GetCouponsRequest toAmount(Double toAmount) {
    this.toAmount = toAmount;
    return this;
  }

  /**
   * Get toAmount
   * @return toAmount
   **/
  
  
    public Double getToAmount() {
    return toAmount;
  }

  public void setToAmount(Double toAmount) {
    this.toAmount = toAmount;
  }

  public GetCouponsRequest limitedToPlan(Integer limitedToPlan) {
    this.limitedToPlan = limitedToPlan;
    return this;
  }

  /**
   * Get limitedToPlan
   * @return limitedToPlan
   **/
  
  
    public Integer getLimitedToPlan() {
    return limitedToPlan;
  }

  public void setLimitedToPlan(Integer limitedToPlan) {
    this.limitedToPlan = limitedToPlan;
  }

  public GetCouponsRequest exceptPlan(Integer exceptPlan) {
    this.exceptPlan = exceptPlan;
    return this;
  }

  /**
   * Get exceptPlan
   * @return exceptPlan
   **/
  
  
    public Integer getExceptPlan() {
    return exceptPlan;
  }

  public void setExceptPlan(Integer exceptPlan) {
    this.exceptPlan = exceptPlan;
  }

  public GetCouponsRequest targetUser(UUID targetUser) {
    this.targetUser = targetUser;
    return this;
  }

  /**
   * Get targetUser
   * @return targetUser
   **/
  
  
    @Valid
    public UUID getTargetUser() {
    return targetUser;
  }

  public void setTargetUser(UUID targetUser) {
    this.targetUser = targetUser;
  }

  public GetCouponsRequest fromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
   **/
  
  
    @Valid
    public LocalDate getFromDate() {
    return fromDate;
  }

  public void setFromDate(LocalDate fromDate) {
    this.fromDate = fromDate;
  }

  public GetCouponsRequest toDate(LocalDate toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
   **/
  
  
    @Valid
    public LocalDate getToDate() {
    return toDate;
  }

  public void setToDate(LocalDate toDate) {
    this.toDate = toDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCouponsRequest getCouponsRequest = (GetCouponsRequest) o;
    return Objects.equals(this.code, getCouponsRequest.code) &&
        Objects.equals(this.currency, getCouponsRequest.currency) &&
        Objects.equals(this.percentageBased, getCouponsRequest.percentageBased) &&
        Objects.equals(this.fromAmount, getCouponsRequest.fromAmount) &&
        Objects.equals(this.toAmount, getCouponsRequest.toAmount) &&
        Objects.equals(this.limitedToPlan, getCouponsRequest.limitedToPlan) &&
        Objects.equals(this.exceptPlan, getCouponsRequest.exceptPlan) &&
        Objects.equals(this.targetUser, getCouponsRequest.targetUser) &&
        Objects.equals(this.fromDate, getCouponsRequest.fromDate) &&
        Objects.equals(this.toDate, getCouponsRequest.toDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, currency, percentageBased, fromAmount, toAmount, limitedToPlan, exceptPlan, targetUser, fromDate, toDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCouponsRequest {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    percentageBased: ").append(toIndentedString(percentageBased)).append("\n");
    sb.append("    fromAmount: ").append(toIndentedString(fromAmount)).append("\n");
    sb.append("    toAmount: ").append(toIndentedString(toAmount)).append("\n");
    sb.append("    limitedToPlan: ").append(toIndentedString(limitedToPlan)).append("\n");
    sb.append("    exceptPlan: ").append(toIndentedString(exceptPlan)).append("\n");
    sb.append("    targetUser: ").append(toIndentedString(targetUser)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
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
