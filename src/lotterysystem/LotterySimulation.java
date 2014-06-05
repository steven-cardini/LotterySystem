package lotterysystem;

import gui.Main;

import java.io.File;
import java.io.IOException;

import javafx.stage.Stage;

import javax.xml.bind.JAXBException;

import lotterysystem.LanguageHandler.*;
import lotterysystem.IInputOutputHandler.*;

public class LotterySimulation {
	
	private static LanguageHandler lang = new LanguageHandler();
	private static ConsoleIOHandler io = new ConsoleIOHandler(lang);
	private static boolean running;	
	
	static File outputXMLFile = new File ("tickets.xml");
	static File archiveXMLFile = new File ("tickets_archive.xml");
	static File historyWinningNumbersFile = new File ("winningNumbers.bin");
	private MarshalHandler marshalHandler;
	private TicketAnalyzer analyzer;

	
	public LotterySimulation () throws JAXBException, IOException, ClassNotFoundException {
		running = true;
		LottoMachine.initialize();
		marshalHandler = new MarshalHandler();
		//analyzer = new TicketAnalyzer(LottoMachine.getWinningMainNumbers(), LottoMachine.getWinningStarNumbers(), LottoMachine.getWinningSuperStar(), LottoMachine.getLastDrawingDate());
	}
	
	
	public static void main (String[] args) throws ClassNotFoundException, IOException, JAXBException {
		
		LotterySimulation sim = new LotterySimulation();
		io.printMessage(lang.getMessage("welcome"));
		MenuSelection selected;

		
		while (running) {
			io.printMessage(lang.getMessage("next_drawing_date") + LottoMachine.getNextDrawingDate());
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
			case CLEAR_ALL:
				sim.clearAll();
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
		analyzer = new TicketAnalyzer(LottoMachine.getWinningMainNumbers(), LottoMachine.getWinningStarNumbers(), LottoMachine.getWinningSuperStar(), LottoMachine.getLastDrawingDate());
	}
	
	private void inputNumbers () {
		int[] mainNumbers=null;
		int[] starNumbers = null;
		int validityDuration = 0;
		
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
		
		io.printMessage(lang.getMessage("validity_duration"));
		String s = io.scanInput();
		try {
			validityDuration = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			io.printError(lang.getMessage("only_numbers_accepted"));
			return;
		}
		
		
		//TODO: enable user to chose 1-4 given superstars, validity duration
		try {
			marshalHandler.addTicket(validityDuration, mainNumbers, starNumbers, LottoMachine.generateSuperStar());
		} catch (Exception e) {
			io.printError(lang.getMessage("persistency_error"));
			e.printStackTrace();
		}
		
		
		/* TODO: needs to be handled by a separate class
		
		//TODO: now new input numbers are compared to the last winning numbers; a functionality must be implemented, where new winning numbers are drawn and tickets are evaluated
		io.printMessage(lang.getMessage("last_drawing_date") + " " + LanguageHandler.formatDate(LottoMachine.getLastDrawingDate(), lang.getCurrentLocale()) );
		io.printMessage(lang.getMessage("your_numbers") + " " + LottoMachine.formatNumbers(mainNumbers) + " + " + LottoMachine.formatNumbers(starNumbers));
		io.printMessage(lang.getMessage("winning_numbers") + " " + LottoMachine.formatNumbers(LottoMachine.getWinningMainNumbers()) + " + " + LottoMachine.formatNumbers(LottoMachine.getWinningStarNumbers()));
		io.printMessage(lang.getMessage("winning_super_star") + " " + LottoMachine.getWinningSuperStar());
		io.printMessage(lang.getMessage("amount_matching_numbers") + " " + analyzer.getAmountMatchingMainNumbers(mainNumbers) + " + " + analyzer.getAmountMatchingStarNumbers(starNumbers));
		
		*/
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
	
	private void clearAll() {
		outputXMLFile.delete();
		archiveXMLFile.delete();
		historyWinningNumbersFile.delete();
		running=false;
	}

}