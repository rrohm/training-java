/*
 Dieses Java-Programm beginnt mit einem BLock-Kommentar.
*/

// Zeilenkommentar. Danach folgt ein Javadoc-Kommentar für das Javadoc-Hilfe-Tool 

/**
 * Dies ist die Klasse für die erste Anwendung. In Java kann kein Code außerhalb 
 * einer Klasse ausgeführt werden, daher muss das Programm in eine Klasse "verpackt"
 * werden. 
 * 
 * <p>Mit <code>javac ErsteAnwendung.java</code> kann die Anwendung übersetzt 
 *    werden.</p>
 * <p>Mit <code>java ErsteAnwendung</code> kann die Anwendung gestartet 
 *    werden.</p>
 * <p>Mit <code>javadoc ErsteAnwendung.java</code> kann die Dokumentation zur
 *    Anwendung generiert werden.</p>
 * <p>Mit <code>javap ErsteAnwendung.class</code> kann der Bytecode der Klasse
 *    "dekompiliert", d.h., wieder in den Quelltext zurück übersetzt werden.</p>
 *
 * <p>Javadoc-Kommentare unterstützen HTML-Syntax. Diese muss aber auch valide sein.</p>
 * @author Robert Rohm 
 */
public class ErsteAnwendung {

  /**
   * Der java-Launcher erwartet eine "statische" Methode namens main(), um dort 
   * mit der Ausführung u		nserer Anwendung zu beginnen.
   * @param args Dieser Parameter ist ein String-Array und enthält ggf.
   *        übergebene Start-Argumente von der Kommandozeile	
   */
  public static void main(String[] args) {
    // Anweisung, mit Semikolon abgeschlossen: 	  
    System.out.println("Hallo Welt!"); 
  }
}
