package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SetPlanPriceRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")




public class SetPlanPriceRequest   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("prices")
  private PlanPrices prices = null;

  public SetPlanPriceRequest id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SetPlanPriceRequest prices(PlanPrices prices) {
    this.prices = prices;
    return this;
  }

  /**
   * Get prices
   * @return prices
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PlanPrices getPrices() {
    return prices;
  }

  public void setPrices(PlanPrices prices) {
    this.prices = prices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetPlanPriceRequest setPlanPriceRequest = (SetPlanPriceRequest) o;
    return Objects.equals(this.id, setPlanPriceRequest.id) &&
        Objects.equals(this.prices, setPlanPriceRequest.prices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, prices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetPlanPriceRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    prices: ").append(toIndentedString(prices)).append("\n");
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

