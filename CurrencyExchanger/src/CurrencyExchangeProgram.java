
import java.io.*;

public class CurrencyExchangeProgram {
	private Currencies currencies; // this private instance variable holds an object of class Currencies
	private KeyboardInput keyboardInput; // this private instance variable holds an object of class keyboardInput 
	
	
	public void loadFile(String fileName) {//Retrieves name of file
		String line = null;
		try{
			FileReader open = new FileReader(fileName);
			BufferedReader read = new BufferedReader(open);
			while((line = read.readLine()) != null) {
                String[] parts = line.split(" ");
                String part1 = parts[0];
                String part2 = parts[1];
                System.out.println(part1 + part2);
                
			
			}read.close();}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");    } 
		catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");    }
	}
	
	/**
	 * This instance method is the central method of our program. It sets
	 * up all we need for keyboard input later, and contains the central
	 * loop to which execution returns. It takes no parameters. 
	 */
	
	public void run() {
		
		keyboardInput = new KeyboardInput(); // we will use this object to obtain keyboard input
		while (true) { // endless while-loop
			// display the menu and get the user's choice
			CurrencyExchangeMenu menu = new CurrencyExchangeMenu(); // ...using the 
			int menuChoice = menu.getChoice(keyboardInput);

			// now process
			switch (menuChoice) {
			case 1:
				listCurrencies(); // output a list of all currencies added to the system
				break;
			case 2: 
				addCurrency(); // add a currency to the system
				break;
			case 3:
				showRate(); // show the exchange rate for a given currency
				
				break;
			case 4:
				convertAmount(); // convert an amount between two currencies
				break;
			}
		}
	}
	/**
	 * Asks user to input (string) code and tests whether code is 3 letters long.
	 * This is an instance method.
	 * Invoked by addCurrency() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 * 
	 * @return string if pass if statement, otherwise will return null
	 */
	private String signalThreeLetters(){
		System.out.print("Enter a three letter currency code (e.g., AUD, JPY, USD, EUR): ");
		String userInputCode = keyboardInput.getLine();
		if (userInputCode.length() != 3) {
			System.out.println("\"" + userInputCode + "\" is not a THREE letter code. Returning to menu.");				
			System.out.println();
		    return null;}
		System.out.println();
		return userInputCode;
		}
	
	/**
	 * This private instance method outputs a list of all currencies stored in the
	 * private instance variable currencies. The method takes no parameters. 
	 */
	private void listCurrencies() {
		// Test whether we already have currencies
		if (currencies == null) {
			// No, so complain and return
			System.out.println("There are currently no currencies in the system.");
			System.out.println("Please add at least one currency.");
			System.out.println();
			return;
		}
		// Reset the index into the currencies list
		currencies.reset();
		Currency currency;
		// Output all currencies
		while ((currency = currencies.next()) != null) {
			System.out.println(currency.getCode());			
		}
		System.out.println();
	}
	
	/**
	 * This private instance method adds a currency to the private instance variable currencies. 
	 * The method takes no parameters. 
	 */
	private void addCurrency() {
		String currencyCode = signalThreeLetters();
		if (currencyCode == null){
			return;
		}
        System.out.print("Enter the exchange rate (value of 1 " +currencyCode+ " in NZD): ");
        String exchangeRateStr = keyboardInput.getLine();
        
        double exchangeRate = Double.parseDouble(exchangeRateStr);
        if (exchangeRate <= 0) {
        	System.out.println("Negative exchange rates not permitted. Returning to menu.");
        	System.out.println();
        	return;
        }
        System.out.println();
        if (currencies == null) {
        	currencies = new Currencies();
        }
        currencies.addCurrency(currencyCode, exchangeRate);
        System.out.println("Currency " +currencyCode+ " with exchange rate " + exchangeRate + " added");
        System.out.println();
	}
	/**
	 * Displays exchange rate of chosen currency object
	 * This is an instance method
	 */
	private void showRate() {
		String currencyCode = signalThreeLetters();
		if (currencyCode == null){
			return;
        }
        //needed if-else to check if currencies is null. As currencies.getCurrencyByCode doesn't work if currencies is null
        if (currencies == null){
        	System.out.println("There are currently no currencies in the system.");
        	System.out.println();}
        	
        else{
        Currency currency = currencies.getCurrencyByCode(currencyCode);
        if (currency == null) {
			// No, so complain and return
			System.out.println("\"" + currencyCode + "\" is is not in the system.");
			System.out.println();}
        else {
        System.out.println("Currency " +currencyCode+ " has exchange rate " + currency.getExchangeRate() + ".");
        System.out.println();}
        
        }
        
	}
	/**
	 * Displays the conversion of currency at a chosen amount
	 * This is an instance method
	 */
	private void convertAmount() {
		System.out.println("Select the currency to convert FROM.");
		String currencyCodeFrom = signalThreeLetters();
		if (currencyCodeFrom == null){
			return;
        }
		System.out.println("Select the currency to convert TO.");
		String currencyCodeTo = signalThreeLetters();
		if (currencyCodeTo == null){
			return;
        }
        //needed if-else to check if currencies is null. As currencies.getCurrencyByCode doesn't work if currencies is initially null
		//also if both currencies are not in the system it will say both currencies are not in the system instead of one of them
        if (currencies == null){
        	System.out.println("\"" + currencyCodeFrom +"\" and \""+ currencyCodeTo+ "\" is not on the system. Returning to menu.");
        	return;}
        else {Currency currencyFrom = currencies.getCurrencyByCode(currencyCodeFrom);
        Currency currencyTo = currencies.getCurrencyByCode(currencyCodeTo);
        if (currencyFrom == null & currencyTo == null){
        	System.out.println("\"" + currencyCodeFrom +"\" and \""+ currencyCodeTo+ "\" is not on the system. Returning to menu.");
        	return;}
   
        if (currencyFrom == null) {
        	System.out.println("\"" + currencyCodeFrom + "\" is not on the system. Returning to menu.");
        	return;}
      
        if (currencyTo == null) {
        	System.out.println("\"" + currencyCodeTo + "\" is not on the system. Returning to menu.");
        	return;
        }
        System.out.println();
        System.out.print("How many " + currencyCodeFrom + " would you like to convert to " + currencyCodeTo + "? Amount: ");
        String amountStr = keyboardInput.getLine();
        Amount amount = new Amount(currencyFrom, Double.parseDouble(amountStr));
        System.out.println();
        System.out.printf("%.2f %s = %.2f %s",  amount.getAmount(), amount.getCurrency().getCode(), 
            amount.getAmountIn(currencyTo), currencyTo.getCode());
        System.out.println(); 
        //Next line below(line167) is invokes my overloaded method
        System.out.println(amount.getAmountIn(currencyTo, currencyFrom));
        System.out.println(); 
        
	}
}
}