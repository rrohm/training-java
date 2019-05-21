/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 *
 *  You are free to:
 *
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 *
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 *
 *  Under the following terms:
 *
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 *
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 *
 *
 *  2019 Aeonium Software Systems, Robert Rohm.
 */
package serialisierung.datenklassen;

/**
 * Diese Klasse illustriert die korrekte Behandlung von Feldern, die aus zum
 * Beispiel Sicherheitsgründen nicht persistiert werden dürfen, mit dem
 * Schlüsselwort <code>transient</code>.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class BenutzerSicher extends Person {

  /**
   * so wird dieses Feld nicht in die Serialisierung einbezogen und damit nicht
   * gespeichert.
   */
  private transient String passwort;

  public BenutzerSicher(String passwort, String name, String vorname) {
    super(name, vorname);
    this.passwort = passwort;
  }

  public String getPasswort() {
    return passwort;
  }

  public void setPasswort(String passwort) {
    this.passwort = passwort;
  }

  /**
   * Achtung! Übrigens auch diese Methode ist aus Sicherheitsgründen, so wie sie
   * hier implementiert ist, bedenklich! Sie sollte so nur in diesem Beispiel
   * verwendet werden. In der Praxis würde überall dort, wo das Objekt in Textform
   * repräsentiert werden muss, damit automatisch das Passwort ausgegeben werden
   * – zum Beispiel auch in Log-Dateien et cetera.
   *
   * @return
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BenutzerSicher ");
    sb.append(this.name).append(", ").append(this.vorname);
    sb.append(", Passwort=").append(this.passwort);
    return sb.toString();
  }
}
