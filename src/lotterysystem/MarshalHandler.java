package lotterysystem;

import jaxb_lotterytypes.*;
import jaxb_lotterytypes.LotteryTicket.Plays;
import jaxb_lotterytypes.LotteryTicket.SuperStarNumbers;
import jaxb_lotterytypes.Play.MainNumbers;
import jaxb_lotterytypes.Play.StarNumbers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class MarshalHandler {

	private LotteryTickets lotteryTicketsRoot;
	private LotteryTickets archiveTicketsRoot;
	private File outputFile = new File("tickets.xml");
	private File archiveFile = new File("tickets_archive.xml");
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	private ObjectFactory objFact;
	private int lastTicketId;

	public MarshalHandler() throws JAXBException, IOException {
		// Package
		JAXBContext jc = JAXBContext.newInstance("jaxb_lotterytypes");
		this.unmarshaller = jc.createUnmarshaller();
		this.marshaller = jc.createMarshaller();
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		this.objFact = new ObjectFactory();

		if (!outputFile.exists())
			outputFile.createNewFile();

		if (!archiveFile.exists())
			archiveFile.createNewFile();

		this.loadLotteryTickets();
		this.loadArchiveTickets();

		// set counter of ticket id
		this.loadLastTicketId();

	}

	public File getOutputFile() {
		return this.outputFile;
	}

	public void setOutputFile(File f) {
		this.outputFile = f;
	}

	public void addMultipleTickets(int validityDuration, int[] mainNumbers,	int[] starNumbers, String[] superStars)
			throws DatatypeConfigurationException {
		// Sort numbers
		mainNumbers = LottoMachine.sortNumbers(mainNumbers);
		starNumbers = LottoMachine.sortNumbers(starNumbers);

		// Create JAXB objects
		MainNumbers mainNrObj = objFact.createPlayMainNumbers();
		List<Integer> mainNrList = mainNrObj.getMainNumber();
		mainNrList.addAll(toList(mainNumbers));

		StarNumbers starNrObj = objFact.createPlayStarNumbers();
		List<Integer> starNrList = starNrObj.getStarNumber();
		starNrList.addAll(toList(starNumbers));

		Play playObj = objFact.createPlay();
		playObj.setMainNumbers(mainNrObj);
		playObj.setStarNumbers(starNrObj);

		Plays playsObj = objFact.createLotteryTicketPlays();
		List<Play> playsList = playsObj.getPlay();
		playsList.add(playObj);

		SuperStarNumbers superStarObj = objFact
				.createLotteryTicketSuperStarNumbers();

		List<String> superStarsList = superStarObj.getSuperStarNumber();
		for (int i = 0; i < superStars.length; i++) {
			if (superStars[i] != null)
				superStarsList.add(superStars[i]);
		}

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(LottoMachine.getNextDrawingDate());
		XMLGregorianCalendar xmlCal = null;
		xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

		LotteryTicket ticket = objFact.createLotteryTicket();
		ticket.setFirstDrawingDate(xmlCal);
		ticket.setPlays(playsObj);
		ticket.setSuperStarNumbers(superStarObj);
		ticket.setValidityDuration(validityDuration);
		ticket.setTicketId(getNextTicketId());

		// Save objects to root object
		this.lotteryTicketsRoot.getLotteryTicket().add(ticket);
	}

	public void addTicket(int validityDuration, int[] mainNumbers, int[] starNumbers, String[] superStars) throws DatatypeConfigurationException, JAXBException {
		this.addMultipleTickets(validityDuration, mainNumbers, starNumbers, superStars);
		this.saveLotteryTickets();
	}

	// Returns all tickets that are valid for the next drawing
	public List<LotteryTicket> getLotteryTickets() {
		return this.lotteryTicketsRoot.getLotteryTicket();
	}

	private void loadLotteryTickets() throws JAXBException {
		if (outputFile.length() < 1)
			this.lotteryTicketsRoot = objFact.createLotteryTickets();
		else
			// Unmarshal the file
			this.lotteryTicketsRoot = (LotteryTickets) unmarshaller
					.unmarshal(this.outputFile);
	}

	private void loadArchiveTickets() throws JAXBException {
		if (archiveFile.length() < 1)
			this.archiveTicketsRoot = objFact.createLotteryTickets();
		else
			// Unmarshal the file
			this.archiveTicketsRoot = (LotteryTickets) unmarshaller
					.unmarshal(this.archiveFile);
	}

	public void saveLotteryTickets() throws JAXBException {
		// Marshal the file
		this.marshaller.marshal(this.lotteryTicketsRoot, this.outputFile);
		this.marshaller.marshal(this.archiveTicketsRoot, this.archiveFile);
	}

	// Removes old tickets and adds them to the archive XML-file
	public void archiveOldTickets() {
		if (this.lotteryTicketsRoot == null || LottoMachine.isFirstDrawing())
			return;

		List<LotteryTicket> currentTickets = lotteryTicketsRoot
				.getLotteryTicket();
		this.lotteryTicketsRoot = objFact.createLotteryTickets();

		for (int i = 0; i < currentTickets.size(); i++) {
			int validityDuration = currentTickets.get(i).getValidityDuration();
			XMLGregorianCalendar firstDrawingDateXML = currentTickets.get(i)
					.getFirstDrawingDate();
			Date firstDrawingDate = firstDrawingDateXML.toGregorianCalendar()
					.getTime();
			Date lastDrawingDate = LottoMachine.getFutureDrawingDate(
					firstDrawingDate, validityDuration);

			if (lastDrawingDate.before(LottoMachine.getNextDrawingDate()))
				this.archiveTicketsRoot.getLotteryTicket().add(
						currentTickets.get(i));
			else
				this.lotteryTicketsRoot.getLotteryTicket().add(
						currentTickets.get(i));
		}

	}

	private static ArrayList<Integer> toList(int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++)
			list.add(new Integer(array[i]));
		return list;
	}

	private int getNextTicketId() {
		this.lastTicketId++;
		return this.lastTicketId;
	}

	private void loadLastTicketId() {
		ArrayList<Integer> ticketNumbers = new ArrayList<>();

		for (LotteryTicket ticket : lotteryTicketsRoot.getLotteryTicket())
			ticketNumbers.add(ticket.getTicketId());

		for (LotteryTicket ticket : archiveTicketsRoot.getLotteryTicket())
			ticketNumbers.add(ticket.getTicketId());

		Collections.sort(ticketNumbers);

		if (ticketNumbers.size() == 0)
			this.lastTicketId = 3000000;
		else
			this.lastTicketId = ticketNumbers.get(ticketNumbers.size() - 1);
	}

}
