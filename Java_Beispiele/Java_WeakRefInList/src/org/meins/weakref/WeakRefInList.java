/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.weakref;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class WeakRefInList {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    List<WeakReference<Object>> list = new ArrayList<>();

    final Thread thread = new Thread(() -> {
      while (!Thread.currentThread().isInterrupted()) {
        final int size = list.size();
        System.out.print("Anzahl Elemente: " + size);
        if (size > 0) {
          System.out.print(" " + list.get(0).get());
        }
        System.out.println("");
        try {
          Thread.sleep(500);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
      }
    });

    thread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Logger.getLogger(WeakRefInList.class.getName()).log(Level.SEVERE, null, ex);
    }

    Object o = new Object();
    list.add(new WeakReference<>(o));


    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Logger.getLogger(WeakRefInList.class.getName()).log(Level.SEVERE, null, ex);
    }

    o = null;

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Logger.getLogger(WeakRefInList.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.gc();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException ex) {
      Logger.getLogger(WeakRefInList.class.getName()).log(Level.SEVERE, null, ex);
    }

    thread.interrupt();
  }

}
