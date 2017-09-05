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
package org.meins.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Einfaches Beispiel für Schreiung sowei direktes und gepuffertes Lesen von
 * Text-Daten mit der klasischen IO-API.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class TextFiles {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    File f;
    try {
      f = File.createTempFile("my-text-file-", ".txt");
      // auch möglich: 
//      f.deleteOnExit();

      FileWriter writer = new FileWriter(f);
      writer.write("Erste Zeile");
      writer.append(System.getProperty("line.separator"));
      writer.write("Zweite Zeile");
      writer.append(System.getProperty("line.separator"));
      writer.write("Dritte Zeile");
      writer.flush();
      writer.close();

      System.out.println("Zeichen-weise Lesen mit einem FileReader");

      FileReader reader = new FileReader(f);
      int c = 0;
      while ((c = reader.read()) != -1) {
        System.out.print((char) c);
      }

      System.out.println("Zeilen-weise lesen mit einem BufferedReader");
      // Ein neuer Reader muss erstellt werden, der alte kann nicht zurückgesetzt werden:
      FileReader reader2 = new FileReader(f);
      BufferedReader bufferedReader = new BufferedReader(reader2);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }

      reader.close();
      reader2.close();

    } catch (IOException ex) {
      Logger.getLogger(TextFiles.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
