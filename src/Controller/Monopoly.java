package Controller;

import Utils.Window;
import javafx.application.Application;
import javafx.stage.Stage;

public class Monopoly extends Application {

	Music gameMusic = Music.getInstance();

	public void start(Stage primaryStage) throws Exception {

		// Initiate Log File
		Logger.initializeMyFileWriter();

		// Initiate Monopoly
		Logger.log("Initializing Monopoly");
		iWindow.swap(primaryStage, Window.Game_UI);
		gameMusic.play("theme.mp3");
		gameMusic.changeVolume("theme.mp3", 50.0);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
