package ir.cliqmind.am.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PlanActivationItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class PlanActivationItem   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("datetime")
  private OffsetDateTime datetime = null;

  public PlanActivationItem id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PlanActivationItem active(Boolean active) {
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

  public PlanActivationItem datetime(OffsetDateTime datetime) {
    this.datetime = datetime;
    return this;
  }

  /**
   * Get datetime
   * @return datetime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDatetime() {
    return datetime;
  }

  public void setDatetime(OffsetDateTime datetime) {
    this.datetime = datetime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanActivationItem planActivationItem = (PlanActivationItem) o;
    return Objects.equals(this.id, planActivationItem.id) &&
        Objects.equals(this.active, planActivationItem.active) &&
        Objects.equals(this.datetime, planActivationItem.datetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, active, datetime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanActivationItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
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

