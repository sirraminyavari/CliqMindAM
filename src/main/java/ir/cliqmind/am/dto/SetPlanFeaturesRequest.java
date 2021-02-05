package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SetPlanFeaturesRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")


public class SetPlanFeaturesRequest   {
  @JsonProperty("features")
  private PlanFeatures features = null;

  public SetPlanFeaturesRequest features(PlanFeatures features) {
    this.features = features;
    return this;
  }

  /**
   * Get features
   * @return features
   **/
  
      @NotNull

    @Valid
    public PlanFeatures getFeatures() {
    return features;
  }

  public void setFeatures(PlanFeatures features) {
    this.features = features;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetPlanFeaturesRequest setPlanFeaturesRequest = (SetPlanFeaturesRequest) o;
    return Objects.equals(this.features, setPlanFeaturesRequest.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetPlanFeaturesRequest {\n");
    
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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
