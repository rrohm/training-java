/*
 */
package service;

/**
 * Einfache Datenklasse
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Person {

  private int ID = 12;
  private String name;
  private String vorname;

  public Person() {
  }

  public Person(String name, String vorname) {
    this.name = name;
    this.vorname = vorname;
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

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }
}
