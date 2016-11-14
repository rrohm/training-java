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
package java_httpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Java_HttpServer.java Example HttpHandler, sends a HTML response.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class MyHandler implements HttpHandler {

  @Override
  public void handle(HttpExchange t) throws IOException {
    InputStream is = t.getRequestBody();
    String body = read(is); // .. read the request body
    System.out.println("body: " + body);
    String host = t.getRequestURI().getHost();
    int port = t.getRequestURI().getPort();
    String path = t.getRequestURI().getPath();
    String query = t.getRequestURI().getQuery();

    String response = "<html><head></head><body>This is the response";
    response += "<br>host: " + host;
    response += "<br>port: " + port;
    response += "<br>path: " + path;
    response += "<br>query: " + query;
    response += "<br></body>";

//    t.sendResponseHeaders(200, response.length()); // nur für single-byte-Zeichen :-(
    t.sendResponseHeaders(200, response.getBytes().length); // für Byte-Anzahl
    t.getResponseHeaders().add("Content-Type", "text/html");

    OutputStream os = t.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }

  private String read(InputStream is) throws UnsupportedEncodingException, IOException {
    final char[] buffer = new char[0x10000];
    StringBuilder out = new StringBuilder();
    Reader in = new InputStreamReader(is, "UTF-8");
    int read;
    do {
      read = in.read(buffer, 0, buffer.length);
      if (read > 0) {
        out.append(buffer, 0, read);
      }
    } while (read >= 0);

    return out.toString();

  }
}
