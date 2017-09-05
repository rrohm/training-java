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
package org.aeoniun.dbunit01;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

/**
 * Another way of getting started is to export existing data from the test
 * database. This script illustrates three ways of exporting data form the
 * database:
 * <ul>
 * <li>Partial data per SELECT statement, spanning several tables</li>
 * <li>Full data sets</li>
 * <li>Data sets from one table plus all referenced tables.</li>
 * </ul>
 *
 * See http://dbunit.sourceforge.net/faq.html#extract
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DBUnitExporter {

  public static void main(String[] args) throws Exception {

    // Define edatabase connection
    Class driverClass = Class.forName("org.postgresql.Driver");
    Connection jdbcConnection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/reallife", "reallife_user", "password");

    // DBUnit specific: 
    IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

    // 1) partial database export
    QueryDataSet partialDataSet = new QueryDataSet(connection);
    partialDataSet.addTable("users", "SELECT * FROM users WHERE name='rrohm'");
    partialDataSet.addTable("tasks");
    FlatXmlDataSet.write(partialDataSet, new FileOutputStream("/tmp/partial.xml"));

    // 2) full database export
    IDataSet fullDataSet = connection.createDataSet();
    FlatXmlDataSet.write(fullDataSet, new FileOutputStream("/tmp/full.xml"));

    // 3) dependent tables database export: export table X and all tables that
    // have a PK which is a FK on X, in the right order for insertion
    String[] depTableNames
            = TablesDependencyHelper.getAllDependentTables(connection, "tasks");
    IDataSet depDataSet = connection.createDataSet(depTableNames);
    FlatXmlDataSet.write(depDataSet, new FileOutputStream("/tmp/dependents.xml"));

  }
}
