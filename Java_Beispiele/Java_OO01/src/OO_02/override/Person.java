
package OO_02.override;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Person {

  /**
   * Sichtbarkeit protected:
   * wie private, aber auch
   * in abgeleiteten Klassen0
   */
  protected String name;
  protected String vorname;

  public Person() {
  }

  public Person(String name, String vorname) {
    this.name = name;
    this.vorname = vorname;
  }


  /**
   * Getter-Methode: vgl. Java Bean Specification,
   * Prefix get (/set) + Feld-Name in Camel-Case
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
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
  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

}
