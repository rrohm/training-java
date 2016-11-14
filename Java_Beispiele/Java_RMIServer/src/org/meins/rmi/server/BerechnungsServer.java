package org.meins.rmi.server;

import java.rmi.RemoteException;
import org.meins.rmi.common.BerechnungsServerIF;

/**
 * Die Server-Klasse implementiert die Dienste des RMI-Servers, sie ist eine
 * (fast ausschließlich) fachliche Klasse.
 *
 * @author robert rohm
 *
 */
public class BerechnungsServer implements BerechnungsServerIF {

    /**
	 * Default serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;

@Override
  public Long addiere(Long a, Long b) throws RemoteException {
    return a + b;
  }
}
