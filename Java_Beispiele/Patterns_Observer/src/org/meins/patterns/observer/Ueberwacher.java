package org.meins.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Typischer Überwacher - er bekommt seine Benachrichtigungsquelle mitgeteilt, 
 * plus ggf. ein Nutzlast-Objekt (Datenobjekt etc. ...). 
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Ueberwacher implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    System.out.println("Überwacher wurde informiert von " + o );
    System.out.println("Übergebene Daten: " + arg);
  }

}
