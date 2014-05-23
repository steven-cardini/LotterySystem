package lotterysystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import jaxb_lotterytypes.LotteryTicket;
import jaxb_lotterytypes.LotteryTicket.Plays;
import jaxb_lotterytypes.LotteryTicket.SuperStarNumbers;
import jaxb_lotterytypes.Play;
import jaxb_lotterytypes.Play.MainNumbers;
import jaxb_lotterytypes.Play.StarNumbers;
import lotterysystem.LanguageHandler.*;
import lotterysystem.IInputOutputHandler.*;

public class LotterySimulation {
	
	private static LanguageHandler lang = new LanguageHandler();
	private static ConsoleIOHandler io = new ConsoleIOHandler(lang);
	private static File outputXMLFile = new File ("tickets.xml");
	private static MarshalHandler marshaller;
	private static UnmarshalHandler unmarshaller;
	private TicketAnalyzer analyzer;

	private static boolean running;	
	
	
	public static void main (String[] args) throws ClassNotFoundException, IOException, JAXBException {
		running = true;
		LottoMachine.initialize();
		LotterySimulation sim = new LotterySimulation();
		sim.drawNewWinningNumbers();
		
		marshaller = new MarshalHandler(outputXMLFile);
		unmarshaller = new UnmarshalHandler(outputXMLFile);
		
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

		
		MainNumbers mainNrObj = new MainNumbers();
		List<Integer> mainNrList = mainNrObj.getMainNumber();
		mainNrList.addAll(toList(mainNumbers));
		
		StarNumbers starNrObj = new StarNumbers();
		List<Integer> starNrList = starNrObj.getStarNumber();
		starNrList.addAll(toList (starNumbers));
		
		Play playObj = new Play();
		playObj.setMainNumbers(mainNrObj);
		playObj.setStarNumbers(starNrObj);
		
		Plays playsObj = new Plays();
		List<Play> playsList = playsObj.getPlay();
		playsList.add(playObj);
		
		SuperStarNumbers superStarObj = new SuperStarNumbers();
		List<String> superStarsList = superStarObj.getSuperStarNumber();
		superStarsList.add(LottoMachine.generateSuperStar());
		
		//TODO: improve and change so that drawing date is shown, not current date
		XMLGregorianCalendar xmlCal = null;
		try {
			xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar now = Calendar.getInstance();
		xmlCal.setDay(now.get(Calendar.DAY_OF_MONTH));
		// We do a +1 below because XMLGregorianCalendar goes from 1 to 12
		// while Calendar.MONTH goes from 0 to 11 !!!
		xmlCal.setMonth(now.get(Calendar.MONTH)+1);
		xmlCal.setYear(now.get(Calendar.YEAR));
		xmlCal.setTime(now.get(Calendar.HOUR_OF_DAY),
		now.get(Calendar.MINUTE),
		now.get(Calendar.SECOND));

		LotteryTicket ticket = new LotteryTicket();
		ticket.setNextDrawingDate(xmlCal);
		ticket.setPlays(playsObj);
		ticket.setSuperStarNumbers(superStarObj);
		ticket.setValidityDuration(1);
		ticket.setTicketId(101);
		
		try {
			marshaller.addTicket(ticket);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		io.printMessage(lang.getMessage("your_numbers") + " " + LottoMachine.formatNumbers(mainNumbers) + " + " + LottoMachine.formatNumbers(starNumbers));
		io.printMessage(lang.getMessage("winning_numbers") + " " + LottoMachine.formatNumbers(LottoMachine.getWinningMainNumbers()) + " + " + LottoMachine.formatNumbers(LottoMachine.getWinningStarNumbers()));
		io.printMessage(lang.getMessage("winning_super_star") + " " + LottoMachine.getWinningSuperStar());
		io.printMessage(lang.getMessage("amount_matching_numbers") + " " + analyzer.getAmountMatchingMainNumbers(mainNumbers) + " + " + analyzer.getAmountMatchingStarNumbers(starNumbers));
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
	
	private static ArrayList<Integer> toList (int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<array.length; i++)
			list.add(new Integer(array[i]));
		return list;
	}
}