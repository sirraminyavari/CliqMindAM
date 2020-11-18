package ir.cliqmind.am.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * PlanFeaturesInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")



@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanFeaturesInner   {
  @JsonProperty("feature_id")
  private Integer featureId = null;

  @JsonProperty("amount")
  private Integer amount = null;

  @JsonProperty("maximum_amount")
  private Integer maximumAmount = null;

  public PlanFeaturesInner featureId(Integer featureId) {
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

  public PlanFeaturesInner amount(Integer amount) {
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

  public PlanFeaturesInner maximumAmount(Integer maximumAmount) {
    this.maximumAmount = maximumAmount;
    return this;
  }

  /**
   * Get maximumAmount
   * @return maximumAmount
  **/
  @ApiModelProperty(value = "")


  public Integer getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(Integer maximumAmount) {
    this.maximumAmount = maximumAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanFeaturesInner planFeaturesInner = (PlanFeaturesInner) o;
    return Objects.equals(this.featureId, planFeaturesInner.featureId) &&
        Objects.equals(this.amount, planFeaturesInner.amount) &&
        Objects.equals(this.maximumAmount, planFeaturesInner.maximumAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(featureId, amount, maximumAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanFeaturesInner {\n");
    
    sb.append("    featureId: ").append(toIndentedString(featureId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    maximumAmount: ").append(toIndentedString(maximumAmount)).append("\n");
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

