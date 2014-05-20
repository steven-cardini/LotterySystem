package lotterysystem;

import java.util.Scanner;
import lotterysystem.LanguageHandler.*;

public class ConsoleIOHandler implements IInputOutputHandler {
	
	private Scanner in = new Scanner (System.in);
	private LanguageHandler lang;
	
	public ConsoleIOHandler(LanguageHandler l) {
		this.lang = l;
	}
	

	@Override
	public void printMessage(String text) {
		System.out.println(text);		
	}

	@Override
	public void printWarning(String text) {
		System.out.println(lang.getMessage("warning") +text);
	}

	@Override
	public void printError(String text) {
		System.err.println(text);
	}

	@Override
	public void printSuccess(String text) {
		System.out.println(lang.getMessage("success") +text);
	}

	@Override
	public String scanInput() {
		String input = "";
		if (in.hasNext()) 
			input = in.next();
		return input;		
	}
	
	public MenuSelection getMenuSelection () throws IllegalArgumentException {
		this.printMessage(lang.getMessage("console_main_menu"));
		String input = this.scanInput().toLowerCase();
		
		if (!input.matches("[abhq]")) throw new IllegalArgumentException();
		
		switch (input) {
		case "a":
			return MenuSelection.INPUT_NUMBERS;
		case "b":
			return MenuSelection.DRAW_NUMBERS;
		case "h":
			return MenuSelection.CHANGE_LANGUAGE;
		case "q":
			return MenuSelection.QUIT;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public Language getLanguageSelection () throws IllegalArgumentException {
		this.printMessage(lang.getMessage("console_language_selection"));
		String input = this.scanInput().toLowerCase();
		
		if (!input.matches("[de]")) throw new IllegalArgumentException();
		
		switch (input) {
		case "d":
			return Language.GERMAN;
		case "e":
			return Language.ENGLISH;
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

}
