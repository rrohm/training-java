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
package java_httpserver;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * This class runs a simple HTTP service, using the
 * com.sun.net.httpserver.HttpServer - a proprietary class that allows for
 * quickly implementing an HTTP service within a plain Java SE application. For
 * beeing a proprietary class, it has some drawbacks: The application is no more
 * portable, it won't run and compile with r.g., IBM JDK and JRE.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_HttpServer {

  /**
   * Java_HttpServer.java start method, creates a
   * com.sun.net.httpserver.HttpServer with a custom handler for a single URL.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/applications/myapp", new MyHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
  }
}
