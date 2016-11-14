/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@RequestScoped
public class Person {

  private String name;

  private String vorname;

  private List<Adresse> adressen = new ArrayList<>();

  public List<Adresse> getAdressen() {
    return adressen;
  }

  public void setAdressen(List<Adresse> adressen) {
    this.adressen = adressen;
  }

  
  public Person() {
  }
 
  
  public Person(String name, String vorname) {
    this.name = name;
    this.vorname = vorname;
  }
  
  
  
  /**
   * Get the value of vorname
   *
   * @return the value of vorname
   */
  public String getVorname() {
    return vorname;
  }

  /**
   * Set the value of vorname
   *
   * @param vorname new value of vorname
   */
  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  /**
   * Get the value of name
   *
   * @return the value of name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the value of name
   *
   * @param name new value of name
   */
  public void setName(String name) {
    this.name = name;
  }

}
