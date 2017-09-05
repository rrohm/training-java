package org.meins.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FehlerbehandlungJDK7 {

  /**
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {


    // Test: NPE?
    FehlerbehandlungJDK7 bsp = new FehlerbehandlungJDK7();

    // bsp.UncheckedException();
    // wird nicht mehr ausgeführt - wegen Unchecked Exception
    // System.out.println("hallo? noch weiter?"); //

    bsp.UncheckedExceptionImThread();
    Thread.currentThread().sleep(2000);
    // Diese Zeile wird noch ausgeführt:
    System.out.println("hallo? noch ohne Thread weiter?"); //

  }

  public void StandardFall() {
    try {
      // Code...
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public void StandardFall2() {
    // Mit Ressourcen, z.B. Lesepuffer:
    // BufferedReader br = new BufferedReader(..);
    try {
      // Code...
      // br.close()
    } catch (Exception e) {
      // br.close()
      // D-R-Y!
      // TODO: handle exception
    }
  }

  public void StandardFall2mitFinally() {
    // Mit Ressourcen, z.B. Lesepuffer:
    // BufferedReader br = new BufferedReader(..);
    try {
      // Code...
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      // br.close();
    }
  }

  /**
   * Neu mit JDK7
   */
  public void TryMitRessource() {
    Connection conn = null; // nur zu Demo-Zwecken
    // Definition und Instanzierung der Ressource
    // in der try-Klausel
    // WICHTIG: ressource muss das AutoCloseable-Interface
    // implementieren
    try (Statement stmt = conn.createStatement(); ResultSet rs = null) {
      // Code...
    } catch (Exception e) {
      // TODO: handle exception
    }
    // AutoCloseable wird hier implizit wieder mit close()
    // geschlossen
  }

  /**
   * Ganz schlecht: nur allgemeine Exception werfen
   *
   * @throws Exception
   */
  public void MehrereExceptions() throws Exception {
    //
  }

  /**
   * Nicht besser!!!
   *
   * @throws IOException
   * @throws RemoteException
   * @throws Exception
   */
  public void MehrereExceptions2() throws IOException, RemoteException,
          Exception {
    try {
      
    } catch (FileNotFoundException| IOException e) {
      // Gemeinsame Fehlerbehandlung für mehrere Typen
    } catch (RemoteException e) {
    } catch (Exception e) {
    }
  }

  public void MehrereExceptionsWeiterwerfernInJDK7() throws IOException, RemoteException {
    try {
      // Code...
      // durch "Final-Rethrow" bleibt die Typ-Information
      // erhalten - so dass spä ter noch individuell
      // reagiert werden kann
    } catch (final Exception e) {
      // TODO: handle exception
      throw e;
    }
  }

  /**
   * Multi-Catch bei JDK 7
   */
  public void MehrereExceptionsFangenInJDK7() throws Exception {
    try {
      // Code...
      // durch "Final-Rethrow" bleibt die Typ-Information
      // erhalten - so dass später noch individuell
      // reagiert werden kann
    } catch (final FileNotFoundException | IOException e) {
      // TODO: handle exception

      // und danach ggf. weiter geworfen
      throw e;
    }
  }

  public void UncheckedException() {
    String t = null;
    System.out.println(t.toString());
  }

  public void UncheckedExceptionImThread() {

    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {

        String t = null;
        System.out.println(t.toString());

      }
    });
    t.start();
  }
}
