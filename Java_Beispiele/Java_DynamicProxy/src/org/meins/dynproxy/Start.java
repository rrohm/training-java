package org.meins.dynproxy;

import java.lang.reflect.Proxy;

public class Start {

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

    helloProxy.sayHello("Welt");
  }
}
