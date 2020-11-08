package ir.cliqmind.am.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * PlanFeature
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class PlanFeature   {
  @JsonProperty("feature_id")
  private Integer featureId = null;

  @JsonProperty("amount")
  private Double amount = null;

  public PlanFeature featureId(Integer featureId) {
    this.featureId = featureId;
    return this;
  }

  /**
   * Get featureId
   * @return featureId
  **/
  @ApiModelProperty(value = "")


  public Integer getFeatureId() {
    return featureId;
  }

  public void setFeatureId(Integer featureId) {
    this.featureId = featureId;
  }

  public PlanFeature amount(Double amount) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanFeature planFeature = (PlanFeature) o;
    return Objects.equals(this.featureId, planFeature.featureId) &&
        Objects.equals(this.amount, planFeature.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(featureId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanFeature {\n");
    
    sb.append("    featureId: ").append(toIndentedString(featureId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

