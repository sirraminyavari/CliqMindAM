package ir.cliqmind.am.domain;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity(name = "Transaction")
@Table(name = "transactions", indexes = {
        @Index(columnList = "user_id", name = "transactions_user_id_idx"),
        @Index(columnList = "code", name = "transactions_code_idx")
})
public class Transaction implements Serializable {

    public enum TransactionType{
        DEPOSIT("deposit"),
        BONUS("bonus"),
        TRANSFER("transfer"),
        BUY("buy"),
        RENEW("renew"),
        UPGRADE("upgrade");

        private String value;

        TransactionType(String value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable = false)
    private UUID userId;

    @Column(name="is_deposit", nullable = false)
    private Boolean isDeposit;

    @Column(name="amount", nullable = false)
    private Double amount;

    @Column(name="currency", length = 10)
    private String currency;

    @Column(name="code", nullable = false, unique = true)
    private String transactionCode;

    @Column(name="type", nullable = false, length = 32)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "time", nullable = false)
    private Instant time;

    @Column(name = "rollbacked")
    private Boolean rollbacked;

    @Column(name = "rollback_time")
    private Instant rollbackTime;

    @Column(name = "rollback_description")
    private String rollbackDescription;

    @Column(name = "rollback_by_user_id")
    private UUID rollbackByUserId;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "used_coupons",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_code")
    )
    @Fetch(value = FetchMode.SUBSELECT)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private List<Coupon> coupons;

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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Boolean getRollbacked() {
        return rollbacked;
    }

    public void setRollbacked(Boolean rollbacked) {
        this.rollbacked = rollbacked;
    }

    public Instant getRollbackTime() {
        return rollbackTime;
    }

    public void setRollbackTime(Instant rollbackTime) {
        this.rollbackTime = rollbackTime;
    }

    public String getRollbackDescription() {
        return rollbackDescription;
    }

    public void setRollbackDescription(String rollbackDescription) {
        this.rollbackDescription = rollbackDescription;
    }

    public UUID getRollbackByUserId() {
        return rollbackByUserId;
    }

    public void setRollbackByUserId(UUID rollbackByUserId) {
        this.rollbackByUserId = rollbackByUserId;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }


}
