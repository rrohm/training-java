package org.meins.classloading;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class KlasseLaden {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    // Klasse muss in C:\org\meins\classloading\ kopieren
    newInstance("/", "org.meins.classloading.Klasse");
    // wenn newInstance mehrmals aufgerufen wird:
    newInstance("/", "org.meins.classloading.Klasse");
  }

  private static Object newInstance(String path, String classname)
          throws Exception {
    // 1.: URL für "Binär"-Namen des Klassenpfads
    URL url = new File(path).toURI().toURL();
    // 2.: Neue ClassLoader-Instanz
    URLClassLoader cl = new URLClassLoader(new URL[]{url});
    // 3.: Klasse laden und initialisieren
    Class<?> c = cl.loadClass(classname);
    // 4.: Objekt von dieser Klasse instanzieren
    return c.newInstance();
  }
}
