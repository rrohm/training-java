/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package i18n01;

import java.util.ResourceBundle;

/**
 *
 * @author robert
 */
public class I18N01 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    ResourceBundle messages = ResourceBundle.getBundle("texte");
    System.out.println(messages.getString("greeting"));
  }
}
