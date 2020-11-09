package ir.cliqmind.am.domain;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@Entity(name = "Coupon")
@Table(name = "coupons")
public class Coupon implements Serializable {

  @Id
  private String code;

  @Column(name = "percentage_based", nullable = false)
  private Boolean percentageBased;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "maximum_amount")
  private Double maximumAmount;

  @Column(name = "currency", length = 10, nullable = false)
  private String currency;

  @Column(name = "expiration_date")
  private Date expirationDate;

  @Column(name = "time", nullable = false)
  private Timestamp time;

  @Column(name = "allow_concurrent_coupons", nullable = false)
  private Boolean allowConcurrentCoupons;

  @Column(name = "allow_secondary_price", nullable = false)
  private Boolean allowSecondaryPrice;

  @Column(name = "maximum_usage_limit")
  private Integer maximumUsageLimit;

  @Column(name = "maximum_usage_limit_per_user")
  private Integer maximumUsageLimitPerUser;

  @ElementCollection(fetch=FetchType.EAGER)
  @CollectionTable(name = "coupon_target_users", joinColumns = @JoinColumn(name = "code"))
  @Column(name = "target_id", nullable = false)
  private List<UUID> targetUsers;

  public Coupon(){

  }

}

