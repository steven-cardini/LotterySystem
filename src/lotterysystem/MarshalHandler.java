package lotterysystem;

import jaxb_lotterytypes.*;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshalHandler {
	
	private LotteryTickets lotteryTickets;
	private File outputFile;
	private Marshaller marshaller;
	
	public MarshalHandler (File outputFile) throws JAXBException, IOException {
		//Package
		JAXBContext jc = JAXBContext.newInstance("jaxb_lotterytypes");
		this.marshaller = jc.createMarshaller();
		this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		this.outputFile=outputFile;
		if (!outputFile.exists()) 
			outputFile.createNewFile();
		
		this.lotteryTickets = new LotteryTickets();	
	}
	
	public File getOutputFile () {
		return this.outputFile;
	}
	
	
	public void setOutputFile (File f) {
		this.outputFile=f;
	}
	
	public void addTicket (LotteryTicket ticket) throws JAXBException {
		this.lotteryTickets.getLotteryTicket().add(ticket);
		this.saveFile();
	}
	
	private void saveFile () throws JAXBException {
		//Marshall the file
		this.marshaller.marshal(this.lotteryTickets, this.outputFile);
	}
	
}
