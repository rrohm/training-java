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
 *  2019 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.sockets;

import java.io.*;
import java.net.*;

/**
 * Simple socket server with JDK7 APIs.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class SimpleServerJDK7 {

  public static void main(String args[]) {
    // Message terminator
    char EOF = (char) 0x00;

    // try-with-ressource:
    // Ressource muss Closeable() implementieren
    try (ServerSocket s = new ServerSocket(4444)) {
      // create a serverSocket connection on port 4444

      System.out.println("Server started. Waiting for connections...");
      // wait for incoming connections
      Socket incoming = s.accept();

      BufferedReader data_in = new BufferedReader(new InputStreamReader(
              incoming.getInputStream()));

      PrintWriter data_out = new PrintWriter(incoming.getOutputStream());

      data_out.println("Welcome! type EXIT to quit." + EOF);
      data_out.flush();

      boolean quit = false;

      // Waits for the EXIT command
      while (!quit) {
        String msg = data_in.readLine();

        System.out.println("msg:" + msg);

        if (msg == null) {
          quit = true;
        }

        if (!msg.trim().equals("EXIT")) {
          data_out.println("You sayed: '" + msg.trim() + "'" + EOF);
          data_out.flush();
        } else {
          quit = true;
        }
      }
    } catch (Exception e) {
      System.out.println("Connection lost");
      e.printStackTrace();

    }
  }
}
