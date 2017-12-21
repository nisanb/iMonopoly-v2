/**
 * Sample Skeleton for 'Check.fxml' Controller Class
 */

package View.Player.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Utils.Param;
import Utils.Window;
import View.IManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameSettings {

	// ========================================== FX COMPONENTS
	// ================================================

	private ResourceBundle resources;

	@FXML
	private Label txt2Err;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="btnVolume"
	private ImageView btnVolume; // Value injected by FXMLLoader

	@FXML // fx:id="slide1"
	private Slider slide1; // Value injected by FXMLLoader

	@FXML // fx:id="label1"
	private Label label1; // Value injected by FXMLLoader

	@FXML // fx:id="img1"
	private ImageView img1; // Value injected by FXMLLoader

	@FXML // fx:id="img11"
	private ImageView img11; // Value injected by FXMLLoader

	@FXML // fx:id="txt1"
	private TextField txt1; // Value injected by FXMLLoader

	@FXML // fx:id="label3"
	private Label label3; // Value injected by FXMLLoader

	@FXML // fx:id="img3"
	private ImageView img3; // Value injected by FXMLLoader

	@FXML // fx:id="txt3"
	private TextField txt3; // Value injected by FXMLLoader

	@FXML // fx:id="label2"
	private Label label2; // Value injected by FXMLLoader

	@FXML // fx:id="img2"
	private ImageView img2; // Value injected by FXMLLoader

	@FXML // fx:id="txt2"
	private TextField txt2; // Value injected by FXMLLoader

	@FXML // fx:id="label4"
	private Label label4; // Value injected by FXMLLoader

	@FXML // fx:id="img4"
	private ImageView img4; // Value injected by FXMLLoader

	@FXML // fx:id="txt4"
	private TextField txt4; // Value injected by FXMLLoader

	@FXML // fx:id="txtNumOfRounds"
	private Spinner<Integer> txtNumOfRounds; // Value injected by FXMLLoader

	@FXML // fx:id="txtInitialSumOFMoney"
	private Spinner<Double> txtInitialSumOFMoney; // Value injected by
													// FXMLLoader

	@FXML // fx:id="txtBankrupt"
	private Spinner<Integer> txtBankrupt; // Value injected by FXMLLoader

	@FXML // fx:id="txtPaymentRelaseFromJail"
	private Spinner<Integer> txtPaymentRelaseFromJail; // Value injected by
														// FXMLLoader

	// LOCAL VARIABLES
	private IManagement _mng = iWindow.getManagement();

	// For generic checks
	private List<TextField> txtfields = new ArrayList<>();

	/**
	 * Initialize fxml page
	 */
	@FXML
	void initialize() {

		// nickNamesValid.setVisible(false);
		txtfields.add(txt2);
		txtfields.add(txt3);
		txtfields.add(txt4);

		// reset visibility
		txt3.setVisible(false);
		label3.setVisible(false);
		txt4.setVisible(false);
		label4.setVisible(false);
		img3.setVisible(false);
		img4.setVisible(false);

		// auto set logged in user
		txt1.setText(_mng.getLoggedPlayer());
		txt1.setDisable(true);

		// get game params
		txtBankrupt.getValueFactory().setValue((Integer) _mng.getParam(Param.BANKRUPTCY));
		Logger.log("Aquired param money: "+_mng.getParam(Param.STARTING_CASH));
		Double initialMoney = 0.0;
		try{
		initialMoney = (Double)_mng.getParam(Param.STARTING_CASH);
		}
		catch(Exception e){
			Logger.log("Couldn't get money!");
		}
		txtInitialSumOFMoney.getValueFactory().setValue(initialMoney);
		txtNumOfRounds.getValueFactory().setValue((Integer) _mng.getParam(Param.MAX_ROUNDS));
		txtPaymentRelaseFromJail.getValueFactory().setValue((Integer) _mng.getParam(Param.RELEASE_FROM_JAIL));

		// reset errors
		errorLabelControl(null, false);
	}

	// ====================================== ACTION EVENTS
	// ====================================================

	/**
	 * This method send the user back to pervious form
	 * 
	 * @param event
	 */
	@FXML
	void back(ActionEvent event) {
		iWindow.swap(Window.Player_Menu);
	}

	@FXML
	void check1(MouseEvent event) {

		Integer res = Integer.valueOf((int) slide1.getValue());
		txt2Err.setVisible(false);

		// this condition gets how many users are going to participate in the
		// game and get input accordingly
		switch (res) {

		case 2:
			txt1.setVisible(true);
			label1.setVisible(true);
			img1.setVisible(true);
			txt3.clear();
			txt4.clear();

			txt2.setVisible(true);
			label2.setVisible(true);
			img2.setVisible(true);
			txt2Err.setVisible(false);
			/* nickNamesValid.setVisible(false); */

			txt3.setVisible(false);
			label3.setVisible(false);
			img3.setVisible(false);

			txt4.setVisible(false);
			label4.setVisible(false);
			img4.setVisible(false);

			break;

		case 3:
			txt1.setVisible(true);
			label1.setVisible(true);
			img1.setVisible(true);

			txt2Err.setVisible(false);

			/* nickNamesValid.setVisible(false); */
			txt2.clear();
			txt4.clear();

			txt2.setVisible(true);
			label2.setVisible(true);
			img2.setVisible(true);

			txt3.setVisible(true);
			label3.setVisible(true);
			img3.setVisible(true);

			txt4.setVisible(false);
			label4.setVisible(false);
			img4.setVisible(false);
			break;

		case 4:
			txt1.setVisible(true);
			/* nickNamesValid.setVisible(false); */

			label1.setVisible(true);
			img1.setVisible(true);

			txt2Err.setVisible(false);

			txt3.clear();
			txt4.clear();
			txt2.clear();

			txt2.setVisible(true);
			label2.setVisible(true);
			img2.setVisible(true);

			txt3.setVisible(true);
			label3.setVisible(true);
			img3.setVisible(true);

			txt4.setVisible(true);
			label4.setVisible(true);
			img4.setVisible(true);
			break;
		}

	}

	@FXML
	void doSwapMusic(MouseEvent event) {

	}

	/**
	 * This methods opens the game boared with user's input Setting the game
	 * temporary params and starts build process
	 * 
	 * @param event
	 */
	@FXML
	void openBoard(ActionEvent event) {

		// Get number of players for this game
		Integer res = Integer.valueOf((int) slide1.getValue());

		// Sets the temporary game params
		Map<Param, Object> paramList = new HashMap<>();
		paramList.put(Param.MAX_ROUNDS, txtNumOfRounds.getValue());
		paramList.put(Param.STARTING_CASH, txtInitialSumOFMoney.getValue());
		paramList.put(Param.BANKRUPTCY, txtBankrupt.getValue());
		paramList.put(Param.RELEASE_FROM_JAIL, txtPaymentRelaseFromJail.getValue());

		/*
		 * Sets players to connect game
		 */
		List<String> playerList = new ArrayList<String>();
		// Add first player which is logged in
		playerList.add(_mng.getLoggedPlayer());
		// Add second player - MUST
		for (TextField box : txtfields) {
			if (!box.getText().isEmpty()) {
				playerList.add(box.getText());
			} else {
				settxtBGC(box, "red");
			}
		}
		if (playerList.size() != res) {
			// There is a problem//
			errorLabelControl("You must fill the empty fields ", true);
			return;
		}

		if (duplicates(playerList)) {
			errorLabelControl("Unable to register with the same nickname", true);
			return;
		}

		_mng.build(playerList, paramList);
		Music.getInstance().stop("theme.mp3");
		
		Music.getInstance().swap("ui_1.mp3");
		
		iWindow.swap(Window.Game_UI);
	}

	// ============================================== METHODS
	// =================================================//

	/**
	 * This helper method prevent from user to set more than one player with the
	 * same name
	 * 
	 * @param playerList
	 * @return
	 */
	private boolean duplicates(final List<String> playerList) {
		Set<String> dup = new HashSet<String>();
		for (String i : playerList) {
			if (dup.contains(i))
				return true;
			dup.add(i);
		}
		return false;
	}

	/**
	 * This method controls the error message label
	 * 
	 * @param msg
	 *            to present to user
	 * @param visiblity
	 *            of the label
	 */
	private void errorLabelControl(String msg, boolean visiblity) {
		this.txt2Err.setVisible(visiblity);
		if (msg == null) {
			this.txt2Err.setText(" ");
		} else {
			this.txt2Err.setText("Error: " + msg);
			System.out.println(msg);
		}
	}

	// ============================================== CSS
	// ======================================================

	private void settxtBGC(TextField tf, String color) {
		tf.setStyle("-fx-background-color:" + color + ";");
	}

}
