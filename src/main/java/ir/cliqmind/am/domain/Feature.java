package ir.cliqmind.am.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Feature")
@Table(name = "features", indexes = {
        @Index(columnList = "name", name = "features_name_idx")
})
public class Feature implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "description", length = 1000)
  private String description;

  @Column(name = "active", nullable = false)
  private Boolean active;

  @OneToMany(mappedBy = "feature", fetch = FetchType.LAZY)
  private Set<PlanFeature> planFeatures = new HashSet<>();


  public Feature() {

  }

  public Feature(Integer featureId) {
    this.id = featureId;
  }

    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  @Transient
  private Integer amount;

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Feature{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", active=" + active +
            ", planFeatures=" + planFeatures +
            ", amount=" + amount +
            '}';
  }

  @PrePersist
  public void prePersist(){
    if(active == null){
      active = true;
    }
  }
}

