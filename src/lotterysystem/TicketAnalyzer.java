package lotterysystem;

public class TicketAnalyzer {
	private int[] chosenMainNumbers;
	private int[] chosenStarNumbers;
	private String[] chosenSuperStars;
	
	private int identicalMainNumbers;
	private int identicalStarNumbers;
	private int[] superStarRanks;
	
	public TicketAnalyzer (int[] chosenMainNumbers, int[] chosenStarNumbers, String[] chosenSuperStars) {
		this.chosenMainNumbers = chosenMainNumbers;
		this.chosenStarNumbers = chosenStarNumbers;
		this.chosenSuperStars = chosenSuperStars;
		if (chosenSuperStars.length>0)
			this.superStarRanks = new int[chosenSuperStars.length];
	}
	
	public void analyze (int[] winningMainNumbers, int[] winningStarNumbers, String winningSuperStar) {
		this.identicalMainNumbers = countIdenticals(winningMainNumbers, this.chosenMainNumbers);
		this.identicalStarNumbers = countIdenticals(winningStarNumbers, this.chosenStarNumbers);
		for (int i=0; i<this.chosenSuperStars.length; i++)
			this.superStarRanks[i] = determineSuperStarRank(winningSuperStar, this.chosenSuperStars[i]);
	}
	
	public int getAmountIdenticalMainNumbers () {
		return this.identicalMainNumbers;
	}
	
	public int getAmountIdenticalStarNumbers () {
		return this.identicalStarNumbers;
	}
	
	public boolean hasSuperStars () {
		return this.chosenSuperStars != null && this.chosenSuperStars.length > 0;
	}
	
	public int[] getSuperStarRanks () {
		return this.superStarRanks;
	}
	
	
	private static int countIdenticals (int[] winningNumbers, int[] numberArray) {
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
	
	private static int determineSuperStarRank (String winningSuperStar, String chosenSuperStar) {
		int superStarRank = 0;
		
		if (chosenSuperStar.equals(winningSuperStar))										// Rank 1
			superStarRank = 1;
		else if (chosenSuperStar.substring(0,2).equals(winningSuperStar.substring(0, 2))	// Rank 2
				 && chosenSuperStar.substring(3,5).equals(winningSuperStar.substring(3,5)))
			superStarRank = 2;
		else if (chosenSuperStar.substring(0,3).equals(winningSuperStar.substring(0,3))		// Rank 3
				 && chosenSuperStar.charAt(4)==winningSuperStar.charAt(4)   || 
				 chosenSuperStar.substring(2,5).equals(winningSuperStar.substring(2,5))
				 && chosenSuperStar.charAt(0)==winningSuperStar.charAt(0))
			superStarRank = 3;
		else if (chosenSuperStar.substring(0,4).equals(winningSuperStar.substring(0,4))  ||	// Rank 4
				 chosenSuperStar.substring(1,5).equals(winningSuperStar.substring(1,5)))
			superStarRank = 4;
		else if (chosenSuperStar.substring(0,2).equals(winningSuperStar.substring(0,2))		// Rank 5
				 && chosenSuperStar.charAt(4)==winningSuperStar.charAt(4)    ||
				 chosenSuperStar.substring(3,5).equals(winningSuperStar.substring(3,5))
				 && chosenSuperStar.charAt(0)==winningSuperStar.charAt(0))
			superStarRank = 5;
		else if (chosenSuperStar.substring(0,3).equals(winningSuperStar.substring(0,3))  ||	// Rank 6
				 chosenSuperStar.substring(2,5).equals(winningSuperStar.substring(2,5)))
			superStarRank = 6;
		else if (chosenSuperStar.charAt(0) == winningSuperStar.charAt(0)					// Rank 7
				 && chosenSuperStar.charAt(4) == winningSuperStar.charAt(4))
			superStarRank = 7;
		else if (chosenSuperStar.substring(0,2).equals(winningSuperStar.substring(0,2))  ||	// Rank 8
				 chosenSuperStar.substring(3,5).equals(winningSuperStar.substring(3,5)))
			superStarRank = 8;
		else if (chosenSuperStar.charAt(0) == winningSuperStar.charAt(0)  ||
				 chosenSuperStar.charAt(4) == winningSuperStar.charAt(4))
			superStarRank = 9;
		
		
		return superStarRank;
	}
}