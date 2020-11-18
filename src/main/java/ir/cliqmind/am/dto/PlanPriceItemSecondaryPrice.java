package ir.cliqmind.am.dto;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * PlanPriceItemSecondaryPrice
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")



@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanPriceItemSecondaryPrice   {
  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("first_date")
  private Date firstDate = null;

  @JsonProperty("expiration_date")
  private Date expirationDate = null;

  public PlanPriceItemSecondaryPrice price(Double price) {
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

  public PlanPriceItemSecondaryPrice firstDate(Date firstDate) {
    this.firstDate = firstDate;
    return this;
  }

  /**
   * Get firstDate
   * @return firstDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Date getFirstDate() {
    return firstDate;
  }

  public void setFirstDate(Date firstDate) {
    this.firstDate = firstDate;
  }

  public PlanPriceItemSecondaryPrice expirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanPriceItemSecondaryPrice planPriceItemSecondaryPrice = (PlanPriceItemSecondaryPrice) o;
    return Objects.equals(this.price, planPriceItemSecondaryPrice.price) &&
        Objects.equals(this.firstDate, planPriceItemSecondaryPrice.firstDate) &&
        Objects.equals(this.expirationDate, planPriceItemSecondaryPrice.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, firstDate, expirationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanPriceItemSecondaryPrice {\n");
    
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    firstDate: ").append(toIndentedString(firstDate)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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

