package View;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Entity.Game;
import Entity.MonDB;
import Entity.User;
import Utils.PlayerAuth;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Login {

	private IManagement manage = iWindow.getManagement();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView btnVolume;

    @FXML
    private TextField frmNickname;

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
    boolean doLogin(ActionEvent event) {
    	Music.getInstance().play("click.wav");
    	Logger.log("Attempting to log in with user "+frmNickname.getText());
    	MonDB.getInstance().setCurrentGame(new Game());
    	MonDB.getInstance().getCurrentGame().setCurrentLoggedUser((new User(frmNickname.getText(), PlayerAuth.PLAYER)));
    	
    	
    	if(frmNickname.getText().isEmpty())
    	{
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("validate fields");
    		alert.setHeaderText(null);
    		alert.setContentText("You must enter a username");
    		alert.showAndWait();
    		return false;
    	}
    	else if(!(frmNickname.getText().equals("user")))
    	{
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("validate fields");
    		alert.setHeaderText(null);
    		alert.setContentText("Incorrect user");
    		alert.showAndWait();
    		return false;
    		
    	}
    	else
    	iWindow.swap(Window.Player_Menu);
		return true;

    	
    	
    	
    }
    
   
    

    @FXML
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'.";
        assert frmNickname != null : "fx:id=\"frmNickname\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'.";
    }
    
    @FXML
    void openAdmin(ActionEvent event) {
    	iWindow.swap(Window.Admin_Login);
    }
}
