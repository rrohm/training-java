package movies;

public class Rental {

	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie, int daysRented) {
		this.daysRented = daysRented;
		this.movie = movie;
	}
	
	public double getAmount() {
		double thisAmount = 0;
		
		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (daysRented > 2) {
				thisAmount += (daysRented - 2) * 1.5;
			}
			break;

		case Movie.NEW_RELEASE:
			thisAmount += daysRented * 3;
			break;

		case Movie.CHILDREN:
			thisAmount += 1.5;
			if (daysRented > 3) {
				thisAmount += (daysRented - 3) * 1.5;
			}
			break;
		}
		return thisAmount;
	}
	
	
	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 1;

		// bonus for 2-day new release rental
		if ((movie.getPriceCode() == Movie.NEW_RELEASE)
				&& daysRented > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
	
	
	public Movie getMovie() {
		return movie;
	}


	public int getDaysRented() {
		return daysRented;
	}
}
