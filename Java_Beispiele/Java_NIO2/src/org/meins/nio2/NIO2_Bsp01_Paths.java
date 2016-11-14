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

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Example: Working with the Paths class.
 * @author robert rohm
 */
public class NIO2_Bsp01_Paths {

  public static void main(String[] args) {

    // Example path, change it according to your file system.
    Path p1 = Paths.get("D:/Programme/apache-maven-3.0.4\\bin");
//    Path p2 = Paths.get(args[0]);
    Path p3 = Paths.get("D:\\Programme\\apache-maven-3.0.4\\bin");//Paths.get(URI.create("file:///d/r/INST"));

    Path p4 = FileSystems.getDefault().getPath("/r");

    printInfo(p1);
    printInfo(p3);
    printInfo(p4);
  }

  public static void printInfo(Path path) {
    System.out.println("PATH-INFO: ----------------------------");
    System.out.format("toString: %s%n", path.toString());
    System.out.format("getFileName: %s%n", path.getFileName());
    System.out.format("getName(0): %s%n", path.getName(0));
    System.out.format("getNameCount: %d%n", path.getNameCount());
    if (path.getNameCount() > 1) {
      System.out.format("subpath(0, count -1): %s%n", path.subpath(0, path.getNameCount() -1));
    }
    System.out.format("getParent: %s%n", path.getParent());
    System.out.format("getRoot: %s%n", path.getRoot());
  }
}
