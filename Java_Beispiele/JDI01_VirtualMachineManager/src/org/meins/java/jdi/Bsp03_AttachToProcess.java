/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.jdi;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Debuggee is started with -Xrunjdwp:transport=dt_socket,server=y,suspend=n
 * @author robert
 */
public class Bsp03_AttachToProcess {

  public static void main(String[] args) throws IOException, IllegalConnectorArgumentsException {

    VirtualMachineManager manager = Bootstrap.virtualMachineManager();

    List<AttachingConnector> attachingConnectors = manager.attachingConnectors();

    System.out.println("List Attaching Connectors: ");
    AttachingConnector pidAttachConnector = null;
    for (AttachingConnector attachingConnector : attachingConnectors) {
      System.out.println("> " + attachingConnector);
      System.out.println("> class.getName(): " + attachingConnector.getClass().getName());
      if (attachingConnector.getClass().getName().equals("com.sun.tools.jdi.ProcessAttachingConnector")) {
        pidAttachConnector = attachingConnector;
      }
    }

    if (pidAttachConnector != null) {
      System.out.println("Attachting connector found, OK.");
    } else {
      throw new NullPointerException("PID-attaching connector not found.");
    }

    System.out.println("\nGet default arguments: ");
    Map<String, Connector.Argument> defaultArguments = pidAttachConnector.defaultArguments();
    Set<String> keySet = defaultArguments.keySet();
    Iterator<String> iterator = keySet.iterator();
    while (iterator.hasNext()) {
      String key = iterator.next();
      System.out.println("Default arguments of connector: " + key + ":" + defaultArguments.get(key));
    }

    System.out.println("\nGet and set single arguments: ");
    Connector.Argument pidArgument = defaultArguments.get("pid");
    pidArgument.setValue("20975");
    defaultArguments.put("pid", pidArgument);

    System.out.println("\nConnect using default arguments: ");
    pidAttachConnector.attach(defaultArguments);

    

  }
}
