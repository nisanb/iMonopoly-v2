package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimerTask;

import javax.swing.text.Position;

import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Entity.Game;
import Entity.MonDB;
import Entity.Player;
import Utils.Window;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class TalUI {

	
	ImageView[][] players = new ImageView[40][4]; 

	@FXML
	private ImageView player1_0= new ImageView();
	@FXML
	private ImageView player2_0= new ImageView();
	@FXML
	private ImageView player3_0= new ImageView();
	@FXML
	private ImageView player4_0= new ImageView();
	@FXML
	private ImageView player1_1= new ImageView();
	@FXML
	private ImageView player2_1= new ImageView();
	@FXML
	private ImageView player3_1= new ImageView();
	@FXML
	private ImageView player4_1= new ImageView();
	@FXML
	private ImageView player1_2= new ImageView();
	@FXML
	private ImageView player2_2= new ImageView();
	@FXML
	private ImageView player3_2= new ImageView();
	@FXML
	private ImageView player4_2= new ImageView();
	@FXML
	private ImageView player1_3= new ImageView();
	@FXML
	private ImageView player2_3= new ImageView();
	@FXML
	private ImageView player3_3= new ImageView();
	@FXML
	private ImageView player4_3= new ImageView();
	@FXML
	private ImageView player1_4= new ImageView();
	@FXML
	private ImageView player2_4= new ImageView();
	@FXML
	private ImageView player3_4= new ImageView();
	@FXML
	private ImageView player4_4= new ImageView();
	@FXML
	private ImageView player1_5= new ImageView();
	@FXML
	private ImageView player2_5= new ImageView();
	@FXML
	private ImageView player3_5= new ImageView();
	@FXML
	private ImageView player4_5= new ImageView();
	@FXML
	private ImageView player1_6= new ImageView();
	@FXML
	private ImageView player2_6= new ImageView();
	@FXML
	private ImageView player3_6= new ImageView();
	@FXML
	private ImageView player4_6= new ImageView();
	@FXML
	private ImageView player1_7= new ImageView();
	@FXML
	private ImageView player2_7= new ImageView();
	@FXML
	private ImageView player3_7= new ImageView();
	@FXML
	private ImageView player4_7= new ImageView();
	@FXML
	private ImageView player1_8= new ImageView();
	@FXML
	private ImageView player2_8= new ImageView();
	@FXML
	private ImageView player3_8= new ImageView();
	@FXML
	private ImageView player4_8= new ImageView();
	@FXML
	private ImageView player1_9= new ImageView();
	@FXML
	private ImageView player2_9= new ImageView();
	@FXML
	private ImageView player3_9= new ImageView();
	@FXML
	private ImageView player4_9= new ImageView();
	@FXML
	private ImageView player1_10= new ImageView();
	@FXML
	private ImageView player2_10= new ImageView();
	@FXML
	private ImageView player3_10= new ImageView();
	@FXML
	private ImageView player4_10= new ImageView();
	@FXML
	private ImageView player1_11= new ImageView();
	@FXML
	private ImageView player2_11= new ImageView();
	@FXML
	private ImageView player3_11= new ImageView();
	@FXML
	private ImageView player4_11= new ImageView();
	@FXML
	private ImageView player1_12= new ImageView();
	@FXML
	private ImageView player2_12= new ImageView();
	@FXML
	private ImageView player3_12= new ImageView();
	@FXML
	private ImageView player4_12= new ImageView();
	@FXML
	private ImageView player1_13= new ImageView();
	@FXML
	private ImageView player2_13= new ImageView();
	@FXML
	private ImageView player3_13= new ImageView();
	@FXML
	private ImageView player4_13= new ImageView();
	@FXML
	private ImageView player1_14= new ImageView();
	@FXML
	private ImageView player2_14= new ImageView();
	@FXML
	private ImageView player3_14= new ImageView();
	@FXML
	private ImageView player4_14= new ImageView();
	@FXML
	private ImageView player1_15= new ImageView();
	@FXML
	private ImageView player2_15= new ImageView();
	@FXML
	private ImageView player3_15= new ImageView();
	@FXML
	private ImageView player4_15= new ImageView();
	@FXML
	private ImageView player1_16= new ImageView();
	@FXML
	private ImageView player2_16= new ImageView();
	@FXML
	private ImageView player3_16= new ImageView();
	@FXML
	private ImageView player4_16= new ImageView();
	@FXML
	private ImageView player1_17= new ImageView();
	@FXML
	private ImageView player2_17= new ImageView();
	@FXML
	private ImageView player3_17= new ImageView();
	@FXML
	private ImageView player4_17= new ImageView();
	@FXML
	private ImageView player1_18= new ImageView();
	@FXML
	private ImageView player2_18= new ImageView();
	@FXML
	private ImageView player3_18= new ImageView();
	@FXML
	private ImageView player4_18= new ImageView();
	@FXML
	private ImageView player1_19= new ImageView();
	@FXML
	private ImageView player2_19= new ImageView();
	@FXML
	private ImageView player3_19= new ImageView();
	@FXML
	private ImageView player4_19= new ImageView();
	@FXML
	private ImageView player1_20= new ImageView();
	@FXML
	private ImageView player2_20= new ImageView();
	@FXML
	private ImageView player3_20= new ImageView();
	@FXML
	private ImageView player4_20= new ImageView();
	@FXML
	private ImageView player1_21= new ImageView();
	@FXML
	private ImageView player2_21= new ImageView();
	@FXML
	private ImageView player3_21= new ImageView();
	@FXML
	private ImageView player4_21= new ImageView();
	@FXML
	private ImageView player1_22= new ImageView();
	@FXML
	private ImageView player2_22= new ImageView();
	@FXML
	private ImageView player3_22= new ImageView();
	@FXML
	private ImageView player4_22= new ImageView();
	@FXML
	private ImageView player1_23= new ImageView();
	@FXML
	private ImageView player2_23= new ImageView();
	@FXML
	private ImageView player3_23= new ImageView();
	@FXML
	private ImageView player4_23= new ImageView();
	@FXML
	private ImageView player1_24= new ImageView();
	@FXML
	private ImageView player2_24= new ImageView();
	@FXML
	private ImageView player3_24= new ImageView();
	@FXML
	private ImageView player4_24= new ImageView();
	@FXML
	private ImageView player1_25= new ImageView();
	@FXML
	private ImageView player2_25= new ImageView();
	@FXML
	private ImageView player3_25= new ImageView();
	@FXML
	private ImageView player4_25= new ImageView();
	@FXML
	private ImageView player1_26= new ImageView();
	@FXML
	private ImageView player2_26= new ImageView();
	@FXML
	private ImageView player3_26= new ImageView();
	@FXML
	private ImageView player4_26= new ImageView();
	@FXML
	private ImageView player1_27= new ImageView();
	@FXML
	private ImageView player2_27= new ImageView();
	@FXML
	private ImageView player3_27= new ImageView();
	@FXML
	private ImageView player4_27= new ImageView();
	@FXML
	private ImageView player1_28= new ImageView();
	@FXML
	private ImageView player2_28= new ImageView();
	@FXML
	private ImageView player3_28= new ImageView();
	@FXML
	private ImageView player4_28= new ImageView();
	@FXML
	private ImageView player1_29= new ImageView();
	@FXML
	private ImageView player2_29= new ImageView();
	@FXML
	private ImageView player3_29= new ImageView();
	@FXML
	private ImageView player4_29= new ImageView();
	@FXML
	private ImageView player1_30= new ImageView();
	@FXML
	private ImageView player2_30= new ImageView();
	@FXML
	private ImageView player3_30= new ImageView();
	@FXML
	private ImageView player4_30= new ImageView();
	@FXML
	private ImageView player1_31= new ImageView();
	@FXML
	private ImageView player2_31= new ImageView();
	@FXML
	private ImageView player3_31= new ImageView();
	@FXML
	private ImageView player4_31= new ImageView();
	@FXML
	private ImageView player1_32= new ImageView();
	@FXML
	private ImageView player2_32= new ImageView();
	@FXML
	private ImageView player3_32= new ImageView();
	@FXML
	private ImageView player4_32= new ImageView();
	@FXML
	private ImageView player1_33= new ImageView();
	@FXML
	private ImageView player2_33= new ImageView();
	@FXML
	private ImageView player3_33= new ImageView();
	@FXML
	private ImageView player4_33= new ImageView();
	@FXML
	private ImageView player1_34= new ImageView();
	@FXML
	private ImageView player2_34= new ImageView();
	@FXML
	private ImageView player3_34= new ImageView();
	@FXML
	private ImageView player4_34= new ImageView();
	@FXML
	private ImageView player1_35= new ImageView();
	@FXML
	private ImageView player2_35= new ImageView();
	@FXML
	private ImageView player3_35= new ImageView();
	@FXML
	private ImageView player4_35= new ImageView();
	@FXML
	private ImageView player1_36= new ImageView();
	@FXML
	private ImageView player2_36= new ImageView();
	@FXML
	private ImageView player3_36= new ImageView();
	@FXML
	private ImageView player4_36= new ImageView();
	@FXML
	private ImageView player1_37= new ImageView();
	@FXML
	private ImageView player2_37= new ImageView();
	@FXML
	private ImageView player3_37= new ImageView();
	@FXML
	private ImageView player4_37= new ImageView();
	@FXML
	private ImageView player1_38= new ImageView();
	@FXML
	private ImageView player2_38= new ImageView();
	@FXML
	private ImageView player3_38= new ImageView();
	@FXML
	private ImageView player4_38= new ImageView();
	@FXML
	private ImageView player1_39= new ImageView();
	@FXML
	private ImageView player2_39= new ImageView();
	@FXML
	private ImageView player3_39= new ImageView();
	@FXML
	private ImageView player4_39= new ImageView();
	    
	    @FXML
	    private Button button1 = new Button();
	    
	    @FXML
	    private Button buttonMenu= new Button();

	    @FXML
	    private Pane pane0= new Pane();
	    @FXML
	    private Pane pane1= new Pane();
	    @FXML
	    private Pane pane2= new Pane();

	    @FXML
	    private Pane pane3= new Pane();

	    @FXML
	    private Pane pane4= new Pane();

	    @FXML
	    private Pane pane5= new Pane();

	    @FXML
	    private Pane pane6= new Pane();

	    @FXML
	    private Pane pane7= new Pane();

	    @FXML
	    private Pane pane8= new Pane();

	    @FXML
	    private Pane pane9= new Pane();
	    
	    @FXML
	    private Button main= new Button();

	    @FXML
	    private Pane pane10= new Pane();

	    @FXML
	    private Pane pane11= new Pane();

	    @FXML
	    private Pane pane12= new Pane();

	    @FXML
	    private Pane pane13= new Pane();

	    @FXML
	    private Pane pane14= new Pane();

	    @FXML
	    private Pane pane15= new Pane();

	    @FXML
	    private Pane pane16= new Pane();

	    @FXML
	    private Pane pane17= new Pane();

	    @FXML
	    private Pane pane18= new Pane();

	    @FXML
	    private Pane pane19= new Pane();

	    @FXML
	    private Pane pane20= new Pane();

	    @FXML
	    private Pane pane21= new Pane();

	    @FXML
	    private Pane pane22= new Pane();

	    @FXML
	    private Pane pane23= new Pane();

	    @FXML
	    private Pane pane24= new Pane();

	    @FXML
	    private Pane pane25= new Pane();

	    @FXML
	    private Pane pane26= new Pane();

	    @FXML
	    private Pane pane27= new Pane();

	    @FXML
	    private Pane pane28= new Pane();

	    @FXML
	    private Pane pane29= new Pane();

	    @FXML
	    private Pane pane30= new Pane();

	    @FXML
	    private Pane pane31= new Pane();

	    @FXML
	    private Pane pane32= new Pane();

	    @FXML
	    private Pane pane33= new Pane();

	    @FXML
	    private Pane pane34= new Pane();

	    @FXML
	    private Pane pane35= new Pane();

	    @FXML
	    private Pane pane36= new Pane();

	    @FXML
	    private Pane pane37= new Pane();

	    @FXML
	    private Pane pane38= new Pane();

	    @FXML
	    private Pane pane39= new Pane();

	    

	    
    public TalUI() {
			super();
			initializeTiles();
		}


    @FXML
    void initialize() {
    	  assert main != null : "fx:id=\"main\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane0 != null : "fx:id=\"pane0\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_0 != null : "fx:id=\"player1_0\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_0 != null : "fx:id=\"player2_0\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_0 != null : "fx:id=\"player3_0\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_0 != null : "fx:id=\"player4_0\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_1 != null : "fx:id=\"player1_1\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_1 != null : "fx:id=\"player2_1\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_1 != null : "fx:id=\"player3_1\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_1 != null : "fx:id=\"player4_1\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane2 != null : "fx:id=\"pane2\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_2 != null : "fx:id=\"player1_2\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_2 != null : "fx:id=\"player2_2\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_2 != null : "fx:id=\"player3_2\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_2 != null : "fx:id=\"player4_2\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane3 != null : "fx:id=\"pane3\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_3 != null : "fx:id=\"player1_3\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_3 != null : "fx:id=\"player2_3\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_3 != null : "fx:id=\"player3_3\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_3 != null : "fx:id=\"player4_3\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane4 != null : "fx:id=\"pane4\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_4 != null : "fx:id=\"player1_4\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_4 != null : "fx:id=\"player2_4\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_4 != null : "fx:id=\"player3_4\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_4 != null : "fx:id=\"player4_4\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane5 != null : "fx:id=\"pane5\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_5 != null : "fx:id=\"player1_5\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_5 != null : "fx:id=\"player2_5\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_5 != null : "fx:id=\"player3_5\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_5 != null : "fx:id=\"player4_5\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane6 != null : "fx:id=\"pane6\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_6 != null : "fx:id=\"player1_6\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_6 != null : "fx:id=\"player2_6\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_6 != null : "fx:id=\"player3_6\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_6 != null : "fx:id=\"player4_6\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane7 != null : "fx:id=\"pane7\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_7 != null : "fx:id=\"player1_7\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_7 != null : "fx:id=\"player2_7\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_7 != null : "fx:id=\"player3_7\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_7 != null : "fx:id=\"player4_7\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane8 != null : "fx:id=\"pane8\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_8 != null : "fx:id=\"player1_8\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_8 != null : "fx:id=\"player2_8\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_8 != null : "fx:id=\"player3_8\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_8 != null : "fx:id=\"player4_8\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane9 != null : "fx:id=\"pane9\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_9 != null : "fx:id=\"player1_9\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_9 != null : "fx:id=\"player2_9\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_9 != null : "fx:id=\"player3_9\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_9 != null : "fx:id=\"player4_9\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane11 != null : "fx:id=\"pane11\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_11 != null : "fx:id=\"player1_11\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_11 != null : "fx:id=\"player2_11\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_11 != null : "fx:id=\"player3_11\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_11 != null : "fx:id=\"player4_11\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane12 != null : "fx:id=\"pane12\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_12 != null : "fx:id=\"player1_111\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_12 != null : "fx:id=\"player2_12\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_12 != null : "fx:id=\"player3_12\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_12 != null : "fx:id=\"player4_12\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane13 != null : "fx:id=\"pane13\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_13 != null : "fx:id=\"player1_1111\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_13 != null : "fx:id=\"player2_13\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_13 != null : "fx:id=\"player3_13\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_13 != null : "fx:id=\"player4_13\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane14 != null : "fx:id=\"pane14\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_14 != null : "fx:id=\"player1_14\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_14 != null : "fx:id=\"player2_14\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_14 != null : "fx:id=\"player3_14\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_14 != null : "fx:id=\"player4_14\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane15 != null : "fx:id=\"pane15\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_15 != null : "fx:id=\"player1_15\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_15 != null : "fx:id=\"player2_15\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_15 != null : "fx:id=\"player3_15\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_15 != null : "fx:id=\"player4_15\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane16 != null : "fx:id=\"pane16\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_16 != null : "fx:id=\"player1_16\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_16 != null : "fx:id=\"player2_16\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_16 != null : "fx:id=\"player3_16\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_16 != null : "fx:id=\"player4_16\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane17 != null : "fx:id=\"pane17\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_17 != null : "fx:id=\"player1_17\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_17 != null : "fx:id=\"player2_17\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_17 != null : "fx:id=\"player3_17\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_17 != null : "fx:id=\"player4_17\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane18 != null : "fx:id=\"pane18\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_18 != null : "fx:id=\"player1_18\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_18 != null : "fx:id=\"player2_18\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_18 != null : "fx:id=\"player3_18\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_18 != null : "fx:id=\"player4_18\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane19 != null : "fx:id=\"pane19\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_19 != null : "fx:id=\"player1_19\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_19 != null : "fx:id=\"player2_19\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_19 != null : "fx:id=\"player3_19\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_19 != null : "fx:id=\"player4_19\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane30 != null : "fx:id=\"pane30\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_30 != null : "fx:id=\"player1_30\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_30 != null : "fx:id=\"player2_30\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_30 != null : "fx:id=\"player3_30\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_30 != null : "fx:id=\"player4_30\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane29 != null : "fx:id=\"pane29\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_29 != null : "fx:id=\"player1_29\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_29 != null : "fx:id=\"player2_29\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_29 != null : "fx:id=\"player3_29\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_29 != null : "fx:id=\"player4_29\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane28 != null : "fx:id=\"pane28\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_28 != null : "fx:id=\"player1_28\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_28 != null : "fx:id=\"player2_28\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_28 != null : "fx:id=\"player3_28\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_28 != null : "fx:id=\"player4_28\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane27 != null : "fx:id=\"pane27\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_27 != null : "fx:id=\"player1_27\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_27 != null : "fx:id=\"player2_27\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_27 != null : "fx:id=\"player3_27\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_27 != null : "fx:id=\"player4_27\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane26 != null : "fx:id=\"pane26\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_26 != null : "fx:id=\"player1_26\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_26 != null : "fx:id=\"player2_26\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_26 != null : "fx:id=\"player3_26\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_26 != null : "fx:id=\"player4_26\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane25 != null : "fx:id=\"pane25\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_25 != null : "fx:id=\"player1_25\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_25 != null : "fx:id=\"player2_25\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_25 != null : "fx:id=\"player3_25\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_25 != null : "fx:id=\"player4_25\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane24 != null : "fx:id=\"pane24\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_24 != null : "fx:id=\"player1_24\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_24 != null : "fx:id=\"player2_24\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_24 != null : "fx:id=\"player3_24\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_24 != null : "fx:id=\"player4_24\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane23 != null : "fx:id=\"pane23\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_23 != null : "fx:id=\"player1_23\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_23 != null : "fx:id=\"player2_23\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_23 != null : "fx:id=\"player3_23\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_23 != null : "fx:id=\"player4_23\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane22 != null : "fx:id=\"pane22\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_22 != null : "fx:id=\"player1_22\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_22 != null : "fx:id=\"player2_22\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_22 != null : "fx:id=\"player3_22\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_22 != null : "fx:id=\"player4_22\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane21 != null : "fx:id=\"pane21\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_21 != null : "fx:id=\"player1_21\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_21 != null : "fx:id=\"player2_21\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_21 != null : "fx:id=\"player3_21\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_21 != null : "fx:id=\"player4_21\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane20 != null : "fx:id=\"pane20\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_20 != null : "fx:id=\"player1_20\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_20 != null : "fx:id=\"player2_20\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_20 != null : "fx:id=\"player3_20\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_20 != null : "fx:id=\"player4_20\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane39 != null : "fx:id=\"pane39\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_39 != null : "fx:id=\"player1_39\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_39 != null : "fx:id=\"player2_39\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_39 != null : "fx:id=\"player3_39\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_39 != null : "fx:id=\"player4_39\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane38 != null : "fx:id=\"pane38\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_38 != null : "fx:id=\"player1_38\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_38 != null : "fx:id=\"player2_38\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_38 != null : "fx:id=\"player3_38\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_38 != null : "fx:id=\"player4_38\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane37 != null : "fx:id=\"pane37\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_37 != null : "fx:id=\"player1_37\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_37 != null : "fx:id=\"player2_37\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_37 != null : "fx:id=\"player3_37\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_37 != null : "fx:id=\"player4_37\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane36 != null : "fx:id=\"pane36\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_36 != null : "fx:id=\"player1_36\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_36 != null : "fx:id=\"player2_36\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_36 != null : "fx:id=\"player3_36\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_36 != null : "fx:id=\"player4_36\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane35 != null : "fx:id=\"pane35\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_35 != null : "fx:id=\"player1_35\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_35 != null : "fx:id=\"player2_35\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_35 != null : "fx:id=\"player3_35\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_35 != null : "fx:id=\"player4_35\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane34 != null : "fx:id=\"pane34\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_34 != null : "fx:id=\"player1_34\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_34 != null : "fx:id=\"player2_34\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_34 != null : "fx:id=\"player3_34\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_34 != null : "fx:id=\"player4_34\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane33 != null : "fx:id=\"pane33\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_33 != null : "fx:id=\"player1_33\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_33 != null : "fx:id=\"player2_33\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_33 != null : "fx:id=\"player3_33\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_33 != null : "fx:id=\"player4_33\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane32 != null : "fx:id=\"pane32\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_32 != null : "fx:id=\"player1_32\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_32 != null : "fx:id=\"player2_32\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_32 != null : "fx:id=\"player3_32\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_32 != null : "fx:id=\"player4_32\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert pane31 != null : "fx:id=\"pane31\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player1_31 != null : "fx:id=\"player1_31\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player2_31 != null : "fx:id=\"player2_31\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player3_31 != null : "fx:id=\"player3_31\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert player4_31 != null : "fx:id=\"player4_31\" was not injected: check your FXML file 'TalUI.fxml'.";
          assert buttonMenu != null : "fx:id=\"buttonMenu\" was not injected: check your FXML file 'TalUI.fxml'.";
        initializeTiles();
    }
       
         
    
    /*
    @FXML
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'.";
        assert frmNickname != null : "fx:id=\"frmNickname\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'.";
    }
    */
    @FXML
    void initializeTiles(){
    	 /*panes.add(pane0);
    	 panes.add(pane1);*/
    	 
    	players[0][0] = player1_0;
    	players[0][1] = player2_0;
    	players[0][2] = player3_0;
    	players[0][3] = player4_0;
    	players[1][0] = player1_1;
    	players[1][1] = player2_1;
    	players[1][2] = player3_1;
    	players[1][3] = player4_1;
    	players[2][0] = player1_2;
    	players[2][1] = player2_2;
    	players[2][2] = player3_2;
    	players[2][3] = player4_2;
    	players[3][0] = player1_3;
    	players[3][1] = player2_3;
    	players[3][2] = player3_3;
    	players[3][3] = player4_3;
    	players[4][0] = player1_4;
    	players[4][1] = player2_4;
    	players[4][2] = player3_4;
    	players[4][3] = player4_4;
    	players[5][0] = player1_5;
    	players[5][1] = player2_5;
    	players[5][2] = player3_5;
    	players[5][3] = player4_5;
    	players[6][0] = player1_6;
    	players[6][1] = player2_6;
    	players[6][2] = player3_6;
    	players[6][3] = player4_6;
    	players[7][0] = player1_7;
    	players[7][1] = player2_7;
    	players[7][2] = player3_7;
    	players[7][3] = player4_7;
    	players[8][0] = player1_8;
    	players[8][1] = player2_8;
    	players[8][2] = player3_8;
    	players[8][3] = player4_8;
    	players[9][0] = player1_9;
    	players[9][1] = player2_9;
    	players[9][2] = player3_9;
    	players[9][3] = player4_9;
    	players[10][0] = player1_10;
    	players[10][1] = player2_10;
    	players[10][2] = player3_10;
    	players[10][3] = player4_10;
    	players[11][0] = player1_11;
    	players[11][1] = player2_11;
    	players[11][2] = player3_11;
    	players[11][3] = player4_11;
    	players[12][0] = player1_12;
    	players[12][1] = player2_12;
    	players[12][2] = player3_12;
    	players[12][3] = player4_12;
    	players[13][0] = player1_13;
    	players[13][1] = player2_13;
    	players[13][2] = player3_13;
    	players[13][3] = player4_13;
    	players[14][0] = player1_14;
    	players[14][1] = player2_14;
    	players[14][2] = player3_14;
    	players[14][3] = player4_14;
    	players[15][0] = player1_15;
    	players[15][1] = player2_15;
    	players[15][2] = player3_15;
    	players[15][3] = player4_15;
    	players[16][0] = player1_16;
    	players[16][1] = player2_16;
    	players[16][2] = player3_16;
    	players[16][3] = player4_16;
    	players[17][0] = player1_17;
    	players[17][1] = player2_17;
    	players[17][2] = player3_17;
    	players[17][3] = player4_17;
    	players[18][0] = player1_18;
    	players[18][1] = player2_18;
    	players[18][2] = player3_18;
    	players[18][3] = player4_18;
    	players[19][0] = player1_19;
    	players[19][1] = player2_19;
    	players[19][2] = player3_19;
    	players[19][3] = player4_19;
    	players[20][0] = player1_20;
    	players[20][1] = player2_20;
    	players[20][2] = player3_20;
    	players[20][3] = player4_20;
    	players[21][0] = player1_21;
    	players[21][1] = player2_21;
    	players[21][2] = player3_21;
    	players[21][3] = player4_21;
    	players[22][0] = player1_22;
    	players[22][1] = player2_22;
    	players[22][2] = player3_22;
    	players[22][3] = player4_22;
    	players[23][0] = player1_23;
    	players[23][1] = player2_23;
    	players[23][2] = player3_23;
    	players[23][3] = player4_23;
    	players[24][0] = player1_24;
    	players[24][1] = player2_24;
    	players[24][2] = player3_24;
    	players[24][3] = player4_24;
    	players[25][0] = player1_25;
    	players[25][1] = player2_25;
    	players[25][2] = player3_25;
    	players[25][3] = player4_25;
    	players[26][0] = player1_26;
    	players[26][1] = player2_26;
    	players[26][2] = player3_26;
    	players[26][3] = player4_26;
    	players[27][0] = player1_27;
    	players[27][1] = player2_27;
    	players[27][2] = player3_27;
    	players[27][3] = player4_27;
    	players[28][0] = player1_28;
    	players[28][1] = player2_28;
    	players[28][2] = player3_28;
    	players[28][3] = player4_28;
    	players[29][0] = player1_29;
    	players[29][1] = player2_29;
    	players[29][2] = player3_29;
    	players[29][3] = player4_29;
    	players[30][0] = player1_30;
    	players[30][1] = player2_30;
    	players[30][2] = player3_30;
    	players[30][3] = player4_30;
    	players[31][0] = player1_31;
    	players[31][1] = player2_31;
    	players[31][2] = player3_31;
    	players[31][3] = player4_31;
    	players[32][0] = player1_32;
    	players[32][1] = player2_32;
    	players[32][2] = player3_32;
    	players[32][3] = player4_32;
    	players[33][0] = player1_33;
    	players[33][1] = player2_33;
    	players[33][2] = player3_33;
    	players[33][3] = player4_33;
    	players[34][0] = player1_34;
    	players[34][1] = player2_34;
    	players[34][2] = player3_34;
    	players[34][3] = player4_34;
    	players[35][0] = player1_35;
    	players[35][1] = player2_35;
    	players[35][2] = player3_35;
    	players[35][3] = player4_35;
    	players[36][0] = player1_36;
    	players[36][1] = player2_36;
    	players[36][2] = player3_36;
    	players[36][3] = player4_36;
    	players[37][0] = player1_37;
    	players[37][1] = player2_37;
    	players[37][2] = player3_37;
    	players[37][3] = player4_37;
    	players[38][0] = player1_38;
    	players[38][1] = player2_38;
    	players[38][2] = player3_38;
    	players[38][3] = player4_38;
    	players[39][0] = player1_39;
    	players[39][1] = player2_39;
    	players[39][2] = player3_39;
    	players[39][3] = player4_39;
    	 
    	 for (int i=1; i<40; i++)
    		 for (int j=0; j<4; j++)
    			 players[i][j].setVisible(false);
    	 
    }

    
    @FXML
     void positionPlayers(){//List <Player> players){
    	
    	int player=2;
    	int current=0;
    	int dice=4;
    	
    	players[current][player].setVisible(false);
		players[dice+current][player].setVisible(true);
    		
    		  	
    }
    private void move(int i){
    	players[i][2].setVisible(false);
		players[i+1][2].setVisible(true);

    }
    public void start(Stage primaryStage) throws Exception {

        // just load fxml file and display it in the stage:

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void menuButton(){
    	iWindow.swap(Window.Player_Menu);
    }
    
    
    
}
