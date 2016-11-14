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
package org.meins.sockets;

import java.io.*;
import java.net.*;

/**
 * Aufruf: java EchoServer * * Erwartet Client-Verbindung auf Port: 4444
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class EchoServer {

  public static void main(String[] args) throws IOException {

    System.out.println("Starting ...");

    // Server-Socket mit Port-Nr. initalisieren
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(4444);
    } catch (IOException e) {
      System.err.println("Could not listen on port: 4444.");
      System.exit(1);
    }

    // Print out: Name, Address and Port-Number for Test
    InetAddress inAdr = InetAddress.getLocalHost();
    System.out.println("Name: " + inAdr.getHostName()
            + " Adresse: " + inAdr.getHostAddress()
            + " Port: " + serverSocket.getLocalPort());
    inAdr = serverSocket.getInetAddress();
    System.out.println("Name: " + inAdr.getHostName()
            + " Adresse: " + inAdr.getHostAddress()
            + " Port: " + serverSocket.getLocalPort());

    int run = 1;
    // Wie lange soll der Server laufen? Endlos bis zur Abbruchbedingung.
    while (run != 0) {

      Socket clientSocket = null;
      System.out.println("Server started !!!");

      try {
        ClientWorker cltWrker;

        // blockierender Aufruf: Serversocket wartet auf Verbindung.
        clientSocket = serverSocket.accept();

        // Wenn Verbinung vorhanden: schnell an einen "Worker" zur
        // Ausführung in einem separaten Thread weitergeben
        // ... und auf nächsten Client warten
        cltWrker = new ClientWorker(clientSocket);
        Thread t = new Thread(cltWrker);
        t.start();

      } catch (IOException e) {
        System.err.println("Accept failed.");
        e.printStackTrace();
        System.exit(1);
      }

      inAdr = clientSocket.getInetAddress();
      System.out.println("Name: " + inAdr.getHostName()
              + " Adresse: " + inAdr.getHostAddress()
              + " Port: " + serverSocket.getLocalPort());

    }
    serverSocket.close();
  }
}
