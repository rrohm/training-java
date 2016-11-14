package movies;

public class Rental {

  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.daysRented = daysRented;
    this.movie = movie;
  }

  public Movie getMovie() {
    return movie;
  }

  public int getDaysRented() {
    return daysRented;
  }
}
