package ir.cliqmind.am.dto;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GetTransactionsRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")




public class GetTransactionsRequest   {
  @JsonProperty("ids")
  @Valid
  private List<Long> ids = null;

  @JsonProperty("user_id")
  private UUID userId = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("is_deposit")
  private Boolean isDeposit = null;

  @JsonProperty("rollbacked")
  private Boolean rollbacked = null;

  @JsonProperty("from_date")
  private Date fromDate = null;

  @JsonProperty("to_date")
  private Date toDate = null;

  @JsonProperty("from_amount")
  private Double fromAmount = null;

  @JsonProperty("to_amount")
  private Double toAmount = null;

  @JsonProperty("count")
  private Integer count = 50;

  @JsonProperty("count_from")
  private Integer countFrom = null;

  public GetTransactionsRequest ids(List<Long> ids) {
    this.ids = ids;
    return this;
  }

  public GetTransactionsRequest addIdsItem(Long idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<Long>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Get ids
   * @return ids
  **/
  @ApiModelProperty(value = "")


  public List<Long> getIds() {
    return ids;
  }

  public void setIds(List<Long> ids) {
    this.ids = ids;
  }

  public GetTransactionsRequest userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public GetTransactionsRequest currency(String currency) {
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

  public GetTransactionsRequest isDeposit(Boolean isDeposit) {
    this.isDeposit = isDeposit;
    return this;
  }

  /**
   * Get isDeposit
   * @return isDeposit
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsDeposit() {
    return isDeposit;
  }

  public void setIsDeposit(Boolean isDeposit) {
    this.isDeposit = isDeposit;
  }

  public GetTransactionsRequest rollbacked(Boolean rollbacked) {
    this.rollbacked = rollbacked;
    return this;
  }

  /**
   * Get rollbacked
   * @return rollbacked
  **/
  @ApiModelProperty(value = "")


  public Boolean isRollbacked() {
    return rollbacked;
  }

  public void setRollbacked(Boolean rollbacked) {
    this.rollbacked = rollbacked;
  }

  public GetTransactionsRequest fromDate(Date fromDate) {
    this.fromDate = fromDate;
    return this;
  }

  /**
   * Get fromDate
   * @return fromDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  public GetTransactionsRequest toDate(Date toDate) {
    this.toDate = toDate;
    return this;
  }

  /**
   * Get toDate
   * @return toDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Date getToDate() {
    return toDate;
  }

  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  public GetTransactionsRequest fromAmount(Double fromAmount) {
    this.fromAmount = fromAmount;
    return this;
  }

  /**
   * Get fromAmount
   * @return fromAmount
  **/
  @ApiModelProperty(value = "")


  public Double getFromAmount() {
    return fromAmount;
  }

  public void setFromAmount(Double fromAmount) {
    this.fromAmount = fromAmount;
  }

  public GetTransactionsRequest toAmount(Double toAmount) {
    this.toAmount = toAmount;
    return this;
  }

  /**
   * Get toAmount
   * @return toAmount
  **/
  @ApiModelProperty(value = "")


  public Double getToAmount() {
    return toAmount;
  }

  public void setToAmount(Double toAmount) {
    this.toAmount = toAmount;
  }

  public GetTransactionsRequest count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * minimum: 1
   * maximum: 200
   * @return count
  **/
  @ApiModelProperty(value = "")

@Min(1) @Max(200) 
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GetTransactionsRequest countFrom(Integer countFrom) {
    this.countFrom = countFrom;
    return this;
  }

  /**
   * Get countFrom
   * minimum: 1
   * @return countFrom
  **/
  @ApiModelProperty(value = "")

@Min(1)
  public Integer getCountFrom() {
    return countFrom;
  }

  public void setCountFrom(Integer countFrom) {
    this.countFrom = countFrom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTransactionsRequest getTransactionsRequest = (GetTransactionsRequest) o;
    return Objects.equals(this.ids, getTransactionsRequest.ids) &&
        Objects.equals(this.userId, getTransactionsRequest.userId) &&
        Objects.equals(this.currency, getTransactionsRequest.currency) &&
        Objects.equals(this.isDeposit, getTransactionsRequest.isDeposit) &&
        Objects.equals(this.rollbacked, getTransactionsRequest.rollbacked) &&
        Objects.equals(this.fromDate, getTransactionsRequest.fromDate) &&
        Objects.equals(this.toDate, getTransactionsRequest.toDate) &&
        Objects.equals(this.fromAmount, getTransactionsRequest.fromAmount) &&
        Objects.equals(this.toAmount, getTransactionsRequest.toAmount) &&
        Objects.equals(this.count, getTransactionsRequest.count) &&
        Objects.equals(this.countFrom, getTransactionsRequest.countFrom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids, userId, currency, isDeposit, rollbacked, fromDate, toDate, fromAmount, toAmount, count, countFrom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTransactionsRequest {\n");
    
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    isDeposit: ").append(toIndentedString(isDeposit)).append("\n");
    sb.append("    rollbacked: ").append(toIndentedString(rollbacked)).append("\n");
    sb.append("    fromDate: ").append(toIndentedString(fromDate)).append("\n");
    sb.append("    toDate: ").append(toIndentedString(toDate)).append("\n");
    sb.append("    fromAmount: ").append(toIndentedString(fromAmount)).append("\n");
    sb.append("    toAmount: ").append(toIndentedString(toAmount)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    countFrom: ").append(toIndentedString(countFrom)).append("\n");
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

