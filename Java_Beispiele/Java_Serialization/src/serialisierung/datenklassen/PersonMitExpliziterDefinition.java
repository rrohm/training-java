package serialisierung.datenklassen;

import java.io.ObjectStreamField;
import java.io.Serializable;

/**
 * Optional können die zu serialisierenden Felder auch explizit benannt werden,
 * wie in diesem Beispiel illustriert. Damit kann der tatsächlich deklarierte
 * Feldnamen vom serialisierten Feldnamen abgetrennt werden.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PersonMitExpliziterDefinition implements Serializable {

  protected String name;
  protected String vorname;

  private static final ObjectStreamField[] serialPersistentFields = {
    new ObjectStreamField("name", String.class),
    new ObjectStreamField("vorname", String.class)
  };

  public PersonMitExpliziterDefinition() {
  }

  public PersonMitExpliziterDefinition(String name, String vorname) {
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
