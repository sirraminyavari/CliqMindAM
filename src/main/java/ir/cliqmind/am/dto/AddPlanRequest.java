package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * AddPlanRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class AddPlanRequest   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("user_based")
  private Boolean userBased = null;

  @JsonProperty("enable_amount")
  private Boolean enableAmount = null;

  @JsonProperty("maximum_amount")
  private Integer maximumAmount = null;

  @JsonProperty("duration_in_months")
  private Integer durationInMonths = null;

  public AddPlanRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AddPlanRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AddPlanRequest userBased(Boolean userBased) {
    this.userBased = userBased;
    return this;
  }

  /**
   * Get userBased
   * @return userBased
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isUserBased() {
    return userBased;
  }

  public void setUserBased(Boolean userBased) {
    this.userBased = userBased;
  }

  public AddPlanRequest enableAmount(Boolean enableAmount) {
    this.enableAmount = enableAmount;
    return this;
  }

  /**
   * Get enableAmount
   * @return enableAmount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isEnableAmount() {
    return enableAmount;
  }

  public void setEnableAmount(Boolean enableAmount) {
    this.enableAmount = enableAmount;
  }

  public AddPlanRequest maximumAmount(Integer maximumAmount) {
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

  public AddPlanRequest durationInMonths(Integer durationInMonths) {
    this.durationInMonths = durationInMonths;
    return this;
  }

  /**
   * Get durationInMonths
   * @return durationInMonths
  **/
  @ApiModelProperty(value = "")


  public Integer getDurationInMonths() {
    return durationInMonths;
  }

  public void setDurationInMonths(Integer durationInMonths) {
    this.durationInMonths = durationInMonths;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddPlanRequest addPlanRequest = (AddPlanRequest) o;
    return Objects.equals(this.name, addPlanRequest.name) &&
        Objects.equals(this.description, addPlanRequest.description) &&
        Objects.equals(this.userBased, addPlanRequest.userBased) &&
        Objects.equals(this.enableAmount, addPlanRequest.enableAmount) &&
        Objects.equals(this.maximumAmount, addPlanRequest.maximumAmount) &&
        Objects.equals(this.durationInMonths, addPlanRequest.durationInMonths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, userBased, enableAmount, maximumAmount, durationInMonths);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddPlanRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    userBased: ").append(toIndentedString(userBased)).append("\n");
    sb.append("    enableAmount: ").append(toIndentedString(enableAmount)).append("\n");
    sb.append("    maximumAmount: ").append(toIndentedString(maximumAmount)).append("\n");
    sb.append("    durationInMonths: ").append(toIndentedString(durationInMonths)).append("\n");
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

