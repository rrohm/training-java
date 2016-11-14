package org.meins.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.meins.rmi.common.BerechnungsServerIF;

public class BerechnungsClient {

  /**
   * Beispiel-Client
   * @param args
   * @author robert rohm
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
