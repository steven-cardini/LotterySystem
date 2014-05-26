package lotterysystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class LottoMachine {
	
	private final static int AMOUNT_MAIN_NUMBERS = 5;
	private final static int MIN_MAIN_NUMBER = 1;
	private final static int MAX_MAIN_NUMBER = 50;
	
	private final static int AMOUNT_STAR_NUMBERS = 2;
	private final static int MIN_STAR_NUMBER = 1;
	private final static int MAX_STAR_NUMBER = 11;

	private static File historyWinnersFile = new File ("historyWinningNumbers.bin");
	private static WinningNumbersSet currentWinningSet;
	private static ArrayList<WinningNumbersSet> pastWinningSets;
	
	
	public static void draw () throws ClassNotFoundException, IOException {
		int[] winningMainNumbers = drawWinningNumbers (AMOUNT_MAIN_NUMBERS, MIN_MAIN_NUMBER, MAX_MAIN_NUMBER);
		int[] winningStarNumbers = drawWinningNumbers (AMOUNT_STAR_NUMBERS, MIN_STAR_NUMBER, MAX_STAR_NUMBER);
		String winningSuperStar = generateSuperStar();
		
		currentWinningSet = new WinningNumbersSet(winningMainNumbers, winningStarNumbers, winningSuperStar, getNewDate());
		
		saveWinningNumbers();
	}

	public static String formatNumbers(int[] numberArray) {
		String formatted="";
		for (int i=0; i<numberArray.length; i++) formatted += numberArray[i] + " ";
		return formatted;
	}
	
	public static int[] getWinningMainNumbers () {
		return currentWinningSet.getWinningMainNumbers();
	}
	
	public static int[] getWinningStarNumbers () {
		return currentWinningSet.getWinningStarNumbers();
	}
	
	public static String getWinningSuperStar () {
		return currentWinningSet.getWinningSuperStar();
	}
	
	public static Date getDrawingDate () {
		return currentWinningSet.getDrawingDate();
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
	
	
	static void initialize() throws ClassNotFoundException, IOException {
		if (!historyWinnersFile.exists()) {
			historyWinnersFile.createNewFile();
			pastWinningSets = new ArrayList<>();
			draw();
			saveWinningNumbers();
		} else {
			loadWinningNumbers();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void loadWinningNumbers() throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(historyWinnersFile));
		pastWinningSets = (ArrayList<WinningNumbersSet>) in.readObject();
		in.close();
	}

	private static void saveWinningNumbers() throws IOException, ClassNotFoundException {
		if (currentWinningSet != null) 
			pastWinningSets.add(currentWinningSet);
		
		ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(historyWinnersFile));
		out.writeObject(pastWinningSets);
		out.close();
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
	
	static String generateSuperStar () {
		Random r = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int pos = r.nextInt(alphabet.length());
		String superStar = alphabet.substring(pos,pos+1);
		
		for (int i=0; i<3; i++)
			superStar += r.nextInt(10);
		
		pos = r.nextInt(alphabet.length());
		superStar += alphabet.substring(pos,pos+1);
		return superStar;
	}
	
	//Method yields date of next drawing; the earliest date is "tomorrow"
	private static Date getNewDate () {
		Date newDate;
		if (currentWinningSet != null) {
			newDate = currentWinningSet.getDrawingDate();
		} else {
			newDate = new Date();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(newDate);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		
		do 
			cal.add(Calendar.DATE, 1);
		while (weekDay!=2 && weekDay!=6);
			
		return cal.getTime();
	}
	
}
