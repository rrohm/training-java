package movies;

public class Movie {

	public static final int CHILDREN = 2;
	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 0;
	
	private String _title;
	private int _priceCode;
	
	public Movie(String title, int priceCode) {
		this._title = title;
		this._priceCode = priceCode;
	}
	
	public int getPriceCode() {
		return _priceCode;
	}
	public void setPriceCode(int _priceCode) {
		this._priceCode = _priceCode;
	}
	
	public String getTitle() {
		return _title;
	}
	
	
}
