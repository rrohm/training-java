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
package org.meins.java.jaxb.basics;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Simple example of writing object data to and subsequently reading from file.
 *
 * @author robert rohm
 */
public class BasicReadWrite {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws JAXBException {

    String filename = "./data.xml";

    Data data = new Data();

    data.getItems().add(new Item("Erstes"));
    data.getItems().add(new Item("Zweites"));

    JAXBContext context = JAXBContext.newInstance(Data.class);
    Marshaller marshaller = context.createMarshaller();

    // Printing the XML to the console: 
    marshaller.marshal(data, System.out);

    // Pretty-printing into a file:
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(data, new File(filename));

    // Reading from file: 
    Unmarshaller unmarshaller = context.createUnmarshaller();

    Data data2 = (Data) unmarshaller.unmarshal(new File(filename));
    System.out.println("data2: ");
    System.out.println(data2);

  }
}
