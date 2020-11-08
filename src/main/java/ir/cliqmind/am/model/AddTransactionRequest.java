package ir.cliqmind.am.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddTransactionRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class AddTransactionRequest   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("user_id")
  private UUID userId = null;

  @JsonProperty("is_deposit")
  private Boolean isDeposit = null;

  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("transaction_code")
  private String transactionCode = null;

  @JsonProperty("type")
  private String type = null;

  public AddTransactionRequest id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AddTransactionRequest userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public AddTransactionRequest isDeposit(Boolean isDeposit) {
    this.isDeposit = isDeposit;
    return this;
  }

  /**
   * Get isDeposit
   * @return isDeposit
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isIsDeposit() {
    return isDeposit;
  }

  public void setIsDeposit(Boolean isDeposit) {
    this.isDeposit = isDeposit;
  }

  public AddTransactionRequest amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public AddTransactionRequest currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Pattern(regexp="[A-Z][A-Z][A-Z]") 
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public AddTransactionRequest transactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
    return this;
  }

  /**
   * Get transactionCode
   * @return transactionCode
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTransactionCode() {
    return transactionCode;
  }

  public void setTransactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
  }

  public AddTransactionRequest type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddTransactionRequest addTransactionRequest = (AddTransactionRequest) o;
    return Objects.equals(this.id, addTransactionRequest.id) &&
        Objects.equals(this.userId, addTransactionRequest.userId) &&
        Objects.equals(this.isDeposit, addTransactionRequest.isDeposit) &&
        Objects.equals(this.amount, addTransactionRequest.amount) &&
        Objects.equals(this.currency, addTransactionRequest.currency) &&
        Objects.equals(this.transactionCode, addTransactionRequest.transactionCode) &&
        Objects.equals(this.type, addTransactionRequest.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, isDeposit, amount, currency, transactionCode, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddTransactionRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    isDeposit: ").append(toIndentedString(isDeposit)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    transactionCode: ").append(toIndentedString(transactionCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

