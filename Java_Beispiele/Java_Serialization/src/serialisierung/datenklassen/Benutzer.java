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
 * Diese Klasse erbt die Serialisierbarkeit sozusagen von ihrer Basisklasse
 * {@link Person}. Besonders delikat: die Klasse Benutzer besitzt ein Feld
 * "Passwort", das in der Praxis eventuell sensible Informationen enthält, die
 * nicht resistent gespeichert werden darf. In dieser ersten Version wird jedoch
 * auch der Wert dieses Feldes sehr realisiert. Böses Foul!
 * Vgl. dazu {@link BenutzerSicher}!
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Benutzer extends Person {
  /**
   * Der Wert dieses Feldes darf nicht sehr realisiert werden! Böses Foul!
   */
  private String passwort;

  public Benutzer(String passwort, String name, String vorname) {
    super(name, vorname);
    this.passwort = passwort;
  }

  public String getPasswort() {
    return passwort;
  }

  public void setPasswort(String passwort) {
    this.passwort = passwort;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Benutzer ");
    sb.append(this.name).append(", ").append(this.vorname);
    sb.append(", Passwort=").append(this.passwort);
    return sb.toString();
  }
}
