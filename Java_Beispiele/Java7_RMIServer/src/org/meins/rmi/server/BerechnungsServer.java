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
package org.meins.rmi.server;

import java.rmi.RemoteException;
import org.meins.rmi.common.BerechnungsServerIF;

/**
 * Die Server-Klasse implementiert die Dienste des RMI-Servers, sie ist eine
 * (fast ausschließlich) fachliche Klasse.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 *
 */
public class BerechnungsServer implements BerechnungsServerIF {

  /**
   * Default serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  /**
   * Diese Methode ist eine remote-Methode, sie muss daher RemoteExceptions
   * deklarieren. Außerdem müssen Übergabe-Typen serialisierbar sein.
   *
   * @param a
   * @param b
   * @return
   * @throws RemoteException
   */
  @Override
  public Long addiere(Long a, Long b) throws RemoteException {
    return a + b;
  }
}
