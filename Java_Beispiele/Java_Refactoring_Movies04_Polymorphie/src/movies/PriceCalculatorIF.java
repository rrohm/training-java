package movies;

public interface PriceCalculatorIF {

  double getAmount(int days);

  int getFrequentRenterPoints(int days);
}
