package ir.cliqmind.am.domain;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "Transaction")
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    private Long id;

    @Column(name="user_id", nullable = false)
    private UUID userId;

    @Column(name="deposit", nullable = false)
    private Boolean isDeposit;

    @Column(name="amount", nullable = false)
    private Double amount;

    @Column(name="currency")
    @ColumnDefault("'IRR'")
    private String currency;

    @Column(name="transaction_code", nullable = false)
    private String transactionCode;

    @Column(name="type", nullable = false)
    private String type;

    public Transaction(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Boolean getDeposit() {
        return isDeposit;
    }

    public void setDeposit(Boolean deposit) {
        isDeposit = deposit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
