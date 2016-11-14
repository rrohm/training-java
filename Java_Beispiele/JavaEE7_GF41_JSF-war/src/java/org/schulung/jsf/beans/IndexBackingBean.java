/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.schulung.jsf.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.schulung.ejb.fachlogik.FachlogikBean;

/**
 * "Backing Bean" für die index.xhtml-Seite, d.h. diese Klasse 
 * soll Daten und Interaktionslogik hinter dieser einen Seite bereitstellen
 * 
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class IndexBackingBean {

    /**
     * Stateless Session Bean aus der EJB-Ebene, 
     * kapselt die Geschäftslogik und soll hier durch den EJB-Container 
     * injiziert werden.
     */
    @EJB
    private FachlogikBean fachlogikBean;
    /**
     * Creates a new instance of IndexBackingBean
     */
    public IndexBackingBean() {
    }
    
    public String behandleWeiterClick(){
        // ... Prüfung und Aufruf der Fachlogik.
        // Prüfung der Authorisierung würde hier ggf. beim Aufruf 
        // durch den EJB-Container automatisch durchgeführt.
        List<String> daten = this.fachlogikBean.bereiteDatenVor();
        if (daten.size() == 0) {
            return "keine-daten";
        } else {
            // im Erfolgsfall
            return "weiter";
        }
    }
}
