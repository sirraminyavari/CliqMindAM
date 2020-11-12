package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Plan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")




public class Plan   {
  @JsonProperty("id")
  private Integer id = null;

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

  @JsonProperty("active")
  private Boolean active = null;

  @JsonProperty("features")
  @Valid
  private List<Feature> features = null;

  @JsonProperty("price")
  @Valid
  private List<PlanPriceItem> price = null;

  public Plan id(Integer id) {
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

  public Plan name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Plan description(String description) {
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

  public Plan userBased(Boolean userBased) {
    this.userBased = userBased;
    return this;
  }

  /**
   * Get userBased
   * @return userBased
  **/
  @ApiModelProperty(value = "")


  public Boolean isUserBased() {
    return userBased;
  }

  public void setUserBased(Boolean userBased) {
    this.userBased = userBased;
  }

  public Plan enableAmount(Boolean enableAmount) {
    this.enableAmount = enableAmount;
    return this;
  }

  /**
   * Get enableAmount
   * @return enableAmount
  **/
  @ApiModelProperty(value = "")


  public Boolean isEnableAmount() {
    return enableAmount;
  }

  public void setEnableAmount(Boolean enableAmount) {
    this.enableAmount = enableAmount;
  }

  public Plan maximumAmount(Integer maximumAmount) {
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

  public Plan durationInMonths(Integer durationInMonths) {
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

  public Plan active(Boolean active) {
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

  public Plan features(List<Feature> features) {
    this.features = features;
    return this;
  }

  public Plan addFeaturesItem(Feature featuresItem) {
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

  public Plan price(List<PlanPriceItem> price) {
    this.price = price;
    return this;
  }

  public Plan addPriceItem(PlanPriceItem priceItem) {
    if (this.price == null) {
      this.price = new ArrayList<PlanPriceItem>();
    }
    this.price.add(priceItem);
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PlanPriceItem> getPrice() {
    return price;
  }

  public void setPrice(List<PlanPriceItem> price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Plan plan = (Plan) o;
    return Objects.equals(this.id, plan.id) &&
        Objects.equals(this.name, plan.name) &&
        Objects.equals(this.description, plan.description) &&
        Objects.equals(this.userBased, plan.userBased) &&
        Objects.equals(this.enableAmount, plan.enableAmount) &&
        Objects.equals(this.maximumAmount, plan.maximumAmount) &&
        Objects.equals(this.durationInMonths, plan.durationInMonths) &&
        Objects.equals(this.active, plan.active) &&
        Objects.equals(this.features, plan.features) &&
        Objects.equals(this.price, plan.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, userBased, enableAmount, maximumAmount, durationInMonths, active, features, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Plan {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    userBased: ").append(toIndentedString(userBased)).append("\n");
    sb.append("    enableAmount: ").append(toIndentedString(enableAmount)).append("\n");
    sb.append("    maximumAmount: ").append(toIndentedString(maximumAmount)).append("\n");
    sb.append("    durationInMonths: ").append(toIndentedString(durationInMonths)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

