package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "PlanPrice")
@Table(name = "plan_price")
public class PlanPrice implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("planId")
    private Plan plan;

    @Column(name = "currency", length = 10, nullable = false)
    private String currency;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "secondary_price")
    private Double secondaryPrice;

    @Column(name = "secondary_price_first_date")
    private Date secondaryPriceFirstDate;

    @Column(name = "secondary_price_expiration_date")
    private Date secondaryPriceExpirationDate;

    public PlanPrice(){}


}
