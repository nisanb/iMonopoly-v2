/**
 * Sample Skeleton for 'NumOfPlayers.fxml' Controller Class
 */

package View.Player.Controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.print.DocFlavor.STRING;

import Controller.iWindow;
import Utils.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameSettings {
	

	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML
    void MouseEntered(MouseEvent event) {

    }

    @FXML
    void doLogin(ActionEvent event) {

    }

    @FXML
    void doSwapMusic(MouseEvent event) {

    }
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'NumOfPlayers.fxml'.";
     
        

    }
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Player_Menu);
    }
    

}
