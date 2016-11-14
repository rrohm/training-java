package prinzip_02_enum;

/**
 * Joshua BLoch ("Effective Java"):
 *
 * "This approach is functionally equivalent to the public field approach,
 * except that it is more concise, provides the serialization machinery for
 * free, and provides an ironclad guarantee against multiple instantiation, even
 * in the face of sophisticated serialization or reflection attacks. While this
 * approach has yet to be widely adopted, a single-element enum type is the best
 * way to implement a singleton. "
 *
 *
 * See also
 * http://www.drdobbs.com/jvm/creating-and-destroying-java-objects-par/208403883?pgno=3
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public enum EnumSingleton {

  /**
   * Enum-Wert für die Singleton-Instanz
   */
  INSTANCE;

  
  // Ab hier: Erweiterter Enum, definiert die Eigenschaften/Methoden der Instanz

  private String singletonDaten = "Daten ...";

  public String getSingletonDaten() {
    return singletonDaten;
  }

  public void setSingletonDaten(String singletonDaten) {
    this.singletonDaten = singletonDaten;
  }
}
