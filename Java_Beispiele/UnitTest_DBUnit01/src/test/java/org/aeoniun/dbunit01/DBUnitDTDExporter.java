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

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;

/**
 * When editing test data sets, you might have a DTD to validate your XML data
 * definition against. With DBUnit, as one of the first steps, you may extract a
 * DTD from the database.
 *
 * See http://dbunit.sourceforge.net/faq.html#extract
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class DBUnitDTDExporter {

  public static void main(String[] args) throws Exception {

    // Define database connection
    Class.forName("org.postgresql.Driver");
    Connection jdbcConnection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/reallife", "reallife_user", "password");
    IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

    // write DTD file
    FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("/tmp/test.dtd"));

//    // or, more flexible: 
//    IDataSet dataSet = connection.createDataSet();
//    Writer out = new OutputStreamWriter(new FileOutputStream("myFile.dtd"));
//    FlatDtdWriter datasetWriter = new FlatDtdWriter(out);
//    datasetWriter.setContentModel(FlatDtdWriter.CHOICE);
//        // You could also use the sequence model which is the default
//    // datasetWriter.setContentModel(FlatDtdWriter.SEQUENCE);
//    datasetWriter.write(dataSet);
  }
}
