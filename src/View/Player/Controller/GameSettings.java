/**
 * Sample Skeleton for 'GameSettings.fxml' Controller Class
 */

package View.Player.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameSettings {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private ImageView img1;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img4;
    
    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="txt1"
    private TextField txt1; // Value injected by FXMLLoader

    @FXML // fx:id="txt2"
    private TextField txt2; // Value injected by FXMLLoader

    @FXML // fx:id="txt3"
    private TextField txt3; // Value injected by FXMLLoader

    @FXML // fx:id="txt4"
    private TextField txt4; // Value injected by FXMLLoader

    @FXML // fx:id="combobox"
    private ComboBox<String> combobox; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Player_Menu);
    }
    
    ObservableList<String> list=FXCollections.observableArrayList("2","3","4");

    @FXML
    void doSwapMusic(MouseEvent event) {

    }

    @FXML
    void txt1(ActionEvent event) {
  
    }
    
    @FXML
    void hidetextfield1() {
    }
    
    @FXML
    void hidetextfield2() {
    }

    @FXML
    void hidetextfield3() {
    }

    @FXML
    void hidetextfield4() {
    }
    
    @FXML
    void hidelabel1() {
    }

    @FXML
    void hidelabel2() {
    }
    

    @FXML
    void doShowPlayers(ActionEvent event)
    {
    	if(combobox.getValue()=="2")
    	{
    		txt1.setVisible(true);
    		label1.setVisible(true);
    		img1.setVisible(true);
    		
    		txt2.setVisible(true);
    		label2.setVisible(true);
    		img2.setVisible(true);
    		
    		txt3.setVisible(false);
    		label3.setVisible(false);
    		img3.setVisible(false);
    		
    		txt4.setVisible(false);
    		label4.setVisible(false);
    		img4.setVisible(false);
    	}
    	
    	if(combobox.getValue()=="3")
    	{
    		txt1.setVisible(true);
    		label1.setVisible(true);
    		img1.setVisible(true);

    		
    		txt2.setVisible(true);
    		label2.setVisible(true);
    		img2.setVisible(true);

    		
    		txt3.setVisible(true);
    		label3.setVisible(true);
    		img3.setVisible(true);

    		
    		txt4.setVisible(false);
    		label4.setVisible(false);
    		img4.setVisible(false);
    	}
    	
    	if(combobox.getValue()=="4")
    	{
    		txt1.setVisible(true);
    		label1.setVisible(true);
    		img1.setVisible(true);
    		
    		txt2.setVisible(true);
    		label2.setVisible(true);
    		img2.setVisible(true);
    		
    		txt3.setVisible(true);
    		label3.setVisible(true);
    		img3.setVisible(true);
    		
    		txt4.setVisible(true);
    		label4.setVisible(true);
    		img4.setVisible(true);
    	}
    	
    	
    }


    @FXML
    void hidelabel3() {
    }

    @FXML
    void hidelabel4() {
    }
    
 

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'GameSettings.fxml'.";
        assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'GameSettings.fxml'.";
        assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'GameSettings.fxml'.";
        assert txt3 != null : "fx:id=\"txt3\" was not injected: check your FXML file 'GameSettings.fxml'.";
        assert txt4 != null : "fx:id=\"txt4\" was not injected: check your FXML file 'GameSettings.fxml'.";
        assert combobox != null : "fx:id=\"combobox\" was not injected: check your FXML file 'GameSettings.fxml'.";
        combobox.setItems(list);
        txt1.setVisible(false);
        label1.setVisible(false);
        txt2.setVisible(false);
        label2.setVisible(false);
        txt3.setVisible(false);
        label3.setVisible(false);
        txt4.setVisible(false);
        label4.setVisible(false);
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(false);
        img4.setVisible(false);
    }
    
    @FXML
    void openBoard(ActionEvent event) {
    	iWindow.swap(Window.Game_UI);
    }
    
    
}
