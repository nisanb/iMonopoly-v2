package View;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Utils.Window;
import View.Player.Controller.Check;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;;

public class Login {

	//private IManagement manage = iWindow.getManagement();
	
    @FXML
    private ResourceBundle resources;
    
    private IManagement mng = iWindow.getManagement();

    @FXML // fx:id="dice"
    private ImageView dice; // Value injected by FXMLLoader
    
    @FXML
    private Label namelabel;

    @FXML
    private URL location;

    @FXML
    private ImageView btnVolume;

    @FXML
    private  TextField frmNickname;

    @FXML
    private Button btnLogin;
    



    @FXML
    void MouseEntered(MouseEvent event) {
    	//Music.getInstance().play("hover.mp3");
    }

    @FXML
    void doSwapMusic(MouseEvent event) {
    	Music.getInstance().swap("theme.mp3");
    }
    
    
    @FXML
    public void doLogin(ActionEvent event) {
    	Music.getInstance().play("click.wav");
    	Logger.log("Attempting to log in with user "+frmNickname.getText());
    	
    	if(frmNickname.getText().isEmpty())
    	{
    		namelabel.setVisible(true);
    	}
    	else
    	{
    	mng.login(frmNickname.getText());
    	iWindow.swap(Window.Player_Menu);
    	}
    	

    	
    	
    	
    }
    
   
    

    @FXML
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'.";
        assert frmNickname != null : "fx:id=\"frmNickname\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'.";
        namelabel.setVisible(false);
        
 
        
        
        
        
        
        
        
    }
    
    @FXML
    void openAdmin(ActionEvent event) {
    	iWindow.swap(Window.Admin_Login);
    }
}
