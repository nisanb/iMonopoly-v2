package View.Admin.Controller;

import Utils.*;
import java.util.ResourceBundle;

import Controller.iWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SysParam {

    @FXML private Button btnSave;

    @FXML private Button btnBack;

    @FXML private Button btnRestore;

    @FXML private Spinner<Integer> spinStartMoney;

    @FXML private TextField TxtSartMoney;

    @FXML private TextField TxtRent;

    @FXML private TextField BuyProperty;

    @FXML private TextField TxtMinLuck;

    @FXML private TextField TxtOnlyLuck;

    @FXML private TextField TxtLuckFine;
    
    @FXML private TextField TxtJailFine;

    @FXML private TextField TxtCheapProperty;

    @FXML private TextField TxtAverageProperty;

    @FXML private TextField TxtExpensiveProperty;

    @FXML private TextField TxtCPd;

    @FXML private TextField TxtAPD;

    @FXML private TextField TxtExpensiveProperyDiscount;

    @FXML private TextField TxtMNOR;

    @FXML private TextField TxtBankRupty;
    
    @FXML private TextField lblEmpty1;
    
    @FXML private TextField lblEmpty2;
    

    

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

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
    
    @FXML private Spinner<?> spinEmpty2;  
    
    @FXML private Spinner<?> spinEmpty1;

    @FXML
    void back(ActionEvent event) {
    	
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    public void initialize() {
    	turnOffEmpty();
    }
    
    
    
    private void turnOffEmpty() {
    	lblEmpty1.setVisible(false);
    	lblEmpty2.setVisible(false);
    	spinEmpty1.setVisible(false);
    	spinEmpty2.setVisible(false);
    }
    
    
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
    
    
    
    private void restoreDefaults() {
    	
    }
    
    
    
    private void saveParams() {
    	System.out.println(spinAvgDisc.getValue());
    }
}



