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
package java_jdbc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_JDBC_ConnectionFactory {

  public static Connection createMySQLConnection() {
    Connection conn = null;
    try {
      // Für MySQL: richtige Treiber-Klasse aus dem Jar laden und instanzieren
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      // Je nach Datenbank: passenden JDBC-Connection-String zusammenbauen und übergeben
      conn = DriverManager.getConnection("jdbc:mysql://192.168.56.200/mysql?user=vmuser&password=password");

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    }

    return conn;
  }

  public static Connection createJavaDBConnection() {
    Connection connection = null;
    try {
      // Für JavaDB
      String dbUser = "dbuser";
      String dbPwd = "password";
      Path homeDir = Paths.get(System.getProperty("user.dir"));
      String dbPath = homeDir.resolve("db/data").toString();
      
      Properties p = new Properties();
      p.put("user", dbUser);
      p.put("password", dbPwd);
      p.put("create", "true");
      
      // JavaDB als EmbeddedDB: läuft im eigenen Prozess!
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connection = DriverManager.getConnection("jdbc:derby:"+dbPath+";", p);
      connection.setAutoCommit(false);

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    }

    return connection;
  }

  public static Connection createPostgresConnection() {
    Connection connection = null;
    try {
      
    String dbHost = "//localhost";
    String dbName = "meinedb";
    String dbUser = "postgres";
    String dbPwd = "password";
    String dbType = "postgresql";
    String dbDrv = "jdbc";
    String dbPort = "5432";

    String url =
            dbDrv + ":"
            + dbType + ":"
            + dbHost + ":"
            + dbPort + "/"
            + dbName;

    Class.forName("org.postgresql.Driver");
    connection = DriverManager.getConnection(url, dbUser, dbPwd);

    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Java_JDBC_ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    }

    return connection;
  }

}
