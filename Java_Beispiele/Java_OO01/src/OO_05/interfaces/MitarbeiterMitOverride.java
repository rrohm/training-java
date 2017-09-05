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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package OO_05.interfaces;

/**
 * Abgeleitete Klasse, übernimmt die Interface-Vorschrift von der Basis-Klasse.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class MitarbeiterMitOverride extends Person {

  private int persNr;

  public MitarbeiterMitOverride() {
    super();
    this.persNr = 01;
  }

  public MitarbeiterMitOverride(String name, String vorname, int nr) {
    super(name, vorname);
    this.persNr = nr;
  }

  @Override
  public void gebeReport(ReportHelfer helfer) {
    helfer.erstelleReport(this);
  }

  @Override
  public String getName() {
    return "MitarbeiterMitOverride " + super.getName();
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
