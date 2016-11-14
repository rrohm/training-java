/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@Entity
public class NewClass implements Serializable {
  
  @Id
  private String value = "test";

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
