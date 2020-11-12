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
 * RenewPlansRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")




public class RenewPlansRequest   {
  @JsonProperty("owner_id")
  private UUID ownerId = null;

  @JsonProperty("plans")
  private PlanRenewalPrice plans = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("coupons")
  @Valid
  private List<String> coupons = null;

  public RenewPlansRequest ownerId(UUID ownerId) {
    this.ownerId = ownerId;
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

  public RenewPlansRequest plans(PlanRenewalPrice plans) {
    this.plans = plans;
    return this;
  }

  /**
   * Get plans
   * @return plans
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PlanRenewalPrice getPlans() {
    return plans;
  }

  public void setPlans(PlanRenewalPrice plans) {
    this.plans = plans;
  }

  public RenewPlansRequest currency(String currency) {
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

  public RenewPlansRequest coupons(List<String> coupons) {
    this.coupons = coupons;
    return this;
  }

  public RenewPlansRequest addCouponsItem(String couponsItem) {
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
    RenewPlansRequest renewPlansRequest = (RenewPlansRequest) o;
    return Objects.equals(this.ownerId, renewPlansRequest.ownerId) &&
        Objects.equals(this.plans, renewPlansRequest.plans) &&
        Objects.equals(this.currency, renewPlansRequest.currency) &&
        Objects.equals(this.coupons, renewPlansRequest.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, plans, currency, coupons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RenewPlansRequest {\n");
    
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

