/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.concurrency.utils.synchronizers.countdownlatch_01;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CountDownLatchSimpleSzenarioExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Anwendung startet.");
        
        // Hier im Hauptthread soll Arbeit nebenläufig ausgeführt werden,
        // der Hauptthread soll warten, bis dieser Thread fertig ist.
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        
        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    // Schwere Arbeit ...
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                } finally {
                    // WICHTIG! Das Latch muss *in jedem Fall* auf 0 runtergezählt
                    // werden, sonst wartet die Anwendung ewig ...
                    countDownLatch.countDown();
                }
                    
                System.out.println("Thread fertig.");
            }
        });
        
        thread.start();
        // hier soll gewartet werden, bis der zusätzliche Thread auch fertig ist!
        // Daher wird hier gewartet, bis das Latch auf 0 runtergezählt worden ist.
        // Erst dann wird nach dem .await()-Aufruf weitergemacht. 
        countDownLatch.await();
        
        System.out.println("Anwendung fertig.");
    }
}
