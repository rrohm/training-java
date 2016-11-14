/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.jdi;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.VirtualMachine;
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
 *
 * The debuggee has to be started with VM options: -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,address=8000.
 * 
 * @author robert rohm
 */
public class Bsp04_AttachToSocket {

  public static void main(String[] args) throws IOException, IllegalConnectorArgumentsException {

    VirtualMachineManager manager = Bootstrap.virtualMachineManager();

    List<AttachingConnector> attachingConnectors = manager.attachingConnectors();

    System.out.println("List Attaching Connectors: ");
    AttachingConnector pidAttachConnector = null;
    for (AttachingConnector attachingConnector : attachingConnectors) {
      System.out.println("> " + attachingConnector);
      System.out.println("> class.getName(): " + attachingConnector.getClass().getName());

      if (attachingConnector.name().equals("com.sun.jdi.SocketAttach")){
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
    Connector.Argument hostArgument = defaultArguments.get("hostname");
    hostArgument.setValue("localhost");
    defaultArguments.put("hostname", hostArgument);
    Connector.Argument portArgument = defaultArguments.get("port");
    portArgument.setValue("8000");
    defaultArguments.put("port", portArgument);

    System.out.println("\nConnect using default arguments: ");
    VirtualMachine attach = pidAttachConnector.attach(defaultArguments);



  }
}
