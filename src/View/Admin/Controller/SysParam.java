package View.Admin.Controller;

<<<<<<< Updated upstream
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

public class SysParam {

    @FXML
    private Button btnSave;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnRestore;

    @FXML
    private Spinner<Integer> spinStartMoney;
=======
import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Entity.MonDB;
import Utils.Param;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SysParam {


    @FXML
    private TextField TxtSartMoney;

    @FXML
    private TextField TxtRent;

    @FXML
    private TextField BuyProperty;

    @FXML
    private TextField TxtMinLuck;

    @FXML
    private TextField TxtOnlyLuck;

    @FXML
    private TextField TxtLuckFine;

    @FXML
    private TextField TxtJailFine;

    @FXML
    private TextField TxtCheapProperty;

    @FXML
    private TextField TxtAverageProperty;

    @FXML
    private TextField TxtExpensiveProperty;

    @FXML
    private TextField TxtCPd;

    @FXML
    private TextField TxtAPD;

    @FXML
    private TextField TxtExpensiveProperyDiscount;

    @FXML
    private TextField TxtMNOR;

    @FXML
    private TextField TxtBankRupty;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
>>>>>>> Stashed changes

    @FXML
    private Spinner<Double> spinRent = new Spinner<Double>(0,100,50);

    @FXML
    private Spinner<Double> spinBuy;

    @FXML
    private Spinner<Integer> spinMinLuck;

    @FXML
    private Spinner<Integer> spinMaxLuck;

    @FXML
    private Spinner<Integer> spinOnlyLuck;

    @FXML
    private Spinner<Integer> spinLuckFIne;

    @FXML
    private Spinner<Integer> spinJailFine;

    @FXML
    private Spinner<Integer> spinCheapProperty;

    @FXML
    private Spinner<Integer> SpinAverageProperty;

    @FXML
    private Spinner<Integer> spinExpensiveProperty;

    @FXML
    private Spinner<Double> spinCheapDisc;

    @FXML
    private Spinner<Double> spinAvgDisc;

    @FXML
    private Spinner<Double> spinExpensiveDisc;

    @FXML
    private Spinner<Integer> spinMaxRounds;

    @FXML
    private Spinner<Integer> spinBankruptcy;

    @FXML
    void back(ActionEvent event) {
    	
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    public void initialize() {
    	
    }
}

    //================================== Action Events ============================================
    /*
    @FXML
    protected void saveClicked(ActionEvent event) {

    	Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText(null);
		alert.setContentText("Parameters Saved");
		alert.showAndWait();
    	iWindow.swap(Window.Admin_Menu);
    }
<<<<<<< Updated upstream
    
    
    protected void nouseExitedPercent(ActionEvent event) {
    	
=======

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'SysParam.fxml'.";
     
       
       
        
>>>>>>> Stashed changes
    }
    
    
    protected void mouseExitedNumber(ActionEvent event) {
    	
    }
    
    
    protected void mouseBackClicked(ActionEvent event) {
    	
    }
    
    
    
    protected void mouseRestoreClicked(ActionEvent event) {
    	
    }
*/


