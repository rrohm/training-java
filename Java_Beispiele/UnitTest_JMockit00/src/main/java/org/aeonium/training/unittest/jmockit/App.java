package org.aeonium.training.unittest.jmockit;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.aeonium.training.unittest.jmockit.model.Person;

/**
 * A simple application that reads person records from a CSV file, needs to be
 * invoided from command line with the path to the file as single argument.
 * <p>
 * (Currently still German naming and comments, will be changed soon :-)
 */
public class App {

  /**
   * Startmethode der Anwendung - hier wird die Anwendungsstruktur aufgebaut und
   * die nötigen Referenzen zugewiesen.
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("PersonenImporter startet!");

    // Die Liste stellt einen wesentlichen Teil des Datenmodells dar
    List<Person> personenListe = new ArrayList<>();

    // Der Importer erhält die Referenz auf das Datenmodell: 
    PersonenImporter importer = new PersonenImporter(personenListe);

    // Zugriff auf die Kommandozeilenparameter
    if (args.length > 0) {
      try {
        importer.importFromCSV(Paths.get(args[0]));

        System.out.println("Personen importiert: " + personenListe.size());

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.err.println("Fehler, Personenliste kann nicht importiert werden: " + args[0]);
      }
    }
  }
}
