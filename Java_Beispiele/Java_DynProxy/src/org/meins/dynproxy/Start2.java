/*
 * This code is released under Creative Commons Attribution 4.0 International
 * (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 * That means:
 *
 * You are free to:
 *
 *     Share — copy and redistribute the material in any medium or format
 *     Adapt — remix, transform, and build upon the material
 *              for any purpose, even commercially.
 *
 *     The licensor cannot revoke these freedoms as long as you follow the
 *     license terms.
 *
 * Under the following terms:
 *
 *     Attribution — You must give appropriate credit, provide a link to the
 *     license, and indicate if changes were made. You may do so in any
 *     reasonable manner, but not in any way that suggests the licensor endorses
 *     you or your use.
 *
 * No additional restrictions — You may not apply legal terms or technological
 * measures that legally restrict others from doing anything the license
 * permits.
 */
package org.meins.dynproxy;


/**
 * ... just like Start class, but with two proxies.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */

import java.lang.reflect.Proxy;
import org.meins.dynproxy.secondtype.Logic;
import org.meins.dynproxy.secondtype.LogicIF;



public class Start2 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    HelloIF hello = new Hello();

    ClassLoader loader = hello.getClass().getClassLoader();

    Class[] interfaces = new Class[]{HelloIF.class};
    LogHandler logHandler = new LogHandler(hello);

    HelloIF helloProxy = (HelloIF) Proxy.newProxyInstance(
            loader, interfaces, logHandler);

    String result = helloProxy.sayHello("Welt");

    System.out.println("Rückgabe des Proxies: " + result);

    LogicIF logic = new Logic();
    loader = logic.getClass().getClassLoader();
    interfaces = new Class[]{LogicIF.class};
    logHandler = new LogHandler(logic);
    LogicIF logicProxy = (LogicIF) Proxy.newProxyInstance(loader, interfaces, logHandler);

    result = logicProxy.doWork("OK");
    System.out.println("Rückgabe des Proxies: " + result);

  }

}
