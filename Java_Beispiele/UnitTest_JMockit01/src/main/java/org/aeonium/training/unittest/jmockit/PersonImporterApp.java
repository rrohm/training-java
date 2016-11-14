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

import java.io.IOException;
import java.nio.file.Paths;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.aeonium.training.unittest.jmockit.helpers.ObjectMapperProvider;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * A simple application that reads person records from a CSV file, needs to be
 * invoided from command line with the path to the file as single argument.
 * <p>
 * (Currently still German naming and comments, will be changed soon :-)
 */
public class PersonImporterApp {
  
  
  private static final String BASE_URI = "http://localhost:8080/";

  /**
   * Startmethode der Anwendung - hier wird die Anwendungsstruktur aufgebaut und
   * die nötigen Referenzen zugewiesen.
   *
   * @param args
   */
  public static void main(String[] args) throws IOException {
    System.out.println("PersonenImporter started!");
    
    Client client = ClientBuilder.newClient()
            .register(ObjectMapperProvider.class)
            .register(JacksonFeature.class)
            ;
    WebTarget path = client.target(BASE_URI).path("person");
    

    // The importer gets only the REST target set:
    PersonenImporter importer = new PersonenImporter(path);

    //For hardcoded testing, if you like it convenient:  
    //importer.importFromCSV(Paths.get("/home/robert/Projekte/aeJavaTraining/work/UnitTest_JMockit01/persons.csv"));
    
    // Parsing comman line args:
    if (args.length > 0) {
      try {
        importer.importFromCSV(Paths.get(args[0]));

        System.out.println("Import OK.");

      } catch (IOException e) {
        // ... error handling
        e.printStackTrace();
        System.err.println("Error, could not import list from path: " + args[0]);
      }
    }
    
    System.out.println("Importer done.");
  }
}
