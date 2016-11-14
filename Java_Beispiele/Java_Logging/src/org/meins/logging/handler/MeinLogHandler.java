/*
 * This code is released under Creative Commons Attribution 4.0 International
 * (CC BY 4.0) license, http://creativecommons.org/licenses/by/4.0/legalcode .
 * That means:
 *
 * You are free to:
 *
 *     Share — copy and redistribute the material in any medium or format
 *     Adapt — remix, transform, and build upon the material
 *              for any purpose, even commercially.
 *
 *     The licensor cannot revoke these freedoms as long as you follow the
 *     license terms.
 *
 * Under the following terms:
 *
 *     Attribution — You must give appropriate credit, provide a link to the
 *     license, and indicate if changes were made. You may do so in any
 *     reasonable manner, but not in any way that suggests the licensor endorses
 *     you or your use.
 *
 * No additional restrictions — You may not apply legal terms or technological
 * measures that legally restrict others from doing anything the license
 * permits.
 */
package org.meins.logging.handler;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Einfache eigene JDK-Log-Handler-Implementierung, illustriert den Einstieg 
 * in die Entwicklung eigener Log-Handler. 
 * 
 * @author robert rohm
 */
public class MeinLogHandler extends Handler {

    /**
     * Dies ist die eigentlich relevante Log-Handler-Methode, hier 
     * findet das Schreiben der Log-Informationen statt - wohin auch immer und
     * womit auch immer. Datenbank, Mail-Session, JMS, JMX, .... Der Fantasie
     * sind da (fast) keine Grenzen gesetzt.
     * 
     * @param record 
     */
    @Override
    public void publish(LogRecord record) {
        System.out.println(record.getMillis() +  " " + record.getMessage());
    }

    @Override
    public void flush() {
        System.out.println("flush()");
    }

    @Override
    public void close() throws SecurityException {
        System.out.println("close()");
    }

}
