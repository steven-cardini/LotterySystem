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
	
	public int amountMatchingMainNumbers (int[] mainNumbers) {
		return countIdenticals(this.winningMainNumbers, mainNumbers);
	}
	
	public int amountMatchingStarNumbers (int[] starNumbers) {
		 return countIdenticals(this.winningStarNumbers, starNumbers);
	}
	
	public boolean superStarMatches(String superStar) {
		return superStar.equals(this.winningSuperStar);
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
}