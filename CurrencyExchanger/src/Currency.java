
public class Currency {
	private String code;
	private double exchangeRate;
	
	/**
	 * constructor
	 * @param code
	 * @param exchangeRate
	 */
	public Currency(String code, double exchangeRate) {
		this.code = code;
		this.exchangeRate = exchangeRate;
	}
	/**
	 * Provides access to the private instance variable String code.
	 * This is an instance method.
	 * Invoked by getCurrencyByCode() in Currencies.
	 * This method takes no parameters
	 * 
	 * @return the Currency objects String code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Provides access to the private instance variable double exchangeRate.
	 * This is an instance method.
	 * Invoked by showRate() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 * 
	 * @return the Currency objects double exchangeRage
	 */
	public double getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * Gives permission for user to create an exchange rate for new Currency object.
	 * This is an instance method.
	 * This method is presently not invoked by any of the code.
	 * 
	 * @param newExchangeRate: user's input that will be made as the exchange rate
	 */
	public void setExchangeRate(double newExchangeRate) {
		exchangeRate = newExchangeRate;
	}
}
