package org.aeonium.training.unittest.jmockit.model;

import java.io.Serializable;

/**
 * Datenklasse der Anwendung.
 *
 * @author Admin
 *
 */
public class Person implements Serializable{

  private String name;
  private String vorname;

  public Person() {
    // TODO Auto-generated constructor stub
  }

  public Person(String name, String vorname) {
    this.name = name;
    this.vorname = vorname;
  }

  /**
   * Eigene Implementierung, für fachlich orientierten Vergleich zweier
   * Person-Instanzen abgewandelt.
   *
   * <b>ACHTUNG!</b> Hierzu sollte unbedingt die JavaDoc-Dokumentation von
   * Object.equals() studiert werden!
   */
  @Override
  public boolean equals(Object obj) {
    // hier: 
    if (obj != null && obj instanceof Person) {
      // eigene Vergleichslogik:
      Person anderePerson = (Person) obj;
      return (anderePerson.name.equals(this.name) && anderePerson.vorname.equals(this.vorname));

    } else {
      return super.equals(obj);
    }
  }

  /**
   * Custom hashcode, based on the contract that if o1.equals(o2) is true, they
   * must return the same hashcode.
   *
   * @return
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = prime;
    result = result + System.identityHashCode(this.name);
    result = result + System.identityHashCode(this.vorname);
    return result;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return this.name + ", " + this.vorname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }
}
