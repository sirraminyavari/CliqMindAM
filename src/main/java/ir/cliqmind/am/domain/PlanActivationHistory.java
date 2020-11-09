package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "PlanActivationHistory")
@Table(name = "plan_activation_history", indexes = {
        @Index(columnList = "owner_id", name = "plan_activation_history_owner_id")
})
public class PlanActivationHistory implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("planId")
    private Plan plan;

    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;

    @Column(name = "upgraded_from_plan_id")
    private Integer upgradedFromPlanId;

    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "time", nullable = false)
    private Timestamp time;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "activated_by_user_id", nullable = false)
    private UUID activatedBy;


    public PlanActivationHistory(){}


}
