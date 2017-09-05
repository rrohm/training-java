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
package OO_02.override;

/**
 * Diese Beispiel-"Anwendung" arbeitet mit einer Basis-Klasse und einer
 * abgeleiteten Klasse mit überschriebener Methode. Unabhängig vom Referenztyp
 * wird immer die eigene Implementierung der Klasse verwendet, auch unabhängig
 * davon, ob sie als Überschreibung mit @Override gekennzeichnet worden ist.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Person p = new Person("Müller", "Lisa");
    System.out.println("Person p: " + p.getName());

    Mitarbeiter m = new Mitarbeiter("Mustermann", "Max", 123);
    System.out.println("Mitarbeiter m: " + m.getName());

    p = m;
    System.out.println("Person p: " + p.getName());

    Person p2 = new Mitarbeiter("Lyse", "Anna", 234);
    System.out.println("Person p2: " + p2.getName());

    p2 = (Person) new Mitarbeiter("Lyse", "Anna", 234);
    System.out.println("Person p2: " + p2.getName());

    verarbeitePerson(p);
    verarbeitePerson(p2);
  }

  public static void verarbeitePerson(Person p) {
    System.out.println("verarbeitete Person: " + p.getName());
  }
}
