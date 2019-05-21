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
package org.meins.java.streams;

import java.io.IOException;
import org.meins.java.streams.nio.bytestreams.CopyBytes;
import org.meins.java.streams.nio.bytestreams.FileFiller;

/**
 *
 * @author robert rohm
 */
public class JavaStreams {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {

    if (args.length < 1) {
      System.out.println("JavaStreams - Demos and Utilities");
      System.out.println("----------------------------------------------------");
      System.out.println("");
      System.out.println("USAGE: ");
      System.out.println(">java -jar JavaStreams.jar [COMMAND] [OPTIONS]");
      System.out.println("");
      System.out.println("COMMAND: [copy|fill]");
    } else {
      String command = args[0];

      long startTimeMillis = System.currentTimeMillis();

      switch (command) {
        case "fill": {
          final long bytes = Long.valueOf(args[2]);
          FileFiller filler = new FileFiller();

          if (args.length == 3) {

            System.out.printf("FILL %d bytes ...\n", bytes);
            filler.fill(args[1], bytes);

          } else if (args.length == 4) {

            final int bufferSize = Integer.valueOf(args[3]);
            System.out.printf("FILL %d bytes (using a buffer of %d bytes) ...\n", bytes, bufferSize);
            filler.fill(args[1], bytes, bufferSize);

          }
          break;
        }
        case "copy": {
          System.out.printf("COPY %s->%s\n", args[1], args[2]);
          CopyBytes copyBytes = new CopyBytes();
          copyBytes.copy(args[1], args[2]);

          break;
        }
      }

      long millis = System.currentTimeMillis() - startTimeMillis;

      System.out.printf("Done in %d millis.\n", millis);
    }
  }

}
