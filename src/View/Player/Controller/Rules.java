/**
 * Sample Skeleton for 'Rules.fxml' Controller Class
 */

package View.Player.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Rules {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Save"
    private ImageView Save; // Value injected by FXMLLoader

    @FXML // fx:id="Back"
    private Button Back; // Value injected by FXMLLoader

    @FXML
    void PrevToSellingProperetirs(MouseEvent event) {

    }

    @FXML
    void btn(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Save != null : "fx:id=\"Save\" was not injected: check your FXML file 'Rules.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'Rules.fxml'.";

    }
    
    @FXML
    void Back(ActionEvent event) {
    	iWindow.swap(Window.Player_Menu);
    }

}
