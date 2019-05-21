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
 * Simple socket server in pre-JDK7 style.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class SimpleServer {

  public static void main(String args[]) {

    // Message terminator
    char EOF = (char) 0x00;
    ServerSocket s = null;

    try {
      // create a serverSocket connection on port 4444
      s = new ServerSocket(4444);

      System.out.println("Server started. Waiting for connections...");

      // Wait for incoming connections - this is a blocking call. 
      // The incomingSocket object represents and encapsulates the client 
      // information (host, port etc.)
      Socket clientSocket = s.accept();

      // A buffered reader for reading (char!) data from the client:
      BufferedReader data_in = new BufferedReader(
              new InputStreamReader(clientSocket.getInputStream()));

      // A print writer for sending (char!) data to the client:
      PrintWriter data_out = new PrintWriter(clientSocket.getOutputStream());

      // Send first response/welcome message to the client: 
      data_out.println("Welcome! type 'quit' to quit." + EOF);
      // Force sending the data and clearing the buffer: 
      data_out.flush();

      boolean quit = false;

      // Waits for the "quit" command
      while (!quit) {
        String msg = data_in.readLine();

        // "Processing" the client message: 
        System.out.println("msg:" + msg);

        if (msg == null) {
          quit = true;
        }

        if (!msg.trim().equals("quit")) {
          data_out.println("You said: '" + msg.trim() + "'" + EOF);
          data_out.flush();
        } else {
          data_out.println("Shutting down. Bye!");
          data_out.flush();
          quit = true;
        }
      }
    } catch (Exception e) {
      System.out.println("Connection lost");
      e.printStackTrace();

    } finally {
      if (s != null) {
        try {
          s.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
