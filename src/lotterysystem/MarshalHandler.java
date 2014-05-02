package lotterysystem;

import jaxb_lotterytypes.*;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshalHandler {
	
	private LotteryTickets lotteryTickets;
	private File outputFile;
	private Marshaller marshaller;
	
	public MarshalHandler (File outputFile) throws JAXBException {
		//Package
		JAXBContext jc = JAXBContext.newInstance("jaxb_lotterytypes");
		this.marshaller = jc.createMarshaller();
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		this.outputFile=outputFile;
		this.lotteryTickets = new LotteryTickets();	
	}
	
	public File getOutputFile () {
		return this.outputFile;
	}
	
	
	public void setOutputFile (File f) {
		this.outputFile=f;
	}
	
	public void addTicket (LotteryTicketType ticket) {
		this.lotteryTickets.getLotteryTicket().add(ticket);
	}
	
	private void saveFile () throws JAXBException {
		//Marshall the file
		this.marshaller.marshal(this.lotteryTickets, this.outputFile);
	}
	
}
