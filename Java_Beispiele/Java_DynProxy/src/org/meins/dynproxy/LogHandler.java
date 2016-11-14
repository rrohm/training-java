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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * The log handler is a simple example for "orthogonal operations" or "aspectes"
 * that need to be executed "around" other methods of the business logic. It
 * works e.g., almost like a JavaEE interceptor, but we need to pass a reference
 * to the proxy explicitly (in the proxy constructor).
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class LogHandler implements InvocationHandler {

  private Object object;

  public LogHandler(Object object) {
    this.object = object;
  }

  /**
   * The interceptor method, needs to invoke the intercepted method explicitly -
   * or deny doing so, explicitly.
   *
   * @param proxy Reference to the actual proxy.
   * @param method The intercepted method.
   * @param args The method arguments
   * @return The return value of the intercepted method - or something else, as
   * we like it.
   * @throws Throwable
   */
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Invoking method " + method.getName());
    System.out.println("proxy: " + proxy.getClass().getName());

    Object result = method.invoke(this.object, args);

    System.out.println("Done.");
//    throw new RuntimeException("TEST-FEHLER aus Handler" );
    return result;
  }
}
