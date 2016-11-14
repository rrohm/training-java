package movies;

public class PriceCalculatorNewRelease implements PriceCalculatorIF {

  @Override
  public double getAmount(int days) {
    return days * 3;
  }

  @Override
  public int getFrequentRenterPoints(int days) {
    if (days > 1) {
      return 2;
    } else {
      return 1;
    }
  }
}
