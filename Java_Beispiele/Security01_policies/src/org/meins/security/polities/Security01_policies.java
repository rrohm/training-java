/*
 *  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 *  Copyright 2013 AEONIUM SOFTWARE SYSTEMS - ALL RIGHTS RESERVED.
 *
 *  The contents of this file are intellectual property of
 *  Aeonium Software Systems, Robert Rohm. All rights reserved.
 *  You must NOT, especially:
 *  - redistribute this file in source form,
 *  - redistribute this file in binary form,
 *  - modify this file,
 *  - use this file for your own work
 *  WITHOUT WRITTEN PERMISSION.
 *
 *  Anyway, we appreciate any interest in our work and knowledge.
 *  So, if you wish to use this file for your own purposes,
 *  please contact us:
 *  mailto:info@aeonium-systems.de
 *
 *
 *  © 2013 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.security.polities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author robert
 */
public class Security01_policies {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    System.setProperty("java.security.policy", "policy");
    System.setSecurityManager(new SecurityManager());
    SecurityManager manager = System.getSecurityManager();
    if (manager == null) {
      System.out.println("Kein SecurityManager!");
    }

    try {
      File datei = new File("C:\\test.txt");
      FileReader fr = new FileReader(datei);
      BufferedReader br = new BufferedReader(fr);

      String zeile;
      while ((zeile = br.readLine()) != null) {
        System.out.println(zeile);
      }
      // Schreibrechte erforderlich:
      datei.canWrite();

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
