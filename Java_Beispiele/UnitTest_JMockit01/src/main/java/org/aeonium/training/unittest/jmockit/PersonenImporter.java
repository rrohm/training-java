package org.aeonium.training.unittest.jmockit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.aeonium.training.unittest.jmockit.model.Person;

/**
 * Diese Klasse soll Personendaten aus einer CSV-Liste importieren und in eine
 * Liste einfügen.
 *
 * @author Admin
 *
 */
public class PersonenImporter {

  private WebTarget path;

  /**
   * The importer works with a JAX-RS REST target and should send each person
   * object to the REST service. In real-life scenarios, this should get
   * optimized so that the importer does not call the service for each record.
   *
   * @param path
   */
  PersonenImporter(WebTarget path) {
    this.path = path;
  }

  public void importFromCSV(Path pathToFile) throws IOException {
    Stream<String> lines = Files.lines(pathToFile);

    lines.forEach((String line) -> {
      // Fields: | name | vorname |
      String[] field = line.split(";");
      
//      Person person = new Person("Mustermann", "M.");
      Person person = new Person(field[0], field[1]);
      
      path.request(MediaType.APPLICATION_JSON).put(Entity.entity(person, MediaType.APPLICATION_JSON));
    });
  }
}
