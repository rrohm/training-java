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
 *  2019 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.audio;

import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 * This example illustrates capturing audio data from the system's default
 * input, here with a duration of 5 seconds, and subsequently playing it back.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_Audio02_capture_and_replay {

  final static int SAMPLE_RATE = 44100;
  final static int SAMPLE_SIZE = 8;
  final static int CHANNELS = 1;

  static boolean stopped;

  /**
   * Run the example
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println("Java_Audio02_capture ");

    TargetDataLine line;
    AudioFormat audioFormat = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, CHANNELS, true, true);

    DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

    if (!AudioSystem.isLineSupported(info)) {
      throw new Exception("Line not supported");

    }

    // Obtain and open the line.
    try {
      line = (TargetDataLine) AudioSystem.getLine(info);
      line.open(audioFormat);

    } catch (LineUnavailableException ex) {
      throw ex;
    }

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int numBytesRead;
    byte[] data = new byte[line.getBufferSize() / 5];

    line.start();

    // set timeout: 
    new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException ex) {
        Logger.getLogger(Java_Audio02_capture_and_replay.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println("Recording done: ");
      stopped = true;
    }).start();

    while (!stopped) {
      numBytesRead = line.read(data, 0, data.length);
      out.write(data, 0, numBytesRead);
    }

    System.out.println("Replay: " + out.size() + " bytes");
    // If you want to see the actual audio bytes: 
//    for (byte b : out.toByteArray()) {
//      System.out.println(" - " + b);
//    }

    try (SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(audioFormat)) {
      sourceDataLine.open(audioFormat, SAMPLE_RATE);
      sourceDataLine.start();
      final byte[] audioData = out.toByteArray();
      sourceDataLine.write(audioData, 0, audioData.length);

      sourceDataLine.drain();
    }

    System.out.println("Done.");

  }
}
