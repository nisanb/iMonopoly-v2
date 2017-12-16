package Controller;

import Entity.MonDB;
import Utils.Window;
import javafx.application.Application;
import javafx.stage.Stage;

public class Monopoly extends Application {

	Music gameMusic = Music.getInstance();

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Initiate Log File
		Logger.initializeMyFileWriter();

		// Initiate Monopoly
		Logger.log("Initializing Monopoly");
		/**
		 * Override
		 */
		//iWindow.swap(primaryStage, Window.Player_GameSettings);
		iWindow.swap(primaryStage, Window.Login);
		gameMusic.play("theme.mp3");
		gameMusic.changeVolume("theme.mp3", 5.0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
