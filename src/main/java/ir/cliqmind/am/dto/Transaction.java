package ir.cliqmind.am.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-08T17:36:36.325Z")




public class Transaction   {
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

  public Transaction id(Long id) {
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

  public Transaction userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public Transaction isDeposit(Boolean isDeposit) {
    this.isDeposit = isDeposit;
    return this;
  }

  /**
   * Get isDeposit
   * @return isDeposit
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsDeposit() {
    return isDeposit;
  }

  public void setIsDeposit(Boolean isDeposit) {
    this.isDeposit = isDeposit;
  }

  public Transaction amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Transaction currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="[A-Z][A-Z][A-Z]") 
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Transaction transactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
    return this;
  }

  /**
   * Get transactionCode
   * @return transactionCode
  **/
  @ApiModelProperty(value = "")


  public String getTransactionCode() {
    return transactionCode;
  }

  public void setTransactionCode(String transactionCode) {
    this.transactionCode = transactionCode;
  }

  public Transaction type(String type) {
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.userId, transaction.userId) &&
        Objects.equals(this.isDeposit, transaction.isDeposit) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.currency, transaction.currency) &&
        Objects.equals(this.transactionCode, transaction.transactionCode) &&
        Objects.equals(this.type, transaction.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, isDeposit, amount, currency, transactionCode, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
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

