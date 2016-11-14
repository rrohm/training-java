/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.jni.Bsp01_Basics;

import org.meins.jni.StrLen;

/**
 *
 * @author robert rohm
 */
public class Java_JNI {

  public static native int getNumber();

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    System.out.println(System.getProperty("java.library.path"));

    System.out.println("StrLen: " + StrLen.strlen("Hallo Welt?!"));
    
  }
}
