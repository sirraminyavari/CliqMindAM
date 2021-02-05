package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")


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

  public GetPlanActivationHistoryRequest ownerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
   **/
  
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
  
  
    public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }


  @Override
  public boolean equals(Object o) {
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
        Objects.equals(this.active, getPlanActivationHistoryRequest.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ownerId, planIds, expired, active);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPlanActivationHistoryRequest {\n");
    
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    planIds: ").append(toIndentedString(planIds)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
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
