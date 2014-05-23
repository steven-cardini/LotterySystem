package lotterysystem;

import java.util.Date;

public class TicketAnalyzer {
	private int[] winningMainNumbers;
	private int[] winningStarNumbers;
	private String winningSuperStar;
	
	public TicketAnalyzer (int[] winningMainNumbers, int[] winningStarNumbers, String winningSuperStar, Date drawingDate) {
		this.winningMainNumbers = winningMainNumbers;
		this.winningStarNumbers = winningStarNumbers;
		this.winningSuperStar = winningSuperStar;
	}
	
	public int getAmountMatchingMainNumbers (int[] mainNumbers) {
		return countIdenticals(this.winningMainNumbers, mainNumbers);
	}
	
	public int getAmountMatchingStarNumbers (int[] starNumbers) {
		 return countIdenticals(this.winningStarNumbers, starNumbers);
	}
	
	public int getAmountMatchingSuperStar (String superStar) {
		return countIdenticals(winningSuperStar, superStar);
	}
	
	private static int countIdenticals(int[] winningNumbers, int[] numberArray) {
		int numberOfIdenticals=0;
		for (int i=0; i<numberArray.length; i++) {
			for (int k=0; k<winningNumbers.length; k++) {
				if (numberArray[i] == winningNumbers[k]) {
					numberOfIdenticals++;
					break;
				}
			}
		}
		return numberOfIdenticals;
	}
	
	private static int countIdenticals(String winningSuperStar, String chosenSuperStar) {
		int numberOfIdenticals=0;
		for (int i=0; i<chosenSuperStar.length(); i++) {
			if (chosenSuperStar.charAt(i)==winningSuperStar.charAt(i))
				numberOfIdenticals++;
		}
		return numberOfIdenticals;
	}
}