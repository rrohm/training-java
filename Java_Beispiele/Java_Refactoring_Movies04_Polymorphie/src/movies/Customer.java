package movies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {

    double totalAmount = 0;
    int frequentRenterPoints = 0;

    String result = "Rental Record for " + getName() + "\n";

    Iterator<Rental> it = rentals.iterator();
    while (it.hasNext()) {
      Rental rental = (Rental) it.next();

      // determine amounts for each line:
      double thisAmount = rental.getAmount();

      // frequent renter points:
      frequentRenterPoints += rental.getFrequentRenterPoints();

      // show figures for this rental
      result = getStatementPerRental(result, rental, thisAmount);

      totalAmount += thisAmount;
    }

    // add footer lines
    result += "Total Amount: " + String.valueOf(totalAmount) + "\n";
    result += "Points: " + String.valueOf(frequentRenterPoints) + " frequent renter Points \n";
    return result;
  }

  private String getStatementPerRental(String result, Rental rental,
          double thisAmount) {
    // Hier auch Perf.-Optimierung:
    StringBuilder sb = new StringBuilder(result);
    sb.append("\t");
    sb.append(rental.getMovie().getTitle());
    sb.append("\t");
    sb.append(String.valueOf(thisAmount));
    sb.append("\n");
    return sb.toString();
  }

}
