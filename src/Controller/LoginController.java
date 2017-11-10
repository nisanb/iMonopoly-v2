/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="volumebtn"
    private ImageView volumebtn; // Value injected by FXMLLoader

    @FXML // fx:id="volumeslider"
    private Slider volumeslider; // Value injected by FXMLLoader

    void doSwap(ActionEvent event) {

    }

    @FXML
    void dobtnClick(ActionEvent event) {
    	Logger.log("Trying to activate button click");
    	Music.getInstance().play("buttonclick.wav");
    }
    
    @FXML
    void swapThemeSound(MouseEvent event) {
    	Logger.log("Swapping game theme music");
    	Music.getInstance().stop("theme.mp3");
    	
    }
    
    @FXML
    void doClick(MouseEvent event) {
    	Music.getInstance().play("buttonhover.mp3");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert volumebtn != null : "fx:id=\"volumebtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert volumeslider != null : "fx:id=\"volumeslider\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
