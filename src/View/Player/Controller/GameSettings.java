/**
 * Sample Skeleton for 'Check.fxml' Controller Class
 */

package View.Player.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.jar.Attributes.Name;

import Controller.iWindow;
import Entity.Answer;
import Entity.MonDB;
import Entity.Question;
import Utils.Param;
import Utils.QuestionStrength;
import Utils.QuestionTag;
import Utils.Window;
import View.IManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;

public class GameSettings {

	private IManagement mng = iWindow.getManagement();

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	private Label txt2Err;

	@FXML
	private Label txt3Err;

    @FXML
    private ImageView ErrMessage;

	@FXML
	private Label txt4Err;

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
	    private Spinner<Integer> txtInitialSumOFMoney; // Value injected by FXMLLoader

	    @FXML // fx:id="txtBankrupt"
	    private Spinner<Integer> txtBankrupt; // Value injected by FXMLLoader

	    @FXML // fx:id="txtPaymentRelaseFromJail"
	    private Spinner<Integer> txtPaymentRelaseFromJail; // Value injected by FXMLLoader
	

	@FXML
	void back(ActionEvent event) {
		iWindow.swap(Window.Player_Menu);
	}
	

	// For generic checks
	private List<TextField> txtfields = new ArrayList<>();
		
	@FXML
	void check1(MouseEvent event) {

		Integer res = Integer.valueOf((int) slide1.getValue());
		ErrMessage.setVisible(false);
		txt2Err.setVisible(false);
		switch (res) {

		case 2:
			txt1.setVisible(true);
			label1.setVisible(true);
			img1.setVisible(true);

			txt2.setVisible(true);
			label2.setVisible(true);
			img2.setVisible(true);
			txt2Err.setVisible(false);

			txt3.setVisible(false);
			label3.setVisible(false);
			img3.setVisible(false);
			txt3Err.setVisible(false);

			txt4.setVisible(false);
			label4.setVisible(false);
			img4.setVisible(false);
			txt4Err.setVisible(false);
			break;

		case 3:
			txt1.setVisible(true);
			label1.setVisible(true);
			img1.setVisible(true);
			txt3Err.setVisible(false);
			txt2Err.setVisible(false);
			txt4Err.setVisible(false);

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
			label1.setVisible(true);
			img1.setVisible(true);
			txt3Err.setVisible(false);
			txt2Err.setVisible(false);
			txt4Err.setVisible(false);

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
	void CheckRight(SwipeEvent event) {

	}

	@FXML
	void check2(MouseEvent event) {

	}

	@FXML
	void doSwapMusic(MouseEvent event) {

	}

	@FXML
	void hidelabel1(MouseEvent event) {

	}

	@FXML
	void hidelabel2(MouseEvent event) {

	}

	@FXML
	void hidelabel3(MouseEvent event) {

	}

	@FXML
	void hidelabel4(MouseEvent event) {

	}

	@FXML
	void hidetextfield1(ActionEvent event) {

	}

	@FXML
	void hidetextfield2(ActionEvent event) {

	}

	@FXML
	void hidetextfield3(ActionEvent event) {

	}

	@FXML
	void hidetextfield4(ActionEvent event) {

	}

	@FXML
	void openBoard(ActionEvent event) {

		Integer res = Integer.valueOf((int) slide1.getValue());


		List<String> playerList = new ArrayList<String>();
		// Add first player which is logged in

		playerList.add(mng.getLoggedPlayer());

		// Add second player - MUST
		for (TextField box : txtfields) {
			if (!box.getText().isEmpty()) {
				playerList.add(box.getText());
			}
		}

		if (playerList.size() != res) {
			// There is a problem
			// print a problem
			
			ErrMessage.setVisible(true);
			txt2Err.setVisible(true);
			
		} else {
			mng.build(playerList);
			iWindow.swap(Window.Game_UI);
		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Check.fxml'.";
		assert slide1 != null : "fx:id=\"slide1\" was not injected: check your FXML file 'Check.fxml'.";
		assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'Check.fxml'.";
		assert img1 != null : "fx:id=\"img1\" was not injected: check your FXML file 'Check.fxml'.";
		assert img11 != null : "fx:id=\"img11\" was not injected: check your FXML file 'Check.fxml'.";
		assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'Check.fxml'.";
		assert label3 != null : "fx:id=\"label3\" was not injected: check your FXML file 'Check.fxml'.";
		assert img3 != null : "fx:id=\"img3\" was not injected: check your FXML file 'Check.fxml'.";
		assert txt3 != null : "fx:id=\"txt3\" was not injected: check your FXML file 'Check.fxml'.";
		assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'Check.fxml'.";
		assert img2 != null : "fx:id=\"img2\" was not injected: check your FXML file 'Check.fxml'.";
		assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'Check.fxml'.";
		assert label4 != null : "fx:id=\"label4\" was not injected: check your FXML file 'Check.fxml'.";
		assert img4 != null : "fx:id=\"img4\" was not injected: check your FXML file 'Check.fxml'.";
		assert txt4 != null : "fx:id=\"txt4\" was not injected: check your FXML file 'Check.fxml'.";

		txtfields.add(txt2);
		txtfields.add(txt3);
		txtfields.add(txt4);
		
		ErrMessage.setVisible(false);
		
		txt3.setVisible(false);
		label3.setVisible(false);
		txt4.setVisible(false);
		label4.setVisible(false);

		img3.setVisible(false);
		img4.setVisible(false);

		txt2Err.setVisible(false);
		txt3Err.setVisible(false);
		txt4Err.setVisible(false);
		
		
		
		

		txt1.setText(mng.getLoggedPlayer());
		txt1.setDisable(true);
		
	}
    
	

}
