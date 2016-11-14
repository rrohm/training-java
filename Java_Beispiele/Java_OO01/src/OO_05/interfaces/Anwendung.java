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
package OO_05.interfaces;

/**
 * Dieses Beispiel zeigt, wie das im 3. und 4. Beispiel gezeigte Problem der
 * Typbindung bei (v.a. fehlenden Implementierungen von) polymorphen Methoden
 * mit Hilfe von Interfaces umgangen werden kann. 
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Person p = new Person("Müller", "Lisa");

    Mitarbeiter m = new Mitarbeiter("Mustermann", "Max", 123);

    MitarbeiterMitOverride mmo = new MitarbeiterMitOverride("Lyse", "Anna", 234);

    ReportHelfer helfer = new ReportHelfer();

    p.gebeReport(helfer);
    m.gebeReport(helfer);

    mmo.gebeReport(helfer);
  }

  public static void verarbeitePerson(Person p) {
    System.out.println("verarbeitete Person: " + p.getName());
  }
}
