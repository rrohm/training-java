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

/**
 * Hier werden die Verarbeitungsmethoden für die unterschiedlichen Datenklassen
 * implementiert - ganz einfach als polymorphe Methoden.
 *
 * @author Robert Rohm
 */
public class KonkreterBesucher implements Visitor {

  @Override
  public void visit(KonkretesObjektA a) {
    // Behandlung speziell für KonkretesObjektA-Instanzen
    System.out.println("KonkretesObjektA wurde typsicher in polymorpher Methode verarbeitet!");
  }

  @Override
  public void visit(KonkretesObjektB b) {
    // Behandlung speziell für KonkretesObjektB-Instanzen
    System.out.println("KonkretesObjektB wurde typsicher in polymorpher Methode verarbeitet!");
  }

}
