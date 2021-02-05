package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate secondaryPriceFirstDate;

    @Column(name = "secondary_price_expiration_date")
    private LocalDate secondaryPriceExpirationDate;

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

    public LocalDate getSecondaryPriceFirstDate() {
        return secondaryPriceFirstDate;
    }

    public void setSecondaryPriceFirstDate(LocalDate secondaryPriceFirstDate) {
        this.secondaryPriceFirstDate = secondaryPriceFirstDate;
    }

    public LocalDate getSecondaryPriceExpirationDate() {
        return secondaryPriceExpirationDate;
    }

    public void setSecondaryPriceExpirationDate(LocalDate secondaryPriceExpirationDate) {
        this.secondaryPriceExpirationDate = secondaryPriceExpirationDate;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "PlanPrice{" +
                "id=" + id +
                ", price=" + price +
                ", secondaryPrice=" + secondaryPrice +
                ", secondaryPriceFirstDate=" + secondaryPriceFirstDate +
                ", secondaryPriceExpirationDate=" + secondaryPriceExpirationDate +
                '}';
    }

}
