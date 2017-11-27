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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import Controller.Management;

public class SysParam {
	
	private Map<Spinner, Param> _parms;
	private IManagement mng = null;
	
    @FXML private Button btnSave;

    @FXML private Button btnBack;

    @FXML private Button btnRestore;
    
    @FXML private Label lblEmpty1;
    
    @FXML private Label lblEmpty2;
    
    @FXML private Label lblError;
    
    
    

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    
    @FXML private Spinner<Integer> spinStartMoney;

    @FXML private Spinner<Double> spinRent = new Spinner<Double>(0,100,50);

    @FXML private Spinner<Double> spinBuy;

    @FXML private Spinner<Integer> spinMinLuck;

    @FXML private Spinner<Integer> spinMaxLuck;

    @FXML private Spinner<Integer> spinOnlyLuck;

    @FXML private Spinner<Integer> spinLuckFIne;

    @FXML private Spinner<Integer> spinJailFine;

    @FXML private Spinner<Integer> spinCheapProperty;

    @FXML private Spinner<Integer> SpinAverageProperty;

    @FXML private Spinner<Integer> spinExpensiveProperty;

    @FXML private Spinner<Double> spinCheapDisc;

    @FXML private Spinner<Double> spinAvgDisc;

    @FXML private Spinner<Double> spinExpensiveDisc;

    @FXML private Spinner<Integer> spinMaxRounds;

    @FXML private Spinner<Integer> spinBankruptcy;
    
    @FXML private Spinner<Double> spinEmpty2;  
    
    @FXML private Spinner<Double> spinEmpty1;

    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Menu);
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    public void initialize() {
    	mng = iWindow.getManagement();
    	turnOffEmpty();
    	errorLabelControl(null, false);
    	addParamsToMap();
    	loadParams();
    }
    
    
    
    
    /**
     * This method turn off empty fields
     */
    private void turnOffEmpty() {   	
    	lblEmpty1.setVisible(false);
    	lblEmpty2.setVisible(false);
    	spinEmpty1.setVisible(false);
    	spinEmpty2.setVisible(false);
    }
    
    
    /**
     * This method adds params to map fot easy set
     */
    private void addParamsToMap() {
    	this._parms = new HashMap<Spinner, Param>();
    	spinStartMoney.getValueFactory().setValue((Integer)mng.getParam(Param.STARTING_CASH));
    	//TODO - add all params to list
    	
    	
    }
    
    
    
    /**
     * This method load the saved params from monDB
     */
    private void loadParams() {
    	IManagement manage = iWindow.getManagement();
    	//_parms.put(spinStartMoney, (Integer) manage.getParam(Param.STARTING_CASH));
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
    	IManagement manage = iWindow.getManagement();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Restore To Default Confirmation");
    	alert.setHeaderText("You are about to reset all parametes to default. \n"
    			+ "This action can not be undone!");
    	alert.setContentText("Do you want to reset all parameters to default?");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if (result.get() == ButtonType.OK){
    	    manage.resetParamsToDefault();
    	} else 
    	{
    	    return;
    	}
    	
    }
    
    
    /**
     * This method saves the params input
     */
    private void saveParams() {
    	for (Map.Entry<Spinner, Param> n: _parms.entrySet()) {
    		if (validateNumbers(n.getKey().getValue().toString())) {
    			errorLabelControl("Can not save parametes with letters", true);
    			return;
    		}
    	}
    	
    	for (Map.Entry<Spinner, Param> n: _parms.entrySet()) {
    		Param.set(n.getValue(), n.getKey().getValue());
    	}
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
			if (Character.isLetter(str.charAt(i))) return false;
		}
    	
    	return true;
    }
   
    
    //spinner properties =>  min="50000" max="10000000" initialValue="100000" amountToStepBy="10000"
}



