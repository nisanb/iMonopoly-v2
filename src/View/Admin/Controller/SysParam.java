package View.Admin.Controller;

import Utils.*;
import View.IManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.iWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import Controller.Management;

public class SysParam {
	
	private Map<Spinner, Param> _params;
	private IManagement mng = null;
	

    @FXML
    private Button btnSave;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRestore;

    @FXML
    private Spinner<?> spinStartMoney;

    @FXML
    private Spinner<?> spinRent;

    @FXML
    private Spinner<?> spinBuy;

    @FXML
    private Spinner<?> spinMinLuck;

    @FXML
    private Spinner<?> spinMaxLuck;

    @FXML
    private Spinner<?> spinMedLuckFine;

    @FXML
    private Spinner<?> spinHardLuckFine;

    @FXML
    private Spinner<?> spinJailFine;

    @FXML
    private Spinner<?> spinEasyPrice;

    @FXML
    private Spinner<?> spinMedPrice;

    @FXML
    private Spinner<?> spinHardPrivce;

    @FXML
    private Spinner<?> spinEasyDisc;

    @FXML
    private Spinner<?> spinMedDisc;

    @FXML
    private Spinner<?> spinHardDisc;

    @FXML
    private Spinner<?> spinMaxRounds;

    @FXML
    private Spinner<?> spinBankruptcy;

    @FXML
    private Spinner<?> spinQMPlayerRight;

    @FXML
    private Spinner<?> spinQMWrongFine;

    @FXML
    private Label lblError;

    @FXML
    private Spinner<?> spinQMOtherRight;

    @FXML
    private Spinner<?> spinQMOnlyPlayerRight;
    
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    

    @FXML
    public void initialize() {
    	mng = iWindow.getManagement();
    	errorLabelControl(null, false);
    	addParamsToMap();
    	loadParams();
    }
       
    
    /**
     * This method adds params to map fot easy set
     */
    private void addParamsToMap() {
    	this._params = new HashMap<Spinner, Param>();
    	_params.put(spinStartMoney, Param.STARTING_CASH);
    	_params.put(spinRent, Param.RENT_PERCENT);
    	_params.put(spinBuy, Param.BUY_PERCENT);
    	_params.put(spinBankruptcy, Param.BANKRUPTCY);
    	_params.put(spinMedPrice, Param.PROPERTY_MINPRICE_MEDIUM);
    	_params.put(spinMedDisc, Param.PROPERTY_MEDIUM_DISCOUNT);
    	_params.put(spinEasyDisc, Param.PROPERTY_EASY_DISCOUNT);
    	_params.put(spinEasyPrice, Param.PROPERTY_MINPRICE_EASY);
    	_params.put(spinHardDisc, Param.PROPERTY_HARD_DISCOUNT);
    	_params.put(spinHardPrivce, Param.PROPERTY_MINPRICE_HARD);
    	_params.put(spinJailFine, Param.RELEASE_FROM_JAIL);
    	_params.put(spinMedLuckFine, Param.LUCK_MEDIUM_FAIL_FINE);
    	_params.put(spinMinLuck, Param.MIN_LUCK);
    	_params.put(spinMaxLuck, Param.MAX_LUCK);
    	_params.put(spinHardLuckFine, Param.LUCK_HARD_FAIL_FINE);
    	_params.put(spinMaxRounds, Param.MAX_ROUNDS);
    	_params.put(spinMinLuck, Param.MIN_LUCK);
    	_params.put(spinQMOnlyPlayerRight, Param.QM_ONLY_ONE_RIGHT);
    	_params.put(spinQMOtherRight, Param.QM_OTHER_PLAYER_RIGHT_ANSWER);
    	_params.put(spinQMPlayerRight, Param.QM_PLAYER_RIGHT_ANSWER);
    	_params.put(spinQMWrongFine, Param.QM_WRONG_ANSWER_FINE);

    }
    
    
    
