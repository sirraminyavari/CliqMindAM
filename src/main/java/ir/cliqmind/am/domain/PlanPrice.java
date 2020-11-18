package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "PlanPrice")
@Table(name = "plan_price")
public class PlanPrice implements Serializable {

    @EmbeddedId
    private PlanPriceId id = new PlanPriceId();

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "secondary_price")
    private Double secondaryPrice;

    @Column(name = "secondary_price_first_date")
    private Date secondaryPriceFirstDate;

    @Column(name = "secondary_price_expiration_date")
    private Date secondaryPriceExpirationDate;

    @ManyToOne
    @MapsId("planId")
    private Plan plan;

    public PlanPrice(){}

    public PlanPriceId getId() {
        return id;
    }

    public void setId(PlanPriceId id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSecondaryPrice() {
        return secondaryPrice;
    }

    public void setSecondaryPrice(Double secondaryPrice) {
        this.secondaryPrice = secondaryPrice;
    }

    public Date getSecondaryPriceFirstDate() {
        return secondaryPriceFirstDate;
    }

    public void setSecondaryPriceFirstDate(Date secondaryPriceFirstDate) {
        this.secondaryPriceFirstDate = secondaryPriceFirstDate;
    }

    public Date getSecondaryPriceExpirationDate() {
        return secondaryPriceExpirationDate;
    }

    public void setSecondaryPriceExpirationDate(Date secondaryPriceExpirationDate) {
        this.secondaryPriceExpirationDate = secondaryPriceExpirationDate;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
