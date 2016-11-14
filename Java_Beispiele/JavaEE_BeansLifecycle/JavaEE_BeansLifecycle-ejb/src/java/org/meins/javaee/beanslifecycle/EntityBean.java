/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.javaee.beanslifecycle;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

/**
 *
 * @author robert
 */
@Entity
public class EntityBean implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  @PrePersist
  public void vorPersistierung(){
    System.out.println(">>> " + this.toString() + ": @PrePersist");
  }

  @PostPersist
  public void nachPersistierung(){
    System.out.println(">>> " + this.toString() + ": @PostPersist");
  }

  @PreRemove
  public void vorBeseitigungAusDerDB(){
    System.out.println(">>> " + this.toString() + ": @PreRemove");
  }

  @PostRemove
  public void nachBeseitigungAusDerDB(){
    System.out.println(">>> " + this.toString() + ": @PostRemove");
  }



  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EntityBean)) {
      return false;
    }
    EntityBean other = (EntityBean) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.meins.javaee.beanslifecycle.EntityBean[ id=" + id + " ]";
  }

}
