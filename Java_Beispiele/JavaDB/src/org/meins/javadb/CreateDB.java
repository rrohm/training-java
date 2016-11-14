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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author robert
 */
public class CreateDB {

  public static final String JDBCDERBYDBDATA = "jdbc:derby:test;create=true";
  private static Connection conn;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    conn = DriverManager.getConnection(JDBCDERBYDBDATA);
    Statement stmt = conn.createStatement();
    
    stmt.execute("CREATE TABLE data1 ("
            + "  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
            + "  text0 VARCHAR(100) NOT NULL,"
            + "  text1 VARCHAR(100) NOT NULL,"
            + "  text2 VARCHAR(100) NOT NULL,"
            + "  n0 DECIMAL(4,2) NOT NULL,"
            + "  n1 DECIMAL(4,2) NOT NULL,"
            + "  n2 DECIMAL(4,2) NOT NULL"
            + " )");
    stmt.execute("CREATE INDEX IX_data1_id ON data1 (id ASC)");

  }

}
