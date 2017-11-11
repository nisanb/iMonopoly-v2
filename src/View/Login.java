package View;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.Music;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView btnVolume;

    @FXML
    private TextField frmNickname;

    @FXML
    private ToggleButton btnLogin;

    @FXML
    void MouseEntered(MouseEvent event) {
    	Music.getInstance().play("hover.mp3");
    }

    @FXML
    void doSwapMusic(MouseEvent event) {
    	Music.getInstance().stop("theme.mp3");
    }
    
    @FXML
    void doLogin(ActionEvent event) {
    	Music.getInstance().play("click.wav");
    }

    @FXML
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'.";
        assert frmNickname != null : "fx:id=\"frmNickname\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
