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
package org.aeonium.training.java.test.unittest_xml01;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;

/**
 * Test cases for the {@link PersonXMLExporter} class, using XMLUnit to compare
 * the SUT's XML output against a beforehand defined test result file. This
 * example takes care of handling comments and whitespaces, so that test result
 * files do not need to match literally, but may be readable formatted and
 * commented.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PersonXMLExporterTest {

  public PersonXMLExporterTest() {
  }

  /**
   * Test of export method, of class PersonXMLExporter.
   */
  @Test
  public void testExport_List() throws Exception {
    System.out.println("export_List");

    // 1) Preparation of SUT and test data
    List<Person> persons = new ArrayList<>();
    persons.add(new Person("Mustermann", "Max"));
    persons.add(new Person("Lyse", "Anna"));

    PersonXMLExporter instance = new PersonXMLExporter();

    // 2) Setup XML comparison with a DiffBuilder.
    //    Testing with maven requires some workarounds if we like to 
    //    manage the test data within the project, see also the pom file, 
    //    section build -> testResources
    Diff diff = DiffBuilder.compare(Input.fromFile("target/test-classes/personlist_testdata.xml"))
            .ignoreComments()   // important!
            .ignoreWhitespace() // important!
            .withTest(instance.export(persons)).build();

    assertFalse(diff.toString(), diff.hasDifferences());
  }

}
