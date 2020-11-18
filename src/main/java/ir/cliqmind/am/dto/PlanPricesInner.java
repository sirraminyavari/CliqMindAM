package ir.cliqmind.am.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PlanPricesInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")



@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanPricesInner   {
  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("secondary_price")
  private PlanPriceItemSecondaryPrice secondaryPrice = null;

  public PlanPricesInner currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public PlanPricesInner price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public PlanPricesInner secondaryPrice(PlanPriceItemSecondaryPrice secondaryPrice) {
    this.secondaryPrice = secondaryPrice;
    return this;
  }

  /**
   * Get secondaryPrice
   * @return secondaryPrice
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PlanPriceItemSecondaryPrice getSecondaryPrice() {
    return secondaryPrice;
  }

  public void setSecondaryPrice(PlanPriceItemSecondaryPrice secondaryPrice) {
    this.secondaryPrice = secondaryPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanPricesInner planPricesInner = (PlanPricesInner) o;
    return Objects.equals(this.currency, planPricesInner.currency) &&
        Objects.equals(this.price, planPricesInner.price) &&
        Objects.equals(this.secondaryPrice, planPricesInner.secondaryPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, price, secondaryPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanPricesInner {\n");
    
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    secondaryPrice: ").append(toIndentedString(secondaryPrice)).append("\n");
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

