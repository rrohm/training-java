package schulung.controller;

import schulung.framework.annotations.Autowire;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
public class PausenzeitController {

  /**
   * Auch das geht bei Reflection: Das Feld als final deklarieren,
   * und danach injizieren: 
   */
  @Autowire
  private final PausenzeitenService service;

  public PausenzeitController() {
    this.service = null;
  }


  public Pausenzeit startePause() {
    return this.service.createPause();
  }

}
