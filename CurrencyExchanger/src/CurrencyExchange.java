
public class CurrencyExchange {

	/**
	 * This program implements a currency converter for multiple currencies. 
	 * The following class method is the main entry point. It instantiates
	 * an object of class CurrencyExchangeProgram and invokes the run() method
	 * on that object.
	 * 
	 * @param args	Command line parameters (not used)
	 */
	public static void main(String[] args) {
   		CurrencyExchangeProgram myCurrencyExchange = new CurrencyExchangeProgram();
   		String hi = "/Users/angelojterminez/Documents/workspace/Assignment1-ater906/bin/forex.txt";
   		myCurrencyExchange.loadFile(hi);
   		myCurrencyExchange.run();
	}

}
