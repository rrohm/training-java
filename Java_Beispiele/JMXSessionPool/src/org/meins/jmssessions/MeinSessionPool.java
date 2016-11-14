package org.meins.jmssessions;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.ServerSession;
import javax.jms.ServerSessionPool;

public class MeinSessionPool implements ServerSessionPool {

  private Connection connection;

  public MeinSessionPool(Connection connection) {
    this.connection = connection;
  }

  @Override
  public ServerSession getServerSession() throws JMSException {
    // TODO Auto-generated method stub

    return null;
  }
}
