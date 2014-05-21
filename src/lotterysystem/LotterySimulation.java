package lotterysystem;

import java.io.IOException;

import lotterysystem.LanguageHandler.*;
import lotterysystem.IInputOutputHandler.*;

public class LotterySimulation {
	
	private static LanguageHandler lang = new LanguageHandler();
	private static ConsoleIOHandler io = new ConsoleIOHandler(lang);
	private TicketAnalyzer analyzer;

	private static boolean running;	
	
	
	public static void main (String[] args) throws ClassNotFoundException, IOException {
		running = true;
		LottoMachine.initialize();
		LotterySimulation sim = new LotterySimulation();
		sim.drawNewWinningNumbers();
		
		io.printMessage(lang.getMessage("welcome"));
		
		while (running) {
			MenuSelection selected;
			try {
				selected = io.getMenuSelection();
			} catch (IllegalArgumentException e) {
				io.printError(lang.getMessage("invalid_input"));
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
				io.printError(lang.getMessage("unknown_error"));
				continue;
			}
			
		}
		
	}
		
	private void drawNewWinningNumbers () throws ClassNotFoundException, IOException {
		LottoMachine.draw();
		analyzer = new TicketAnalyzer(LottoMachine.getWinningMainNumbers(), LottoMachine.getWinningStarNumbers(), LottoMachine.getWinningSuperStar(), LottoMachine.getDrawingDate());
	}
	
	private void inputNumbers () {
		int[] mainNumbers=null;
		int[] starNumbers = null;
		
		try {
			mainNumbers = this.getMainNumbers();
		} catch (NumberOutOfRangeException e) {
			io.printError(lang.getMessage("only_numbers_accepted_range") + " " + LottoMachine.getMinMainNumber() + "-" + LottoMachine.getMaxMainNumber());
			return;
		} catch (IllegalArgumentException e) {
			io.printError(lang.getMessage("only_numbers_accepted"));
			return;
		}
		
		try {
			starNumbers = this.getStarNumbers();
		} catch (NumberOutOfRangeException e) {
			io.printError(lang.getMessage("only_numbers_accepted_range") + " " + LottoMachine.getMinStarNumber() + "-" + LottoMachine.getMaxStarNumber());
			return;
		} catch (IllegalArgumentException e) {
			io.printError(lang.getMessage("only_numbers_accepted"));
			return;
		}
		
		io.printMessage(lang.getMessage("your_numbers") + " " + LottoMachine.formatNumbers(mainNumbers) + " + " + LottoMachine.formatNumbers(starNumbers));
		io.printMessage(lang.getMessage("winning_numbers") + " " + LottoMachine.formatNumbers(LottoMachine.getWinningMainNumbers()) + " + " + LottoMachine.formatNumbers(LottoMachine.getWinningStarNumbers()));
		io.printMessage(lang.getMessage("amount_matching_numbers") + " " + analyzer.amountMatchingMainNumbers(mainNumbers) + " + " + analyzer.amountMatchingStarNumbers(starNumbers));
	}
	
	private void changeLanguage () {
		Language language;
		try {
			language = io.getLanguageSelection();
		} catch (IllegalArgumentException e) {
			io.printError(lang.getMessage("invalid_input"));
			return;
		}
		
		lang.setLanguage(language);
	}
	
	private int[] getMainNumbers () throws NumberOutOfRangeException, IllegalArgumentException {
		io.printMessage(lang.getMessage("enter_main_numbers"));
		int[] mainNumbers = io.getNumbers(LottoMachine.getAmountMainNumbers(), LottoMachine.getMaxMainNumber(), LottoMachine.getMinMainNumber());
		return mainNumbers;
	}
	
	private int[] getStarNumbers () throws NumberOutOfRangeException, IllegalArgumentException {
		io.printMessage(lang.getMessage("enter_star_numbers"));
		int[] starNumbers = io.getNumbers(LottoMachine.getAmountStarNumber(), LottoMachine.getMaxStarNumber(), LottoMachine.getMinStarNumber());
		return starNumbers;
	}
}