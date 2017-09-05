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
 * Beispiel-Client - hier wird der SecurityManager in der Anwendung selbs
 * definiert, er und die Information zur Poliy-Datei müssen daher nicht mehr in
 * den VM-Startoptionen angegeben werden.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class BerechnungsClientRemote {

  /**
   * Start-Methode der Anwendung, hier wird im wesentlichen nur über die
   * RMIRegistry ein Server-Stub-Objekt (Stellvertreter-Objekt) geholt, auf dem
   * dann sofort die gewünschten Methoden ausgeführt werden können. Das
   * Stellvertreterobjekt ist lediglich als Interface-Typ bekannt.
   *
   * @param args
   * @author robert rohm
   */
  public static void main(String[] args) {
    System.out.println("Start mit Remote registry auf 192.168.100.200");

    // 1. Wir brauchen einen Sicherheitsmanager
    //    Für den SecurityManager ist eine policy-Datei erforderlich
    System.getProperties().setProperty("java.security.policy", "policy");

    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }
    // Das geht nicht - hierzu ist eine PropertyPermission erforderlich, die in der
    // Policy bereits gewährt sein muss.
//    System.getProperties().setProperty("java.security.policy", "policy");

    // Das geht:
    System.getProperties().setProperty("java.rmi.server.codebase", "file:/home/robert/Projekte/aeJavaTraining/work/Java7_RMIServer/dist/Java7_RMIServer.jar");
    try {
      Registry registry = LocateRegistry.getRegistry("192.168.100.200");

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
