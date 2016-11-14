package org.meins.java8.collectionsStreams;

/**
 * Einfache Datenklasse. 
 * 
 * @author Admin
 */
public class Kunde {

    private String nr;
    private String name;

    public Kunde() {
    }

    public Kunde(String nr, String name) {
        this.nr = nr;
        this.name = name;
    }

    @Override
    public String toString() {        
        return new StringBuilder(this.nr).append(" ").append(this.name).toString();
    }
    
    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
