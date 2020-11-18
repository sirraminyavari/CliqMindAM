package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * GenerateCouponCodeResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-17T18:53:52.082Z")




public class GenerateCouponCodeResponse   {
  @JsonProperty("code")
  private String code = null;

  public GenerateCouponCodeResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^[a-zA-Z0-9]*$") @Size(min=10,max=10) 
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenerateCouponCodeResponse generateCouponCodeResponse = (GenerateCouponCodeResponse) o;
    return Objects.equals(this.code, generateCouponCodeResponse.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenerateCouponCodeResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

