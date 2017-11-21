/**
 * Sample Skeleton for 'Player_Menu.fxml' Controller Class
 */

package View.Player.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Menu {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserLogged"
    private Label lblUserLogged; // Value injected by FXMLLoader

    @FXML
    void MouseEntered(MouseEvent event) {

    }

    @FXML
    void doLogout(ActionEvent event) {

    }

    @FXML
    void doSwapMusic(MouseEvent event) {

    }
    


    	/*
<<<<<<< HEAD:src/View/Player_Menu.java
    	iWindow.swap(Window.MainBoardTal);
=======
    	iWindow.swap(Window.Player_GameSettings);
>>>>>>> order package of admin,player and game:src/View/Player/Controller/Menu.java

    }*/

    @FXML
    void openStatistics(ActionEvent event) {
    	iWindow.swap(Window.Player_Statistics);
    }
    
    @FXML
    void openGame(ActionEvent event) {
    	iWindow.swap(Window.Player_GameSettings);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Player_Menu.fxml'.";
        assert lblUserLogged != null : "fx:id=\"lblUserLogged\" was not injected: check your FXML file 'Player_Menu.fxml'.";

    }
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Login);
    }
}
