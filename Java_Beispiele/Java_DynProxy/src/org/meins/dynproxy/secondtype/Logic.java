package org.meins.dynproxy.secondtype;

public class Logic implements LogicIF {

  public String doWork(String name) {
    System.out.println("At work: " + name + "!");
    return "At work: " + name + "!";
  }
}
