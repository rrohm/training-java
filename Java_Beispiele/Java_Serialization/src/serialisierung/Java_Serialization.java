
package serialisierung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import serialisierung.datenklassen.Benutzer;
import serialisierung.datenklassen.BenutzerSicher;
import serialisierung.datenklassen.Person;

/**
 * Dieses Beispiel illustriert die Serialisierung, d.h.: die Speicherung von
 * Objekten binärer Form. Anschließend werden diese Objekte wieder
 * deserialisiert, d.h..: in binärer Form ein gelesen und wieder in Java-Objekte
 * im Arbeitsspeicher zurückverwandelt.
 *
 * <p>Besonders zu beachten ist hierbei, dass alle zu serialisierenden Objekte
 * das Interface Serializable implementieren müssen. Damit sind primitive
 * Eigenschaften und String-Eigenschaften ebenso wie Enum-Typen automatisch
 * serialisierbar. Für komplexe Typen gelten dieselben Regeln: Sie müssen
 * ihrerseits serialisierbar sein dürfen nur serialisierbare Typen für ihre
 * Eigenschaften verwenden.
 * </p>
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class Java_Serialization {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

    Person          p1 = new Person("Mustermann", "Max");
    Benutzer        b1 = new Benutzer("geheim", "Lyse", "Anna");
    BenutzerSicher  bs1 = new BenutzerSicher("wirklich geheim", "Lauter", "Leo");

    System.out.println("p1:  " + p1);
    System.out.println("b1:  " + b1);
    System.out.println("bs1: " + bs1);

    FileOutputStream f = new FileOutputStream("p1.data");
    ObjectOutput s = new ObjectOutputStream(f);
    s.writeObject(p1);
    s.flush();
    s.close();
    f.close();

    f = new FileOutputStream("b1.data");
    s = new ObjectOutputStream(f);
    s.writeObject(b1);
    s.flush();
    s.close();
    f.close();

    f = new FileOutputStream("bs1.data");
    s = new ObjectOutputStream(f);
    s.writeObject(bs1);
    s.flush();
    s.close();
    f.close();

    // Lesezugriff
    FileInputStream in = new FileInputStream("p1.data");
    ObjectInputStream is = new ObjectInputStream(in);
    Person p2 = (Person) is.readObject();
    is.close();
    in.close();

    in = new FileInputStream("b1.data");
    is = new ObjectInputStream(in);
    Benutzer b2 = (Benutzer) is.readObject();
    is.close();
    in.close();

    in = new FileInputStream("bs1.data");
    is = new ObjectInputStream(in);
    BenutzerSicher bs2 = (BenutzerSicher) is.readObject();
    is.close();
    in.close();

    System.out.println(p2);
    System.out.println(b2);
    System.out.println(bs2);

  }

}
