package ir.cliqmind.am.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PlanPriceItem
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanPriceItem   {
  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("secondary_price")
  private PlanPriceItemSecondaryPrice secondaryPrice = null;

  public PlanPriceItem currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  
  
  @Pattern(regexp="[A-Z][A-Z][A-Z]")   public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public PlanPriceItem price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  
  
    public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public PlanPriceItem secondaryPrice(PlanPriceItemSecondaryPrice secondaryPrice) {
    this.secondaryPrice = secondaryPrice;
    return this;
  }

  /**
   * Get secondaryPrice
   * @return secondaryPrice
   **/
  
  
    @Valid
    public PlanPriceItemSecondaryPrice getSecondaryPrice() {
    return secondaryPrice;
  }

  public void setSecondaryPrice(PlanPriceItemSecondaryPrice secondaryPrice) {
    this.secondaryPrice = secondaryPrice;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanPriceItem planPriceItem = (PlanPriceItem) o;
    return Objects.equals(this.currency, planPriceItem.currency) &&
        Objects.equals(this.price, planPriceItem.price) &&
        Objects.equals(this.secondaryPrice, planPriceItem.secondaryPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, price, secondaryPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanPriceItem {\n");
    
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
