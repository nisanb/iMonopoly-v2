/**
 * Sample Skeleton for 'EnterAdmin.fxml' Controller Class
 */

package View.Admin.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Login {
	
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private Label namelabel;

    @FXML
    private Label namelabel1;

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
        namelabel.setVisible(false);
        namelabel1.setVisible(false);
        
     

        
    }
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Login);
    }
    
    @FXML
    void openWelcomeAdmin(ActionEvent event) {
    	
    	   if(txtUserName.getText().isEmpty())
           {
           	namelabel.setVisible(true);
           }
    	   else
    	   {
    		   namelabel.setVisible(false);
    	   }

    	   if(txtPassword.getText().isEmpty())
           {
           	namelabel1.setVisible(true);
           }
    	   else
    	   {
    		   namelabel1.setVisible(false);
    	   }

    	   if((!txtUserName.getText().isEmpty())&&(!txtPassword.getText().isEmpty()))
    	   {
    		   iWindow.swap(Window.Admin_Menu);
    	   }
    }

}
