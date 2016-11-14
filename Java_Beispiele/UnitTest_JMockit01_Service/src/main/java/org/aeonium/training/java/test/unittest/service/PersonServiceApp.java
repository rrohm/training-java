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

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * This is a simple Spring Boot application the serves as the "service" for the
 * UnitTest_JMockit01 client application – that should be tested without the
 * service. So, in this case the service is just there to see that/how the
 * clients actually works.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@SpringBootApplication
public class PersonServiceApp {

  static final Logger LOG = Logger.getLogger(PersonServiceApp.class.getName());

  public static void main(String[] args) {
    LOG.info("Starting UnitTest_JMockit01 Backend");
    ApplicationContext context = SpringApplication.run(PersonServiceApp.class, args);
  }

}
