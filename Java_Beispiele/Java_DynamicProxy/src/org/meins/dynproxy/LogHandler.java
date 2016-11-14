package org.meins.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

  private Object object;

  public LogHandler(Object object) {
    this.object = object;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Invoking method " + method.getName());

    Object result = method.invoke(this.object, args);

    System.out.println("Done.");
    return result;
  }
}