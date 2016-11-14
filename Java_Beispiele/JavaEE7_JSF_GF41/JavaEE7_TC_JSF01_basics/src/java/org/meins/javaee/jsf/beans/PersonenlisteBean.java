/*
 *  This code is released under Creative Commons Attribution 4.0 International
 *  (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 *  That means:
 * 
 *  You are free to:
 * 
 *      Share — copy and redistribute the material in any medium or format
 *      Adapt — remix, transform, and build upon the material
 *               for any purpose, even commercially.
 * 
 *      The licensor cannot revoke these freedoms as long as you follow the
 *      license terms.
 * 
 *  Under the following terms:
 * 
 *      Attribution — You must give appropriate credit, provide a link to the
 *      license, and indicate if changes were made. You may do so in any
 *      reasonable manner, but not in any way that suggests the licensor endorses
 *      you or your use.
 * 
 *  No additional restrictions — You may not apply legal terms or technological
 *  measures that legally restrict others from doing anything the license
 *  permits.
 * 
 *
 *  2015 Aeonium Software Systems, Robert Rohm.
 */
package org.meins.javaee.jsf.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.meins.javaee.jsf.Converter.PersonConverter;

/**
 *
 * @author Robert Rohm&lt;r.rohm@aeonium-systems.de&gt;
 */
@ManagedBean
@SessionScoped
public class PersonenlisteBean {
  
  private List<PersonBean> personenListe = new ArrayList<>();
  
  private PersonConverter converter;

  public List<PersonBean> getPersonenListe() {
    return personenListe;
  }

  public void setPersonenListe(List<PersonBean> personenListe) {
    this.personenListe = personenListe;
  }

  /**
   * Creates a new instance of PersonenlisteBean
   */
  public PersonenlisteBean() {
    this.personenListe.add(new PersonBean("Martin", "Mustermann"));
    this.personenListe.add(new PersonBean("Anna","Lyse"));
    this.personenListe.add(new PersonBean("Max", "Ernst"));
    
    this.converter = new PersonConverter(this.personenListe);
  }

  public PersonConverter getConverter() {
    return converter;
  }
  
}
