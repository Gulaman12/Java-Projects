
public class CurrencyExchangeMenu {
	/** 
	 *  Displays the Menu of the program.
	 *  This is an instance method.
	 *  Invoked by getInput(KeyboardInput k) in CurrencyExchangeMenu.
	 *  This method takes no parameters.
	 */ 
	private void showMenu() {
		System.out.println("***Welcome to the currency exchange calculator***");
		System.out.println();
		System.out.println("1) List available currencies");
		System.out.println("2) Add a currency");
		System.out.println("3) Show an exchange rate");
		System.out.println("4) Convert an amount");
		System.out.println();
		System.out.print("Enter your choice: ");		
	}
	/**
	 * Calls to user input and converts input to integer.
	 * This is an instance method.
	 * Invoked by getChoice() in CurrencyExchangeMenu.
	 *  
	 * @param k:gets user input from user
	 * @return retrieves the user input
	 */
	private int getInput(KeyboardInput k) {
        String choiceStr = k.getLine();     
        return Integer.parseInt(choiceStr);
	}
	/**
	 * Tests if number is within the range of 1-4 will keep asking for number 1-4 if statement false.
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 * 
	 * @param k: Gets a user input (integer)
	 * @return An integer from 1-4
	 */
	public int getChoice(KeyboardInput k) {
		showMenu();
		int choice = getInput(k);
		while ((choice < 1) || (choice > 4)) {
			System.out.print("Invalid input. Please enter your choice: ");
			choice = getInput(k);
		}
		return choice;		
	}	
}
