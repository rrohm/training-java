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
 *
 * Aufruf: java org.meins.sockets.EchoClient <ServerName> <PortNr>
 *
 *         wird kein ServerName und PortNr eingegeben,
 *         wird localhost und Port:4444 als default verwendet
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class EchoClient {

  public static void main(String[] args) throws IOException {

    Socket echoSocket = null;
    DataOutputStream out = null;
    //DataInputStream  in  = null;
    BufferedReader in = null;
    int port = 4444;
    String hostname = "localhost";

    try {
      if (args.length == 0) {
        hostname = "localhost";
        echoSocket = new Socket(hostname, 4444);
      } else {
        if (args.length == 1) {
          hostname = args[0];
          echoSocket = new Socket(hostname, 4444);
        } else {
          port = Integer.parseInt(args[1]);
          hostname = args[0];
          echoSocket = new Socket(hostname, port);
        }
      }

      out = new DataOutputStream(echoSocket.getOutputStream());
      //in  = new DataInputStream(echoSocket.getInputStream());
      in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host: ? " + port);
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to: ? " + hostname);
      System.exit(1);
    }

    // Print out: Name, Address and Port-Number for Test
    InetAddress inAdr = InetAddress.getLocalHost();
    System.out.println("Name: " + inAdr.getHostName()
            + " Adresse: " + inAdr.getHostAddress()
            + " Port: " + echoSocket.getLocalPort());

    inAdr = echoSocket.getInetAddress();
    System.out.println("Name: " + inAdr.getHostName()
            + " Adresse: " + inAdr.getHostAddress()
            + " Port: " + echoSocket.getPort());

    //DataInputStream stdIn = new DataInputStream(System.in);
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String userInput;
    String inputLine;

    System.out.println("Client Started");
    inputLine = in.readLine();
    System.out.println("echo: " + inputLine);

    // Eingabe von der Konsole:
    while ((userInput = stdIn.readLine()) != null) {
      System.out.println("Send Server");
      
      out.writeBytes(userInput);
      out.writeByte('\n');
      
      // blockierender Aufruf: Antwort vom Server abwarten
      inputLine = in.readLine();
      System.out.println("echo: " + inputLine);
      System.out.println("Next Input:");

      if (inputLine.equals("Bye.") || inputLine.equals("End.")) {
        break;
      }
    }

    // ACHTUNG: .close() muss in eigenen try-catch-Block eingeschlossen werden.
    out.close();
    in.close();
    stdIn.close();
    echoSocket.close();
  }
}
