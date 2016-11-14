/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.meins.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@SessionScoped
public class MyManagedBean {

  private Person person;

  /**
   * Creates a new instance of MyManagedBean
   */
  public MyManagedBean() {
    this.person = new Person("Mustermann", "Max");
    this.person.getAdressen().add(new Adresse("Heimweg", "2", "90909", "Dadorf"));
    this.person.getAdressen().add(new Adresse("Arbeistadt", "31", "90909", "Dadorf"));
  }  
  
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
  
}
