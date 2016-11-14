/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Externer Message-Listener für die Message-Queue.
 *
 * Dieses Beispiel arbeitet mit einer lokalen Glassfish Message Queue. Soll eine
 * Remote-Queue verwendet werden, so müssen folgende System-Properties angegeben
 * werden:
 *
 * "org.omg.CORBA.ORBInitialHost" = "anderer Host"
 * "org.omg.CORBA.ORBInitialPort" = "3700";
 *
 * @author robert rohm
 */
public class JMSMessageListener {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws NamingException, JMSException {
    System.out.println("1. Starting JMSMessageListener");

    InitialContext ctx = new InitialContext(System.getProperties());
    System.out.println("2. InitialContext");

    QueueConnectionFactory connectionFactory = (QueueConnectionFactory) ctx.lookup("jms/meineQueueFactory");
    System.out.println("3. QueueConnectionFactory");

    QueueConnection connection = connectionFactory.createQueueConnection();
    System.out.println("4. QueueConnection");

    QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    Queue queue = (Queue) ctx.lookup("jms/meineQueue");
    System.out.println("5. QueueSession");

    QueueReceiver receiver = session.createReceiver(queue);
    receiver.setMessageListener(new MessageListener() {
      @Override
      public void onMessage(Message message) {
        if (message instanceof TextMessage) {
          TextMessage textMessage = (TextMessage) message;

          try {
            System.out.println("Nachricht: " + textMessage.getText());
          } catch (JMSException ex) {
            System.err.println("FEHLER. ");
          }
        }
      }
    });
    connection.start();
    try {
      Thread.sleep(50000);
    } catch (InterruptedException ex) {
      Logger.getLogger(JMSMessageListener.class.getName()).log(Level.SEVERE, null, ex);
    }

    connection.close();
    System.out.println("OK.");
  }
}
