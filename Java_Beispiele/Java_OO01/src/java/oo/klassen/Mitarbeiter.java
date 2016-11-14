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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package java.oo.klassen;

/**
 * Die Klasse Mitarbeiter erbt von der Klasse Person. Felder, die in der dieser
 * abgeleiteten Klasse sichtbar sein sollen, müssen der Vorfahr-Klasse Person
 * als protected deklariert werden. Ansonsten kann nur über die Getter- und
 * Setter-Methoden der Vorfahr-Klasse auf die Eigenschaften zugegriffen werden –
 * was jedoch nicht üblich ist und durch den Methodenaufruf unnötigen Overhead
 * erzeugt.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Mitarbeiter extends Person {

  private int persNr;

  /**
   * Im Standard-Konstruktor der abgeleiteten Klasse wird mit dem super()-Aufruf
   * der Konstruktor der Vorfahren-Klasse aufgerufen. Dies ist nicht zwingend
   * erforderlich. In der Praxis ist es jedoch in den meisten Fällen gewünscht,
   * auch die Initialisierungslogik der Vorfahren-Klasse beizubehalten.
   */
  public Mitarbeiter() {
    super();
    this.persNr = 01;
  }

  /**
   * Auch in dem überladenen “Bequemlichkeits“-Konstruktor kann ein
   * entsprechender geerbter Konstruktor der Vorfahren Klasse in die
   * Initialisierung der Instanz einbezogen werden.
   *
   * @param name
   * @param vorname
   * @param nr
   */
  public Mitarbeiter(String name, String vorname, int nr){
    super(name, vorname);
    this.persNr = nr;
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
