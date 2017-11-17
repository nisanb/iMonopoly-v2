package Controller;

import java.io.IOException;

import Utils.Window;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class iWindow {

	private static Stage currentStage;
	private static Scene currentScene;
	private static FXMLLoader currentLoader;

	public static void swap(Stage primaryStage, Window toOpen) {
		currentStage = primaryStage;
		currentStage.initStyle(StageStyle.UNDECORATED);
		swap(toOpen);
		currentStage.show();
	}

	public static void swap(Window toOpen) {

		if (iWindow.currentScene != null) {
			/**
			 * Fade Out
			 */
			FadeTransition ft = new FadeTransition(Duration.millis(300), iWindow.currentScene.getRoot());
			ft.setFromValue(1.0);
			ft.setToValue(0.5);
			ft.play();
		}
		
		/**
		 * Start new window
		 */
		iWindow.currentLoader = new FXMLLoader(iWindow.class.getResource("/View/" + toOpen + ".fxml"));
		Parent root = null;
		try {
			root = iWindow.currentLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

		/**
		 * Fade in the new window
		 */
		FadeTransition ft = new FadeTransition(Duration.millis(300), (AnchorPane) root);
		ft.setFromValue(0.5);
		ft.setToValue(1.0);
		ft.play();
		iWindow.currentScene = new Scene(root);
		Logger.log(iWindow.class.getResource("/Resources/css/style.css").toExternalForm());
		iWindow.currentScene.getStylesheets()
				.add(iWindow.class.getResource("/Resources/css/style.css").toExternalForm());

		// primaryStage.initStyle(StageStyle.UNDECORATED);

		currentStage.setScene(currentScene);
		iWindow.currentStage.show();
	}

}
