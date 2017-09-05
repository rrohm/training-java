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
package org.meins.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * A simple rundable for handling client connections.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class ClientWorker implements Runnable {

  private Socket cltsocket;

  /**
   * Creates a new instance of ClienWorker
   */
  public ClientWorker(Socket sock) {
    System.out.println("new ClientWorker");
    this.cltsocket = sock;

  }

  /**
   * When an object implementing interface <code>Runnable</code> is used to
   * create a thread, starting the thread causes the object's <code>run</code>
   * method to be called in that separately executing thread.
   * <p>
   * The general contract of the method <code>run</code> is that it may take any
   * action whatsoever.
   *
   * @see java.lang.Thread#run()
   *
   */
  public void run() {

    try {
      // Für binäre Daten:
      //DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
      //DataInputStream  in  = new DataInputStream(clientSocket.getInputStream());

      // Für Zeichendaten sinnvoller - und gepuffert:
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(cltsocket.getOutputStream()));
      BufferedReader in = new BufferedReader(new InputStreamReader(cltsocket.getInputStream()));
      String inputLine, outputLine;

      System.out.println("Server waiting !!!");

      // Hier: Input kommt vom Client zeilenweise
      while ((inputLine = in.readLine()) != null) {
        outputLine = inputLine;
        out.write(outputLine, 0, outputLine.length());
        out.newLine();
        out.flush();
        //out.writeBytes(outputLine);
        //out.writeByte('\n');
        //out.println(outputLine);
        //out.flush();
        System.out.println("Received:" + outputLine);
        if (outputLine.equals("Bye.")) {
          break;
        }
        if (outputLine.equals("End.")) {
//               run = 0;
          break;
        }
        if (outputLine.equals((char) 0x00)) {
          break;
        }
      }

      // Besser: Closables immer explizit schließen:
      out.close();
      in.close();
      cltsocket.close();
      System.out.println("Worker finished.");

    } catch (IOException e) {
      System.err.println("Accept failed.");
      System.exit(1);
    }

  }
}
