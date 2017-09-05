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
package org.aeonium.training.unittest.jmockit;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import mockit.*;
import org.aeonium.training.unittest.jmockit.model.Person;
import org.junit.Test;

/**
 * This example shows how to verify that the SUT has called certain methods 
 * with given parameters upon a collaborator object. 
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PersonenImporterTest {
  
  public PersonenImporterTest() {
  }
  

  /**
   * The mocked collaborator, had to be a class type in previous versions.
   */
  @Mocked
  List mockedList = null;
  
  /**
   * Test of importFromCSV method, of class PersonenImporter.
   */
  @Test
  public void testImportFromCSVwithMock() throws Exception {
    System.out.println("importFromCSV " + mockedList);
    
		PersonenImporter personenImporter = new PersonenImporter(mockedList);
		Path datei = Paths.get("/home/robert/Projekte/1506-367/dist/Tag_4/personen.csv");
//		Path datei = Paths.get("C:\\Users\\Admin\\Desktop\\Share\\personen.csv");
		personenImporter.importFromCSV(datei);
    
    // Verify whether these methods have been called by the SUT upon the 
    // mocked list with the given arguments.
    new Verifications() {{
      mockedList.add(new Person("Mustermann", "Max"));
      mockedList.add(new Person("Lyse", "Anna"));
    }};
    
  }

}
