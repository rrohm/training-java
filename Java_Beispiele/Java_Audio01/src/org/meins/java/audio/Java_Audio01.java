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
 *  2016 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.java.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * This example illustrates how to play audio data, here it is a self-generated
 * sine wave.
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_Audio01 {

  final static int SAMPLE_RATE = 44100;
  final static int SAMPLE_SIZE = 8;
  final static int CHANNELS = 1;

  /**
   * Run the example.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) throws LineUnavailableException {

    AudioFormat audioFormat = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, CHANNELS, true, true);
    try (SourceDataLine sourceDataLine = AudioSystem.getSourceDataLine(audioFormat)) {
      sourceDataLine.open(audioFormat, SAMPLE_RATE);
      sourceDataLine.start();

      final byte[] audioData = createSinWaveBuffer(400, 1000);
      sourceDataLine.write(audioData, 0, audioData.length);

      sourceDataLine.drain();
    }
  }

  /**
   * Create byte data for a sin wave at a given sample rate.
   *
   * @param freq The frequency.
   * @param ms The duration in milliseconds
   * @return The audio data
   */
  public static byte[] createSinWaveBuffer(double freq, int ms) {
    int samples = (int) ((ms * SAMPLE_RATE) / 1000);
    byte[] output = new byte[samples];
    //
    double period = (double) SAMPLE_RATE / freq;
    for (int i = 0; i < output.length; i++) {
      double angle = 2.0 * Math.PI * i / period;
      output[i] = (byte) (Math.sin(angle) * 127f);
    }

    return output;
  }

}
