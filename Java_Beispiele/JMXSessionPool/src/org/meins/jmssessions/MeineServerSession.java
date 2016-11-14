package org.meins.jmssessions;

import javax.jms.JMSException;
import javax.jms.ServerSession;
import javax.jms.Session;

/**
 *
 *
 * @author R. Rohm
 *
 */
public class MeineServerSession implements ServerSession {

  // TODO ACHTUNG - nur vor�ufige Initialisierung!
  Session session = null;

  @Override
  public Session getSession() throws JMSException {
    //
    return this.session;
  }

  @Override
  public void start() throws JMSException {

    // Thread mit session als Runnable
    Thread t = new Thread(this.session);
    // Thread starten
    t.start();
    // Danach: Session wieder in Pool zur�cklegen

  }
}
