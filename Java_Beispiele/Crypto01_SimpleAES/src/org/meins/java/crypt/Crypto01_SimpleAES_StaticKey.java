/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.java.crypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
 * Dieses Beispiel illustriert das grundsätzliche Vorgehen in der Arbeit mit 
 * der Crypto-API.
 * 
 * @author robert rohm
 */
public class Crypto01_SimpleAES_StaticKey {
  public static final String BSP_01 = "Das ist der erste wichtige Text. Wie lange ist der Text aktuell? "
                                + "Und wie lange wird er sein, wenn er verschlüsselt ist? ";
  public static final String BSP_02 = "Das ist der kurze wichtige Text. ";
  public static final String BSP_03 = "Das ist der erste wichtige Text. Wie lange ist der Text aktuell? "
          + "Und wie lange wird er sein, wenn er verschlüsselt ist? Vor allem, "
          + "wenn er etwas länger ist. In der praxis zeigt sich, dass der Text"
          + "je gewähltem Algorithmus und gewählter Speichermethode verschlüsselt"
          + "wesentlich mehr Speicher beanspruchen kann. ";

  private static String keyString = "ACED00057372001F6A617661782E63727970746F2E737065632E5365637265744B6579537065635B470B66E230614D0200024C0009616C676F726974686D7400124C6A6176612F6C616E672F537472696E673B5B00036B65797400025B427870740003414553757200025B42ACF317F8060854E0020000787000000010F3BD2238E871E798105248F427AD891F";

  public static final String CRYPT_ALGORITHM = "AES";

  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException {

    // Test for maximum key length
    System.out.println("Get maximum key length: ");

    int maxAllowedKeyLength = Cipher.getMaxAllowedKeyLength(CRYPT_ALGORITHM);

    System.out.println(" Max. key lengh: " + maxAllowedKeyLength);

    KeyGenerator generator = KeyGenerator.getInstance(CRYPT_ALGORITHM);
    generator.init(maxAllowedKeyLength);

    System.out.println("\nGenerate key: ");
    SecretKey key = generator.generateKey();
//    System.out.println("  key: " + key.serialVersionUID);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(key);
    oos.flush();
    byte[] bytes = bos.toByteArray();
    System.out.println("bytes: " + bytes);
    System.out.println("bytes: " + bytesToHexString(bytes));
    
    // Deserialisieren eines gespeicherten Schlüssels (ACHTUNG!!! RisiKO!!!)
    byte[] parsedHexBinary = DatatypeConverter.parseHexBinary(keyString);
    ByteArrayInputStream bais = new ByteArrayInputStream(parsedHexBinary);
    ObjectInputStream ois = new ObjectInputStream(bais);
    key = (SecretKey) ois.readObject();

    System.out.println("  key: " + key.toString());
    System.out.println("  key: " + key.getFormat());
    System.out.println("  key: " + key.getAlgorithm());

    byte[] keyBytes = key.getEncoded();
    System.out.println("  bytes: " + bytesToString(keyBytes));
    System.out.println("  bytes: " + bytesToHexString(keyBytes));

    Cipher cipher = Cipher.getInstance(CRYPT_ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, key);


    String data = BSP_03;

    //
    System.out.println("Eingangsdaten: ");
    System.out.println("  Länge unverschlüsselt: " + data.length());
    System.out.println("  Länge verschlüsselt  : " + cipher.getOutputSize(data.length()));
    System.out.println("  Blockgröße           : " + cipher.getBlockSize());
    System.out.println(data);

    System.out.println("Verschlüsselte Daten: ");
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
    cipherOutputStream.write(data.getBytes());
    cipherOutputStream.flush();
    cipherOutputStream.close();

    byte[] encryptedData = outputStream.toByteArray();
    System.out.println("  Länge verschlüsselt    : " + cipher.getOutputSize(encryptedData.length));
    System.out.println("  Länge verschlüsselt/hex: " + cipher.getOutputSize(bytesToHexString(encryptedData).length()));

    System.out.println(bytesToString(encryptedData));
    System.out.println("\n");
    System.out.println(bytesToHexString(encryptedData));

    System.out.println("\nDekoderierung");
    Cipher decodeCipher = Cipher.getInstance(CRYPT_ALGORITHM);
    decodeCipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decodedData = decodeCipher.doFinal(encryptedData);
    String decodedText = new String(decodedData, "UTF-8");
    System.out.println(decodedText);
  }

  private static void printBytes(byte[] data){
    for (byte b : data) {
      System.out.println(b);
    }
  }

  private static String bytesToString(byte[] data){
    StringBuilder sb = new StringBuilder();
    for (byte b : data) {
      sb.append(b);
    }
    return sb.toString();
  }
  private static String bytesToHexString(byte[] data){
    StringBuilder sb = new StringBuilder();
    for (byte b : data) {
      sb.append(String.format("%02X", b));
    }
    return sb.toString();
  }
}
