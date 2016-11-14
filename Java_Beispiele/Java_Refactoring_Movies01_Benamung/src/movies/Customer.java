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
      double thisAmount = 0;
      Rental each = (Rental) it.next();

      // determine amounts for each line:
      switch (each.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          thisAmount += 2;
          if (each.getDaysRented() > 2) {
            thisAmount += (each.getDaysRented() - 2) * 1.5;
          }
          break;

        case Movie.NEW_RELEASE:
          thisAmount += each.getDaysRented() * 3;
          break;

        case Movie.CHILDREN:
          thisAmount += 1.5;
          if (each.getDaysRented() > 3) {
            thisAmount += (each.getDaysRented() - 3) * 1.5;
          }
          break;
      }

      // frequent renter points:
      frequentRenterPoints++;

      // bonus for 2-day new release rental
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
              && each.getDaysRented() > 1) {
        frequentRenterPoints++;
      }

      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t"
              + String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    // add footer lines
    result += "Total Amount: " + String.valueOf(totalAmount) + "\n";
    result += "Points: " + String.valueOf(frequentRenterPoints) + " frequent renter Points \n";
    return result;
  }
}
