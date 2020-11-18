package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GetPlanActivationHistoryResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")




public class GetPlanActivationHistoryResponse   {
  @JsonProperty("total_count")
  private Integer totalCount = null;

  @JsonProperty("items")
  @Valid
  private List<PlanActivationItem> items = null;

  public GetPlanActivationHistoryResponse totalCount(Integer totalCount) {
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

  public GetPlanActivationHistoryResponse items(List<PlanActivationItem> items) {
    this.items = items;
    return this;
  }

  public GetPlanActivationHistoryResponse addItemsItem(PlanActivationItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<PlanActivationItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PlanActivationItem> getItems() {
    return items;
  }

  public void setItems(List<PlanActivationItem> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPlanActivationHistoryResponse getPlanActivationHistoryResponse = (GetPlanActivationHistoryResponse) o;
    return Objects.equals(this.totalCount, getPlanActivationHistoryResponse.totalCount) &&
        Objects.equals(this.items, getPlanActivationHistoryResponse.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPlanActivationHistoryResponse {\n");
    
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

