/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_processapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Cf. https://www.x.org/archive/X11R7.6/doc/man/man1/xev.1.xhtml
 * Cf. https://www.x.org/archive/X11R7.6/doc/man/man1/xinput.1.xhtml 
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_ProcessAPI {

  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    // TODO code application logic here
    ProcessBuilder pb = new ProcessBuilder("xinput", "test-xi2", "--root")
            .redirectErrorStream(true);
    
    Process process = pb.start();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    
    String line;
    while ((line = bufferedReader.readLine()) != null) {      
      System.out.println("line: " + line);
    }
  }
  
}
