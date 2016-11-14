/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meins.threads.basics06_ExceptionHandler;

/**
 *
 * @author Admin
 */
public class ThreadMitExceptionHandler {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception aus Thread!");
                System.out.println("... behandeln.");
            }
        });
        
        thread.start();
    }

}
