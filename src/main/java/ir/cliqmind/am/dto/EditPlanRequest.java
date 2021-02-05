package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EditPlanRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")


public class EditPlanRequest   {
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

  @JsonProperty("features")
  private PlanFeatures features = null;

  @JsonProperty("price")
  private PlanPrices price = null;

  public EditPlanRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EditPlanRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EditPlanRequest userBased(Boolean userBased) {
    this.userBased = userBased;
    return this;
  }

  /**
   * Get userBased
   * @return userBased
   **/
      @NotNull

    public Boolean isUserBased() {
    return userBased;
  }

  public void setUserBased(Boolean userBased) {
    this.userBased = userBased;
  }

  public EditPlanRequest enableAmount(Boolean enableAmount) {
    this.enableAmount = enableAmount;
    return this;
  }

  /**
   * Get enableAmount
   * @return enableAmount
   **/
  
      @NotNull

    public Boolean isEnableAmount() {
    return enableAmount;
  }

  public void setEnableAmount(Boolean enableAmount) {
    this.enableAmount = enableAmount;
  }

  public EditPlanRequest maximumAmount(Integer maximumAmount) {
    this.maximumAmount = maximumAmount;
    return this;
  }

  /**
   * Get maximumAmount
   * @return maximumAmount
   **/
  
  
    public Integer getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(Integer maximumAmount) {
    this.maximumAmount = maximumAmount;
  }

  public EditPlanRequest durationInMonths(Integer durationInMonths) {
    this.durationInMonths = durationInMonths;
    return this;
  }

  /**
   * Get durationInMonths
   * @return durationInMonths
   **/
  
  
    public Integer getDurationInMonths() {
    return durationInMonths;
  }

  public void setDurationInMonths(Integer durationInMonths) {
    this.durationInMonths = durationInMonths;
  }

  public EditPlanRequest features(PlanFeatures features) {
    this.features = features;
    return this;
  }

  /**
   * Get features
   * @return features
   **/
  
  
    @Valid
    public PlanFeatures getFeatures() {
    return features;
  }

  public void setFeatures(PlanFeatures features) {
    this.features = features;
  }

  public EditPlanRequest price(PlanPrices price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  
  
    @Valid
    public PlanPrices getPrice() {
    return price;
  }

  public void setPrice(PlanPrices price) {
    this.price = price;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EditPlanRequest editPlanRequest = (EditPlanRequest) o;
    return Objects.equals(this.name, editPlanRequest.name) &&
        Objects.equals(this.description, editPlanRequest.description) &&
        Objects.equals(this.userBased, editPlanRequest.userBased) &&
        Objects.equals(this.enableAmount, editPlanRequest.enableAmount) &&
        Objects.equals(this.maximumAmount, editPlanRequest.maximumAmount) &&
        Objects.equals(this.durationInMonths, editPlanRequest.durationInMonths) &&
        Objects.equals(this.features, editPlanRequest.features) &&
        Objects.equals(this.price, editPlanRequest.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, userBased, enableAmount, maximumAmount, durationInMonths, features, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EditPlanRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    userBased: ").append(toIndentedString(userBased)).append("\n");
    sb.append("    enableAmount: ").append(toIndentedString(enableAmount)).append("\n");
    sb.append("    maximumAmount: ").append(toIndentedString(maximumAmount)).append("\n");
    sb.append("    durationInMonths: ").append(toIndentedString(durationInMonths)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
