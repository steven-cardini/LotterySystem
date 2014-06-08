package lotterysystem;

import java.util.ArrayList;
import java.util.List;

import jaxb_lotterytypes.LotteryTicket;

public class DrawingResult {
	private int[] winningMainNumbers;
	private int[] winningStarNumbers;
	private String winningSuperStar;
	private List<TicketAnalyzer> ticketAnalyzers;

	public DrawingResult (WinningNumbersSet winners, List<LotteryTicket> tickets) {
		this.winningMainNumbers = winners.getWinningMainNumbers();
		this.winningStarNumbers = winners.getWinningStarNumbers();
		this.winningSuperStar = winners.getWinningSuperStar();
		this.ticketAnalyzers = new ArrayList<TicketAnalyzer>();
		
		// For each ticket, create a TicketAnalyzer object and analyze the numbers
		for (int i=0; i<tickets.size(); i++) {
			List<Integer> mainNumbers = tickets.get(i).getPlays().getPlay().get(0).getMainNumbers().getMainNumber();
			List<Integer> starNumbers = tickets.get(i).getPlays().getPlay().get(0).getStarNumbers().getStarNumber();
			List<String> superStars = tickets.get(i).getSuperStarNumbers().getSuperStarNumber();
			this.ticketAnalyzers.add(new TicketAnalyzer(toIntArray(mainNumbers), toIntArray(starNumbers), toStringArray(superStars)));
			this.ticketAnalyzers.get(i).analyze(this.winningMainNumbers, this.winningStarNumbers, this.winningSuperStar);
		}
	}
	
	// Returns an int[] with winner statistics regarding main and star numbers
	public int[] getWinnersPerNumberRank () {
		int size = 13;
		int i=-1;
		int[] winnersPerRank = new int[size];
		
		winnersPerRank[++i] = this.determineNumberWinners(5,2);
		winnersPerRank[++i] = this.determineNumberWinners(5,1);
		winnersPerRank[++i] = this.determineNumberWinners(5,0);
		winnersPerRank[++i] = this.determineNumberWinners(4,2);
		winnersPerRank[++i] = this.determineNumberWinners(4,1);
		winnersPerRank[++i] = this.determineNumberWinners(4,0);
		winnersPerRank[++i] = this.determineNumberWinners(3,2);
		winnersPerRank[++i] = this.determineNumberWinners(2,2);
		winnersPerRank[++i] = this.determineNumberWinners(3,1);
		winnersPerRank[++i] = this.determineNumberWinners(3,0);
		winnersPerRank[++i] = this.determineNumberWinners(1,2);
		winnersPerRank[++i] = this.determineNumberWinners(2,1);
		winnersPerRank[++i] = this.determineNumberWinners(2,0);
		
		return winnersPerRank;
	}
	
	
	public int[] getWinnersPerSuperStarRank () {
		return this.determineSuperStarWinners();
	}
	
	
	
	
	private int determineNumberWinners (int identicalMainNumbers, int identicalStarNumbers) {
		int result = 0;
		
		for (int i=0; i<this.ticketAnalyzers.size(); i++) {
			if (this.ticketAnalyzers.get(i).getAmountIdenticalMainNumbers() >= identicalMainNumbers
				&& this.ticketAnalyzers.get(i).getAmountIdenticalStarNumbers() >= identicalStarNumbers)
			  result++;
		}
		
		return result;
	}
	
	private int[] determineSuperStarWinners () {
		int[] result = new int[9];
		
		for (int i=0; i<this.ticketAnalyzers.size(); i++) {
			if (this.ticketAnalyzers.get(i).hasSuperStars()) {
				int[] currentRanks = this.ticketAnalyzers.get(i).getSuperStarRanks();
				for (int j=0; j<currentRanks.length; j++)
					result[j] += currentRanks[j];
			}
		}
		
		return result;
	}
	
	private static int[] toIntArray (List<Integer> list) {
		int[] array = new int[list.size()];
		for (int i=0; i<list.size(); i++)
			array[i] = list.get(i);
		return array;
	}
	
	private static String[] toStringArray (List<String> list) {
		String[] array = new String[list.size()];
		for (int i=0; i<list.size(); i++)
			array[i] = list.get(i);
		return array;
	}
}
