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
 * BuyPlanRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")




public class BuyPlanRequest   {
  @JsonProperty("plan_id")
  private Integer planId = null;

  @JsonProperty("owner_id")
  private UUID ownerId = null;

  @JsonProperty("user_id")
  private UUID userId = null;

  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("use_secondary_price")
  private Boolean useSecondaryPrice = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("coupons")
  @Valid
  private List<String> coupons = null;

  public BuyPlanRequest planId(Integer planId) {
    this.planId = planId;
    return this;
  }

  /**
   * Get planId
   * @return planId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getPlanId() {
    return planId;
  }

  public void setPlanId(Integer planId) {
    this.planId = planId;
  }

  public BuyPlanRequest ownerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  public BuyPlanRequest userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public UUID getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public BuyPlanRequest amount(Integer amount) {
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

  public BuyPlanRequest useSecondaryPrice(Boolean useSecondaryPrice) {
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

  public BuyPlanRequest currency(String currency) {
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

  public BuyPlanRequest coupons(List<String> coupons) {
    this.coupons = coupons;
    return this;
  }

  public BuyPlanRequest addCouponsItem(String couponsItem) {
    if (this.coupons == null) {
      this.coupons = new ArrayList<String>();
    }
    this.coupons.add(couponsItem);
    return this;
  }

  /**
   * Get coupons
   * @return coupons
  **/
  @ApiModelProperty(value = "")


  public List<String> getCoupons() {
    return coupons;
  }

  public void setCoupons(List<String> coupons) {
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
    BuyPlanRequest buyPlanRequest = (BuyPlanRequest) o;
    return Objects.equals(this.planId, buyPlanRequest.planId) &&
        Objects.equals(this.ownerId, buyPlanRequest.ownerId) &&
        Objects.equals(this.amount, buyPlanRequest.amount) &&
        Objects.equals(this.useSecondaryPrice, buyPlanRequest.useSecondaryPrice) &&
        Objects.equals(this.currency, buyPlanRequest.currency) &&
        Objects.equals(this.coupons, buyPlanRequest.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, ownerId, amount, useSecondaryPrice, currency, coupons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuyPlanRequest {\n");
    
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

