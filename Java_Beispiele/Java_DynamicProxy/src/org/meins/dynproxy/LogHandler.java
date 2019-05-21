package org.meins.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

  private final Object object;

  public LogHandler(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//    System.out.println("proxy:  " + proxy); // NEIN!!!
    System.out.println("object: " + this.object);
    System.out.println("Invoking method " + method.getName());

//    Object result = method.invoke(proxy, args); // NEIN!!!
    Object result = method.invoke(this.object, args);

    System.out.println("Done.");
    return result;
  }
}