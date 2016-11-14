package org.meins.dynproxy;

public class Hello implements HelloIF {

  public String sayHello(String name) {
    System.out.println("Hello " + name + "!");
    return "Hello " + name + "!";
  }
}
