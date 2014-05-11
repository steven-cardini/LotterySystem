package lotterysystem;

import java.util.Scanner;

public class ConsoleIOHandler implements IInputOutputHandler {
	
	private Scanner in = new Scanner (System.in);
	
	@Override
	public void printMessage(String text) {
		System.out.println(text);		
	}

	@Override
	public void printWarning(String text) {
		System.out.println("! Warning: " +text);
	}

	@Override
	public void printError(String text) {
		System.err.println(text);
	}

	@Override
	public void printSuccess(String text) {
		System.out.println("Successful: " +text);
	}

	@Override
	public String scanInput() {
		String input = "";
		if (in.hasNext()) 
			input = in.next();
		return input;		
	}

	@Override
	public int[] scanNumbers (int amount, int max, int min) {
		int[] mainNumbers = new int[amount];
		
		for (int i=0; i<amount; i++) {
			String number = this.scanInput();
			
			for (int j=0; j<number.length(); j++) {
				if (!Character.isDigit(number.charAt(j))) {
					this.printError("Only numbers accepted!");
					return null;
				}
			}
						
			int nr = Integer.parseInt(number);
			if (nr>max || nr<min) {
				this.printError("Only numbers between " + min + " and " + max + " accepted!");
				return null;
			}
			
			mainNumbers[i] = nr;
		}
		return mainNumbers;
	}

}
