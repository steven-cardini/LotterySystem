package lotterysystem;

import java.util.Date;

public class LottoMachine {
	
	private final static int AMOUNT_MAIN_NUMBERS = 5;
	private final static int MIN_MAIN_NUMBER = 1;
	private final static int MAX_MAIN_NUMBER = 50;
	
	private final static int AMOUNT_STAR_NUMBERS = 2;
	private final static int MIN_STAR_NUMBER = 1;
	private final static int MAX_STAR_NUMBER = 11;
	
	private static int[] winningMainNumbers;
	private static int[] winningStarNumbers;
	private static String winningSuperStar;
	private static Date drawDate;
	
	
	public static void draw () {
		winningMainNumbers = drawWinningNumbers (AMOUNT_MAIN_NUMBERS, MIN_MAIN_NUMBER, MAX_MAIN_NUMBER);
		winningStarNumbers = drawWinningNumbers (AMOUNT_STAR_NUMBERS, MIN_STAR_NUMBER, MAX_STAR_NUMBER);
		drawDate = new Date();
	}
	
	public static String formatNumbers(int[] numberArray) {
		String formatted="";
		for (int i=0; i<numberArray.length; i++) formatted += numberArray[i] + " ";
		return formatted;
	}
	
	public static int[] getWinningMainNumbers () {
		return winningMainNumbers;
	}
	
	public static int[] getWinningStarNumbers () {
		return winningStarNumbers;
	}
	
	public static String getWinningSuperStar () {
		return winningSuperStar;
	}
	
	public static Date getDrawDate () {
		return drawDate;
	}
	
	public static int getAmountMainNumbers () {
		return AMOUNT_MAIN_NUMBERS;
	}
	
	public static int getMaxMainNumber () {
		return MAX_MAIN_NUMBER;
	}
	
	public static int getMinMainNumber () {
		return MIN_MAIN_NUMBER;
	}
	
	public static int getAmountStarNumber () {
		return AMOUNT_STAR_NUMBERS;
	}
	
	public static int getMaxStarNumber () {
		return MAX_STAR_NUMBER;
	}
	
	public static int getMinStarNumber () {
		return MIN_STAR_NUMBER;
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
	
}
