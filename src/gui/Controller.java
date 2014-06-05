package gui;

import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import lotterysystem.LanguageHandler;
import lotterysystem.LottoMachine;
import lotterysystem.MarshalHandler;
import lotterysystem.LanguageHandler.Language;
import lotterysystem.NumberOutOfRangeException;

public class Controller implements Initializable {

	@SuppressWarnings("unused")
	private URL location;

	@FXML
	private Label langEN;

	@FXML
	private Label langDE;

	@FXML
	private Label labelNextDrawingDate;

	@FXML
	private TextField fieldMainNumber0;

	@FXML
	private TextField fieldMainNumber1;

	@FXML
	private TextField fieldMainNumber2;

	@FXML
	private TextField fieldMainNumber3;

	@FXML
	private TextField fieldMainNumber4;

	@FXML
	private TextField fieldStarNumber0;

	@FXML
	private TextField fieldStarNumber1;

	@FXML
	private CheckBox superStar1;

	@FXML
	private CheckBox superStar2;

	@FXML
	private CheckBox superStar3;

	@FXML
	private ChoiceBox<String> listValidityDuration;

	@FXML
	private Button buttonBuyTicket;

	@FXML
	private Label message;

	private MarshalHandler marshalHandler;
	private Locale locale;
	private LanguageHandler languageHandler;
	ObservableList<String> validityList = FXCollections.observableArrayList(
			"1", "2", "4", "6", "8", "10");

	@FXML
	void langSwitchEnglish(MouseEvent event) {
		this.languageHandler.setLanguage(Language.ENGLISH);
		System.out.println("eng");
	}

	@FXML
	void langSwitchGerman(MouseEvent event) {
		this.languageHandler.setLanguage(Language.GERMAN);
		System.out.println("ger");
	}
	
	//TODO: support multiple super stars!
	@FXML
	void actionBuyTicket(ActionEvent event) {
		int validityDuration;
		int[] mainNumbers;
		int[] starNumbers;
		String[] superStars;
		
		try {
			validityDuration = Integer.parseInt(listValidityDuration.getValue());
		} catch (NumberFormatException e) {
			printError("Choose a validity duration!");
			return;
		}
		
		try {
			mainNumbers = this.parseMainNumbers();
			starNumbers = this.parseStarNumbers();
		} catch (NumberFormatException e) {
			printError("Only numbers accepted!");
			return;
		} catch (NumberOutOfRangeException e) {
			printError ("One or more number(s) out of range!");
			return;
		}
		
		superStars = this.getSuperStars();
		
		try {
			marshalHandler.addTicket(validityDuration, mainNumbers, starNumbers, superStars);
		} catch (Exception e) {
			printError("Error in persistence!");
			return;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.location = location;
		this.locale = resources.getLocale();
		this.languageHandler = new LanguageHandler(resources);

		try {
			this.marshalHandler = new MarshalHandler();
		} catch (Exception e) {
			printError("An error ocurred setting up the XML File!");
		}

		try {
			LottoMachine.initialize();
		} catch (Exception e) {
			printError("An error occurred upon initialization of the Lotto Machine");
		}

		String nextDrawingDate = LanguageHandler.formatDate(
				LottoMachine.getNextDrawingDate(), this.locale);
		labelNextDrawingDate.setText(nextDrawingDate);
		superStar1.setText(LottoMachine.generateSuperStar());
		superStar2.setText(LottoMachine.generateSuperStar());
		superStar3.setText(LottoMachine.generateSuperStar());
		listValidityDuration.setItems(validityList);
		resources = ResourceBundle.getBundle("messages", new Locale("de"));
	}

	private void printError(String errorMessage) {
		Paint paint = Color.rgb(255, 10, 10);
		message.setTextFill(paint);
		message.setText(errorMessage);
	}

	private int[] parseMainNumbers() throws NumberFormatException, NumberOutOfRangeException {
		int[] mainNumbers = { 	Integer.parseInt(fieldMainNumber0.getText()),
								Integer.parseInt(fieldMainNumber1.getText()),
								Integer.parseInt(fieldMainNumber2.getText()),
								Integer.parseInt(fieldMainNumber3.getText()),
								Integer.parseInt(fieldMainNumber4.getText()) };
		
		for (int i=0; i<mainNumbers.length; i++) {
			if (mainNumbers[i]<LottoMachine.getMinMainNumber() || mainNumbers[i]>LottoMachine.getMaxMainNumber())
				throw new NumberOutOfRangeException();
		}
		
		return mainNumbers;
	}
	
	private int[] parseStarNumbers() throws NumberFormatException, NumberOutOfRangeException {
		int[] starNumbers = { 	Integer.parseInt(fieldStarNumber0.getText()),
								Integer.parseInt(fieldStarNumber1.getText()) };
		
		for (int i=0; i<starNumbers.length; i++) {
			if (starNumbers[i]<LottoMachine.getMinStarNumber() || starNumbers[i]>LottoMachine.getMaxStarNumber())
				throw new NumberOutOfRangeException();
		}
		
		return starNumbers;
	}
	
	private String[] getSuperStars() {
		String[] superStars = new String[3];
		int counter=0;
		if (superStar1.isSelected()) {
			superStars[counter] = superStar1.getText();
			counter++;
		}
		if (superStar2.isSelected()) {
			superStars[counter] = superStar2.getText();
			counter++;
		}
		if (superStar3.isSelected()) {
			superStars[counter] = superStar3.getText();
			counter++;
		}
		
		return superStars;
	}

}
