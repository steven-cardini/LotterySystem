package lotterysystem;

import jaxb_lotterytypes.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshalHandler {
	
	private LotteryTickets lotteryTickets;
	private File inputFile;
	private Unmarshaller unmarshaller;
	
	public UnmarshalHandler (File inputFile) throws JAXBException {
		//Package
		JAXBContext jc = JAXBContext.newInstance("jaxb_lotterytypes");
		this.unmarshaller = jc.createUnmarshaller();
		
		this.inputFile=inputFile;
	}
	
	public File getInputFile () {
		return this.inputFile;
	}
	
	public void setInputFile (File inputFile) {
		this.inputFile=inputFile;
	}
	
	private void loadFile () throws JAXBException {
		this.lotteryTickets = (LotteryTickets) unmarshaller.unmarshal(this.inputFile);
	}
}
