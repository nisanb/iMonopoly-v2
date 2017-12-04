package View.Game.Controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.IntBinaryOperator;

import Controller.Logger;
import Controller.iWindow;
import Entity.Player;
import Entity.Question;
import Utils.Window;
import View.IGameEngine;
import View.Admin.Controller.SysParam;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class UI implements UIInterface{
	
	private static UI _instance = null;
	

	List<String> playersList = new ArrayList<>();

	ImageView playerPics[] = new ImageView[playersList.size()];
	ImageView[][] players = new ImageView[40][4];
	ImageView[] roll1= new ImageView[6];
	ImageView[] roll2= new ImageView[6];
	
	public static final double playerStatsLeyoutx=80;
	public static final int[] playersStatsY={60,150,240,330};

	public static final IGameEngine ge = iWindow.getGameEngine();
	
	
	
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
	    
	    @FXML
	    private ImageView playerBlueStats = new ImageView();

	    @FXML
	    private ImageView playerYellowStats = new ImageView();

	    @FXML
	    private ImageView playerGreenStats= new ImageView();

	    @FXML
	    private ImageView playerRedStats= new ImageView();

	    @FXML
	    private Pane player1StatsPane = new Pane();

	    @FXML
	    private Label lblMoney1= new Label();

	    @FXML
	    private Label lblStrikes1= new Label();

	    @FXML
	    private Label moneyPlayer1= new Label();

	    @FXML
	    private Label strikesPlayer1= new Label();

	    @FXML
	    private Pane player2StatsPane= new Pane();

	    @FXML
	    private Label lblMoney2= new Label();

	    @FXML
	    private Label lblStrikes2= new Label();

	    @FXML
	    private Label moneyPlayer2= new Label();

	    @FXML
	    private Label strikesPlayer2= new Label();
	    
	    @FXML
	    private Pane player3StatsPane= new Pane();

	    @FXML
	    private Label lblMoney3= new Label();

	    @FXML
	    private Label lblStrikes3= new Label();

	    @FXML
	    private Label moneyPlayer3= new Label();
	    
	    @FXML
	    private Label moneyPlayer4= new Label();

	    @FXML
	    private Label strikesPlayer3= new Label();

	    @FXML
	    private Pane player4StatsPane= new Pane();

	    @FXML
	    private Label lblMoney4= new Label();

	    @FXML
	    private Label lblStrikes4= new Label();

	    @FXML
	    private Label strikesPlayer4= new Label();

	    @FXML
	    private Button btnBuyProperty = new Button();

	    @FXML
	    private Button btnSellProperty= new Button();

	    @FXML
	    private Button btnQuitGame= new Button();

	    @FXML
	    private Pane rollDicePane = new Pane();

	    @FXML
	    private Pane cube2pane= new Pane();

	    @FXML
	    private ImageView roll2_1= new ImageView();

	    @FXML
	    private ImageView roll2_2= new ImageView();

	    @FXML
	    private ImageView roll2_3= new ImageView();

	    @FXML
	    private ImageView roll2_4= new ImageView();

	    @FXML
	    private ImageView roll2_5= new ImageView();

	    @FXML
	    private ImageView roll2_6= new ImageView();

	    @FXML
	    private Button btnRollDice = new Button();

	    @FXML
	    private Pane cube1Pane= new Pane();

	    @FXML
	    private ImageView roll1_1 = new ImageView();

	    @FXML
	    private ImageView roll1_2 = new ImageView();

	    @FXML
	    private ImageView roll1_3= new ImageView();

	    @FXML
	    private ImageView roll1_4= new ImageView();

	    @FXML
	    private ImageView roll1_5= new ImageView();

	    @FXML
	    private ImageView roll1_6= new ImageView();
	    
	    @FXML
	    private AnchorPane inBoardMenu = new AnchorPane();

	    @FXML
	    private ScrollPane gameLogScrollPane = new ScrollPane();

	    @FXML
	    private TextArea gameLogs = new TextArea();

	    @FXML
	    private Pane questionsPane = new Pane();

	    @FXML
	    private Pane questionsPane1 = new Pane();

	    @FXML
	    private Label playerXIsAnswering = new Label();

	    @FXML
	    private Label lblplayerXIsAnswering1 = new Label();

	    @FXML
	    private TextArea txtAnsw1;

	    @FXML
	    private TextArea txtAnsw2;

	    @FXML
	    private TextArea txtAnsw3;

	    @FXML
	    private TextArea txtAnsw4;
	    
	    @FXML
	    private Button btnOfferTrade = new Button();
	    
	    @FXML
	    private Label round = new Label();
	    
	    @FXML
	    private Pane questionsPaneContainer = new Pane();
	    
	    @FXML
	    private Label theQuestion= new Label();
	    
	    @FXML
	    private Button btnPayRent= new Button();
	    
	    @FXML
	    private Button btnFinishTurn = new Button();

	    @FXML
	    private Pane paneCurrentTurnPlayer1= new Pane();

	    @FXML
	    private Pane paneCurrentTurnPlayer2= new Pane();

	    @FXML
	    private Pane paneCurrentTurnPlayer3= new Pane();

	    @FXML
	    private Pane paneCurrentTurnPlayer4= new Pane();
	    
	    @FXML
	    private Pane txtAnswerPane1 = new Pane();
	    
	    @FXML
	    private Pane txtAnswerPane2= new Pane();
	    
	    @FXML
	    private Pane txtAnswerPane3 = new Pane();
	    
	    @FXML
	    private Pane txtAnswerPane4 = new Pane();
	    
	    @FXML // fx:id="player1Container"
	    private AnchorPane player1Container = new AnchorPane(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="valuePlayer1"
	    private Label valuePlayer1 = new Label(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="player2Container"
	    private AnchorPane player2Container = new AnchorPane(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="valuePlayer2"
	    private Label valuePlayer2 = new Label(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="player3Container"
	    private AnchorPane player3Container = new AnchorPane(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="valuePlayer3"
	    private Label valuePlayer3 = new Label(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="player2Container"
	    private AnchorPane player4Container = new AnchorPane(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="valuePlayer2"
	    private Label valuePlayer4 = new Label(); // Value injected by FXMLLoader
	    
	    @FXML // fx:id="lblValue1"
	    private Label lblValue1; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="lblValue1"
	    private Label lblValue2; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="lblValue1"
	    private Label lblValue3; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="lblValue1"
	    private Label lblValue4; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="buyRentPane"
	    private Pane buyRentPane; // Value injected by FXMLLoader

	    @FXML // fx:id="playerXRentOrBuy"
	    private Label playerXRentOrBuy; // Value injected by FXMLLoader

	    @FXML // fx:id="txtBuyPrice"
	    private Label txtBuyPrice; // Value injected by FXMLLoader

	    @FXML // fx:id="txtRentPrice"
	    private Label txtRentPrice; // Value injected by FXMLLoader

	    @FXML // fx:id="sellTradePane"
	    private Pane sellTradePane = new Pane(); // Value injected by FXMLLoader
	    
	    @FXML 
	    private Pane inBoardWhitePane; // Value injected by FXMLLoader
	    

	    @FXML // fx:id="playerXSellOrTrade"
	    private Label playerXSellOrTrade; // Value injected by FXMLLoader
	    @FXML 
	    private Button buttonQuitGame= new Button();
	    @FXML
	    private Label lblRound;
	    @FXML
	    private Pane txtAnswerPane= new Pane();
	    
	    @FXML 
	    private Label txtPlayer2Name= new Label();
	    @FXML 
	    private Label txtPlayer1Name= new Label();
	    @FXML 
	    private Label txtPlayer3Name= new Label();
	    @FXML 
	    private Label txtPlayer4Name= new Label();
	     
	    
	    

	    
	    Pane currentPlayerPanes[]={paneCurrentTurnPlayer1,paneCurrentTurnPlayer2,paneCurrentTurnPlayer3,paneCurrentTurnPlayer4};
	    Label playersStrikes[]={strikesPlayer1,strikesPlayer2,strikesPlayer3,strikesPlayer4};
	    Label playersCash[]={moneyPlayer1,moneyPlayer2,moneyPlayer3,moneyPlayer4};
	    Label playersValue[]={valuePlayer1,valuePlayer2,valuePlayer3,valuePlayer4};
	    Pane inBoardPanes[] = {txtAnswerPane, buyRentPane, sellTradePane};
	    @FXML
	    private Button btnTest = new Button();
	    
	   
	public UI() {
		super();
	}
	

	public void buildBoard(){
		initialize();
		/*
		
		for (int i=0; i<playersList.size(); i++){
			if (playersList.get(i).getPlayerColor()==Color.yellow){
				playerYellowStats.setLayoutY(playersStatsY[i]);
				playerPics[i]=playerYellowStats;
					
			}
			if (playersList.get(i).getPlayerColor()==Color.blue){
				playerBlueStats.setLayoutY(playersStatsY[i]);
				playerPics[i]=playerBlueStats;
			}
			if (playersList.get(i).getPlayerColor()==Color.red){
				playerRedStats.setLayoutY(playersStatsY[i]);
				playerPics[i]=playerRedStats;
			}
			if (playersList.get(i).getPlayerColor()==Color.green){
				playerGreenStats.setLayoutY(playersStatsY[i]);
				playerPics[i]=playerGreenStats;
			}
		}
		*/
	}

	public void initializeGame(){
			
	}
	

	public void answeringQuestion(String playerNickname, Question question){
		
	}
	@FXML
	public void buyProperty(){
		ge.btnBuyProperty();
	}
	@FXML
	public void sellProperty(){
		ge.btnSellProperty();
	}
	@FXML
	public void offerTrade(){
		ge.btnOfferTrade();
	}
	@FXML
	 void rollDice(){
		initializeDicesBeforeRoll();
		ge.btnRollDice();
	}

    private void initializeDicesBeforeRoll() {
        	for (int i=0; i<6; i++){
        		roll1[i].setVisible(false);
        		roll2[i].setVisible(false);
        	}	
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
    

	public static UI getInstance() {
		return _instance;
	}

	@Override
	public void movePlayer(String player, int tileFrom, int tileTo) {
		int playerPosition= playersList.indexOf(player);
		players[tileFrom][playerPosition].setVisible(false);
		players[tileTo][playerPosition].setVisible(true);
		
	}
	@FXML
    void btnTest(MouseEvent event) {
	gameLogScrollPane.setVisible(!gameLogScrollPane.isVisible());
	questionsPane.setVisible(!questionsPane.isVisible());
	txtAnswerPane.setVisible(!txtAnswerPane.isVisible());
		
	}

	@Override
	public void allowPurchase(Boolean allow) {
		btnBuyProperty.setDisable(!allow);
		System.err.println("Purchase Button: "+allow);
		
	}

	@Override
	public void allowRent(Boolean allow) {
		btnPayRent.setDisable(!allow);
		
	}

	@Override
	public void allowRollDice(Boolean enabled) {
		btnRollDice.setDisable(!enabled);
		
	}

	@Override
	public void finishGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayQuestion(Question question, String player) {
		gameLogScrollPane.setVisible(false);
		questionsPane.setVisible(true);
		playerXIsAnswering.setText(player + " is answering question :");
		theQuestion.setText(question.getqQuestion());
		txtAnsw1.setText(question.getqAnswers().get(0)+"");
		txtAnsw2.setText(question.getqAnswers().get(1)+"");
		txtAnsw3.setText(question.getqAnswers().get(2)+"");
		txtAnsw4.setText(question.getqAnswers().get(3)+"");
		txtAnswerPane1.setVisible(false);
		txtAnswerPane2.setVisible(false);
		txtAnswerPane3.setVisible(false);
		txtAnswerPane4.setVisible(false);
		
	}

	@Override
	public void updateCurrentPlayer(String nickname) {
		System.out.println("want to add glow");
		for (int i=0; i<playersList.size(); i++){
			if (playersList.get(i).equals(nickname)){
				System.out.println(i);
				System.out.println("want to add glow");
				addGlow(i+1);
			}
			
		}
	}



	@Override
	public void gameLog(String message) {
		gameLogs.setText(message+"\n"+gameLogs.getText());
		gameLogDisplay(true);
	}

	@Override
	public void gameLogDisplay(Boolean display) {
		questionsPane.setVisible(!display);
		questionsPaneContainer.setVisible(!display);
		gameLogScrollPane.setVisible(display);
		
	}
	

    @FXML
    void sendAnswerBtn(MouseEvent event) {
    	List<Integer> answers = new ArrayList<Integer>();
    	if (txtAnswerPane1.isVisible())
    		answers.add(1);
    	if (txtAnswerPane2.isVisible())
    		answers.add(2);
    	if (txtAnswerPane3.isVisible())
    		answers.add(3);
    	if (txtAnswerPane4.isVisible())
    		answers.add(4);
    	System.out.println(answers+" are the answers");
    	//ge.AnswerQuestion(answers);
    }

	@FXML
	 void answer1(MouseEvent event){
		txtAnswerPane1.setVisible(!txtAnswerPane1.isVisible());
		System.out.println("a");
		//ge.AnswerQuestion(1);
	}
	@FXML
	 void answer2(MouseEvent event){
		txtAnswerPane2.setVisible(!txtAnswerPane2.isVisible());
		System.out.println("aa");
		//ge.AnswerQuestion(2);
	}
	@FXML
	 void answer3(MouseEvent event){
		txtAnswerPane3.setVisible(!txtAnswerPane3.isVisible());
		System.out.println("aaa");
		//ge.AnswerQuestion(3);
	}
	@FXML
	 void answer4(MouseEvent event){
		txtAnswerPane4.setVisible(!txtAnswerPane4.isVisible());
		System.out.println("aaaa");
		//ge.AnswerQuestion(4);
	}
	
    
	@Override
	public void BuildBoard() {	
		txtPlayer1Name.setText(playersList.get(0));
		txtPlayer2Name.setText(playersList.get(1));
		setInMenuPanesInVisible();
		gameLogDisplay(true);
		player3Container.setVisible(false);
		player4Container.setVisible(false);
		players[0][3].setVisible(false);
		players[0][2].setVisible(false);
		if  (playersList.size()>2 ) {
			txtPlayer3Name.setText(playersList.get(2));
			player3Container.setVisible(true);
			players[0][2].setVisible(true);
		}
		if (playersList.size()>3) {
			txtPlayer4Name.setText(playersList.get(3));
			player4Container.setVisible(true);
			players[0][3].setVisible(true);
		}
	}

	@Override
	public void showAnswer(int answerNum) {
		if (answerNum==1)
			txtAnswerPane1.setVisible(true);
		if (answerNum==2)
			txtAnswerPane2.setVisible(true);
		if (answerNum==3)
			txtAnswerPane3.setVisible(true);
		if (answerNum==4)
			txtAnswerPane4.setVisible(true);
	}
	
	@Override
	public void changeDice(int diceNumber, int amount) {
		if (diceNumber==1)
			roll1[amount-1].setVisible(true);
		if (diceNumber==2)
			roll2[amount-1].setVisible(true);
		
	}
	
	@Override
	public boolean buyOrRentProperty(int buyAmount, int rentAmount, String player, String AssetName) {
		// TODO Auto-generated method stub
		return false;
	}
    
	@Override
	public void updatePlayerProperties(String nickname, Integer cash, Integer strikes, Integer assetsWorth,
			Integer assetsAmount) {
		int pos=playersList.indexOf(nickname);
		System.out.println(pos+ " pos");


		switch (pos){
			case (0):{
				moneyPlayer1.setText(cash+"$");
				strikesPlayer1.setText(strikes+"");
				String temp=assetsWorth+"(#"+assetsAmount+")";
				valuePlayer1.setText(assetsWorth+"$"+ " (#"+assetsAmount+")");
				break;
			}
			case (1):{
				moneyPlayer2.setText(cash+"$");
				strikesPlayer2.setText(strikes+"");
				valuePlayer2.setText(assetsWorth+"$"+ " (#"+assetsAmount+")");
				break;
			}
			case (2):{
				moneyPlayer3.setText(cash+"$");
				strikesPlayer3.setText(strikes+"");
				valuePlayer3.setText(assetsWorth+"$"+ " (#"+assetsAmount+")");
				break;
			}
			case (3):{
				moneyPlayer4.setText(cash+"$");
				strikesPlayer4.setText(strikes+"");
				valuePlayer4.setText(assetsWorth+"$"+ " (#"+assetsAmount+")");
				break;
			}
			
		}		

	}
	
	@Override
	public void allowFinishTurn(Boolean enabled) {
		btnFinishTurn.setDisable(!enabled);
		
	}
    
   //////////////////////////////////////////////////initialize 
    
    private void initializeDicesFirstTime() {
    	roll1[0]=roll1_1;
    	roll1[1]=roll1_2;
    	roll1[2]=roll1_3;
    	roll1[3]=roll1_4;
    	roll1[4]=roll1_5;
    	roll1[5]=roll1_6;
    	roll2[0]=roll2_1;
    	roll2[1]=roll2_2;
    	roll2[2]=roll2_3;
    	roll2[3]=roll2_4;
    	roll2[4]=roll2_5;
    	roll2[5]=roll2_6;
		
    	for (int i=0; i<6; i++){
    		roll1[i].setVisible(false);
    		roll2[i].setVisible(false);
    	}
    }
    
    
    
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
    	 System.out.println("visible? "+ players[8][0].isVisible()); 
    }
 
    @FXML
    void initialize() {
    	  _instance = this;
          ge.setUI(this);
        initializeTiles();
        initializeDicesFirstTime();
        BuildBoard();
    }
    
    private void addGlow(int playerNum){
    	int depth = 120;//Setting the uniform variable for the glow width and height
    	javafx.scene.paint.Color red = null;
    	red = new javafx.scene.paint.Color(1, 0, 0, 1);
    	Effect glow = new Glow(1);
    	DropShadow borderGlow= new DropShadow();
    	borderGlow.setOffsetY(0f);
    	borderGlow.setOffsetX(0f);
    	borderGlow.setColor(red);
    	borderGlow.setWidth(depth);
    	borderGlow.setHeight(depth);
    	txtPlayer1Name.setEffect(new Glow(0)); //Apply the borderGlow effect to the JavaFX node
    	txtPlayer2Name.setEffect(new Glow(0)); //Apply the borderGlow effect to the JavaFX node
    	txtPlayer3Name.setEffect(new Glow(0)); //Apply the borderGlow effect to the JavaFX node
    	txtPlayer4Name.setEffect(new Glow(0));
    	switch (playerNum){
    		case (1): {txtPlayer1Name.setEffect(glow); //Apply the borderGlow effect to the JavaFX node
    
    			break;
    		}
    		case (2): {txtPlayer2Name.setEffect(glow); //Apply the borderGlow effect to the JavaFX node
    			break;
    		
    		}
    		case (3):{ txtPlayer3Name.setEffect(glow); //Apply the borderGlow effect to the JavaFX node
    			break;
    		}
    		case (4): {txtPlayer4Name.setEffect(glow); //Apply the borderGlow effect to the JavaFX node
    			break;
    		}
    	}
    }


	@Override
	public void build(List<String> playerList) {
		Logger.log("Adding "+playerList.size()+" players to Game UI");
		this.playersList.addAll(playerList);
		
	}

	@Override
	public void allowSellProperty(Boolean allow) {
		btnSellProperty.setDisable(!allow);


		
	}
	
	@FXML
    void btnFinishTurn(ActionEvent event) {
		setInMenuPanesInVisible();
		gameLogScrollPane.setVisible(true);
		ge.btnFinishTurn();
		
	}
	@FXML
    void btnBuyProperty(ActionEvent event) {
		setInMenuPanesInVisible();
		buyRentPane.setVisible(true);
		ge.btnBuyProperty();
	}
	
	void setInMenuPanesInVisible(){
		txtAnswerPane.setVisible(false);
		buyRentPane.setVisible(false);
		gameLogScrollPane.setVisible(false);
		sellTradePane.setVisible(false);
	}
	 @FXML
	 void btnOfferAtTade(ActionEvent event) {
		 setInMenuPanesInVisible();
		 sellTradePane.setVisible(true);
	    }
	 @FXML
	 void btnPayRent(ActionEvent event) {
		 setInMenuPanesInVisible();
		 btnPayRent.setVisible(true);
	    }
	 @FXML
	  void btnSellProperty(ActionEvent event) {
		 setInMenuPanesInVisible();
		 sellTradePane.setVisible(true);
	    }
	 
	public void landOnEmptyPropertyButtonsDisplay(){
		 allowPurchase(true);
		 allowSellProperty(false);
		 allowRent(false);
		 allowFinishTurn(true);
		 allowRollDice(false);
	 }
	public void landOnOwnerPropertyButtonsDisplay(){
		 allowPurchase(true);
		 allowSellProperty(false);
		 allowFinishTurn(false);
		 allowRent(false);
		 allowRollDice(false);
	 }
	public void landOnQuestionMarkButtonsDisplay(){
		 allowPurchase(false);
		 allowSellProperty(false);
		 allowFinishTurn(false);
		 allowRent(false);
		 allowRollDice(false);
	 }
	public void beforeRollDiceButtonsDisplay(){
		 allowFinishTurn(false);
		 allowPurchase(false);
		 allowRent(false);
		 allowSellProperty(true);
		 allowRollDice(true);
	 }
	public void landOnLuckyTileButtonsDisplay(){
		 allowPurchase(false);
		 allowSellProperty(false);
		 allowFinishTurn(false);
		 allowRent(false);
		 allowRollDice(false);
	 }
	public void finishedATileButtonsDisplay(){
		 allowPurchase(false);
		 allowSellProperty(false);
		 allowFinishTurn(true);
		 allowRent(false);
		 allowRollDice(false);
	 }
	public void landOnAJailButtonsDisplay(){
		 allowPurchase(false);
		 allowSellProperty(false);
		 allowFinishTurn(true);
		 allowRent(false);
		 allowRollDice(false);
	 }
	public void landOnAGoTileButtonsDisplay(){
		 allowPurchase(false);
		 allowSellProperty(false);
		 allowFinishTurn(true);
		 allowRent(false);
		 allowRollDice(false);
	 }
	
	public void landOnHisOwnPropertyButtonsDisplay(){
		 allowPurchase(false);
		 allowSellProperty(false);
		 allowFinishTurn(true);
		 allowRent(false);
		 allowRollDice(false);
	}
}
