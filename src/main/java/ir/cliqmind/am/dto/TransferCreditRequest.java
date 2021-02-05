package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TransferCreditRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-22T08:12:05.647Z[GMT]")


public class TransferCreditRequest   {
  @JsonProperty("from_user_id")
  private UUID fromUserId = null;

  @JsonProperty("to_user_id")
  private UUID toUserId = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("code")
  private String code = null;

  public TransferCreditRequest fromUserId(UUID fromUserId) {
    this.fromUserId = fromUserId;
    return this;
  }

  /**
   * Get fromUserId
   * @return fromUserId
   **/
  
      @NotNull

    @Valid
    public UUID getFromUserId() {
    return fromUserId;
  }

  public void setFromUserId(UUID fromUserId) {
    this.fromUserId = fromUserId;
  }

  public TransferCreditRequest toUserId(UUID toUserId) {
    this.toUserId = toUserId;
    return this;
  }

  /**
   * Get toUserId
   * @return toUserId
   **/
  
      @NotNull

    @Valid
    public UUID getToUserId() {
    return toUserId;
  }

  public void setToUserId(UUID toUserId) {
    this.toUserId = toUserId;
  }

  public TransferCreditRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  
      @NotNull

  @Pattern(regexp="[A-Z][A-Z][A-Z]")   public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public TransferCreditRequest amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  
      @NotNull

    public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public TransferCreditRequest code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  
  
    public String getCode() {
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
    TransferCreditRequest transferCreditRequest = (TransferCreditRequest) o;
    return Objects.equals(this.fromUserId, transferCreditRequest.fromUserId) &&
        Objects.equals(this.toUserId, transferCreditRequest.toUserId) &&
        Objects.equals(this.currency, transferCreditRequest.currency) &&
        Objects.equals(this.amount, transferCreditRequest.amount) &&
        Objects.equals(this.code, transferCreditRequest.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromUserId, toUserId, currency, amount, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferCreditRequest {\n");
    
    sb.append("    fromUserId: ").append(toIndentedString(fromUserId)).append("\n");
    sb.append("    toUserId: ").append(toIndentedString(toUserId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
