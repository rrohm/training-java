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

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class exports person data to xml.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PersonXMLExporter {

  public String export(List<Person> persons) throws Exception {
    try {
      JAXBContext context = JAXBContext.newInstance(Person.class, PersonListData.class);
      Marshaller marshaller = context.createMarshaller();

      final StringWriter stringWriter = new StringWriter();

      marshaller.marshal(new PersonListData(persons), stringWriter);

      return stringWriter.toString();

    } catch (JAXBException ex) {
      Logger.getLogger(PersonXMLExporter.class.getName()).log(Level.SEVERE, null, ex);
      throw new Exception("Could not export data: " + ex.getMessage());
    }
  }

  /**
   * Helper class for JAXB marshalling: since we need an XmlRootElement and the
   * ArrayList isn't, we simple define our own wrapper. This one shows a simple
   * approach for putting each instance of {@link Person} into a single
   * <code>person</code> element.
   */
  @XmlRootElement(name = "persons")
  private static class PersonListData {

    @XmlElement(name = "person")
    private List<Person> persons;

    public PersonListData() {
      this.persons = new ArrayList<>();
    }

    public PersonListData(List<Person> persons) {
      this.persons = new ArrayList<>();
      this.persons = persons;
    }

    public List<Person> getPersons() {
      return persons;
    }
  }
}
