package lotterysystem;

public class LottoMachine {
	
	private final static int AMOUNT_MAIN_NUMBERS = 5;
	private final static int MIN_MAIN_NUMBER = 1;
	private final static int MAX_MAIN_NUMBER = 50;
	
	private final static int AMOUNT_STAR_NUMBERS = 2;
	private final static int MIN_STAR_NUMBER = 1;
	private final static int MAX_STAR_NUMBER = 11;
	
	private static int[] winningMainNumbers;
	private static int[] winningStarNumbers;
	

	// TODO: modify to be more generic and implement via abstract IO class
	public static void printNumbers() {
		winningMainNumbers = drawWinningNumbers(AMOUNT_MAIN_NUMBERS, MIN_MAIN_NUMBER, MAX_MAIN_NUMBER);
		System.out.println("\nWinning main numbers:");
		System.out.println(formatNumbers(winningMainNumbers));
		
		winningStarNumbers = drawWinningNumbers(AMOUNT_STAR_NUMBERS, MIN_STAR_NUMBER, MAX_STAR_NUMBER);
		System.out.println("Winning star numbers:");
		System.out.println(formatNumbers(winningStarNumbers));
	}
	
	private static int[] drawWinningNumbers(int amount, int minValue, int maxValue) {
		int[] newWinningNumbers = new int[amount];
		int currentDrawIndex=0;
		while (currentDrawIndex<amount) {
			int drawnNumber = drawNumber(minValue, maxValue);
			if (alreadyContained(drawnNumber, newWinningNumbers)) continue;
			else newWinningNumbers[currentDrawIndex] = drawnNumber;
			currentDrawIndex++;
		}
		return sortNumbers(newWinningNumbers);
	}
	
	private static int drawNumber (int minNumber, int maxNumber) {
		int drawnNumber = (int) (maxNumber * Math.random() + minNumber);		
		return drawnNumber;
	}
	
	private static int[] sortNumbers (int[] numberArray) {
		int length = numberArray.length;
		int currentSortIndex = 0;
		int[] sortedNumbers = new int[length];
		int[] sortedIndexes = new int[length];
		for (int i=0; i<length; i++) {
			sortedNumbers[i] = Integer.MAX_VALUE;
			sortedIndexes[i] = Integer.MAX_VALUE;
		}
		
		while (currentSortIndex<length) {
			for (int i=0; i<length; i++) {
				if (alreadyContained(i,sortedIndexes)) continue;
				if (numberArray[i]<sortedNumbers[currentSortIndex]) {
					sortedNumbers[currentSortIndex] = numberArray[i];
					sortedIndexes[currentSortIndex] = i;
				}
			}
			currentSortIndex++;
		}
		return sortedNumbers;
	}
	
	private static boolean alreadyContained (int number, int[] numberArray) {
		int length = numberArray.length;
		for (int i=0; i<length; i++) {
			if (number==numberArray[i]) return true;
		}
		
		return false;
	}
	
	private static String formatNumbers(int[] numberArray) {
		String formatted="";
		for (int i=0; i<numberArray.length; i++) formatted += numberArray[i] + " ";
		return formatted;
	}
}
