package gui;
	
import java.util.Locale;
import java.util.ResourceBundle;

import gui.Main;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Locale locale = new Locale("en","US");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane root = (FlowPane)FXMLLoader.load(getClass().getResource("Main.fxml"), ResourceBundle.getBundle("messages", locale));	
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("EuroMillions");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
