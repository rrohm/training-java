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
package org.meins.java.streams.nio.bytestreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Einfaches Kopieren mittels Byte-Streams. Aus Performance-Gründen und auch
 * wegen der einfacheren Handhabung ist jedoch die Verwendung von NIO2 zu
 * empfehlen.
 *
 * @author robert rohm
 */
public class CopyBytes {

  public void copy(String source, String target) throws FileNotFoundException, IOException {

    FileInputStream in = null;
    FileOutputStream out = null;

    try {
      in = new FileInputStream(source);
      out = new FileOutputStream(target);
      int c;

      while ((c = in.read()) != -1) {
        out.write(c);
      }
    } finally {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }
}
