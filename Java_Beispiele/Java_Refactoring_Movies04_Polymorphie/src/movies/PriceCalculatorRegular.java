package movies;

public class PriceCalculatorRegular implements PriceCalculatorIF {

  @Override
  public double getAmount(int days) {
    double amount = 2;
    if (days > 2) {
      amount += (days - 2) * 1.5;
    }
    return amount;
  }

  @Override
  public int getFrequentRenterPoints(int days) {

    return 1;
  }

}
