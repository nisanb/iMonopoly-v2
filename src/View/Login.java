package View;



import java.net.URL;
import java.util.ResourceBundle;

import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;;

public class Login {	
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
    private Button btnExit;
    


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
    		setUserBGC("red");
    	}
    	else
    	{
    	mng.login(frmNickname.getText());
    	setUserBGC("white");
    	iWindow.swap(Window.Player_Menu);
    	}
    	  	
    	
    }
    
   
    @FXML
    void exitGmae() {
    	System.exit(0);
    }
    

    @FXML
    void initialize() {
        namelabel.setVisible(false);
        

    }
    
    @FXML
    void openAdmin(ActionEvent event) {
    	iWindow.swap(Window.Admin_Login);
    }
    
    
    
    //============================================= CSS ========================================================
    private void setUserBGC(String color) {
    	frmNickname.setStyle("-fx-background-color:" + color +";");
    }
    
    
}
