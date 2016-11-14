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
 *  2014 Aeonium Software Systems, Robert Rohm.
 */

package org.meins.javaee.appclientfx;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.meins.ejb.session.TestSessionBeanRemote;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class FXMLDocumentController implements Initializable {

  @FXML
  private Label label;

  @FXML
  private void handleButtonAction(ActionEvent event) {
    System.out.println("You clicked me!");
    label.setText(this.testBean.sayHello("Brave New World"));
  }

  private TestSessionBeanRemote testBean;

  public FXMLDocumentController() {
    try {
      //
      Properties props = new Properties();
      props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");

      // Optional:
      //    props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
      //    props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
      //
      //// optional.  Defaults to localhost.  Only needed if web server is running
      //// on a different host than the appserver
      //    props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
      //// optional.  Defaults to 3700.  Only needed if target orb port is not 3700.
      //    props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

      InitialContext context = new InitialContext(props);
      testBean = (TestSessionBeanRemote) context.lookup("java:global/JavaEE7_GF41-ear/JavaEE7_GF41-ejb/TestSessionBean!org.meins.ejb.session.TestSessionBeanRemote");
      System.out.println("TestSessionBeanRemote load: " + testBean);
    } catch (NamingException ex) {
      Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }

  }



  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}
