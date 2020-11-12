package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpradePlanRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")




public class UpradePlanRequest   {
  @JsonProperty("from_plan_id")
  private Integer fromPlanId = null;

  @JsonProperty("to_plan_id")
  private Integer toPlanId = null;

  @JsonProperty("owner_id")
  private UUID ownerId = null;

  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("use_secondary_price")
  private Boolean useSecondaryPrice = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("coupons")
  @Valid
  private List<Coupon> coupons = null;

  public UpradePlanRequest fromPlanId(Integer fromPlanId) {
    this.fromPlanId = fromPlanId;
    return this;
  }

  /**
   * Get fromPlanId
   * @return fromPlanId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getFromPlanId() {
    return fromPlanId;
  }

  public void setFromPlanId(Integer fromPlanId) {
    this.fromPlanId = fromPlanId;
  }

  public UpradePlanRequest toPlanId(Integer toPlanId) {
    this.toPlanId = toPlanId;
    return this;
  }

  /**
   * Get toPlanId
   * @return toPlanId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getToPlanId() {
    return toPlanId;
  }

  public void setToPlanId(Integer toPlanId) {
    this.toPlanId = toPlanId;
  }

  public UpradePlanRequest ownerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
  }

  public UpradePlanRequest amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public UpradePlanRequest useSecondaryPrice(Boolean useSecondaryPrice) {
    this.useSecondaryPrice = useSecondaryPrice;
    return this;
  }

  /**
   * Get useSecondaryPrice
   * @return useSecondaryPrice
  **/
  @ApiModelProperty(value = "")


  public Boolean isUseSecondaryPrice() {
    return useSecondaryPrice;
  }

  public void setUseSecondaryPrice(Boolean useSecondaryPrice) {
    this.useSecondaryPrice = useSecondaryPrice;
  }

  public UpradePlanRequest currency(String currency) {
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

  public UpradePlanRequest coupons(List<Coupon> coupons) {
    this.coupons = coupons;
    return this;
  }

  public UpradePlanRequest addCouponsItem(Coupon couponsItem) {
    if (this.coupons == null) {
      this.coupons = new ArrayList<Coupon>();
    }
    this.coupons.add(couponsItem);
    return this;
  }

  /**
   * Get coupons
   * @return coupons
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Coupon> getCoupons() {
    return coupons;
  }

  public void setCoupons(List<Coupon> coupons) {
    this.coupons = coupons;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpradePlanRequest upradePlanRequest = (UpradePlanRequest) o;
    return Objects.equals(this.fromPlanId, upradePlanRequest.fromPlanId) &&
        Objects.equals(this.toPlanId, upradePlanRequest.toPlanId) &&
        Objects.equals(this.ownerId, upradePlanRequest.ownerId) &&
        Objects.equals(this.amount, upradePlanRequest.amount) &&
        Objects.equals(this.useSecondaryPrice, upradePlanRequest.useSecondaryPrice) &&
        Objects.equals(this.currency, upradePlanRequest.currency) &&
        Objects.equals(this.coupons, upradePlanRequest.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromPlanId, toPlanId, ownerId, amount, useSecondaryPrice, currency, coupons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpradePlanRequest {\n");
    
    sb.append("    fromPlanId: ").append(toIndentedString(fromPlanId)).append("\n");
    sb.append("    toPlanId: ").append(toIndentedString(toPlanId)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    useSecondaryPrice: ").append(toIndentedString(useSecondaryPrice)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    coupons: ").append(toIndentedString(coupons)).append("\n");
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

