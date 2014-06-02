package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label langEN;

    @FXML
    private ChoiceBox<String> listValidityDuration;

    @FXML
    private Label langDE;
    
    @FXML
    private Label message;

    public Controller () {
    }
    
    @FXML
    void langSwitchEnglish(ActionEvent event) {
    	System.out.println("eng");
    }

    @FXML
    void langSwitchGerman(ActionEvent event) {
    	System.out.println("ger");
    }

    @FXML
    void initialize() {
        assert message != null : "fx:id=\"message\" was not injected: check your FXML file 'Main.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        assert message != null : "fx:id=\"message\" was not injected: check your FXML file 'Main.fxml'.";
		
	}
}
