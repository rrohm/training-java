/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.jdi;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
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
 * Debuggee is started with -Xrunjdwp:transport=dt_socket,server=y,suspend=n
 * @author robert
 */
public class Bsp05_FindClassInstances {

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
    VirtualMachine vm = pidAttachConnector.attach(defaultArguments);
    System.out.println("vm.canGetBytecodes()                " + vm.canGetBytecodes());
    System.out.println("vm.canGetClassFileVersion()         " + vm.canGetClassFileVersion());
    System.out.println("vm.canGetConstantPool()             " + vm.canGetConstantPool());
    System.out.println("vm.canGetCurrentContendedMonitor()  " + vm.canGetCurrentContendedMonitor());
    System.out.println("vm.canGetInstanceInfo()             " + vm.canGetInstanceInfo());
    System.out.println("vm.canGetMethodReturnValues()       " + vm.canGetMethodReturnValues());
    System.out.println("vm.canGetMonitorFrameInfo()         " + vm.canGetMonitorFrameInfo());
    System.out.println("vm.canGetMonitorInfo()              " + vm.canGetMonitorInfo());
    System.out.println("vm.canGetOwnedMonitorInfo()         " + vm.canGetOwnedMonitorInfo());
    System.out.println("vm.canGetSourceDebugExtension()     " + vm.canGetSourceDebugExtension());
    System.out.println("vm.canGetSyntheticAttribute()       " + vm.canGetSyntheticAttribute());

    System.out.println("\nFind loaded classes:");
    List<ReferenceType> allClasses = vm.allClasses();
    for (ReferenceType referenceType : allClasses) {
      System.out.println("" + referenceType.name());
    }


    System.out.println("\nFind instances of classes from given package: ");
    String packageName = "org.meins";
    allClasses = vm.allClasses();
    for (ReferenceType referenceType : allClasses) {
      final String name = referenceType.name();
      if (name.startsWith(packageName)) {
        // get all instances:
        List<ObjectReference> instances = referenceType.instances(0);
        for (ObjectReference objectReference : instances) {
          System.out.println("" + objectReference);
        }
      }
    }

    System.out.println("\nFind instances of classes from given package + references: ");
    packageName = "org.meins";
    allClasses = vm.allClasses();
    for (ReferenceType referenceType : allClasses) {
      final String name = referenceType.name();
      if (name.startsWith(packageName)) {
        // get all instances:
        List<ObjectReference> instances = referenceType.instances(0);
        for (ObjectReference objectReference : instances) {
          System.out.println("" + objectReference);

          List<ObjectReference> referringObjects = objectReference.referringObjects(0);
          System.out.println("  references: " + referringObjects.size());
          for (ObjectReference referringObject : referringObjects) {
            System.out.println("  " + referringObject);
          }
        }
      }
    }
  }
}
