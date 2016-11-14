/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_midi01;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

/**
 *
 * @see http://docs.oracle.com/javase/tutorial/sound/overview-MIDI.html
 * @see http://docs.oracle.com/javase/tutorial/sound/MIDI-messages.html
 * 
 * @author Robert Rohm &lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_MIDI01 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      //
      ShortMessage message = new ShortMessage();
      message.setMessage(ShortMessage.NOTE_ON, 0, 60, 93);
      long timestamp = -1;
      Receiver receiver = MidiSystem.getReceiver();
      
      while (true) {        
        receiver.send(message, timestamp);
        
        try {
          Thread.sleep(2000);
        } catch (InterruptedException ex) {
          Logger.getLogger(Java_MIDI01.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
    } catch (InvalidMidiDataException ex) {
      ex.printStackTrace();
      Logger.getLogger(Java_MIDI01.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MidiUnavailableException ex) {
      ex.printStackTrace();
      Logger.getLogger(Java_MIDI01.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}
