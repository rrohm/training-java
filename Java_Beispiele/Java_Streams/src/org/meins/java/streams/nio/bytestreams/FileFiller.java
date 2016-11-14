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

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robert rohm
 */
public class FileFiller {

  /**
   * Fill a file with a given number of bytes, using only a FileOutputStream.
   *
   * @param filename
   * @param size
   */
  public void fill(String filename, long size) {

    try (FileOutputStream outputStream = new FileOutputStream(filename)) {
      int max = Byte.MAX_VALUE;

      for (int i = 0; i < size; i++) {
        outputStream.write(i % max);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(FileFiller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(FileFiller.class.getName()).log(Level.SEVERE, null, ex);

    }
  }

  public void fillChannel(String filename, long size) {
    throw new UnsupportedOperationException();
//
//    try (FileOutputStream outputStream = new FileOutputStream(filename);
//            FileChannel channel = outputStream.getChannel()
//            ) {
//
//      int max = Byte.MAX_VALUE;
//
//      for (int i = 0; i < size; i++) {
//        channel.
//        outputStream.write(i % max);
//      }
//
//    } catch (FileNotFoundException ex) {
//      Logger.getLogger(FileFiller.class.getName()).log(Level.SEVERE, null, ex);
//    } catch (IOException ex) {
//      Logger.getLogger(FileFiller.class.getName()).log(Level.SEVERE, null, ex);
//
//    }
  }

  /**
   * Fill a file with a given number of bytes, using a BufferedOutputStream.
   *
   * @param filename
   * @param size
   * @param bufferSize
   */
  public void fill(String filename, long size, int bufferSize) {

    try (
            FileOutputStream fos = new FileOutputStream(filename);
            BufferedOutputStream bos = new BufferedOutputStream(fos, bufferSize)) {

      int max = Byte.MAX_VALUE;

      for (int i = 0; i < size; i++) {
        bos.write(i % max);
      }

      bos.flush();

    } catch (FileNotFoundException ex) {
      Logger.getLogger(FileFiller.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(FileFiller.class.getName()).log(Level.SEVERE, null, ex);

    }
  }
}
