package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    void doClick(ActionEvent event) {
    	Logger.log("Clicked Button!");
    }

    
    @FXML
    void initialize() {
        assert btnLogin != null : "fx:id=\"SD\" was not injected: check your FXML file 'Eli.fxml'.";
    }
}
