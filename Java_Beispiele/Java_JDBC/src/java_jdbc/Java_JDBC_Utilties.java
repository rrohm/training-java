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
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package java_jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_JDBC_Utilties {

  public static boolean exists(Connection conn, String tablename) {
    boolean result = false;
    String[] types = {"TABLE"};

    try {
      DatabaseMetaData metaData = conn.getMetaData();
      ResultSet tables = metaData.getTables(null, null, "%", types);
      while (tables.next()) {
        String string = tables.getString("TABLE_NAME");
        // ACHTUNG! Nur auf diese Art prüfen, wenn Tabellennamen 
        // tatschlich caseinsensitive sind (oder so behandelt werden)!
        result = string.toLowerCase().equals(tablename.toLowerCase());
        if (result) {
          break;
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(Java_JDBC_Utilties.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
  }

  public static boolean existsColumn(Connection conn, String tableName, String columnName) {
    boolean result = false;

    try {
      DatabaseMetaData metaData = conn.getMetaData();
      ResultSet columns = metaData.getColumns(null, null, "%", "%");
      while (columns.next()) {
        String string = columns.getString("COLUMN_NAME");
//        System.out.println("-->" + string);
        result = string.toLowerCase().equals(columnName.toLowerCase());
        if (result) {
          break;
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(Java_JDBC_Utilties.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
  }

}
