/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.threads.basics07_ThreadsBeenden;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Dieses Beispiel illustriert das korrekte Beenden eines selbst erzeugten
 * Threads.
 *
 * @author R. Rohm
 */
public class ThreadsBeenden {
// Innere Klasse ist hier static, weil sie aus statischem Kontext heraus aufgerufen wird.

    static class MeinRunnable implements Runnable {

        private int counter = 0;

        /**
         * Nebenläufig auszuführender Code wird in der run()-Methode
         * implementiert.
         */
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " counter: " + counter++);
                // Beispiel: hier soll der Thread gebremst werden
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    // Standard-Behandlung: Dieser Fall tritt nur ein, wenn der 
                    // Thread von außen Aufforderung zum Beenden bekommen hat.
                    // Er wird jedoch nur zunächst aufgeweckt, die Interrupt-Flag-
                    // Änderung erfolgt jedoch nicht mehr - und muss deshalb 
                    // explizit nachgeholt werden.
                    Thread.currentThread().interrupt();
                }
            }
            // Hier folgt z.B. Aufräum-Arbeit vor Verlassen des Runnables.
            System.out.println("Werde Arbeit beenden!");
            // Bei Verlassen der run()-Methode terminiert der Thread.
        }
    }

    public static void main(String[] args) {

        final Thread thread = new Thread(new MeinRunnable());
        thread.start();
        
        // Aktuellen Thread kurz anhalte
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            // Wann kann das passiert sein?
            // ... wenn der Thread wie hier z.B. schläft und währenddessen 
            // auf interrupt() hätte reagieren sollen.
            Logger.getLogger(ThreadsBeenden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Nach der Wartezeit: eigenen Thread stoppen
        thread.interrupt();
        
        System.out.println("Anwendung beendet.");
    }
}
