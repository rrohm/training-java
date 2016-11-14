/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.utils;

/**
 *
 * @author robert
 */
public class Stopwatch {

  private long nanotime = System.nanoTime();
  private long milliseconds = System.currentTimeMillis();

  /**
   * @return the nanotime
   */
  public long getNanotime() {
    return nanotime;
  }

  /**
   * @return the milliseconds
   */
  public long getMilliseconds() {
    return milliseconds;
  }

  public long getElapsedNanos(){
    return System.nanoTime() - this.nanotime;
  }
  public long getElapsedMillis(){
    return System.currentTimeMillis() - this.milliseconds;
  }


}
