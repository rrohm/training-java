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
package org.aeonium.training.unittest.jmockit;

import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import mockit.Mocked;
import mockit.Verifications;
import org.aeonium.training.unittest.jmockit.model.Person;
import org.junit.Test;

/**
 * In this example we mock the REST webservice target in order to test the 
 * PersonImporter without the REST service beeing actually available.
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PersonenImporterTest {

  /**
   * The mocked web target
   */
  @Mocked
  WebTarget path;

  public PersonenImporterTest() {
  }

  /**
   * Test of importFromCSV method, of class PersonenImporter.
   */
  @Test
  public void testImportFromCSV() throws Exception {
    System.out.println("importFromCSV ");

    PersonenImporter personenImporter = new PersonenImporter(path);
    Path datei = Paths.get("/home/robert/Projekte/aeJavaTraining/work/UnitTest_JMockit01/persons.csv");

    personenImporter.importFromCSV(datei);

    // Verify whether these methods have been called by the SUT upon the 
    // mocked REST target with the given arguments.
    // IMPORTANT: This does work without the REST service actually available.
    // Test the verification by simply renaming the persons - it fails with 
    // a "Missing invocation" exception. 
    new Verifications() {
      {
        path.request(MediaType.APPLICATION_JSON).put(Entity.entity(new Person("Mustermann", "Max"), MediaType.APPLICATION_JSON));
        path.request(MediaType.APPLICATION_JSON).put(Entity.entity(new Person("Lyse", "Anna"), MediaType.APPLICATION_JSON));
      }
    };
  }

}
