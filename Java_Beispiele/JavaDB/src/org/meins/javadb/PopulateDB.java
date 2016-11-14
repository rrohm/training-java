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
package org.meins.javadb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author robert
 */
public class PopulateDB {

  public static final String JDBCDERBYDBDATA = "jdbc:derby:test;create=true";
  public static final int RECORDS = 1000000;
  private static Connection conn;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    conn = DriverManager.getConnection(JDBCDERBYDBDATA);

    for (int i = 0; i < RECORDS; i++) {
      // Hinweis: Dieser Abschnitt kann punkto Performance mehrfach optimiert werden!!
      String t0 = createRandomString(10, 100);
      String t1 = createRandomString(10, 100);
      String t2 = createRandomString(10, 100);
      double d0 = createRandomNumber(10, 100);
      double d1 = createRandomNumber(10, 100);
      double d2 = createRandomNumber(10, 100);
      PreparedStatement stmt = conn.prepareCall(""
              + "INSERT INTO data1 (text0, text1, text2, n0, n1, n2) VALUES (?, ?, ?, ?, ?, ?)");
      stmt.setString(1, t0);
      stmt.setString(2, t1);
      stmt.setString(3, t2);
      stmt.setBigDecimal(4, new BigDecimal(d0));
      stmt.setBigDecimal(5, new BigDecimal(d1));
      stmt.setBigDecimal(6, new BigDecimal(d2));
      stmt.execute();
    }
  }

  private static double createRandomNumber(int min, int max) {
    return min + ((max - min) * Math.random());
  }
  private static String createRandomString(int min, int max) {
    String chars = "QWERTZUIOPASDFGHJKLÖÄÜYXCVBNMqwertzuiopasdfghjklyxcvbnm";
    StringBuilder sb = new StringBuilder();
    double random = Math.random();
    int l = (int) (min + Math.round((1 - random) * (max - min)));
//    System.out.print("l: " + l);
    for (int i = 0; i < l; i++) {
      int j = (int) (chars.length() * Math.random());
      sb.append(chars.charAt(j));
    }
//    System.out.println(" " + sb.toString());
    return sb.toString();
  }

}