    /**
     * This method load the saved params from monDB
     */
    private void loadParams() {
    	for (Map.Entry<Spinner, Param> temp : _params.entrySet()) {
    		temp.getKey().getValueFactory().setValue(mng.getParam(temp.getValue()));
    	}
    }
    
    
    /**
     * Action Listener - get the source of the button and does the required action
     * @param e
     */
    @FXML
    private void buttonClicked(ActionEvent e) {
    	if (e.getSource().equals(btnSave)) {
    		saveParams();
    	}
    	else if (e.getSource().equals(btnRestore)) {
    		restoreDefaults();
    	}
    	else if (e.getSource().equals(btnBack)) {
    		iWindow.swap(Window.Admin_Menu);
    	}
    	else {
    		return;
    	}
    }
    
    
    /**
     * This method restores all the params to defaults
     */
    private void restoreDefaults() {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Restore To Default Confirmation");
    	alert.setHeaderText("You are about to reset all parametes to default. \n"
    			+ "This action can not be undone!");
    	alert.setContentText("Do you want to reset all parameters to default?");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	/*
    	//add style to alert
    	DialogPane dialogPane = alert.getDialogPane();
    	dialogPane.getStylesheets().add( getClass().getResource("/View/Admin/myDialog.css").toExternalForm());
    	dialogPane.getStyleClass().add("myDialog");
    	*/
    	
    	if (result.get() == ButtonType.OK){
    	    mng.resetParamsToDefault();
    	} else 
    	{
    	    return;
    	}
    	
    }
    
    
    /**
     * This method saves the params input
     */
    private void saveParams() {
    	for (Map.Entry<Spinner, Param> n: _params.entrySet()) {
    		if (!validateNumbers(n.getKey().getValue().toString())) {
    			errorLabelControl("Can not save parametes with letters", true);
    			return;
    		}
    	}
    	
    	if (!checkRules()) return;
    	
    	for (Map.Entry<Spinner, Param> n: _params.entrySet()) {
    		mng.setParam(n.getValue(), n.getKey().getValue());
    	}
    mng.exportDB();
    }
    
    
    /**
     * This method controls the error label
     * @param msg - message to present
     * @param visiblity - show or not show the label
     */
    private void errorLabelControl(String msg, boolean visiblity) {
    	this.lblError.setVisible(visiblity);
    	if (msg == null) {
    		this.lblError.setText(" ");
    	}
    	else {
    		this.lblError.setText("Error: " + msg);
    	}
    }
    
    
    
    
    private boolean validateNumbers(String str) {
    	for (int i = 0; i < str.length(); i++) {
    		if (str.length() < 1) return false;
    		if (Character.isLetter(str.charAt(i))) {
				if (!str.substring(i, i+1).equals(".") || !str.substring(i, i+1).equals("-")) {
					return false;
				}
			}
		}
    	
    	return true;
    }
    
    
    /**
     * This method checks if numbers are logical
     * @return
     */
    private boolean checkRules() {
    	
    	//check if min luck < max luck
    	if (Validators.string2Double(spinMinLuck.getValue().toString()) > 
    			Validators.string2Double(spinMaxLuck.getValue().toString())) {
    		errorLabelControl("Min luck can't be greater than Max luck", true);
    		return false;
    	}
    	
    	//check if prices are logical
    	if (Validators.string2Double(spinEasyPrice.getValue().toString()) > 
    			Validators.string2Double(spinMedPrice.getValue().toString()) ||
    		Validators.string2Double(spinMedPrice.getValue().toString()) > 
    				Validators.string2Double(spinHardPrivce.getValue().toString())) { 
    		errorLabelControl("Make sure all property prices are logical", true);
    	}
    	
    	errorLabelControl(null, false);
    	return true;
    }
   
    
    //spinner properties =>  min="50000" max="10000000" initialValue="100000" amountToStepBy="10000"
}



