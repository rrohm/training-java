/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @deprecated This does not work - don't try it this way.
 * @author robert rohm
 */
public class JMSMessageReciever {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws NamingException, JMSException {
System.out.println("1");
    InitialContext ctx = new InitialContext(System.getProperties());
System.out.println("2");
    ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/meineFactoy01");
System.out.println("3");
    Connection connection = connectionFactory.createConnection();
System.out.println("4");

    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    Queue queue = (Queue) ctx.lookup("jms/meineQueue");
System.out.println("5");

    MessageConsumer consumer = session.createConsumer(queue);
    int n = 0;
    while (n < 20) {
      Message receive = consumer.receive(5000);
      if (receive != null) {
        if (receive instanceof TextMessage) {
          TextMessage textMessage = (TextMessage) receive;
          String text = textMessage.getText();
          System.out.println("Gelesen: " + text);
        }
      } else {
        System.out.println("keine Nachricht ...");
      }
      n++;
    }
    session.close();
    connection.close();
System.out.println("OK.");
  }
}
