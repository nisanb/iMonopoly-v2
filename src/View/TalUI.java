package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

	public ArrayList<Pane> panes=new ArrayList<>();
	 @FXML
	    private ImageView player1 = new ImageView();

	    @FXML
	    private ImageView player3 = new ImageView();

	    @FXML
	    private ImageView player4= new ImageView();

	    @FXML
	    private ImageView player2= new ImageView();

	    @FXML
	    private Pane parentPane;
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

	    @FXML
	    private Button button1;

	    @FXML
	    void initialize(ActionEvent event) {
	    	initialize2();
	    }
	    
    public TalUI() {
			super();
			initialize2();
			initializeTiles();
		}

	/*
    @FXML
    void doLogin(ActionEvent event) {
    	Music.getInstance().play("click.wav");
    	Logger.log("Attempting to log in with user "+frmNickname.getText());
    	iWindow.swap(Window.Login);
    }
    */
    @FXML
    void initialize2() {
    	assert parentPane != null : "fx:id=\"parentPane\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert player1 != null : "fx:id=\"player1\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert player3 != null : "fx:id=\"player3\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert player4 != null : "fx:id=\"player4\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert player2 != null : "fx:id=\"player2\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane0 != null : "fx:id=\"pane0\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane2 != null : "fx:id=\"pane2\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane3 != null : "fx:id=\"pane3\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane4 != null : "fx:id=\"pane4\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane5 != null : "fx:id=\"pane5\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane6 != null : "fx:id=\"pane6\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane7 != null : "fx:id=\"pane7\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane8 != null : "fx:id=\"pane8\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane9 != null : "fx:id=\"pane9\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane10 != null : "fx:id=\"pane10\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane11 != null : "fx:id=\"pane11\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane12 != null : "fx:id=\"pane12\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane13 != null : "fx:id=\"pane13\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane14 != null : "fx:id=\"pane14\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane15 != null : "fx:id=\"pane15\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane16 != null : "fx:id=\"pane16\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane17 != null : "fx:id=\"pane17\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane18 != null : "fx:id=\"pane18\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane19 != null : "fx:id=\"pane19\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane20 != null : "fx:id=\"pane20\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane21 != null : "fx:id=\"pane21\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane22 != null : "fx:id=\"pane22\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane23 != null : "fx:id=\"pane23\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane24 != null : "fx:id=\"pane24\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane25 != null : "fx:id=\"pane25\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane26 != null : "fx:id=\"pane26\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane27 != null : "fx:id=\"pane27\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane28 != null : "fx:id=\"pane28\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane29 != null : "fx:id=\"pane29\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane30 != null : "fx:id=\"pane30\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane31 != null : "fx:id=\"pane31\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane32 != null : "fx:id=\"pane32\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane33 != null : "fx:id=\"pane33\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane34 != null : "fx:id=\"pane34\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane35 != null : "fx:id=\"pane35\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane36 != null : "fx:id=\"pane36\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane37 != null : "fx:id=\"pane37\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane38 != null : "fx:id=\"pane38\" was not injected: check your FXML file 'TalUI.fxml'.";
        assert pane39 != null : "fx:id=\"pane39\" was not injected: check your FXML file 'TalUI.fxml'.";
        
        initializeTiles();
        positionPlayers();

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
    void initializeTiles(){
    	 panes.add(pane0);
    	 panes.add(pane1);
    	 panes.add(pane2);
    	 panes.add(pane3);
    	 panes.add(pane4);
    	 panes.add(pane5);
    	 panes.add(pane6);
    	 panes.add(pane7);
    	 panes.add(pane8);
    	 panes.add(pane9);
    	 panes.add(pane10);
    	 panes.add(pane11);
    	 panes.add(pane12);
    	 panes.add(pane13);
    	 panes.add(pane14);
    	 panes.add(pane15);
    	 panes.add(pane16);
    	 panes.add(pane17);
    	 panes.add(pane18);
    	 panes.add(pane19);
    	 panes.add(pane20);
    	 panes.add(pane21);
    	 panes.add(pane22);
    	 panes.add(pane23);
    	 panes.add(pane24);
    	 panes.add(pane25);
    	 panes.add(pane26);
    	 panes.add(pane27);
    	 panes.add(pane28);
    	 panes.add(pane29);
    	 panes.add(pane30);
    	 panes.add(pane31);
    	 panes.add(pane32);
    	 panes.add(pane33);
    	 panes.add(pane34);
    	 panes.add(pane35);
    	 panes.add(pane36);
    	 panes.add(pane37);
    	 panes.add(pane38);
    	 panes.add(pane39);
    	 
    	
    	
    	 
    		
 
    }
    
     void positionPlayers(){//List <Player> players){
    	int tile=17;
    	
    	
    	player1.setX(panes.get(tile).getLayoutX());
    	player1.setY(panes.get(tile).getLayoutY());
    	System.out.println("pane6 parent is "+ pane6.getParent());
    	System.out.println(panes.get(tile).getLayoutX()+ " layout x");
    	System.out.println(panes.get(tile).getLayoutY()+ " layout y");
    	System.out.println("pane6 is "+panes.get(tile));
    	System.out.println("x is : "+player1.getX());
    	System.out.println("y is : "+player1.getY());
    	
    		
    	

    	
    }
    
    public void start(Stage primaryStage) throws Exception {

        // just load fxml file and display it in the stage:
    	initialize2();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
    	TalUI t = new TalUI();
    	iWindow.swap(Window.MainBoardTal);
    	System.out.println(t.panes.get(0).getLayoutX()+ " this is layout");
    	
    	
    }
    
    
}
