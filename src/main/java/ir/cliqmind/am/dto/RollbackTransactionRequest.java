package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RollbackTransactionRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-12T12:24:22.951Z")




public class RollbackTransactionRequest   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("done_by_user_id")
  private UUID doneByUserId = null;

  @JsonProperty("description")
  private String description = null;

  public RollbackTransactionRequest id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RollbackTransactionRequest doneByUserId(UUID doneByUserId) {
    this.doneByUserId = doneByUserId;
    return this;
  }

  /**
   * Get doneByUserId
   * @return doneByUserId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public UUID getDoneByUserId() {
    return doneByUserId;
  }

  public void setDoneByUserId(UUID doneByUserId) {
    this.doneByUserId = doneByUserId;
  }

  public RollbackTransactionRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


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
    RollbackTransactionRequest rollbackTransactionRequest = (RollbackTransactionRequest) o;
    return Objects.equals(this.id, rollbackTransactionRequest.id) &&
        Objects.equals(this.doneByUserId, rollbackTransactionRequest.doneByUserId) &&
        Objects.equals(this.description, rollbackTransactionRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, doneByUserId, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RollbackTransactionRequest {\n");
    
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

