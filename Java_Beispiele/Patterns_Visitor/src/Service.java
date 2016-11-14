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
 * Diese Klasse ein das Negativ-Beispiel, das ohne Verwendung des
 * Besucher-Musters implementiert worden ist - hier werden unterschiedliche
 * Typen mit "instanceof"-Kaskaden unterschieden.
 *
 * @deprecated Negativ-Beispiel!
 *
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class Service {

  List<KonkretesObjektIF> liste = new ArrayList<>();

  public List<KonkretesObjektIF> getListe() {
    return liste;
  }

  public void setListe(List<KonkretesObjektIF> liste) {
    this.liste = liste;
  }

  public void addElement(KonkretesObjektIF o){
    this.liste.add(o);
  }

  public void verarbeite(List<KonkretesObjektIF> liste){
    for (KonkretesObjektIF konkretesObjekt : liste) {
      System.out.println("Service sagt, das ist ein ... ");
      if (konkretesObjekt instanceof KonkretesObjektIF) {
        System.out.println("KonkretesObjekt!");
      }
      if (konkretesObjekt instanceof KonkretesObjektA) {
        System.out.println("KonkretesObjektA!");
      }
      if (konkretesObjekt instanceof KonkretesObjektB) {
        System.out.println("KonkretesObjektB!");
      }
//      konkretesObjekt.accept(visitor);
    }
  }
}
