package movies;

public class Rental {

  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.daysRented = daysRented;
    this.movie = movie;
  }

  public double getAmount() {

    return movie.getPriceCalculator().getAmount(daysRented);
  }

  public int getFrequentRenterPoints() {
    return movie.getPriceCalculator().getFrequentRenterPoints(daysRented);
  }

  public Movie getMovie() {
    return movie;
  }

  public int getDaysRented() {
    return daysRented;
  }
}
