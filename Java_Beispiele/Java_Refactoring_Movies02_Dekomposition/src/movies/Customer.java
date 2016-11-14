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
      double thisAmount = getAmount(rental);

      // frequent renter points:
      frequentRenterPoints = getFrequentRenterPoints(
              frequentRenterPoints, rental);

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

  private int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
    frequentRenterPoints++;

    // bonus for 2-day new release rental
    if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
            && rental.getDaysRented() > 1) {
      frequentRenterPoints++;
    }
    return frequentRenterPoints;
  }

  private double getAmount(Rental each) {
    double thisAmount = 0;

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
    return thisAmount;
  }
}
