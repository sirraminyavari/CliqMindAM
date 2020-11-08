package ir.cliqmind.am.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * GetCouponsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class GetCouponsResponse   {
  @JsonProperty("total_count")
  private Integer totalCount = null;

  @JsonProperty("coupons")
  @Valid
  private List<Coupon> coupons = null;

  public GetCouponsResponse totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Get totalCount
   * @return totalCount
  **/
  @ApiModelProperty(value = "")


  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public GetCouponsResponse coupons(List<Coupon> coupons) {
    this.coupons = coupons;
    return this;
  }

  public GetCouponsResponse addCouponsItem(Coupon couponsItem) {
    if (this.coupons == null) {
      this.coupons = new ArrayList<Coupon>();
    }
    this.coupons.add(couponsItem);
    return this;
  }

  /**
   * Get coupons
   * @return coupons
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Coupon> getCoupons() {
    return coupons;
  }

  public void setCoupons(List<Coupon> coupons) {
    this.coupons = coupons;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCouponsResponse getCouponsResponse = (GetCouponsResponse) o;
    return Objects.equals(this.totalCount, getCouponsResponse.totalCount) &&
        Objects.equals(this.coupons, getCouponsResponse.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalCount, coupons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCouponsResponse {\n");
    
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    coupons: ").append(toIndentedString(coupons)).append("\n");
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

