/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.jdi;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.Connector;
import java.util.List;

/**
 *
 * @author robert
 */
public class Bsp01_ListConnectors {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    VirtualMachineManager manager = Bootstrap.virtualMachineManager();

    System.out.println("List available connectors");
    List<Connector> allConnectors = manager.allConnectors();

    for (Connector connector : allConnectors) {
      System.out.println("Connector: " + connector);
    }

  }
}
