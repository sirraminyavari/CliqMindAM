package ir.cliqmind.am.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GetPlansResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class GetPlansResponse   {
  @JsonProperty("total_count")
  private Integer totalCount = null;

  @JsonProperty("plans")
  @Valid
  private List<Plan> plans = null;

  public GetPlansResponse totalCount(Integer totalCount) {
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

  public GetPlansResponse plans(List<Plan> plans) {
    this.plans = plans;
    return this;
  }

  public GetPlansResponse addPlansItem(Plan plansItem) {
    if (this.plans == null) {
      this.plans = new ArrayList<Plan>();
    }
    this.plans.add(plansItem);
    return this;
  }

  /**
   * Get plans
   * @return plans
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Plan> getPlans() {
    return plans;
  }

  public void setPlans(List<Plan> plans) {
    this.plans = plans;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPlansResponse getPlansResponse = (GetPlansResponse) o;
    return Objects.equals(this.totalCount, getPlansResponse.totalCount) &&
        Objects.equals(this.plans, getPlansResponse.plans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, plans);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPlansResponse {\n");
    
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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

