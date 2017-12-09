/**
 * Sample Skeleton for 'WelcomeAdmin.fxml' Controller Class
 */

package View.Admin.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Menu {

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
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'WelcomeAdmin.fxml'.";

    }
    
    @FXML
    void openAdminStatistics(ActionEvent event) {
    	iWindow.swap(Window.Admin_Statistics);
    }
    
//here stop//
    
    @FXML
    void openSystemParameters(ActionEvent event) {
    	iWindow.swap(Window.Admin_SysParams);
    }
    

    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Login);
    }
    
    @FXML
    void openquestion(ActionEvent event) {
    	iWindow.swap(Window.Admin_Questions);
    }
    

    @FXML
    void leadboardClicked(ActionEvent e) {
    	iWindow.swap(Window.Player_LeadBoard);
    }
}
