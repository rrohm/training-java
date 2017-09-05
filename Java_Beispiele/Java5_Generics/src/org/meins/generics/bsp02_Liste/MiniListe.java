/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 *
 *  You are free to:
 *
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 *
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 *
 *  Under the following terms:
 *
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 *
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 *
 *
 *  2017 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.generics.bsp02_Liste;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author r. rohm
 */
public class MiniListe<E> implements Iterable<E> {

  private Object[] data;
  private int size;

  /**
   * Erzeugt eine leere Liste, die maximal maxSize Elemente
   * aufnehmen kann.
   */
  public MiniListe(int maxSize) {
    this.data = new Object[maxSize];
    this.size = 0;
  }

  /**
   * Fügt ein Element zur Liste hinzu. Falls diese schon
   * voll ist, wird eine Exception ausgelöst.
   */
  public void addElement(E element) {
    if (size >= data.length) {
      throw new ArrayIndexOutOfBoundsException();
    }
    this.data[this.size++] = element;
  }

  /**
   * Liefert die Anzahl der Elemente in der Liste.
   */
  public int size() {
    return size;
  }

  /**
   * Liefert das Element an Position pos. Falls kein solches
   * Element vorhanden ist, wird eine Exception ausgelöst.
   */
  public E elementAt(int pos) {
    if (pos >= size) {
      throw new NoSuchElementException();
    }
    return (E) data[pos];
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      int pos = 0;

      @Override
      public boolean hasNext() {
        return pos < size;
      }

      @Override
      public E next() {
        if (pos >= size) {
          throw new NoSuchElementException();
        }
        return (E) data[pos++];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }


  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    //Untypisierte Verwendung
    MiniListe l1 = new MiniListe(10);
    l1.addElement(3.14);
    l1.addElement("world");
    for (Object o : l1) {
      System.out.println(o);
    }
    //Ganzzahlige Typisierung
    System.out.println("---");
    MiniListe<Integer> l2 = new MiniListe<Integer>(5);
    l2.addElement(3);
    l2.addElement(1);
    l2.addElement(4);
    for (Integer i : l2) {
      System.out.println(i + 1000);
    }
    //Verwendung read-only
    System.out.println("---");
    MiniListe<? extends Number> l3 = l2;
    for (Number i : l3) {
      System.out.println(i.intValue() + 1000);
    }
  }
}
