package lotterysystem;

import jaxb_lotterytypes.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.datatype.XMLGregorianCalendar;

public class MarshalHandler {
	
	private LotteryTickets lotteryTicketsRoot;
	private File outputFile;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public MarshalHandler (File outputFile) throws JAXBException, IOException {
		//Package
		JAXBContext jc = JAXBContext.newInstance("jaxb_lotterytypes");
		this.unmarshaller = jc.createUnmarshaller();
		this.marshaller = jc.createMarshaller();
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		this.outputFile=outputFile;
		if (!outputFile.exists()) 
			outputFile.createNewFile();
		
		this.loadSavedTickets();
	}
	
	public File getOutputFile () {
		return this.outputFile;
	}
	
	
	public void setOutputFile (File f) {
		this.outputFile=f;
	}
	
	public void addTicket (LotteryTicket ticket) throws JAXBException {
		this.lotteryTicketsRoot.getLotteryTicket().add(ticket);
		this.saveFile();
	}
	
	private void loadSavedTickets () throws JAXBException {
		if (outputFile.length()<1)
			this.lotteryTicketsRoot = new LotteryTickets();
		else
			//Unmarshal the file
			this.lotteryTicketsRoot = (LotteryTickets) unmarshaller.unmarshal(this.outputFile);
	}
	
	private void saveFile () throws JAXBException {
		this.removeOldTickets();
		//Marshal the file
		this.marshaller.marshal(this.lotteryTicketsRoot, this.outputFile);
	}
	
	//TODO: improve so that multiple drawings are supported
	private void removeOldTickets () {
		if (this.lotteryTicketsRoot == null)
			return;
		
		List<LotteryTicket> tickets = lotteryTicketsRoot.getLotteryTicket();
		
		this.lotteryTicketsRoot = new LotteryTickets();
		
		for (int i=0; i<tickets.size(); i++) {
			XMLGregorianCalendar ticketDateXML = tickets.get(i).getTicketDate();
			Date ticketDate = ticketDateXML.toGregorianCalendar().getTime();
			Date ticketDrawDate = LottoMachine.getNextDrawingDate(ticketDate);
			if (ticketDrawDate.before(new Date())) {
				tickets.remove(i);
				System.out.println("-> Removed ticket at pos" + i);
			} else {
				this.lotteryTicketsRoot.getLotteryTicket().add(tickets.get(i));
			}
		}		
	}
	
}
