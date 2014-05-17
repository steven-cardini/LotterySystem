package lotterysystem;

import java.util.Date;

public class LotterySimulation {
	
	private static IInputOutputHandler io = new ConsoleIOHandler();
	private TicketAnalyzer analyzer;
	private static int[] winningMainNumbers;
	private static int[] winningStarNumbers;
	private static String winningSuperStarNumber = "test";
	
	public static void main (String[] args) {
		LotterySimulation sim = new LotterySimulation();
		sim.drawNewWinningNumbers();
		io.printMessage("Amount of matching numbers: " + sim.numbersMatch());
		io.printMessage("Winning numbers: " + LottoMachine.formatNumbers(winningMainNumbers) + " + " + LottoMachine.formatNumbers(winningStarNumbers));
	}
	
	private int[] getMainNumbers () {
		io.printMessage("Please enter your main numbers!");
		int[] mainNumbers = io.scanNumbers(LottoMachine.getAmountMainNumbers(), LottoMachine.getMaxMainNumber(), LottoMachine.getMinMainNumber());
		return mainNumbers;
	}
	
	private int[] getStarNumbers () {
		io.printMessage("Please enter your star numbers!");
		int[] starNumbers = io.scanNumbers(LottoMachine.getAmountStarNumber(), LottoMachine.getMaxStarNumber(), LottoMachine.getMinStarNumber());
		return starNumbers;
	}
	
	private int numbersMatch () {
		int matchingMainNumbers = analyzer.amountMatchingMainNumbers(this.getMainNumbers());
		int matchingStarNumbers = analyzer.amountMatchingStarNumbers(this.getStarNumbers());
		return matchingMainNumbers + matchingStarNumbers;
	}
	
	private void drawNewWinningNumbers () {
		winningMainNumbers = LottoMachine.drawWinningMainNumbers();
		winningStarNumbers = LottoMachine.drawWinningStarNumbers();
		analyzer = new TicketAnalyzer(winningMainNumbers, winningStarNumbers, winningSuperStarNumber, new Date());
	}

}
