package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CalculatePlanUpgradeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")


public class CalculatePlanUpgradeRequest   {
  @JsonProperty("owner_id")
  private UUID ownerId = null;

  @JsonProperty("from_plan_id")
  private Integer fromPlanId = null;

  @JsonProperty("to_plan_id")
  private Integer toPlanId = null;

  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("use_secondary_price")
  private Boolean useSecondaryPrice = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("coupons")
  @Valid
  private List<String> coupons = null;

  public CalculatePlanUpgradeRequest ownerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
   **/
      @NotNull

    @Valid
    public UUID getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
  }

  public CalculatePlanUpgradeRequest fromPlanId(Integer fromPlanId) {
    this.fromPlanId = fromPlanId;
    return this;
  }

  /**
   * Get fromPlanId
   * @return fromPlanId
   **/
      @NotNull

    public Integer getFromPlanId() {
    return fromPlanId;
  }

  public void setFromPlanId(Integer fromPlanId) {
    this.fromPlanId = fromPlanId;
  }

  public CalculatePlanUpgradeRequest toPlanId(Integer toPlanId) {
    this.toPlanId = toPlanId;
    return this;
  }

  /**
   * Get toPlanId
   * @return toPlanId
   **/
      @NotNull

    public Integer getToPlanId() {
    return toPlanId;
  }

  public void setToPlanId(Integer toPlanId) {
    this.toPlanId = toPlanId;
  }

  public CalculatePlanUpgradeRequest amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/

    public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public CalculatePlanUpgradeRequest useSecondaryPrice(Boolean useSecondaryPrice) {
    this.useSecondaryPrice = useSecondaryPrice;
    return this;
  }

  /**
   * Get useSecondaryPrice
   * @return useSecondaryPrice
   **/

    public Boolean isUseSecondaryPrice() {
    return useSecondaryPrice;
  }

  public void setUseSecondaryPrice(Boolean useSecondaryPrice) {
    this.useSecondaryPrice = useSecondaryPrice;
  }

  public CalculatePlanUpgradeRequest currency(String currency) {
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

  public CalculatePlanUpgradeRequest coupons(List<String> coupons) {
    this.coupons = coupons;
    return this;
  }

  public CalculatePlanUpgradeRequest addCouponsItem(String couponsItem) {
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

    public List<String> getCoupons() {
    return coupons;
  }

  public void setCoupons(List<String> coupons) {
    this.coupons = coupons;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculatePlanUpgradeRequest calculatePlanUpgradeRequest = (CalculatePlanUpgradeRequest) o;
    return Objects.equals(this.ownerId, calculatePlanUpgradeRequest.ownerId) &&
        Objects.equals(this.fromPlanId, calculatePlanUpgradeRequest.fromPlanId) &&
        Objects.equals(this.toPlanId, calculatePlanUpgradeRequest.toPlanId) &&
        Objects.equals(this.amount, calculatePlanUpgradeRequest.amount) &&
        Objects.equals(this.useSecondaryPrice, calculatePlanUpgradeRequest.useSecondaryPrice) &&
        Objects.equals(this.currency, calculatePlanUpgradeRequest.currency) &&
        Objects.equals(this.coupons, calculatePlanUpgradeRequest.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, fromPlanId, toPlanId, amount, useSecondaryPrice, currency, coupons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatePlanUpgradeRequest {\n");
    
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    fromPlanId: ").append(toIndentedString(fromPlanId)).append("\n");
    sb.append("    toPlanId: ").append(toIndentedString(toPlanId)).append("\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
