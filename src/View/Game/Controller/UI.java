package View.Game.Controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.prism.impl.ps.CachingShapeRep;

import Controller.GameEngine;
import Controller.iWindow;
import Entity.Player;
import Entity.Question;
import Utils.Window;
import View.IGameEngine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class UI implements UIInterface{
	
	private static UI _instance = null;
	
	ArrayList<Player> playersList = new ArrayList<>();
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
	    private Button btnOfferTrade;
	    
	    @FXML
	    private Label round = new Label();
	    
	    @FXML
	    private Pane questionsPaneContainer;
	    
	    @FXML
	    private Label theQuestion= new Label();
	    
	    @FXML
	    private Button btnPayRent;

	    @FXML
	    private Pane paneCurrentTurnPlayer1;

	    @FXML
	    private Pane paneCurrentTurnPlayer2;

	    @FXML
	    private Pane paneCurrentTurnPlayer3;

	    @FXML
	    private Pane paneCurrentTurnPlayer4;
	    
	    @FXML
	    private Pane txtAnswerPane1;
	    
	    @FXML
	    private Pane txtAnswerPane2;
	    
	    @FXML
	    private Pane txtAnswerPane3;
	    
	    @FXML
	    private Pane txtAnswerPane4;
	    
	    Pane currentPlayerPanes[]={paneCurrentTurnPlayer1,paneCurrentTurnPlayer2,paneCurrentTurnPlayer3,paneCurrentTurnPlayer2};
	    Label playersStrikes[]={strikesPlayer1,strikesPlayer2,strikesPlayer3,strikesPlayer4};
	    Label playersCash[]={moneyPlayer1,moneyPlayer2,moneyPlayer3,moneyPlayer4};
	    
	   
	public UI() {
			super();
			
			//initializeGame(){
			
		}
	
	public void buildBoard(){
		initialize();
		
		
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
	}

	public void initializeGame(){
			
	}
	
	public void answeringQuestion(String playerNickname, Question question){
		
	}
	@FXML
	public void buyProperty(){
		
	}
	@FXML
	public void sellProperty(){
		
	}
	@FXML
	public void offerTrade(){
		
	}
	@FXML
	private void rollDice(){
		initializeDicesBeforeRoll();
		//Board.getInstance().rollADice(playerNickName, gameNum, tileNum)
		//Random r = new Random();
		/*
		int gameNum=Board.getInstance().getCurrentGameNum();
		String playerNickname=Board.getInstance().whosTurn(gameNum);
		int tileNum= Board.getInstance().getCurrentTile(playerNickname);
		int dice1 = (Board.getInstance().rollADice(playerNickname, gameNum, tileNum)).get(0);
		int dice2 = (Board.getInstance().rollADice(playerNickname, gameNum, tileNum)).get(1);
		
		roll1[dice1-1].setVisible(true);
		roll2[dice2-1].setVisible(true);
		moveAPlayer(dice1+dice2);
		*/
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
    
    public void moveAPlayer(int dice){
    	int player=2;
    	int i;
    	for (i=0; i<40; i++)
    		if (players[i][2].isVisible())
    			break;
    	int current=i;
    	players[current][player].setVisible(false);
		players[(dice+current)%40][player].setVisible(true);
		
		
    }
    
    

	public static UI getInstance() {
		return _instance;
	}

	@Override
	public void movePlayer(Player player, int tileFrom, int tileTo) {
		int playerPosition= playersList.indexOf(player);
		players[tileFrom][playerPosition].setVisible(false);
		players[tileTo][playerPosition].setVisible(true);
		
	}

	@Override
	public void allowPurchase(Boolean allow) {
		btnBuyProperty.setDisable(!allow);
		
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
	public void displayQuestion(Question question, Player player) {
		gameLogScrollPane.setVisible(false);
		questionsPane.setVisible(true);
		playerXIsAnswering.setText(player.getNickName()+ " is answering question :");
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
	public void updatePlayerProperties(Player player) {
		int pos=playersList.indexOf(player);
		
		//playersCash[pos].setText(player.get);
		//playersStrikes[pos].setText(player);
		
		
	}

	@Override
	public void updateCurrentPlayer(Player player) {
		for (int i=0; i<playersList.size(); i++){
			if (playersList.get(i).equals(player)){
				currentPlayerPanes[i].setVisible(true);
			}
			else
				currentPlayerPanes[i].setVisible(false);
		}
	}

	@Override
	public void gameLog(String message) {
		gameLogs.setText(gameLogs.getText()+ "\n" +message);
		
	}

	@Override
	public void gameLogDisplay(Boolean display) {
		questionsPane.setVisible(!display);
		questionsPaneContainer.setVisible(!display);
		gameLogScrollPane.setVisible(display);
		
	}
	@FXML
	public void answer1(MouseEvent event){
		ge.AnswerQuestion(1);
	}
	@FXML
	public void answer2(MouseEvent event){
		ge.AnswerQuestion(2);
	}
	@FXML
	public void answer3(MouseEvent event){
		ge.AnswerQuestion(3);
	}
	@FXML
	public void answer4(MouseEvent event){
		ge.AnswerQuestion(4);
	}
	
    
	@Override
	public void BuildBoard() {
		// TODO Auto-generated method stub
		
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
    	 for (Player p: playersList);
    	 
    	 //currentPlayerPanes.add()
    	 
    }
    
    
    @FXML
    void initialize() {
    	  _instance = this;
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
          assert playerBlueStats != null : "fx:id=\"player1Stats\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert playerYellowStats != null : "fx:id=\"player2Stats\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert playerGreenStats != null : "fx:id=\"player3Stats\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert playerRedStats != null : "fx:id=\"player4Stats\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert player1StatsPane != null : "fx:id=\"player1StatsPane\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert player1StatsPane != null : "fx:id=\"player1StatsPane\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblMoney1 != null : "fx:id=\"lblMoney1\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblStrikes1 != null : "fx:id=\"lblStrikes1\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert moneyPlayer1 != null : "fx:id=\"moneyPlayer1\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert strikesPlayer1 != null : "fx:id=\"strikesPlayer1\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert player2StatsPane != null : "fx:id=\"player2StatsPane\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblMoney2 != null : "fx:id=\"lblMoney2\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblStrikes2 != null : "fx:id=\"lblStrikes2\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert moneyPlayer2 != null : "fx:id=\"moneyPlayer2\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert strikesPlayer2 != null : "fx:id=\"strikesPlayer2\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblMoney3 != null : "fx:id=\"lblMoney3\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblStrikes3 != null : "fx:id=\"lblStrikes3\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert moneyPlayer3 != null : "fx:id=\"moneyPlayer3\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert moneyPlayer4 != null : "fx:id=\"moneyPlayer4\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert strikesPlayer3 != null : "fx:id=\"strikesPlayer3\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert player4StatsPane != null : "fx:id=\"player4StatsPane\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblMoney4 != null : "fx:id=\"lblMoney4\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert lblStrikes4 != null : "fx:id=\"lblStrikes4\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert strikesPlayer4 != null : "fx:id=\"strikesPlayer4\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert btnBuyProperty != null : "fx:id=\"btnBuyProperty\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert btnSellProperty != null : "fx:id=\"btnSellProperty\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert btnQuitGame != null : "fx:id=\"btnQuitGame\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert rollDicePane != null : "fx:id=\"rollDicePane\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert cube2pane != null : "fx:id=\"cube2pane\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll2_1 != null : "fx:id=\"roll2_1\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll2_2 != null : "fx:id=\"roll2_2\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll2_3 != null : "fx:id=\"roll2_3\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll2_4 != null : "fx:id=\"roll2_4\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll2_5 != null : "fx:id=\"roll2_5\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll2_6 != null : "fx:id=\"roll2_6\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert btnRollDice != null : "fx:id=\"btnRollDice\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert cube1Pane != null : "fx:id=\"cube1Pane\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll1_1 != null : "fx:id=\"roll1_1\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll1_2 != null : "fx:id=\"roll1_2\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll1_3 != null : "fx:id=\"roll1_3\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll1_4 != null : "fx:id=\"roll1_4\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll1_5 != null : "fx:id=\"roll1_5\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert roll1_6 != null : "fx:id=\"roll1_6\" was not injected: check your FXML file 'Game_UI.fxml'.";
          assert inBoardMenu != null : "fx:id=\"inBoardMenu\" was not injected: check your FXML file 'UI.fxml'.";
          assert gameLogScrollPane != null : "fx:id=\"gameLogScrollPane\" was not injected: check your FXML file 'UI.fxml'.";
          assert gameLogs != null : "fx:id=\"gameLogs\" was not injected: check your FXML file 'UI.fxml'.";
          assert questionsPane != null : "fx:id=\"questionsPane\" was not injected: check your FXML file 'UI.fxml'.";
          assert questionsPane1 != null : "fx:id=\"questionsPane1\" was not injected: check your FXML file 'UI.fxml'.";
          assert playerXIsAnswering != null : "fx:id=\"lblplayerXIsAnswering\" was not injected: check your FXML file 'UI.fxml'.";
          assert lblplayerXIsAnswering1 != null : "fx:id=\"lblplayerXIsAnswering1\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnsw1 != null : "fx:id=\"txtAnsw1\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnsw2 != null : "fx:id=\"txtAnsw2\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnsw3 != null : "fx:id=\"txtAnsw11\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnsw4 != null : "fx:id=\"txtAnsw21\" was not injected: check your FXML file 'UI.fxml'.";
          assert btnOfferTrade != null : "fx:id=\"btnOfferTrade\" was not injected: check your FXML file 'UI.fxml'.";
          assert round != null : "fx:id=\"round\" was not injected: check your FXML file 'UI.fxml'.";
          assert btnPayRent != null : "fx:id=\"btnPayRent\" was not injected: check your FXML file 'UI.fxml'.";
          assert paneCurrentTurnPlayer1 != null : "fx:id=\"paneCurrentTurnPlayer1\" was not injected: check your FXML file 'UI.fxml'.";
          assert paneCurrentTurnPlayer2 != null : "fx:id=\"paneCurrentTurnPlayer2\" was not injected: check your FXML file 'UI.fxml'.";
          assert paneCurrentTurnPlayer3 != null : "fx:id=\"paneCurrentTurnPlayer3\" was not injected: check your FXML file 'UI.fxml'.";
          assert paneCurrentTurnPlayer4 != null : "fx:id=\"paneCurrentTurnPlayer4\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnswerPane2 != null : "fx:id=\"txtAnswerPane2\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnswerPane4 != null : "fx:id=\"txtAnswerPane4\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnswerPane3 != null : "fx:id=\"txtAnswerPane3\" was not injected: check your FXML file 'UI.fxml'.";
          assert txtAnswerPane1 != null : "fx:id=\"txtAnswerPane3\" was not injected: check your FXML file 'UI.fxml'.";
          
        initializeTiles();
        initializeDicesFirstTime();
    }

	@Override
	public void changeDice(int diceNumber, int amount) {
		// TODO Auto-generated method stub
		
	}

	

}
