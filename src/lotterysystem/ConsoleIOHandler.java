package lotterysystem;

import java.util.ListResourceBundle;
import java.util.Scanner;

public class ConsoleIOHandler implements IInputOutputHandler {
	
	private Scanner in = new Scanner (System.in);
	private ListResourceBundle textResources = new TextResourcesEN();
	

	@Override
	public void printMessage(String text) {
		System.out.println(text);		
	}

	@Override
	public void printWarning(String text) {
		System.out.println(textResources.getString("warning") +text);
	}

	@Override
	public void printError(String text) {
		System.err.println(text);
	}

	@Override
	public void printSuccess(String text) {
		System.out.println(textResources.getString("success") +text);
	}

	@Override
	public String scanInput() {
		String input = "";
		if (in.hasNext()) 
			input = in.next();
		return input;		
	}
	
	public menuSelection getMenuSelection () throws IllegalArgumentException {
		this.printMessage(textResources.getString("console_main_menu"));
		String input = this.scanInput().toLowerCase();
		
		if (!input.matches("[abhq]")) throw new IllegalArgumentException();
		
		switch (input) {
		case "a":
			return menuSelection.INPUT_NUMBERS;
		case "b":
			return menuSelection.DRAW_NUMBERS;
		case "h":
			return menuSelection.CHANGE_LANGUAGE;
		case "q":
			return menuSelection.QUIT;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public language getLanguageSelection () throws IllegalArgumentException {
		this.printMessage(textResources.getString("console_language_selection"));
		String input = this.scanInput().toLowerCase();
		
		if (!input.matches("[de]")) throw new IllegalArgumentException();
		
		switch (input) {
		case "d":
			return language.GERMAN;
		case "e":
			return language.ENGLISH;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int[] getNumbers (int amount, int max, int min) {
		int[] mainNumbers = new int[amount];
		
		for (int i=0; i<amount; i++) {
			String number = this.scanInput();
			
			for (int j=0; j<number.length(); j++) {
				if (!Character.isDigit(number.charAt(j))) {
					throw new IllegalArgumentException();
				}
			}
						
			int nr = Integer.parseInt(number);
			if (nr>max || nr<min) {
				throw new NumberOutOfRangeException();
			}
			
			mainNumbers[i] = nr;
		}
		return mainNumbers;
	}
	
	public void switchTextResources (IInputOutputHandler.language lang) {
		switch (lang) {
		case ENGLISH:
			this.textResources = new TextResourcesEN();
			break;
		case GERMAN:
			this.textResources = new TextResourcesDE();
			break;
		}
	}

}
