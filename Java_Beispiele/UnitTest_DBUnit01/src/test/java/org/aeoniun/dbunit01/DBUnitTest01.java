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
 *  2016 Aeonium Software Systems, Robert Rohm.
 */
package org.aeoniun.dbunit01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A simple example, illustrating how two datasets can get compared against each
 * other. In this case, it is an xml dataset created beforehand and the actual
 * dataset in the SQL table. This technique can be used when we want to verify
 * modifications that the SUT should have made in the database. In this example,
 * this is left out for brevity.
 *
 * <strong>CAUTION!</strong> DBUnit has a strange behaviour dealing with NULL
 * values in the database, see {@link DBUnitTest01#testDataInDBAgainstXML() }!
 *
 * <strong>Prerequisites:</strong> Create the file <code>full.xml</code> with 
 * the {@link DBUnitExporter} and place it at "/tmp/full.xml". 
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DBUnitTest01 {

  private static IDatabaseConnection connection;

  public DBUnitTest01() {
  }

  /**
   * Setup: create connection.
   *
   * @throws SQLException
   * @throws ClassNotFoundException
   * @throws DatabaseUnitException
   */
  @BeforeClass
  public static void setUpClass() throws SQLException, ClassNotFoundException, DatabaseUnitException {

    Class driverClass = Class.forName("org.postgresql.Driver");
    Connection jdbcConnection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/reallife", "reallife_user", "password");

    // DBUnit specific: 
    connection = new DatabaseConnection(jdbcConnection);
  }

  /**
   * Tear down: close connection.
   *
   * @throws SQLException
   */
  @AfterClass
  public static void tearDownClass() throws SQLException {
    connection.close();
  }

  @Before
  public void setUp() {
    // TODO: here we would prepare the database state for each test method.
  }

  @After
  public void tearDown() {
  }

  /**
   * Simple example how we would test the state in the database against a
   * beforehand extracted test dataset, e.g., after the SUT has (or: should
   * have) modified the state in the database.
   *
   * <strong>Beware</strong> - this simple test exhibits a strange (default(!))
   * behaviour of DBUnit: The first tag of the XmlDataSet is used to define the
   * data structure. Since the XML dataset does not store NULL values and simple
   * omits the attribute, DBUnit might fail the test, reporting missing
   * columns(!).
   *
   * @throws DataSetException
   * @throws FileNotFoundException
   * @throws SQLException
   * @throws DatabaseUnitException
   */
  @Test
  public void testDataInDBAgainstXML() throws DataSetException, FileNotFoundException, SQLException, DatabaseUnitException {

    // TODO: Here goes the SUT method invocation that modifies the database.
    
    FlatXmlDataSet xmlData = new FlatXmlDataSetBuilder().build(new FileInputStream("/tmp/full.xml"));

    IDataSet databaseDataSet = connection.createDataSet();

    ITable actualTable = databaseDataSet.getTable("tasks");
    ITable exportedFullTable = xmlData.getTable("tasks");

    Assertion.assertEquals(exportedFullTable, actualTable);
  }
}
