package org.meins.sessionbeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Beispiel für Verwendung einer Message-Queue mit Message-Driven-Bean dahinter
 * aus einer EJB heraus.
 *
 * @author robert rohm
 */
@Stateless
@LocalBean
public class JMSAufruferBean {

  @Resource(mappedName = "jms/meineQueue")
  private Queue meineQueue;
  @Resource(mappedName = "jms/meineFactory01")
  private ConnectionFactory meineFactoy01;

  public void jmsNachrichtSenden() {

    try {
      // Aufruf in der Business-Methode
      this.sendJMSMessageToMeineQueue("Nachricht von der Session-Bean");
    } catch (JMSException ex) {
      Logger.getLogger(JMSAufruferBean.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  private Message createJMSMessageForjmsMeineQueue(Session session, Object messageData) throws JMSException {
    // TODO create and populate message to send
    TextMessage tm = session.createTextMessage();
    tm.setText(messageData.toString());
    return tm;
  }

  private void sendJMSMessageToMeineQueue(Object messageData) throws JMSException {
    Connection connection = null;
    Session session = null;
    try {
      connection = meineFactoy01.createConnection();
      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      MessageProducer messageProducer = session.createProducer(meineQueue);
      messageProducer.send(createJMSMessageForjmsMeineQueue(session, messageData));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (JMSException e) {
          Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
        }
      }
      if (connection != null) {
        connection.close();
      }
    }
  }


}
