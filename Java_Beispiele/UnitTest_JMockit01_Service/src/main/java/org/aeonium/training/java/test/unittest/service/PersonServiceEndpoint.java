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
package org.aeonium.training.java.test.unittest.service;

import javax.ws.rs.core.MediaType;
import org.aeonium.training.unittest.jmockit.model.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST service endpoint – this endpoint would, in a real scenario, for example
 * store new person records in a database etc.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@RestController
public class PersonServiceEndpoint {

  /**
   * Example method for storing a new Person.
   *
   * @param p The Person object to be stored.
   */
  @RequestMapping(path = "/person", consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}, method = RequestMethod.PUT)
  public void storePerson(@RequestBody Person p) {
    System.out.println("PersonServiceEndpoint received a new Object: ");
    System.out.println(p.toString());
  }
}
