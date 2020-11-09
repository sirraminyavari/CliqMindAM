package ir.cliqmind.am.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Feature")
@Table(name = "feature")
public class Feature implements Serializable {

  @Id
  private Integer id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

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

