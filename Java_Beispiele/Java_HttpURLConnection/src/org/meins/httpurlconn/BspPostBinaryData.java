/*
 * This code is released under Creative Commons Attribution 4.0 International
 * (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 * That means:
 *
 * You are free to:
 *
 *     Share — copy and redistribute the material in any medium or format
 *     Adapt — remix, transform, and build upon the material
 *              for any purpose, even commercially.
 *
 *     The licensor cannot revoke these freedoms as long as you follow the
 *     license terms.
 *
 * Under the following terms:
 *
 *     Attribution — You must give appropriate credit, provide a link to the
 *     license, and indicate if changes were made. You may do so in any
 *     reasonable manner, but not in any way that suggests the licensor endorses
 *     you or your use.
 *
 * No additional restrictions — You may not apply legal terms or technological
 * measures that legally restrict others from doing anything the license
 * permits.
 */
package org.meins.httpurlconn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * http://localhost:8000/applications/myapp
 *
 * @author http://www.xyzws.com/Javafaq/how-to-use-httpurlconnection-post-data-to-web-server/139
 * @author robert
 */
public class BspPostBinaryData {

  public static void main(String[] args) {
    String filename = "D:/Chrysanthemum.jpg";
//    String filename = "/home/robert/Desktop/TEST/Testbild.jpg";
    String response = excutePost("http://localhost:8000/applications/myapp", filename);
    System.out.println("Response:\n" + response);
  }

  public static String excutePost(String targetURL, String Filename)
  {
    URL url;
    HttpURLConnection connection = null;
    try {

      Path p = Paths.get(Filename);
      boolean exists = p.toFile().exists();

      System.out.println("File Exists: " + exists);
      byte[] allBytes = Files.readAllBytes(p);

      //Create connection
      url = new URL(targetURL);
      connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type",
           "application/x-www-form-urlencoded");

      connection.setRequestProperty("Content-Length", "" +
               Integer.toString(allBytes.length));
      connection.setRequestProperty("Content-Language", "en-US");

      connection.setUseCaches (false);
      connection.setDoInput(true);
      connection.setDoOutput(true);

      //Send request
      DataOutputStream wr = new DataOutputStream (
                  connection.getOutputStream ());
      wr.write (allBytes, 0, allBytes.length);
      wr.flush ();
      wr.close ();

      //Get Response
      InputStream is = connection.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
      String line;
      StringBuffer response = new StringBuffer();
      while((line = rd.readLine()) != null) {
        response.append(line);
        response.append('\r');
      }
      rd.close();
      return response.toString();

    } catch (Exception e) {

      e.printStackTrace();
      return null;

    } finally {

      if(connection != null) {
        connection.disconnect();
      }
    }
  }
}
