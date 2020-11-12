package ir.cliqmind.am.domain;

import org.hibernate.annotations.ColumnDefault;

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

  @OneToMany(mappedBy = "feature")
  private Set<PlanFeature> planFeatures = new HashSet<>();


  public Feature() {

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
}
