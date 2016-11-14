/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schulung.controller;

/**
 * Zu injizierender Service - muss eine public class sein,
 * package private reicht nicht, auch wenn es für die Compile-Zeit in Ordnung
 * wäre.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PausenzeitenService {

  public Pausenzeit createPause(){
    return new Pausenzeit();
  }
}
