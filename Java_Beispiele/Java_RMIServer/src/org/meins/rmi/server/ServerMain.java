package org.meins.rmi.server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Diese KLasse ist die eigentliche Start-Klasse der Anwendung.
 *
 * @author robert rohm
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
//			Registry registry = LocateRegistry.createRegistry(1099);//getRegistry();
      Registry registry = LocateRegistry.getRegistry();
      BerechnungsServer server = new BerechnungsServer();

      // Die Server-Implementierung wird unter dem u.g. Namen registriert.
      // Falls bereits ein Objekt unter diesem Namen registriert ist, wird es ersetzt.
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
