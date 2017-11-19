/**
 * Sample Skeleton for 'EnterAdmin.fxml' Controller Class
 */

package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EnterAdmin {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserLogged"
    private Label lblUserLogged; // Value injected by FXMLLoader

    @FXML
    void doSwapMusic(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'EnterAdmin.fxml'.";
        assert lblUserLogged != null : "fx:id=\"lblUserLogged\" was not injected: check your FXML file 'EnterAdmin.fxml'.";

    }
}
