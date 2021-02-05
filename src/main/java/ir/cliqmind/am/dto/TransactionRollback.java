package ir.cliqmind.am.dto;

import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * TransactionRollback
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionRollback   {
  @JsonProperty("time")
  private Instant time = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("done_by_user_id")
  private UUID doneByUserId = null;

  public TransactionRollback time(Instant time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   **/
  
  
    @Valid
    public Instant getTime() {
    return time;
  }

  public void setTime(Instant time) {
    this.time = time;
  }

  public TransactionRollback description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TransactionRollback doneByUserId(UUID doneByUserId) {
    this.doneByUserId = doneByUserId;
    return this;
  }

  /**
   * Get doneByUserId
   * @return doneByUserId
   **/
  
  
    @Valid
    public UUID getDoneByUserId() {
    return doneByUserId;
  }

  public void setDoneByUserId(UUID doneByUserId) {
    this.doneByUserId = doneByUserId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionRollback transactionRollback = (TransactionRollback) o;
    return Objects.equals(this.time, transactionRollback.time) &&
        Objects.equals(this.description, transactionRollback.description) &&
        Objects.equals(this.doneByUserId, transactionRollback.doneByUserId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, description, doneByUserId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionRollback {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    doneByUserId: ").append(toIndentedString(doneByUserId)).append("\n");
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
