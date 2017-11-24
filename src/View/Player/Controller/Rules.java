/**
 * Sample Skeleton for 'Rules.fxml' Controller Class
 */

package View.Player.Controller;

import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Rules {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    


    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
 

    @FXML // fx:id="Pane2"
    private Pane Pane2; // Value injected by FXMLLoader

    @FXML // fx:id="Pane1"
    private Pane Pane1; // Value injected by FXMLLoader
    
    @FXML // fx:id="Pane3"
    private Pane Pane3; // Value injected by FXMLLoader
    
    @FXML // fx:id="Pane4"
    private Pane Pane4; // Value injected by FXMLLoader

    @FXML
    void btn(MouseEvent event) {

    }
    
    @FXML
    void GoForward(MouseEvent event) {
    	
    	Pane1.setVisible(false);
    	
 
    	}
    	
    
    	
    	
    	
    	
    	
    	

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Pane2 != null : "fx:id=\"Pane2\" was not injected: check your FXML file 'Rules.fxml'.";
        assert Pane1 != null : "fx:id=\"Pane1\" was not injected: check your FXML file 'Rules.fxml'.";
    

    }
}
