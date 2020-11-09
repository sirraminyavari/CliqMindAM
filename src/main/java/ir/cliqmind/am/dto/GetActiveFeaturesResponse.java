package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GetActiveFeaturesResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class GetActiveFeaturesResponse   {
  @JsonProperty("total_count")
  private Integer totalCount = null;

  @JsonProperty("features")
  @Valid
  private List<Feature> features = null;

  public GetActiveFeaturesResponse totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Get totalCount
   * @return totalCount
  **/
  @ApiModelProperty(value = "")


  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public GetActiveFeaturesResponse features(List<Feature> features) {
    this.features = features;
    return this;
  }

  public GetActiveFeaturesResponse addFeaturesItem(Feature featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<Feature>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Get features
   * @return features
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Feature> getFeatures() {
    return features;
  }

  public void setFeatures(List<Feature> features) {
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
    GetActiveFeaturesResponse getActiveFeaturesResponse = (GetActiveFeaturesResponse) o;
    return Objects.equals(this.totalCount, getActiveFeaturesResponse.totalCount) &&
        Objects.equals(this.features, getActiveFeaturesResponse.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetActiveFeaturesResponse {\n");
    
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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

