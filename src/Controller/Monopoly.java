package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Monopoly extends Application{

	public void start(Stage primaryStage) throws Exception {
		
		//Initiate Log File
		Logger.initializeMyFileWriter();
		
		//Initiate Monopoly
		Logger.log("Initializing Monopoly");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	


}
