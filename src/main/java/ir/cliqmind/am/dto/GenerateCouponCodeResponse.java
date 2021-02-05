package ir.cliqmind.am.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * GenerateCouponCodeResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")

@JsonInclude(JsonInclude.Include.NON_NULL)
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
  
  
  @Pattern(regexp="^[a-zA-Z0-9]*$") @Size(min=10,max=10)   public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
