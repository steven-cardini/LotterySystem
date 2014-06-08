package gui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

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
	
	private static final int SIMULATION_NUMBER = 1000;
	
	// Tab 1
	
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
	private CheckBox superStar4;

	@FXML
	private ChoiceBox<String> listValidityDuration;

	@FXML
	private Button buttonBuyTicket;
	
	// Tab 2
	
	@FXML
    private Label langEN2;
	
	@FXML
    private Label langDE2;
	
	@FXML
	private Label labelCurrentDrawingDate;
	
	@FXML
    private Label labelWinningNumbers;
	
	@FXML
    private Label labelWinningSuperStar;
	
	@FXML
    private Label labelNumberRank0;
	
	@FXML
    private Label labelNumberRank1;
	
	@FXML
    private Label labelNumberRank2;
	
	@FXML
    private Label labelNumberRank3;
	
	@FXML
    private Label labelNumberRank4;
	
	@FXML
    private Label labelNumberRank5;
	
	@FXML
    private Label labelNumberRank6;
	
	@FXML
    private Label labelNumberRank7;
	
	@FXML
    private Label labelNumberRank8;
	
	@FXML
    private Label labelNumberRank9;
	
	@FXML
    private Label labelNumberRank10;
	
	@FXML
    private Label labelNumberRank11;
	
	@FXML
    private Label labelNumberRank12;
	
	@FXML
    private Label labelSuperStarRank1;
	
	@FXML
    private Label labelSuperStarRank2;
	
	@FXML
    private Label labelSuperStarRank3;
	
	@FXML
    private Label labelSuperStarRank4;
	
	@FXML
    private Label labelSuperStarRank5;
	
	@FXML
    private Label labelSuperStarRank6;
	
	@FXML
    private Label labelSuperStarRank7;
	
	@FXML
    private Label labelSuperStarRank8;
	
	@FXML
    private Label labelSuperStarRank9;
	
    @FXML
    private Button buttonSimulateBuys;

    @FXML
    private Button buttonDrawNumbers;
    
    
	@FXML
	private Label message;
	
	ObservableList<String> validityList = FXCollections.observableArrayList("1", "2", "4", "6", "8", "10");

	private MarshalHandler marshalHandler;
	private LanguageHandler languageHandler = new LanguageHandler (Main.getInstance().getLanguage());
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			this.marshalHandler = new MarshalHandler();
		} catch (Exception e) {
			printError("xml_initial_error");
		}

		try {
			LottoMachine.initialize();
		} catch (Exception e) {
			printError("lotto_machine_error");
		}
		
		String nextDrawingDate = languageHandler.formatDate(LottoMachine.getNextDrawingDate());
		labelNextDrawingDate.setText(nextDrawingDate);
		superStar1.setText(LottoMachine.generateSuperStar());
		superStar2.setText(LottoMachine.generateSuperStar());
		superStar3.setText(LottoMachine.generateSuperStar());
		superStar4.setText(LottoMachine.generateSuperStar());
		listValidityDuration.setItems(validityList);
		
		if (LottoMachine.isFirstDrawing()) {
			labelCurrentDrawingDate.setText(languageHandler.getMessage("no_drawing_yet"));
			labelWinningNumbers.setText(languageHandler.getMessage("no_drawing_yet"));
			labelWinningSuperStar.setText(languageHandler.getMessage("no_drawing_yet"));
		} else {
			labelCurrentDrawingDate.setText(languageHandler.formatDate(LottoMachine.getLastDrawingDate()));
			int[] mainNumbers = LottoMachine.getWinningMainNumbers();
			int[] starNumbers = LottoMachine.getWinningStarNumbers();
			String winningNumbers = LottoMachine.formatNumbers(mainNumbers) + "  |  " + LottoMachine.formatNumbers(starNumbers);
			String superStar = LottoMachine.getWinningSuperStar();
			labelWinningNumbers.setText(winningNumbers);
			
			labelWinningSuperStar.setText(superStar);
			
			int[] numberWinners = LottoMachine.getResults().getWinnersPerNumberRank();
			labelNumberRank0.setText(Integer.toString(numberWinners[0]));
			labelNumberRank1.setText(Integer.toString(numberWinners[1]));
			labelNumberRank2.setText(Integer.toString(numberWinners[2]));
			labelNumberRank3.setText(Integer.toString(numberWinners[3]));
			labelNumberRank4.setText(Integer.toString(numberWinners[4]));
			labelNumberRank5.setText(Integer.toString(numberWinners[5]));
			labelNumberRank6.setText(Integer.toString(numberWinners[6]));
			labelNumberRank7.setText(Integer.toString(numberWinners[7]));
			labelNumberRank8.setText(Integer.toString(numberWinners[8]));
			labelNumberRank9.setText(Integer.toString(numberWinners[9]));
			labelNumberRank10.setText(Integer.toString(numberWinners[10]));
			labelNumberRank11.setText(Integer.toString(numberWinners[11]));
			labelNumberRank12.setText(Integer.toString(numberWinners[12]));
			
			int[] superStarWinners = LottoMachine.getResults().getWinnersPerSuperStarRank();
			labelSuperStarRank9.setText(Integer.toString(superStarWinners[0]));
			labelSuperStarRank8.setText(Integer.toString(superStarWinners[1]));
			labelSuperStarRank7.setText(Integer.toString(superStarWinners[2]));
			labelSuperStarRank6.setText(Integer.toString(superStarWinners[3]));
			labelSuperStarRank5.setText(Integer.toString(superStarWinners[4]));
			labelSuperStarRank4.setText(Integer.toString(superStarWinners[5]));
			labelSuperStarRank3.setText(Integer.toString(superStarWinners[6]));
			labelSuperStarRank2.setText(Integer.toString(superStarWinners[7]));
			labelSuperStarRank1.setText(Integer.toString(superStarWinners[8]));
}
		
		
	}
	

	@FXML
	void langSwitchEnglish(MouseEvent event) {
		languageHandler.setLanguage(Language.ENGLISH);
	}

	@FXML
	void langSwitchGerman(MouseEvent event) {
		languageHandler.setLanguage(Language.GERMAN);
	}
	
	@FXML
	void actionBuyTicket(ActionEvent event) {
		int validityDuration;
		int[] mainNumbers;
		int[] starNumbers;
		String[] superStars;
		
		try {
			validityDuration = Integer.parseInt(listValidityDuration.getValue());
		} catch (NumberFormatException e) {
			printError("no_validity_duration");
			return;
		}
		
		try {
			mainNumbers = this.parseMainNumbers();
			starNumbers = this.parseStarNumbers();
		} catch (NumberFormatException e) {
			printError("only_numbers_accepted");
			return;
		} catch (NumberOutOfRangeException e) {
			printError ("numbers_out_of_range");
			return;
		}
		
		superStars = this.getSuperStars();
		
		try {
			marshalHandler.addTicket(validityDuration, mainNumbers, starNumbers, superStars);
		} catch (Exception e) {
			printError("xml_save_error");
			return;
		}
		
		printSuccess("successful_buy");
	}
	
    @FXML
    void actionSimulateBuys(ActionEvent event) {
    	
    	printSuccess("creating_random");
    	
    	Random rand = new Random();
    	
    	int[] validityDurations = new int [validityList.size()];
    	for (int i=0; i<validityList.size(); i++)
    		validityDurations[i] = Integer.parseInt(validityList.get(i));
    	
    	int validityDuration=0;
    	int[] mainNumbers = null;
    	int[] starNumbers = null;
    	int amountSuperStars=0;
    	String[] superStars = null;
    	
    	for (int i=0; i<SIMULATION_NUMBER; i++) {
    		validityDuration = validityDurations[rand.nextInt(validityDurations.length)];
    		mainNumbers = LottoMachine.getRandomNumbers(LottoMachine.getAmountMainNumbers(), LottoMachine.getMinMainNumber(), LottoMachine.getMaxMainNumber());
    		starNumbers = LottoMachine.getRandomNumbers(LottoMachine.getAmountStarNumber(), LottoMachine.getMinStarNumber(), LottoMachine.getMaxStarNumber());
    		amountSuperStars = rand.nextInt(4)+1;
    		superStars = new String[amountSuperStars];
    		for (int j=0; j<amountSuperStars; j++)
    			superStars[j] = LottoMachine.generateSuperStar();
    		
    		try {
    			marshalHandler.addTicket(validityDuration, mainNumbers, starNumbers, superStars);
    		} catch (Exception e) {
    			printError("xml_save_error");
    			return;
    		}
    	}
    	
		printSuccess("successful_random");
    	
    }
    
    //TODO: implement
    @FXML
    void actionDrawNumbers(ActionEvent event) {
    	try {
			LottoMachine.draw(marshalHandler.getLotteryTickets());
			Main.getInstance().reload();
		} catch (Exception e) {
			printError("unknown_error");		
		}
    }

	private void printError(String errorMessageKey) {
		Paint paint = Color.rgb(255, 10, 10);
		message.setTextFill(paint);
		message.setText(languageHandler.getMessage(errorMessageKey));
	}
	
	private void printSuccess(String successMessageKey) {
		Paint paint = Color.rgb(5, 140, 5);
		message.setTextFill(paint);
		message.setText(languageHandler.getMessage(successMessageKey));
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
		if (superStar4.isSelected()) {
			superStars[counter] = superStar4.getText();
			counter++;
		}
		
		return superStars;
	}
}
