/**
 * Sample Skeleton for 'Check.fxml' Controller Class
 */

package View.Player.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;

public class Check {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="slide1"
    private Slider slide1; // Value injected by FXMLLoader

    @FXML // fx:id="label1"
    private Label label1; // Value injected by FXMLLoader

    @FXML // fx:id="img1"
    private ImageView img1; // Value injected by FXMLLoader

    @FXML // fx:id="img11"
    private ImageView img11; // Value injected by FXMLLoader

    @FXML // fx:id="txt1"
    private TextField txt1; // Value injected by FXMLLoader

    @FXML // fx:id="label3"
    private Label label3; // Value injected by FXMLLoader

    @FXML // fx:id="img3"
    private ImageView img3; // Value injected by FXMLLoader

    @FXML // fx:id="txt3"
    private TextField txt3; // Value injected by FXMLLoader

    @FXML // fx:id="label2"
    private Label label2; // Value injected by FXMLLoader

    @FXML // fx:id="img2"
    private ImageView img2; // Value injected by FXMLLoader

    @FXML // fx:id="txt2"
    private TextField txt2; // Value injected by FXMLLoader

    @FXML // fx:id="label4"
    private Label label4; // Value injected by FXMLLoader

    @FXML // fx:id="img4"
    private ImageView img4; // Value injected by FXMLLoader

    @FXML // fx:id="txt4"
    private TextField txt4; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Player_Menu);
    }

    @FXML
    void check1(MouseEvent event) {
    
    
    	Integer res= Integer.valueOf((int) slide1.getValue());
    	
    	
      	if(res==2)
    	{
    		txt1.setVisible(true);
    		label1.setVisible(true);
    		img1.setVisible(true);
    		
    		txt2.setVisible(true);
    		label2.setVisible(true);
    		img2.setVisible(true);
    		
    		txt3.setVisible(false);
    		label3.setVisible(false);
    		img3.setVisible(false);
    		
    		txt4.setVisible(false);
    		label4.setVisible(false);
    		img4.setVisible(false);
    	}
    	
    	if(res==3)
    	{
    		txt1.setVisible(true);
    		label1.setVisible(true);
    		img1.setVisible(true);

    		
    		txt2.setVisible(true);
    		label2.setVisible(true);
    		img2.setVisible(true);

    		
    		txt3.setVisible(true);
    		label3.setVisible(true);
    		img3.setVisible(true);

    		
    		txt4.setVisible(false);
    		label4.setVisible(false);
    		img4.setVisible(false);
    	}
    	
    	if(res==4)
    	{
    		txt1.setVisible(true);
    		label1.setVisible(true);
    		img1.setVisible(true);
    		
    		txt2.setVisible(true);
    		label2.setVisible(true);
    		img2.setVisible(true);
    		
    		txt3.setVisible(true);
    		label3.setVisible(true);
    		img3.setVisible(true);
    		
    		txt4.setVisible(true);
    		label4.setVisible(true);
    		img4.setVisible(true);
    	}
    }
    
    @FXML
    void CheckRight(SwipeEvent event) {
    	
 
    }
    
    @FXML
    void check2(MouseEvent event) {
    	 
    }


    @FXML
    void doSwapMusic(MouseEvent event) {

    }

    @FXML
    void hidelabel1(MouseEvent event) {

    }

    @FXML
    void hidelabel2(MouseEvent event) {

    }

    @FXML
    void hidelabel3(MouseEvent event) {

    }

    @FXML
    void hidelabel4(MouseEvent event) {

    }

    @FXML
    void hidetextfield1(ActionEvent event) {

    }

    @FXML
    void hidetextfield2(ActionEvent event) {

    }

    @FXML
    void hidetextfield3(ActionEvent event) {

    }

    @FXML
    void hidetextfield4(ActionEvent event) {

    }

    @FXML
    void openBoard(ActionEvent event) {
    	iWindow.swap(Window.Game_UI);
    }
    
  

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Check.fxml'.";
        assert slide1 != null : "fx:id=\"slide1\" was not injected: check your FXML file 'Check.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'Check.fxml'.";
        assert img1 != null : "fx:id=\"img1\" was not injected: check your FXML file 'Check.fxml'.";
        assert img11 != null : "fx:id=\"img11\" was not injected: check your FXML file 'Check.fxml'.";
        assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'Check.fxml'.";
        assert label3 != null : "fx:id=\"label3\" was not injected: check your FXML file 'Check.fxml'.";
        assert img3 != null : "fx:id=\"img3\" was not injected: check your FXML file 'Check.fxml'.";
        assert txt3 != null : "fx:id=\"txt3\" was not injected: check your FXML file 'Check.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'Check.fxml'.";
        assert img2 != null : "fx:id=\"img2\" was not injected: check your FXML file 'Check.fxml'.";
        assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'Check.fxml'.";
        assert label4 != null : "fx:id=\"label4\" was not injected: check your FXML file 'Check.fxml'.";
        assert img4 != null : "fx:id=\"img4\" was not injected: check your FXML file 'Check.fxml'.";
        assert txt4 != null : "fx:id=\"txt4\" was not injected: check your FXML file 'Check.fxml'.";
        
       
        
        txt3.setVisible(false);
        label3.setVisible(false);
        txt4.setVisible(false);
        label4.setVisible(false);
      
        img3.setVisible(false);
        img4.setVisible(false);

    }
    
   
}
