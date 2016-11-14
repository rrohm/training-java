/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.jdi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author robert rohm
 * @see http://stackoverflow.com/questions/7834270/how-do-i-obtain-the-pid-of-a-spawned-java-process
 */
public class Bsp02_ListPIDs {

  public static void main(String[] args) throws IOException {
    
    Process p = Runtime.getRuntime().exec("jps -l");
    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    String line = null;

    while ((line = reader.readLine()) != null) {
      String[] javaproc = line.split(" ");

      System.out.println("line: " + line);
      System.out.println("PID : " + Integer.valueOf(javaproc[0]));
    }

  }
}
