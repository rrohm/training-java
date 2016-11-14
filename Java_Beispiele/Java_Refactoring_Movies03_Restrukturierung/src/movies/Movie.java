package movies;

public class Movie {

	public static final int CHILDREN = 2;
	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 0;
	
	private String title;
	private int priceCode;
	
	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}
	
	
	public int getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(int _priceCode) {
		this.priceCode = _priceCode;
	}
	
	public String getTitle() {
		return title;
	}
	
	
}
