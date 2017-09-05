/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schulung;

import schulung.controller.Pausenzeit;
import schulung.controller.PausenzeitController;
import schulung.framework.Framework;

/**
 * Startklasse einer Anwendung, die mit Dependeny Injection (DI) arbeitet.
 *
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Anwendung {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    
    // 0) Achtung: Das Beispiel arbeitet mit Reflection - Zugriff z.B. auf 
    //    private Felder wird bei Einsatz eines SecurityManagers normalerweise
    //    unterbunden.
//    SecurityManager securityManager = System.getSecurityManager();
//    if (securityManager == null) {
//      System.setSecurityManager(new SecurityManager());
//    }

    //1) Erzeugung der Controller-Instanz mit dem Framework
    PausenzeitController controller =
            (PausenzeitController) Framework.assemble(PausenzeitController.class);

    System.out.println("controller: " + controller);

    Pausenzeit pause = controller.startePause();

    System.out.println("pause: " + pause);
  }

}
