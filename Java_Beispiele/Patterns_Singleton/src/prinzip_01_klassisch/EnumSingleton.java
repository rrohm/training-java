package prinzip_01_klassisch;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public enum EnumSingleton {
  INSTANCE; 
  
  private String singletonDaten = "Daten ...";

  public String getSingletonDaten() {
    return singletonDaten;
  }

  public void setSingletonDaten(String singletonDaten) {
    this.singletonDaten = singletonDaten;
  }
}
