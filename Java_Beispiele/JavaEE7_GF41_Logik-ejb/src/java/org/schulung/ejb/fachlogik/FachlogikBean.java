/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.schulung.ejb.fachlogik;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 * Diese Klasse ("Enterprise Java Bean") kapselt die GEschäftslogik, 
 * und nimmt ggf. auch Prüfung der Authorisierung vor. 
 * 
 * @author Admin
 */
@Stateless
@LocalBean
//@RolesAllowed(value = "fachberechsnutzer") // hier auskommentiert, würde Authentifizierung erfordern!
public class FachlogikBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<String> bereiteDatenVor() {
        List<String> liste = new ArrayList<>();
        liste.add("Erster");
        liste.add("Zweiter");
        
        return liste;
    }
}
