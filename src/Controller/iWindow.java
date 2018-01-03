package Controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import Entity.MonDB;
import Utils.Window;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class iWindow {

	private static Stage currentStage;
	private static Scene currentScene;
	private static FXMLLoader currentLoader;

	/**
	 * This method takes window and sets it as the current windows for user
	 *
	 * @param primaryStage
	 * @param toOpen
	 */
	public static void swap(Stage primaryStage, Window toOpen) {
		if (currentStage != null)
			currentStage.close();
		Platform.setImplicitExit(false);
		currentStage = primaryStage;
		currentStage.initStyle(StageStyle.UNDECORATED);
		swap(toOpen);
		currentStage.show();
		currentScene.getWindow().centerOnScreen();

		currentStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close iShark Monopoly?",
						"Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Logger.log("Received closing request..");
					MonDB.getInstance().closeGame();
					System.exit(0);

				}

			}
		});
	}

	/**
	 * This method takes window and sets it as the current windows for user
	 *
	 * @param toOpen
	 */
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
			e.printStackTrace();
			Logger.log("Couldn't get file: " + iWindow.class.getResource("/View/" + toOpen + ".fxml"), true);
			System.exit(0);
		}

		/**
		 * Fade in the new window
		 */
		FadeTransition ft = new FadeTransition(Duration.millis(300), root);
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

		currentScene.getWindow().centerOnScreen();
	}

	public static Management getManagement() {
		return Management.getInstance();
	}

	public static GameEngine getGameEngine() {
		return GameEngine.getInstance();
	}
}
