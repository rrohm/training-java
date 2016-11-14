package serialisierung.datenklassen;

import java.io.Serializable;

/**
 * Diese Klasse ist serialisierbar. Diese Eigenschaft wird auch auf abgeleitete
 * Klassen vererbt, d.h.: eventuell abgeleitete Klassen wie zum Beispiel der
 * Benutzer müssen das Interface nicht mehr explizit nochmal angeben.
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Person implements Serializable {
  protected String name;
  protected String vorname;

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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Person ");
    sb.append(this.name).append(", ").append(this.vorname);
    return sb.toString();
  }



}
