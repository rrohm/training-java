/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@ApplicationScoped
public class SessionBean {

  private Person person;

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
  
  /**
   * Creates a new instance of SessionBean
   */
  public SessionBean() {
    this.person = new Person("Mustermann", "Max");
    this.person.getAdressen().add(new Adresse("Heimweg", "2", "90909", "Dadorf"));
    this.person.getAdressen().add(new Adresse("Arbeistadt", "31", "90909", "Dadorf"));
  }
  
  
}
