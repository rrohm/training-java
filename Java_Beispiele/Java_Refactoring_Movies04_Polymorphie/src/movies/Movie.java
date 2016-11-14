package movies;

public class Movie {

  public static final int CHILDREN = 2;
  public static final int REGULAR = 1;
  public static final int NEW_RELEASE = 0;

  private String title;

  private PriceCalculatorIF priceCalculator;

  public Movie(String title, int priceCode) {
    this.title = title;

    switch (priceCode) {
      case Movie.REGULAR:
        priceCalculator = new PriceCalculatorRegular();
        break;

      case Movie.NEW_RELEASE:
        priceCalculator = new PriceCalculatorNewRelease();
        break;

      case Movie.CHILDREN:
        priceCalculator = new PriceCalculatorChildren();
        break;
    }
  }

  public String getTitle() {
    return title;
  }

  public PriceCalculatorIF getPriceCalculator() {
    return priceCalculator;
  }

  public void setPriceCalculator(PriceCalculatorIF priceCalculator) {
    this.priceCalculator = priceCalculator;
  }
}
