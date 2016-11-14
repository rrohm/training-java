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
 * @author robert rohm
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
