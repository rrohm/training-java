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
package org.meins.nio2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Example: Creating and writing files.
 * @author robert rohm
 */
public class NIO2_Bsp04_CreateAndWrite {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Path sourcePath = Paths.get("D:\\WORK\\NIO2_Bsp04_CreateAndWrite.txt");


    try {
      Files.createFile(sourcePath);

      Charset charset = Charset.forName("UTF-8");
      String s = "Das ist mein Inhalt für die neue Datei. \nDanke!";

      try (BufferedWriter writer = Files.newBufferedWriter(sourcePath, charset)) {
        writer.write(s, 0, s.length());
      } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
      }

    } catch (IOException ex) {
      // Hier: besseres Exception-Handling!
      ex.printStackTrace();
    }
  }
}
