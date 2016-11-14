package OO_02.override;

/**
 * Diese Klasse markiert das Überschreiben einer geerbten Methode korrekterweise
 * mit @Override. Dies ist v.a. sinnvoll, damit dieser zusammenhang auch vom
 * Compiler geprüft werden kann.
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
