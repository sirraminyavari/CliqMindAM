package ir.cliqmind.am.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ResponseMessage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage   {
  @JsonProperty("result")
  private String result = null;

  @JsonProperty("message")
  private String message = null;

  public ResponseMessage result(String result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
   **/
  
  
    public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public ResponseMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseMessage responseMessage = (ResponseMessage) o;
    return Objects.equals(this.result, responseMessage.result) &&
        Objects.equals(this.message, responseMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseMessage {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
