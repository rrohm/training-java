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
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Example: walking filesystem trees with a FileVisitor.
 * @author robert rohm
 */
public class NIO2_Bsp03_TreeWalk {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
    Path sourcePath = Paths.get("R:\\Quelle");

    FileVisitor fileVisitor = new FileVisitor() {

      @Override
      public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("preVisitDirectory: " + dir);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        System.out.println("visitFile " + file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        System.out.println("postVisitDirectory " + dir);
        return FileVisitResult.CONTINUE;
      }
    };

    Files.walkFileTree(sourcePath, fileVisitor);

  }


}
