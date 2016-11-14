/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2013 AEONIUM SOFTWARE SYSTEMS - ALL RIGHTS RESERVED.
 *
 * The contents of this file are intellectual property of
 * Aeonium Software Systems, Robert Rohm. All rights reserved.
 * You must NOT, especially:
 * - redistribute this file in source form,
 * - redistribute this file in binary form,
 * - modify this file,
 * - use this file for your own work
 * WITHOUT WRITTEN PERMISSION.
 *
 * Anyway, we appreciate any interest in our work and knowledge.
 * So, if you wish to use this file for your own purposes,
 * please contact us:
 * mailto:info@aeonium-systems.de
 *
 *
 * © 2013 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.jdbc.mysql;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author robert
 */
public class MySQLConnect {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {

      // TODO code application logic here
      // Für MySQL
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.200/mysql?user=vmuser&password=password");

      
      String sql = "SELECT * FROM user";

      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet resultSet = stmt.executeQuery();
      if (resultSet != null) {
        int n = 0;
        while (resultSet.next()) {
          String host = resultSet.getString("Host");
          String user = resultSet.getString("User");

          System.out.println(n + ": " + user + "@" + host);
          n++;
        }
      }

    } catch (SQLException ex) {
      Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
