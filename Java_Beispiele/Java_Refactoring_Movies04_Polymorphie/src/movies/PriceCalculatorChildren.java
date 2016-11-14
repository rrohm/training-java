package movies;

public class PriceCalculatorChildren implements PriceCalculatorIF {

  @Override
  public double getAmount(int days) {
    double amount = 1.5;
    if (days > 3) {
      amount += (days - 3) * 1.5;
    }
    return amount;
  }

  @Override
  public int getFrequentRenterPoints(int days) {

    return 1;
  }

}
