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

/**
 * http://localhost:8000/applications/myapp
 *
 * @author
 * http://www.xyzws.com/Javafaq/how-to-use-httpurlconnection-post-data-to-web-server/139
 * @author robert
 */
public class BspGetData {

  public static void main(String[] args) {
    String response = excutePost("http://aeonium-systems.de", "DasSindDieParameter");
    System.out.println("Response:\n" + response);
  }

  public static String excutePost(String targetURL, String content) {
    URL url;
    HttpURLConnection connection = null;
    try {
      //Create connection
      url = new URL(targetURL);
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      String USER_AGENT = "R. Rohm with java!";
      connection.setRequestProperty("User-Agent", USER_AGENT);
//      connection.setRequestProperty("Content-Type",
//           "application/x-www-form-urlencoded");
//
//      connection.setRequestProperty("Content-Length", "" +
//               Integer.toString(content.getBytes().length));
//      connection.setRequestProperty("Content-Language", "en-US");

      // technisch notwendig:
//      connection.setUseCaches(false);
//      connection.setDoInput(true);
//      connection.setDoOutput(false);
      //Send request
//      DataOutputStream wr = new DataOutputStream (
//                  connection.getOutputStream ());
//      wr.writeBytes (content);
//      wr.flush ();
//      wr.close ();
      int responseCode = connection.getResponseCode();
      System.out.println("\nSending 'GET' request to URL : " + url);
      System.out.println("Response Code : " + responseCode);

      //Get Response
      InputStream is = connection.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
      String line;
      StringBuffer response = new StringBuffer();
      while ((line = rd.readLine()) != null) {
        response.append(line);
        response.append("\n");
      }
      rd.close();
      return response.toString();

    } catch (Exception e) {

      e.printStackTrace();
      return null;

    } finally {

      if (connection != null) {
        connection.disconnect();
      }
    }
  }
}
