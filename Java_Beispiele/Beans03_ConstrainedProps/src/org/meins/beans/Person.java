/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author robert
 */
public class Person implements Serializable {

  private int ID;
  private String name;
  private String vorname;
  private Date erfasstAm;
  public static int counter = 0;

  public Person() {
    this.ID = ++Person.counter;
    this.erfasstAm = Calendar.getInstance().getTime();
  }

  private final VetoableChangeSupport changeSupport = new VetoableChangeSupport(this);

  public void addPropertyChangeListener(VetoableChangeListener listener) {
    changeSupport.addVetoableChangeListener(listener);
  }

  public void removePropertyChangeListener(VetoableChangeListener listener) {
    changeSupport.removeVetoableChangeListener(listener);
  }


  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) throws PropertyVetoException {
    String oldName = this.name;
    changeSupport.fireVetoableChange("name", oldName, name);
    this.name = name;
  }

  /**
   * @return the vorname
   */
  public String getVorname() {
    return vorname;
  }

  /**
   * @param vorname the vorname to set
   */
  public void setVorname(String vorname) throws PropertyVetoException {
    String oldVorname = this.vorname;
    this.vorname = vorname;
    changeSupport.fireVetoableChange("vorname", oldVorname, vorname);
  }

  /**
   * @return the erfasstAm
   */
  public Date getErfasstAm() {
    return erfasstAm;
  }

  /**
   * @param erfasstAm the erfasstAm to set
   */
  public void setErfasstAm(Date erfasstAm) {
    this.erfasstAm = erfasstAm;
  }

  /**
   * @return the ID
   */
  public int getID() {
    return ID;
  }

  /**
   * @param ID the ID to set
   */
  public void setID(int ID) {
    this.ID = ID;
  }

  @Override
  public String toString() {
    return "ID# ".concat(Integer.toString(this.ID)).concat(" ").concat(this.name).concat(", ").concat(this.vorname);
  }
}
