/**
 */
package org.meins.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Externer Sender für die Message-Queue.
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
public class JMSMessageSender {

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

    MessageProducer sender = session.createProducer(queue);
    TextMessage message = session.createTextMessage();
    message.setStringProperty("subject", "Hallo");
    message.setText("Hallo - wer da?");
System.out.println("6");

    sender.send(message);
System.out.println("7");

    session.close();
    connection.close();
System.out.println("OK.");
  }
}
