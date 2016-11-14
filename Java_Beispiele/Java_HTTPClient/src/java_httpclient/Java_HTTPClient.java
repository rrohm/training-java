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
package java_httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import sun.net.www.http.HttpClient;

/**
 * Experiment with sun.net.www.http.HttpClient, not functionable.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 * @deprecated HttpClient is internal proprietary API and may be removed in a
 * future release.
 */
public class Java_HTTPClient {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    HttpClient client = new HttpClient(new URL("http://test.de"), null, 80);

    InputStream inputStream = client.getInputStream();
    String urlFile = client.getURLFile();
    System.out.println(urlFile);

    Reader r = new InputStreamReader(inputStream, "UTF-8");
    int intch;
    while ((intch = r.read()) != -1) {
      char ch = (char) intch;
      System.out.print(ch);
    }
  }
}
