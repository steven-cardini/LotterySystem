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
import java.util.List;
import java.util.Random;

import jaxb_lotterytypes.LotteryTicket;

public class LottoMachine {
	
	private final static int AMOUNT_MAIN_NUMBERS = 5;
	private final static int MIN_MAIN_NUMBER = 1;
	private final static int MAX_MAIN_NUMBER = 50;
	
	private final static int AMOUNT_STAR_NUMBERS = 2;
	private final static int MIN_STAR_NUMBER = 1;
	private final static int MAX_STAR_NUMBER = 11;

	private static File historyWinnersFile = new File ("winningNumbers.bin");
	private static File historyStatisticsFile = new File ("winnerStatistics.bin");
	private static WinningNumbersSet currentWinningSet;
	private static ArrayList<WinningNumbersSet> pastWinningSets;
	private static DrawingResult currentDrawingResult;
	private static ArrayList<DrawingResult> pastDrawingResults;
	private static Date nextDrawingDate;
	
	
	public static void draw (MarshalHandler handler) throws ClassNotFoundException, IOException {
		int[] winningMainNumbers = drawWinningNumbers (AMOUNT_MAIN_NUMBERS, MIN_MAIN_NUMBER, MAX_MAIN_NUMBER);
		int[] winningStarNumbers = drawWinningNumbers (AMOUNT_STAR_NUMBERS, MIN_STAR_NUMBER, MAX_STAR_NUMBER);
		String winningSuperStar = generateSuperStar();
		
		currentWinningSet = new WinningNumbersSet(winningMainNumbers, winningStarNumbers, winningSuperStar, nextDrawingDate);
		
		currentDrawingResult = new DrawingResult(currentWinningSet, handler.getLotteryTickets());

		nextDrawingDate = calculateSubsequentDrawingDate();
		
		handler.archiveOldTickets();
		
		saveOutputFiles();

	}

	public static String formatNumbers(int[] numberArray) {
		String formatted="";
		for (int i=0; i<numberArray.length; i++)  {
			formatted += numberArray[i];
			if (i<numberArray.length-1)
				formatted += "-";
		}
		return formatted;
	}
	
	
	// WARNING: the following methods may throw a null pointer exception if no draw has been made until now
	// ----->
	public static int[] getWinningMainNumbers () {
		return currentWinningSet.getWinningMainNumbers();
	}
	
	public static int[] getWinningStarNumbers () {
		return currentWinningSet.getWinningStarNumbers();
	}
	
	public static String getWinningSuperStar () {
		return currentWinningSet.getWinningSuperStar();
	}
	
	public static Date getLastDrawingDate () {
		return currentWinningSet.getDrawingDate();
	}
	
	public static DrawingResult getResults () {
		return currentDrawingResult;
	}
	// <-----
	
	public static Date getNextDrawingDate () {
		return nextDrawingDate;
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
	
	public static boolean isFirstDrawing () {
		return currentWinningSet == null;
	}
		
	public static void initialize() throws ClassNotFoundException, IOException {
		if (!historyStatisticsFile.exists()) {
			historyStatisticsFile.createNewFile();
			pastDrawingResults = new ArrayList<>();
		}
		
		if (!historyWinnersFile.exists() || historyWinnersFile.length()<=1) {
			historyWinnersFile.createNewFile();
			pastWinningSets = new ArrayList<>();
		} else {
			loadOutputFiles();
		}
		nextDrawingDate = calculateSubsequentDrawingDate();
	}
	
	//Method yields date of next n-th drawing after the provided date (inclusive)
	public static Date getFutureDrawingDate (Date date, int n) {
		int counter = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		
		while (counter<n) {
			if (weekDay==3 || weekDay==6)
				counter++;
			if (counter==n)
				break;
			cal.add(Calendar.DATE, 1);
			weekDay = cal.get(Calendar.DAY_OF_WEEK);
		}
		
		return cal.getTime();
	}
	
	// sorts a given int array from smallest to largest number
	public static int[] sortNumbers (int[] numberArray) {
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
	
	public static int[] getRandomNumbers (int amount, int minValue, int maxValue) {
		return drawWinningNumbers(amount, minValue, maxValue);
	}
	
	//Method yields the first drawing date after the latest drawing date
	private static Date calculateSubsequentDrawingDate () {
		Calendar cal = Calendar.getInstance();
		if (currentWinningSet==null) {  // first drawing
			cal.setTime(new Date());
		} else {
			cal.setTime(currentWinningSet.getDrawingDate());
			cal.add(Calendar.DATE, 1);
		}
		return getFutureDrawingDate(cal.getTime(), 1);
	}
	
	@SuppressWarnings("unchecked")
	private static void loadOutputFiles() throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(historyWinnersFile));
		pastWinningSets = (ArrayList<WinningNumbersSet>) in.readObject();
		in.close();
		currentWinningSet = pastWinningSets.get(pastWinningSets.size()-1);
		
		in = new ObjectInputStream(new FileInputStream(historyStatisticsFile));
		pastDrawingResults = (ArrayList<DrawingResult>) in.readObject();
		in.close();
		currentDrawingResult = pastDrawingResults.get(pastWinningSets.size()-1);
	}

	private static void saveOutputFiles() throws IOException, ClassNotFoundException {
		if (currentWinningSet != null) 
			pastWinningSets.add(currentWinningSet);
		
		ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(historyWinnersFile));
		out.writeObject(pastWinningSets);
		out.close();
		
		if (currentDrawingResult != null)
			pastDrawingResults.add(currentDrawingResult);
		
		out = new ObjectOutputStream (new FileOutputStream(historyStatisticsFile));
		out.writeObject(pastDrawingResults);
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
		
	private static boolean alreadyContained (int number, int[] numberArray) {
		int length = numberArray.length;
		for (int i=0; i<length; i++) {
			if (number==numberArray[i]) return true;
		}
		
		return false;
	}
	
	public static String generateSuperStar () {
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
		
}
