package ir.cliqmind.am.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * RollbackTransaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-07T10:04:52.693Z")




public class RollbackTransaction   {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("done_by_user_id")
  private String doneByUserId = null;

  @JsonProperty("description")
  private String description = null;

  public RollbackTransaction id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public RollbackTransaction doneByUserId(String doneByUserId) {
    this.doneByUserId = doneByUserId;
    return this;
  }

  /**
   * Get doneByUserId
   * @return doneByUserId
  **/
  @ApiModelProperty(value = "")


  public String getDoneByUserId() {
    return doneByUserId;
  }

  public void setDoneByUserId(String doneByUserId) {
    this.doneByUserId = doneByUserId;
  }

  public RollbackTransaction description(String description) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RollbackTransaction rollbackTransaction = (RollbackTransaction) o;
    return Objects.equals(this.id, rollbackTransaction.id) &&
        Objects.equals(this.doneByUserId, rollbackTransaction.doneByUserId) &&
        Objects.equals(this.description, rollbackTransaction.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, doneByUserId, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RollbackTransaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    doneByUserId: ").append(toIndentedString(doneByUserId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

