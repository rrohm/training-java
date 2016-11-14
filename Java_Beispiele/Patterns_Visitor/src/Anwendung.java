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

import java.util.ArrayList;
import java.util.List;

/**
 * Dieses Beispiel illustriert den Einsatz des Besucher-Musters (Visitor
 * Pattern).
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  /**
   * @param args
   */
  public static void main(String[] args) {

    List<KonkretesObjektIF> liste = new ArrayList<>();

    liste.add(new KonkretesObjektA());
    liste.add(new KonkretesObjektB());

    Visitor visitor = new KonkreterBesucher();

    for (KonkretesObjektIF konkretesObjekt : liste) {
      // Code wie in den folgenden Zeilen wäre
      // unter Umständen OHNE visitor-Pattern nötig:
      
//      System.out.println("das ist ein ... ");
//      if (konkretesObjekt instanceof KonkretesObjektIF) {
//        System.out.println("KonkretesObjekt!");
//      }
//      if (konkretesObjekt instanceof KonkretesObjektA) {
//        System.out.println("KonkretesObjektA!");
//      }
//      if (konkretesObjekt instanceof KonkretesObjektB) {
//        System.out.println("KonkretesObjektB!");
//      }
      konkretesObjekt.accept(visitor);
    }

    Service service = new Service();
//    KonkretesObjekt o = new KonkretesObjektA();
//    service.getListe().add(o);
//    o = new KonkretesObjektB();
//    service.getListe().add(o);

    service.addElement(new KonkretesObjektA());
    service.addElement(new KonkretesObjektB());
    service.verarbeite(service.getListe());
  }
}
