package org.meins.java.crypto;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Illustratives Beispiel: Erzeugung von Hash-Werten von Dateien.
 * 
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class MD5FromFile {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException, NoSuchAlgorithmException, Exception {
    if (args.length == 0) {
      System.out.println("USAGE: java org.meins.java.crypto.MD5FromFile FILE");
      return;
    }

    MessageDigest md = MessageDigest.getInstance("MD5");

    // read bytes one by one - ineffective!
//    try (InputStream is = Files.newInputStream(Paths.get(args[0]))) {
//      DigestInputStream dis = new DigestInputStream(is, md);
//      
//      /* Read stream to EOF as normal... */
//      int b;
//      int v = 0;
//      while ((b = dis.read()) > -1) {
//        v++;
//      }
//      System.out.println(v + " bytes read.");
//    }
//    
    // tremendously faster: 
    try (InputStream is = Files.newInputStream(Paths.get(args[0]))) {
      DigestInputStream dis = new DigestInputStream(is, md);

      byte[] buffer = new byte[1024 * 32];

      /* Read stream to EOF as normal... */
      int numRead;
      int v = 0;

      do {
        numRead = dis.read(buffer);
        if (numRead > -1) {
          v += numRead;
        }
      } while (numRead != -1);

      System.out.println(v + " bytes read.");
    }

    byte[] digest = md.digest();

    for (byte e : digest) {
      System.out.print(e);
      System.out.print(" ");
    }
    System.out.println("");
    System.out.println(getHexString(digest));
  }

 
  public static String getHexString(byte[] b) throws Exception {
    String result = "";
    for (int i = 0; i < b.length; i++) {
      result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
    }
    return result;
  }
}
