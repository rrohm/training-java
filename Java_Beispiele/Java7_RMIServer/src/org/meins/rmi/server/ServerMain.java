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
package org.meins.rmi.server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Diese KLasse ist die eigentliche Start-Klasse der Anwendung.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 *
 */
public class ServerMain {

  /**
   * Hier wird der RMI-Server-Dienst eingerichtet und gestartet:
   *
   * @param args
   */
  public static void main(String[] args) {

    // 1. Wir brauchen einen Sicherheitsmanager
    //    Für den SecurityManager ist eine policy-Datei anlegen
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }

    // 2. Wir müssen den Server in der RMI-Registry registrieren ("binden")
    try {
      Registry registry = LocateRegistry.getRegistry();
      //  alternativ, falls Registry auf anderem Port läuft: Registry registry = LocateRegistry.createRegistry(1099);

      // Die Server-Implementierung wird unter dem u.g. Namen registriert.
      // Falls bereits ein Objekt unter diesem Namen registriert ist, wird es ersetzt.
      BerechnungsServer server = new BerechnungsServer();
      registry.rebind("MeinRMIServer", server);

      System.out.println("Server gestartet.");
      System.in.read();

    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
