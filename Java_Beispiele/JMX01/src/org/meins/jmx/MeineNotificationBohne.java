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
 *  2019 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * Diese MBean verwendet zusätzlich den JMX Notification-Mechanismus: via JMX
 * können sich Clients wie die JConsole registrieren, um auf Ereignisse aus
 * einer MBean zu lauschen. Hiermit können z.B. einfache Log-Meldungen mit der
 * JConsole überwacht werden.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class MeineNotificationBohne extends NotificationBroadcasterSupport implements MeineNotificationBohneMBean {

  private String name = "Meine JMX Bohne";
  // Zähler für JMX-Norifications
  private long sequenceNumber = 0;

  /* (non-Javadoc)
   * @see org.meins.jmx.MeineBohneMBean#malZwei(int)
   */
  @Override
  public int malZwei(int n) {
    return n * 2;
  }


  /* (non-Javadoc)
   * @see org.meins.jmx.MeineBohneMBean#getName()
   */
  @Override
  public String getName() {
    return name;
  }


  /* (non-Javadoc)
   * @see org.meins.jmx.MeineBohneMBean#setName(java.lang.String)
   */
  @Override
  public void setName(String name) {
    String oldValue = this.name;

    this.name = name;

    // Hier: Die MBean soll bei Änderung der Eigenschaft
    // an die JMX-Konsole funken:
    Notification n = new AttributeChangeNotification(
            this, // Sender
            sequenceNumber++, // Numerierung für die eigenen Notifications
            System.currentTimeMillis(), // Zeitstempel in Millisikunden
            "Name geändert!",
            "Name", // ACHTUNG: Bean-Attribut-Name, mit Großbuchstabe (kein Feldname)
            "String",
            oldValue, this.name);

    this.sendNotification(n);
  }
}
