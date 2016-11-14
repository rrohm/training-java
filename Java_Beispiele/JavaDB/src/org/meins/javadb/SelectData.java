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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author robert
 */
public class SelectData {

  public static final String JDBCDERBYDBDATA = "jdbc:derby:test;create=true";
  private static Connection conn;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    conn = DriverManager.getConnection(JDBCDERBYDBDATA);
    Statement stmt = conn.createStatement();

    ResultSet res = stmt.executeQuery("SELECT * FROM data1");

    if (res != null) {
      while (res.next()) {
        int id = res.getInt("id");
        System.out.println("ID: " + id);
      }
    }
    System.out.println("fertig.");
  }
}
