
public class Currencies {
	private int currencyIndex;
	private Currency[] currencies;
	/**
	 * Creates a new Currencies object.
	 * This is an instance method.
	 * Invoked by addCurrency() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 */
	public Currencies() {
		currencies = null;
		currencyIndex = 0;
	}
	/**
	 * Puts added currency object into the array.
	 * This is an instance method.
	 * Invoked by addCurrency(String code, double exchangeRate) in Currencies.
	 * 
	 * @param newCurrency: The created currency object
	 */
	public void addCurrency(Currency newCurrency) {
		//needed to invoke the next method so that the next new currency would be stored in the index after previous currency
		//problem would replace old currency with the new currency
		if (currencies == null) {
			currencies = new Currency[1];
			currencies[0] = newCurrency;
		}
		else
		{
			Currency[] tmpCurrencies = new Currency[currencies.length + 1];
			for (int i=0; i < currencies.length; i++) {
				tmpCurrencies[i] = currencies[i];
			}
			tmpCurrencies[currencies.length] = newCurrency;
			currencies = tmpCurrencies;
			next();
		}
	}
	/**
	 * Will invoke constructor in Currency class to create new Currency object, then invokes the other addCurrency method in this class
	 * This is an instance method.
	 * Invoked by addCurrency() in CurrencyExchangeProgram.
	 * 
	 * @param code: the string data used to give constructor the currency code for the new Currency object
	 * @param exchangeRate: the double data used to give constructor the exchange rate for the new Currency object
	 */
	public void addCurrency(String code, double exchangeRate) {
		Currency newCurrency = new Currency(code,exchangeRate);
		addCurrency(newCurrency);
	}	
	/**
	 * To provide access to test/retrieve if selected code is in the private instance variable Currency[] currencies.
	 * This is an instance method.
	 * Invoked by showRate() in CurrencyExchangeProgram.
	 * 
	 * @param code: The currency code used to test if code is in array or not
	 * @return will return the currency code object if found in array, else will return null
	 */
	public Currency getCurrencyByCode(String code) {
		//needed to not make currencies.length not add 1 because it would make the currency array out of bounds
		//problem: had an array out of bounds error
		if (currencies == null){
			return null;
		}
		else{
			for (int i=0; i < currencies.length; i++) {
				if (currencies[i].getCode().equals(code)) return currencies[i];}
			
			}return null;
	}
	/**
	 * Retrieved code will find Currency obejct then delete it if in the array.
	 * This is an instance method.
	 * This method is presently not invoked by any of the code.
	 * 
	 * @param code: The currency code used to test if code is in array or not
	 */
	public void deleteCurrencyByCode(String code) {
		if (currencies == null) return;
		for (int i=0; i < currencies.length; i++) {
			if (currencies[i].getCode().equals(code)) {
				if (currencies.length == 1) {
					currencies = null;
					return;
				}
				else
				{
					Currency[] tmpCurrencies = new Currency[currencies.length-1];
					for (int j=0; j<i; j++) {
						tmpCurrencies[j] = currencies[j];
					}
					for (int j=i; j<tmpCurrencies.length; j++) {
						tmpCurrencies[j] = currencies[j+1];
					}
					currencies = tmpCurrencies;
				}
			}
		}
	}
	/**
	 * To reset currencyIndex count back to 0.
	 * This is an instance method.
	 * Invoked by listCurrencies() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 */
	public void reset() {
		currencyIndex = 0;
	}
	/**
	 * To go to next Currency object in the array.
	 * This is an instance method.
	 * Invoked by listCurrencies() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 * 
	 * @return returns the next Currency object in the array, if no more will return null
	 */
	public Currency next() {
		if (currencyIndex == currencies.length) return null;
		Currency c = currencies[currencyIndex];
		currencyIndex++;
		return c;
	}
	
}
