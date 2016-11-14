/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto02_aeswithsecurepwd;

import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author robert
 * @see
 * http://stackoverflow.com/questions/992019/java-256-bit-aes-password-based-encryption
 */
public class Crypto02_AESwithSecurePwd {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {

    char[] password = "top secret".toCharArray();
    byte[] salt = "irgendwas".getBytes();

    /* Derive the key, given password and salt.  */
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
    SecretKey tmp = factory.generateSecret(spec);
    SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

    /* Encrypt the message. */
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secret);
    AlgorithmParameters params = cipher.getParameters();
    byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
    byte[] ciphertext = cipher.doFinal("Hello, World!".getBytes("UTF-8"));

    System.out.println("Verschlüsselte Daten: ");
    System.out.println(bytesToHexString(ciphertext));


    System.out.println("Entschlüsselte Daten: ");
    /* Decrypt the message, given derived key and initialization vector. */
    Cipher decodeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    decodeCipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
    String plaintext = new String(decodeCipher.doFinal(ciphertext), "UTF-8");
    System.out.println(plaintext);
  }

  private static void printBytes(byte[] data) {
    for (byte b : data) {
      System.out.println(b);
    }
  }

  private static String bytesToString(byte[] data) {
    StringBuilder sb = new StringBuilder();
    for (byte b : data) {
      sb.append(b);
    }
    return sb.toString();
  }

  private static String bytesToHexString(byte[] data) {
    StringBuilder sb = new StringBuilder();
    for (byte b : data) {
      sb.append(String.format("%02X", b));
    }
    return sb.toString();
  }
}
