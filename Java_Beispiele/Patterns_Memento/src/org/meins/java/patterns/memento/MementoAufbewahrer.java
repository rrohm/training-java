package org.meins.java.patterns.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class MementoAufbewahrer {

  private Deque<UrheberObjekt.Memento> mementoStack = new ArrayDeque<>();

  public void speichereMemento(UrheberObjekt.Memento m){
    this.mementoStack.add(m);
  }

  public UrheberObjekt.Memento holeLetztesMemento(){
    return mementoStack.pollLast();
  }
}
