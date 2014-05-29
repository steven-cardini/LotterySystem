package lotterysystem;

import jaxb_lotterytypes.*;
import jaxb_lotterytypes.LotteryTicket.Plays;
import jaxb_lotterytypes.LotteryTicket.SuperStarNumbers;
import jaxb_lotterytypes.Play.MainNumbers;
import jaxb_lotterytypes.Play.StarNumbers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class MarshalHandler {

	private LotteryTickets lotteryTicketsRoot;
	private File outputFile;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	private ObjectFactory objFact;
	private int lastTicketId;

	public MarshalHandler(File outputFile) throws JAXBException, IOException {
		// Package
		JAXBContext jc = JAXBContext.newInstance("jaxb_lotterytypes");
		this.unmarshaller = jc.createUnmarshaller();
		this.marshaller = jc.createMarshaller();
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		this.objFact = new ObjectFactory();

		this.outputFile = outputFile;
		if (!outputFile.exists())
			outputFile.createNewFile();

		this.loadSavedTickets();
		if (this.lotteryTicketsRoot.getLotteryTicket().size()==0)
			this.lastTicketId = 3000000;
		else {
			this.lastTicketId = this.lotteryTicketsRoot.getLotteryTicket().get(this.lotteryTicketsRoot.getLotteryTicket().size()-1).getTicketId();
		}
	}

	public File getOutputFile() {
		return this.outputFile;
	}

	public void setOutputFile(File f) {
		this.outputFile = f;
	}

	public void addTicket(Date nextDrawingDate, int validityDuration, int[] mainNumbers, int[] starNumbers, String superStar) throws DatatypeConfigurationException, JAXBException {
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
		
		SuperStarNumbers superStarObj = objFact.createLotteryTicketSuperStarNumbers();
		List<String> superStarsList = superStarObj.getSuperStarNumber();
		superStarsList.add(superStar);

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(nextDrawingDate);
		XMLGregorianCalendar xmlCal = null;
		xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

		LotteryTicket ticket = objFact.createLotteryTicket();
		ticket.setFirstDrawingDate(xmlCal);
		ticket.setPlays(playsObj);
		ticket.setSuperStarNumbers(superStarObj);
		ticket.setValidityDuration(validityDuration);
		ticket.setTicketId(getNextTicketId());
		
		// Save objects to XML file
		this.lotteryTicketsRoot.getLotteryTicket().add(ticket);
		this.saveFile();
	}

	private void loadSavedTickets() throws JAXBException {
		if (outputFile.length() < 1)
			this.lotteryTicketsRoot = objFact.createLotteryTickets();
		else
			// Unmarshal the file
			this.lotteryTicketsRoot = (LotteryTickets) unmarshaller.unmarshal(this.outputFile);
	}

	private void saveFile() throws JAXBException {
		this.removeOldTickets();
		// Marshal the file
		this.marshaller.marshal(this.lotteryTicketsRoot, this.outputFile);
	}

	
	// TODO: improve so that multiple drawings are supported
	private void removeOldTickets() {
		if (this.lotteryTicketsRoot == null || LottoMachine.isFirstDrawing())
			return;

		List<LotteryTicket> tickets = lotteryTicketsRoot.getLotteryTicket();

		this.lotteryTicketsRoot = new LotteryTickets();

		for (int i = 0; i < tickets.size(); i++) {
			XMLGregorianCalendar ticketDateXML = tickets.get(i).getFirstDrawingDate();
			Date ticketDrawDate = ticketDateXML.toGregorianCalendar().getTime();

			// TODO: check if it works
			if (ticketDrawDate.before(LottoMachine.getLastDrawingDate())) {
				tickets.remove(i);
				System.out.println("-> Removed ticket at pos" + i);
			} else {
				this.lotteryTicketsRoot.getLotteryTicket().add(tickets.get(i));
			}
		}
	}
	
	private static ArrayList<Integer> toList (int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<array.length; i++)
			list.add(new Integer(array[i]));
		return list;
	}
	
	private int getNextTicketId () {
		this.lastTicketId++;
		return this.lastTicketId;
	}

}
