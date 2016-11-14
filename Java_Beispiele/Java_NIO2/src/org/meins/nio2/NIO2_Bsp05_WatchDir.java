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

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Example: Directory Watcher Service
 * @author robert rohm
 */
public class NIO2_Bsp05_WatchDir {

  /**
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      Path sourcePath = Paths.get("D:\\WORK");


      WatchService watcher = FileSystems.getDefault().newWatchService();

      sourcePath.register(watcher,
              StandardWatchEventKinds.ENTRY_CREATE,
              StandardWatchEventKinds.ENTRY_DELETE,
              StandardWatchEventKinds.ENTRY_MODIFY);



      WatchKey key;
      for (;;) {

        // wait for key to be signaled
        try {
          key = watcher.take();
        } catch (InterruptedException x) {
          return;
        }

        for (WatchEvent<?> event : key.pollEvents()) {
          WatchEvent.Kind<?> kind = event.kind();

          // This key is registered only
          // for ENTRY_CREATE events,
          // but an OVERFLOW event can
          // occur regardless if events
          // are lost or discarded.
          if (kind == StandardWatchEventKinds.OVERFLOW) {
            continue;
          }

          // The filename is the
          // context of the event.
          WatchEvent<Path> ev = (WatchEvent<Path>) event;
          Path filename = ev.context();

          // Verify that the new
          //  file is a text file.
          try {
            // Resolve the filename against the directory.
            // If the filename is "test" and the directory is "foo",
            // the resolved name is "test/foo".
            Path child = sourcePath.resolve(filename);
            if (!Files.probeContentType(child).equals("text/plain")) {
              System.err.format("New file '%s'"
                      + " is not a plain text file.%n", filename);
              continue;
            }
          } catch (IOException x) {
            System.err.println(x);
            continue;
          }

          System.out.format("Detected file %s%n", filename);
        }

        // Reset the key -- this step is critical if you want to
        // receive further watch events.  If the key is no longer valid,
        // the directory is inaccessible so exit the loop.
        boolean valid = key.reset();
        if (!valid) {
          break;
        }
      }


    } catch (IOException ex) {
      Logger.getLogger(NIO2_Bsp05_WatchDir.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
