package lotterysystem;

import java.util.Date;
import java.util.ListResourceBundle;

import lotterysystem.ConsoleIOHandler.menuSelection;

public class LotterySimulation {
	
	private static ConsoleIOHandler io = new ConsoleIOHandler();
	private TicketAnalyzer analyzer;
	private static int[] winningMainNumbers;
	private static int[] winningStarNumbers;
	private static String winningSuperStarNumber = "test";

	private ListResourceBundle textResources = new TextResourcesEN();
	private static boolean running = true;
	
	
	public static void main (String[] args) {
		LotterySimulation sim = new LotterySimulation();
		sim.drawNewWinningNumbers();
		
		io.printMessage(sim.textResources.getString("welcome"));
		
		while (running) {
			menuSelection selected;
			try {
				selected = io.getMenuSelection();
			} catch (IllegalArgumentException e) {
				io.printError(sim.textResources.getString("invalid_input"));
				continue;
			}
			
			switch (selected) {
			case INPUT_NUMBERS:
				sim.inputNumbers();
				break;
			case DRAW_NUMBERS:
				sim.drawNewWinningNumbers();
				break;
			case CHANGE_LANGUAGE:
				sim.changeLanguage();
				break;
			case QUIT:
				running = false;
				break;
			default:
				io.printError(sim.textResources.getString("unknown_error"));
				continue;
			}
			
		}
		
	}
		
	private void drawNewWinningNumbers () {
		winningMainNumbers = LottoMachine.drawWinningMainNumbers();
		winningStarNumbers = LottoMachine.drawWinningStarNumbers();
		analyzer = new TicketAnalyzer(winningMainNumbers, winningStarNumbers, winningSuperStarNumber, new Date());
	}
	
	private void inputNumbers () {
		int[] mainNumbers=null;
		int[] starNumbers = null;
		
		try {
			mainNumbers = this.getMainNumbers();
		} catch (NumberOutOfRangeException e) {
			io.printError(textResources.getString("only_numbers_accepted_range") + " " + LottoMachine.getMinMainNumber() + "-" + LottoMachine.getMaxMainNumber());
			return;
		} catch (IllegalArgumentException e) {
			io.printError(textResources.getString("only_numbers_accepted"));
			return;
		}
		
		try {
			starNumbers = this.getStarNumbers();
		} catch (NumberOutOfRangeException e) {
			io.printError(textResources.getString("only_numbers_accepted_range") + " " + LottoMachine.getMinStarNumber() + "-" + LottoMachine.getMaxStarNumber());
			return;
		} catch (IllegalArgumentException e) {
			io.printError(textResources.getString("only_numbers_accepted"));
			return;
		}
		
		io.printMessage(textResources.getString("your_numbers") + " " + LottoMachine.formatNumbers(mainNumbers) + " + " + LottoMachine.formatNumbers(starNumbers));
		io.printMessage(textResources.getString("winning_numbers") + " " + LottoMachine.formatNumbers(winningMainNumbers) + " + " + LottoMachine.formatNumbers(winningStarNumbers));
		io.printMessage(textResources.getString("amount_matching_numbers") + " " + analyzer.amountMatchingMainNumbers(mainNumbers) + " + " + analyzer.amountMatchingStarNumbers(starNumbers));
	}
	
	private void changeLanguage () {
		IInputOutputHandler.language lang;
		try {
			lang = io.getLanguageSelection();
		} catch (IllegalArgumentException e) {
			io.printError(textResources.getString("invalid_input"));
			return;
		}
		
		this.switchTextResources(lang);
		io.switchTextResources(lang);
	}
	
	private int[] getMainNumbers () throws NumberOutOfRangeException, IllegalArgumentException {
		io.printMessage(textResources.getString("enter_main_numbers"));
		int[] mainNumbers = io.getNumbers(LottoMachine.getAmountMainNumbers(), LottoMachine.getMaxMainNumber(), LottoMachine.getMinMainNumber());
		return mainNumbers;
	}
	
	private int[] getStarNumbers () throws NumberOutOfRangeException, IllegalArgumentException {
		io.printMessage(textResources.getString("enter_star_numbers"));
		int[] starNumbers = io.getNumbers(LottoMachine.getAmountStarNumber(), LottoMachine.getMaxStarNumber(), LottoMachine.getMinStarNumber());
		return starNumbers;
	}
	
	private void switchTextResources (IInputOutputHandler.language lang) {
		switch (lang) {
		case ENGLISH:
			this.textResources = new TextResourcesEN();
			break;
		case GERMAN:
			this.textResources = new TextResourcesDE();
			break;
		}
	}

}
