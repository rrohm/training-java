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
package org.meins.rmi.common;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Das Interface des RMI-Servers. Dieses wird sowohl vom Server als auch vom
 * CLient benötigt. Es ist daher in einem eigenen Projekt ausgelagert.
 *
 * Das Server-Interface muss von Remote und Serializable ableiten.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 *
 */
public interface BerechnungsServerIF extends Remote, Serializable {

  /**
   * Technische Konvention: Jede Methode eines RMI-Servers muss RemoteExceptions
   * werfen (können).
   *
   * ACHTUNG: Alle Rückgabe-Typen und alle Übergabe-Typen müssen serialisierbar
   * sein, d.h. für Klassen: sie müssen das Serializable-Interface
   * implementieren.
   *
   * @param a
   * @param b
   * @return
   * @throws RemoteException
   */
  public Long addiere(Long a, Long b) throws RemoteException;
}
