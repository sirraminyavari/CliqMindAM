package ir.cliqmind.am.model;

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
 * GetPlanActivationHistoryRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class GetPlanActivationHistoryRequest   {
  @JsonProperty("owner_id")
  private UUID ownerId = null;

  @JsonProperty("plan_ids")
  @Valid
  private List<Integer> planIds = null;

  @JsonProperty("expired")
  private Boolean expired = null;

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("count_from")
  private Integer countFrom = null;

  public GetPlanActivationHistoryRequest ownerId(UUID ownerId) {
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

  public GetPlanActivationHistoryRequest planIds(List<Integer> planIds) {
    this.planIds = planIds;
    return this;
  }

  public GetPlanActivationHistoryRequest addPlanIdsItem(Integer planIdsItem) {
    if (this.planIds == null) {
      this.planIds = new ArrayList<Integer>();
    }
    this.planIds.add(planIdsItem);
    return this;
  }

  /**
   * Get planIds
   * @return planIds
  **/
  @ApiModelProperty(value = "")


  public List<Integer> getPlanIds() {
    return planIds;
  }

  public void setPlanIds(List<Integer> planIds) {
    this.planIds = planIds;
  }

  public GetPlanActivationHistoryRequest expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

  /**
   * Get expired
   * @return expired
  **/
  @ApiModelProperty(value = "")


  public Boolean isExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public GetPlanActivationHistoryRequest active(Boolean active) {
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

  public GetPlanActivationHistoryRequest count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * minimum: 1
   * @return count
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Min(1)
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GetPlanActivationHistoryRequest countFrom(Integer countFrom) {
    this.countFrom = countFrom;
    return this;
  }

  /**
   * Get countFrom
   * minimum: 1
   * @return countFrom
  **/
  @ApiModelProperty(value = "")

@Min(1)
  public Integer getCountFrom() {
    return countFrom;
  }

  public void setCountFrom(Integer countFrom) {
    this.countFrom = countFrom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPlanActivationHistoryRequest getPlanActivationHistoryRequest = (GetPlanActivationHistoryRequest) o;
    return Objects.equals(this.ownerId, getPlanActivationHistoryRequest.ownerId) &&
        Objects.equals(this.planIds, getPlanActivationHistoryRequest.planIds) &&
        Objects.equals(this.expired, getPlanActivationHistoryRequest.expired) &&
        Objects.equals(this.active, getPlanActivationHistoryRequest.active) &&
        Objects.equals(this.count, getPlanActivationHistoryRequest.count) &&
        Objects.equals(this.countFrom, getPlanActivationHistoryRequest.countFrom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, planIds, expired, active, count, countFrom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPlanActivationHistoryRequest {\n");
    
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    planIds: ").append(toIndentedString(planIds)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    countFrom: ").append(toIndentedString(countFrom)).append("\n");
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

