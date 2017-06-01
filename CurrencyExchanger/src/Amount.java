
public class Amount {
	private Currency currency;
	private double amount;
	
	/**
	 * Creates a new Amount object.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * 
	 * @param currency: gives the Amount object a currency. 
	 * @param amount: gives the amount currency is to be converted to
	 */
	public Amount(Currency currency, double amount) {
		this.setCurrency(currency);
		this.setAmount(amount);
	}
	/**
	 * Provides access to the private instance variable Currency currency.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 * 
	 * @return the Amount objects Currency currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * Gives permission for constructor to set a currency for the new Amount object.
	 * This is an instance method.
	 * Invoked by Amount(Currency,double) in Amount.
	 * 
	 * @param currency: user's input that will be made as the exchange rate
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	/**
	 * Provides access to the private instance variable double amount.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 * 
	 * @return the Amount objects Currency currency
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * Gives permission for constructor to set the amount to convert for the new Amount object.
	 * This is an instance method.
	 * Invoked by Amount(Currency,double) in Amount.
	 * 
	 * @param amount: user's input that will be made as the exchange rate
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * Returns a string which states that the conversion of dollars between the Currency objects was successful.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * 
	 * @param otherCurrency: the Currency object that it will be converted to (currencyTo)
	 * @param currency: the Currency object that is being converted (currencyFrom)
	 * @return the string telling user it has been successfully converted the dollars, when retrieved it is then printed
	 */
	public String getAmountIn(Currency otherCurrency,Currency currency){
		String convert = new Double(amount * currency.getExchangeRate() / otherCurrency.getExchangeRate()).toString();
		String currencyName = currency.getCode();
		String currencyNameTwo = otherCurrency.getCode();
		return currencyName +"'s successfully converted to "+ convert +" " + currencyNameTwo +"'s";
	}
	/**
	 * Returns a double which is the amount of Currency converted.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * 
	 * @param otherCurrency: the Currency object that it will be converted to (currencyTo)
	 * @return the double representing the amount of dollars it has converted from Currency object
	 */
	public double getAmountIn(Currency otherCurrency) {
		return amount * currency.getExchangeRate() / otherCurrency.getExchangeRate();
	}

}
