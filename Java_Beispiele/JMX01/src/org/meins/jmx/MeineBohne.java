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

/**
 * Von dieser Klasse wird eine Instanz als JMX Management Bean bereitgestellt.
 * Sie ist eine ganz normale plain old Java bean, einzige Voraussetzung ist: die
 * für JMX verwendeten Eigenschaften und Methoden müssen in einem zugehörigen
 * Interface beschrieben werden, welches mit dem Postfix "MBean" benannt ist.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class MeineBohne implements MeineBohneMBean {

  private String name = "Meine JMX Bohne";

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
    this.name = name;
  }
}
