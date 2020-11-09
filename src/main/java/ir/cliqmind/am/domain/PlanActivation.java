package ir.cliqmind.am.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embeddable;

@Embeddable
public class PlanActivation implements Serializable{

    @Id
    private Integer id;

    @Column(name="active")
    @ColumnDefault("false")
    private Boolean active;

    @Column(name="datetime", nullable = false)
    private Timestamp datetime;

    public PlanActivation(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
