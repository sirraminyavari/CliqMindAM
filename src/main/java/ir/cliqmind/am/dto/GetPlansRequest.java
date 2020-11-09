package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GetPlansRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class GetPlansRequest   {
  @JsonProperty("ids")
  @Valid
  private List<Integer> ids = null;

  @JsonProperty("active")
  private Boolean active = null;

  public GetPlansRequest ids(List<Integer> ids) {
    this.ids = ids;
    return this;
  }

  public GetPlansRequest addIdsItem(Integer idsItem) {
    if (this.ids == null) {
      this.ids = new ArrayList<Integer>();
    }
    this.ids.add(idsItem);
    return this;
  }

  /**
   * Get ids
   * @return ids
  **/
  @ApiModelProperty(value = "")


  public List<Integer> getIds() {
    return ids;
  }

  public void setIds(List<Integer> ids) {
    this.ids = ids;
  }

  public GetPlansRequest active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")


  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPlansRequest getPlansRequest = (GetPlansRequest) o;
    return Objects.equals(this.ids, getPlansRequest.ids) &&
        Objects.equals(this.active, getPlansRequest.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ids, active);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPlansRequest {\n");
    
    sb.append("    ids: ").append(toIndentedString(ids)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
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

