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
 * CalculatePlanRenewalPriceRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")


public class CalculatePlanRenewalPriceRequest   {
  @JsonProperty("owner_id")
  private UUID ownerId = null;

  @JsonProperty("plans")
  private PlanRenewalPrice plans = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("coupons")
  @Valid
  private List<String> coupons = null;

  public CalculatePlanRenewalPriceRequest ownerId(UUID ownerId) {
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

  public CalculatePlanRenewalPriceRequest plans(PlanRenewalPrice plans) {
    this.plans = plans;
    return this;
  }

  /**
   * Get plans
   * @return plans
   **/
      @NotNull

    @Valid
    public PlanRenewalPrice getPlans() {
    return plans;
  }

  public void setPlans(PlanRenewalPrice plans) {
    this.plans = plans;
  }

  public CalculatePlanRenewalPriceRequest currency(String currency) {
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

  public CalculatePlanRenewalPriceRequest coupons(List<String> coupons) {
    this.coupons = coupons;
    return this;
  }

  public CalculatePlanRenewalPriceRequest addCouponsItem(String couponsItem) {
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
    CalculatePlanRenewalPriceRequest calculatePlanRenewalPriceRequest = (CalculatePlanRenewalPriceRequest) o;
    return Objects.equals(this.ownerId, calculatePlanRenewalPriceRequest.ownerId) &&
        Objects.equals(this.plans, calculatePlanRenewalPriceRequest.plans) &&
        Objects.equals(this.currency, calculatePlanRenewalPriceRequest.currency) &&
        Objects.equals(this.coupons, calculatePlanRenewalPriceRequest.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, plans, currency, coupons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatePlanRenewalPriceRequest {\n");
    
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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
