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
package OO_04.abstrakt;

/**
 * Abgeleitete Klasse, überschreibt nicht alle Methoden. Zu beachten ist das
 * Verhalten zur Laufzeit!
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Mitarbeiter extends Person {

  private int persNr;

  public Mitarbeiter() {
    super();
    this.persNr = 01;
  }

  public Mitarbeiter(String name, String vorname, int nr) {
    super(name, vorname);
    this.persNr = nr;
  }

  /**
   * ACHTUNG! Hier wird die Methode von Person überschrieben!
   *
   * @return Geänderter Namen
   */
  public String getName() {
    return "Mitarbeiter " + super.getName();
  }

  /**
   * @return the persNr
   */
  public int getPersNr() {
    return persNr;
  }

  /**
   * @param persNr the persNr to set
   */
  public void setPersNr(int persNr) {
    this.persNr = persNr;
  }

}
