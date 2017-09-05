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
package org.meins.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.meins.rmi.common.BerechnungsServerIF;

/**
 * Beispiel-Client - diese Version muss über VM-Optionen einen SecurityManager
 * zugewiesen bekommen, d.h., der Start-Aufruf muss so aussehen:
 * <br>
 * <pre>java -Djava.security.manager -Djava.security.policy=policy -Djava.rmi.server.useCodebaseOnly=false -jar Java7_RMIClient.jar</pre>
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class BerechnungsClient {

  /**
   * Start-Methode der Anwendung, hier wird im wesentlichen nur über die
   * RMIRegistry ein Server-Stub-Objekt (Stellvertreter-Objekt) geholt, auf dem
   * dann sofort die gewünschten Methoden ausgeführt werden können. Das
   * Stellvertreterobjekt ist lediglich als Interface-Typ bekannt.
   *
   * @param args
   */
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry();

      BerechnungsServerIF serverIF = (BerechnungsServerIF) registry.lookup("MeinRMIServer");

      Long l = serverIF.addiere(new Long(3), new Long(7));

      System.out.println("Ergebnis: " + l);

    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
