package View.Admin.Controller;

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
    
    
    protected void nouseExitedPercent(ActionEvent event) {
    	
    }
    
    
    protected void mouseExitedNumber(ActionEvent event) {
    	
    }
    
    
    protected void mouseBackClicked(ActionEvent event) {
    	
    }
    
    
    
    protected void mouseRestoreClicked(ActionEvent event) {
    	
    }
*/


