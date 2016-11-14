
import movies.Customer;
import movies.Movie;
import movies.Rental;

public class Beispiel {

  /**
   * @param args
   */
  public static void main(String[] args) {
		// TODO Auto-generated method stub

    Movie movie01 = new Movie("Hallo Welt", Movie.NEW_RELEASE);
    Movie movie02 = new Movie("Sesamstrasse", Movie.CHILDREN);
    Movie movie03 = new Movie("Krieg und Frieden", Movie.REGULAR);

    Customer kunde01 = new Customer("Max Mustermann");

    kunde01.addRental(new Rental(movie01, 1));
    kunde01.addRental(new Rental(movie02, 4));
    kunde01.addRental(new Rental(movie03, 3));

    System.out.print(kunde01.statement());
  }

}
