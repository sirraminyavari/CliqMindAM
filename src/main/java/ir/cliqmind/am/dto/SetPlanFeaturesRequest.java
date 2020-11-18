package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SetPlanFeaturesRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")




public class SetPlanFeaturesRequest   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("features")
  private PlanFeatures features = null;

  public SetPlanFeaturesRequest id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SetPlanFeaturesRequest features(PlanFeatures features) {
    this.features = features;
    return this;
  }

  /**
   * Get features
   * @return features
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PlanFeatures getFeatures() {
    return features;
  }

  public void setFeatures(PlanFeatures features) {
    this.features = features;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetPlanFeaturesRequest setPlanFeaturesRequest = (SetPlanFeaturesRequest) o;
    return Objects.equals(this.id, setPlanFeaturesRequest.id) &&
        Objects.equals(this.features, setPlanFeaturesRequest.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetPlanFeaturesRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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

