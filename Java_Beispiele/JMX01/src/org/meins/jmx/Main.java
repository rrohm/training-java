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
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.jmx;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * Diese Anwendung illustriert den Einsatz der JMX Java Management Extensions
 * und der JConsole.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // Voraussetzung für die Administrierung per JMX:
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

    try {
      // Definition des MBean-Objekt-Namens für den MBean-Server
      // Vergleichbar mit JNDI-Lookup und JNDI-Namen:
      // Der vordere Teil des Namens ist lediglich eine Namensraum-Definition.
      ObjectName name = new ObjectName("org.meins.jmx:type=MeineBohne");

      MeineBohne bohne = new MeineBohne();
      mbs.registerMBean(bohne, name);

      ObjectName name2 = new ObjectName("org.meins.jmx:type=MeineNotificationBohne");

      MeineNotificationBohne bohne2 = new MeineNotificationBohne();
      mbs.registerMBean(bohne2, name2);

    } catch (MalformedObjectNameException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InstanceAlreadyExistsException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MBeanRegistrationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NotCompliantMBeanException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("Bitte Taste drücken");
    try {
      System.in.read();
      System.out.println("Fertig.");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
