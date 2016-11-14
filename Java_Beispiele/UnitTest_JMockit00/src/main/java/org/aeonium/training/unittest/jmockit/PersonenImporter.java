package org.aeonium.training.unittest.jmockit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.aeonium.training.unittest.jmockit.model.Person;


/**
 * Diese Klasse soll Personendaten aus einer CSV-Liste importieren
 * und in eine Liste einfügen. 
 * @author Admin
 *
 */
public class PersonenImporter {
	
	private List<Person> personenListe;

	/**
	 * Mit der Konstruktion muss die Referenz auf das Datenmodell übergeben werden.
	 *  
	 * @param personenListe
	 */
	public PersonenImporter(List<Person> personenListe) {
		this.personenListe = personenListe;
	}

	public void importFromCSV(Path pathToFile) throws IOException {
		Stream<String> lines = Files.lines(pathToFile);
		
		lines.forEach(new Consumer<String>(){

			public void accept(String line) {
				// Felder: | name | vorname |
				String[] feld = line.split(";");
				
				Person person = new Person(feld[0], feld[1]);
				
				personenListe.add(person);
				
			}
		});
	}

	public List<Person> getPersonenListe() {
		return personenListe;
	}

	public void setPersonenListe(List<Person> personenListe) {
		this.personenListe = personenListe;
	}
}
