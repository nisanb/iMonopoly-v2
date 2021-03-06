package View.Game.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.GameEngine;
import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Entity.Answer;
import Entity.Player;
import Entity.Question;
import Utils.NamedColor;
import Utils.QuestionTag;
import Utils.SpecialList;
import Utils.Window;
import View.IGameEngine;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UI implements UIInterface {

	private static UI _instance = null;

	List<String> playersList = new ArrayList<>();

	ImageView[] roll1 = new ImageView[6];
	ImageView[] roll2 = new ImageView[6];

	public static final double playerStatsLeyoutx = 80;
	public static final int[] playersStatsY = { 60, 150, 240, 330 };

	public static IGameEngine ge;

	SpecialList<PlayerUI> playerList;

	@FXML
	private ImageView bgImage;

	@FXML
	private Button button1 = new Button();

	@FXML
	private Button btnBailOut;

	@FXML
	private Button buttonMenu = new Button();

	@FXML
	private Button main = new Button();

	@FXML
	private Label qmPlayerText;

	@FXML
	private ImageView imgPlayer1 = new ImageView();
	@FXML
	private ImageView imgPlayer2 = new ImageView();
	@FXML
	private ImageView imgPlayer3 = new ImageView();
	@FXML
	private ImageView imgPlayer4 = new ImageView();

	@FXML
	private Pane player1StatsPane = new Pane();

	@FXML
	private Pane qmPane;

	@FXML
	private ListView<QuestionTag> qmSelectTag;

	@FXML
	private Button btnQMShow;

	@FXML
	private Label lblMoney1 = new Label();

	@FXML
	private Label lblStrikes1 = new Label();

	@FXML
	private Label moneyPlayer1 = new Label();

	@FXML
	private Label strikesPlayer1 = new Label();

	@FXML
	private Pane player2StatsPane = new Pane();

	@FXML
	private Label lblMoney2 = new Label();

	@FXML
	private Label lblStrikes2 = new Label();

	@FXML
	private Label moneyPlayer2 = new Label();

	@FXML
	private Label strikesPlayer2 = new Label();

	@FXML
	private Pane player3StatsPane = new Pane();

	@FXML
	private Label lblMoney3 = new Label();

	@FXML
	private Label lblStrikes3 = new Label();

	@FXML
	private Label moneyPlayer3 = new Label();

	@FXML
	private Label moneyPlayer4 = new Label();

	@FXML
	private Label strikesPlayer3 = new Label();

	@FXML
	private Pane player4StatsPane = new Pane();

	@FXML
	private Label lblMoney4 = new Label();

	@FXML
	private Label lblStrikes4 = new Label();

	@FXML
	private Label strikesPlayer4 = new Label();

	@FXML
	private Button btnBuyProperty = new Button();

	@FXML
	private Button btnSellProperty = new Button();

	@FXML
	private Button btnQuitGame = new Button();

	@FXML
	private Pane rollDicePane = new Pane();

	@FXML
	private Pane cube2pane = new Pane();

	@FXML
	private ImageView roll2_1 = new ImageView();

	@FXML
	private ImageView roll2_2 = new ImageView();

	@FXML
	private ImageView roll2_3 = new ImageView();

	@FXML
	private ImageView roll2_4 = new ImageView();

	@FXML
	private ImageView roll2_5 = new ImageView();

	@FXML
	private ImageView roll2_6 = new ImageView();

	@FXML
	private Button btnRollDice = new Button();

	@FXML
	private Pane cube1Pane = new Pane();

	@FXML
	private ImageView roll1_1 = new ImageView();

	@FXML
	private ImageView roll1_2 = new ImageView();

	@FXML
	private ImageView roll1_3 = new ImageView();

	@FXML
	private ImageView roll1_4 = new ImageView();

	@FXML
	private ImageView roll1_5 = new ImageView();

	@FXML
	private ImageView roll1_6 = new ImageView();

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
	private TextArea theQuestion = new TextArea();

	@FXML
	private Button btnPayRent = new Button();

	@FXML
	private Button btnFinishTurn = new Button();

	@FXML
	private Pane paneCurrentTurnPlayer1 = new Pane();

	@FXML
	private Pane paneCurrentTurnPlayer2 = new Pane();

	@FXML
	private Pane paneCurrentTurnPlayer3 = new Pane();

	@FXML
	private Pane paneCurrentTurnPlayer4 = new Pane();

	@FXML
	private Pane txtAnswerPane1;

	@FXML
	private Pane txtAnswerPane2;

	@FXML
	private Pane txtAnswerPane3;

	@FXML
	private Pane txtAnswerPane4;

	private Pane[] _answerPanes;
	private TextArea[] _txtAnswerAreas;

	@FXML // fx:id="player1Container"
	private AnchorPane player1Container = new AnchorPane(); // Value injected by
															// FXMLLoader

	@FXML // fx:id="valuePlayer1"
	private Label valuePlayer1 = new Label(); // Value injected by FXMLLoader

	@FXML // fx:id="player2Container"
	private AnchorPane player2Container = new AnchorPane(); // Value injected by
															// FXMLLoader

	@FXML // fx:id="valuePlayer2"
	private Label valuePlayer2 = new Label(); // Value injected by FXMLLoader

	@FXML // fx:id="player3Container"
	private AnchorPane player3Container = new AnchorPane(); // Value injected by
															// FXMLLoader

	@FXML // fx:id="valuePlayer3"
	private Label valuePlayer3 = new Label(); // Value injected by FXMLLoader

	@FXML // fx:id="player2Container"
	private AnchorPane player4Container = new AnchorPane(); // Value injected by
															// FXMLLoader

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
	private Button buttonQuitGame = new Button();
	@FXML
	private Label lblRound;
	@FXML
	private Pane txtAnswerPane = new Pane();

	@FXML
	private Label txtPlayer2Name = new Label();
	@FXML
	private Label txtPlayer1Name = new Label();
	@FXML
	private Label txtPlayer3Name = new Label();
	@FXML
	private Label txtPlayer4Name = new Label();

	/**
	 * Set game flow panes for tile positioning and player movement
	 */
	@FXML
	private FlowPane tile00;
	@FXML
	private FlowPane tile01;
	@FXML
	private FlowPane tile02;
	@FXML
	private FlowPane tile03;
	@FXML
	private FlowPane tile04;
	@FXML
	private FlowPane tile05;
	@FXML
	private FlowPane tile06;
	@FXML
	private FlowPane tile07;
	@FXML
	private FlowPane tile08;
	@FXML
	private FlowPane tile09;
	@FXML
	private FlowPane tile10;
	@FXML
	private FlowPane tile11;
	@FXML
	private FlowPane tile12;
	@FXML
	private FlowPane tile13;
	@FXML
	private FlowPane tile14;
	@FXML
	private FlowPane tile15;
	@FXML
	private FlowPane tile16;
	@FXML
	private FlowPane tile17;
	@FXML
	private FlowPane tile18;
	@FXML
	private FlowPane tile19;
	@FXML
	private FlowPane tile20;
	@FXML
	private FlowPane tile21;
	@FXML
	private FlowPane tile22;
	@FXML
	private FlowPane tile23;
	@FXML
	private FlowPane tile24;
	@FXML
	private FlowPane tile25;
	@FXML
	private FlowPane tile26;
	@FXML
	private FlowPane tile27;
	@FXML
	private FlowPane tile28;
	@FXML
	private FlowPane tile29;
	@FXML
	private FlowPane tile30;
	@FXML
	private FlowPane tile31;
	@FXML
	private FlowPane tile32;
	@FXML
	private FlowPane tile33;
	@FXML
	private FlowPane tile34;
	@FXML
	private FlowPane tile35;
	@FXML
	private FlowPane tile36;
	@FXML
	private FlowPane tile37;
	@FXML
	private FlowPane tile38;
	@FXML
	private FlowPane tile39;

	@FXML
	private CheckBox cb1, cb2, cb3, cb4;
	private List<CheckBox> _ansBox = new ArrayList<>();

	private SpecialList<FlowPane> _tiles;

	AnchorPane _playersAnchorPanes[];
	Label _playersNames[];
	ImageView _playersImages[];
	Label _playersStrikes[];
	Label _playersCash[];
	Label _playersValue[];
	Pane inBoardPanes[];

	@FXML
	private Button btnTest = new Button();

	public UI() {
		super();
	}

	public void answeringQuestion(String playerNickname, Question question) {

	}

	@FXML
	public void buyProperty() {
		ge.btnBuyProperty();
	}

	@FXML
	public void sellProperty() {
		ge.btnSellProperty();
	}

	@FXML
	public void offerTrade() {
		ge.btnOfferTrade();
	}

	@FXML
	void rollDice() {
		initializeDicesBeforeRoll();
		ge.btnRollDice();
	}

	private void initializeDicesBeforeRoll() {
		for (int i = 0; i < 6; i++) {
			roll1[i].setVisible(false);
			roll2[i].setVisible(false);
		}
	}

	/*
	 * @FXML void initialize() { assert btnVolume != null :
	 * "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'."
	 * ; assert frmNickname != null :
	 * "fx:id=\"frmNickname\" was not injected: check your FXML file 'Login.fxml'."
	 * ; assert btnLogin != null :
	 * "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'."
	 * ; assert btnVolume != null :
	 * "fx:id=\"btnVolume\" was not injected: check your FXML file 'Login.fxml'."
	 * ; }
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
	public void menuButton() {
		Music.getInstance().stop("ui_1.mp3");
		Music.getInstance().swap("theme.mp3");
		ge.closeGame();
		iWindow.swap(Window.Player_Menu);
	}

	public static UI getInstance() {
		return _instance;
	}

	@Override
	public void movePlayer(String player, int tileFrom, int tileTo) {
		PlayerUI pUI = playerList.get(player);

		Integer j = 0;
		while (tileFrom != tileTo) {

			final Integer tmpFrom = tileFrom;
			// Initiate a post visit from the current tile of current player
			// before leaving
			ge.postVisit(tileFrom);

			tileFrom %= 40;
			Integer nextLocation = (tileFrom + 1) % 40;

			/**
			 * Remove old image
			 */
			ImageView tmpRecent = pUI.getRecentImage();
			_tiles.get(nextLocation).getChildren().add(pUI.getNewImage());

			// Move the player
			/**
			 * Add new image
			 */
			Timeline tl = new Timeline();
			KeyValue transparent = new KeyValue(pUI.getRecentImage().opacityProperty(), 0.0);
			KeyValue opaque = new KeyValue(pUI.getRecentImage().opacityProperty(), 1.0);
			KeyFrame startFadeIn = new KeyFrame(Duration.millis(100 * j), transparent);
			KeyFrame endFadeIn = new KeyFrame(Duration.millis(1000 + 100 * j++), opaque);
			tl.getKeyFrames().addAll(startFadeIn, endFadeIn);
			tl.play();

			tl.setOnFinished(e -> {
				Timeline tl2 = new Timeline();
				KeyValue from = new KeyValue(tmpRecent.opacityProperty(), 0.7);
				KeyValue to = new KeyValue(tmpRecent.opacityProperty(), 0.0);
				KeyFrame startFadeOut = new KeyFrame(Duration.ZERO, from);
				KeyFrame finishFadeOut = new KeyFrame(Duration.millis(500), to);
				tl2.getKeyFrames().addAll(startFadeOut, finishFadeOut);
				tl2.play();
				tl2.setOnFinished(c -> {
					_tiles.get(tmpFrom).getChildren().remove(tmpRecent);
					pUI.getRecentImage().setOpacity(1.0);
				});

			});
			// Initiate previsit
			ge.preVisit(nextLocation);
			tileFrom = nextLocation;
		}

		// Visit - happens when player arrives to the final tile
		ge.Visit(tileTo);

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
	public void allowTrade(Boolean allow) {
		btnOfferTrade.setDisable(true);
	}

	@Override
	public void updateCurrentPlayer(String nickname) {
		Logger.log("Adding glow to player " + nickname);
		for (PlayerUI p : playerList)
			p.glow(false);

		playerList.get(nickname).glow(true);
	}

	@Override
	public void gameLog(String message) {
		gameLogs.setText(message + "\n" + gameLogs.getText());
		gameLogDisplay();
	}

	@Override
	public void gameLogDisplay() {
		disableAllPanes();
		gameLogScrollPane.setVisible(true);
		gameLogs.setVisible(true);

	}

	private void disableAllPanes() {
		qmPane.setVisible(false);
		buyRentPane.setVisible(false);
		questionsPaneContainer.setVisible(false);
		gameLogScrollPane.setVisible(false);
		txtAnswerPane.setVisible(false);
	}

	@FXML
	void answer1(MouseEvent event) {
		txtAnswerPane1.setVisible(!txtAnswerPane1.isVisible());
		// showAnswerClicked(txtAnswerPane1, txtAnswerPane1.isVisible(),
		// txtAnsw1);

		// ge.AnswerQuestion(1);
	}

	@FXML
	void answer2(MouseEvent event) {
		txtAnswerPane2.setVisible(!txtAnswerPane2.isVisible());
		// showAnswerClicked(txtAnswerPane2, txtAnswerPane2.isVisible(),
		// txtAnsw2);

		// ge.AnswerQuestion(2);
	}

	@FXML
	void answer3(MouseEvent event) {
		txtAnswerPane3.setVisible(!txtAnswerPane3.isVisible());
		// showAnswerClicked(txtAnswerPane3, txtAnswerPane3.isVisible(),
		// txtAnsw3);

		// ge.AnswerQuestion(3);
	}

	@FXML
	void answer4(MouseEvent event) {
		txtAnswerPane4.setVisible(!txtAnswerPane4.isVisible());
		// showAnswerClicked(txtAnswerPane4, txtAnswerPane4.isVisible(),
		// txtAnsw4);

		// ge.AnswerQuestion(4);
	}

	// private void showAnswerClicked(Pane answerPane, Boolean display, TextArea
	// ta) {
	// Timeline tl = new Timeline();
	// String originalColor = display ? "white" : "aqua";
	// String toChange = display ? "aqua" : "white";
	// tl.getKeyFrames().add(new KeyFrame(Duration.ZERO, "test", e -> {
	// ta.setStyle("-fx-text-fill: " + originalColor + ";");
	// ta.applyCss();
	// }));
	// tl.getKeyFrames().add(new KeyFrame(Duration.millis(200), "test", e -> {
	// ta.setStyle("-fx-text-fill: " + toChange + ";");
	// ta.applyCss();
	// }));
	// tl.play();
	// }

	@Override
	public void BuildBoard() {

		// Sets the current playlist
		// 1 - blue

		// 2 - green
		// 3 - yellow
		// 4 - red

		/*
		 * txtPlayer1Name.setText(playersList.get(0));
		 * txtPlayer2Name.setText(playersList.get(1));
		 * setInMenuPanesInVisible(); gameLogDisplay(true);
		 * player3Container.setVisible(false);
		 * player4Container.setVisible(false); players[0][3].setVisible(false);
		 * players[0][2].setVisible(false); if (playersList.size()>2 ) {
		 * txtPlayer3Name.setText(playersList.get(2));
		 * player3Container.setVisible(true); players[0][2].setVisible(true); }
		 * if (playersList.size()>3) {
		 * txtPlayer4Name.setText(playersList.get(3));
		 * player4Container.setVisible(true); players[0][3].setVisible(true); }
		 */
	}

	@Override
	public void changeDice(int diceNumber, int amount) {
		if (diceNumber == 1)
			roll1[amount - 1].setVisible(true);
		if (diceNumber == 2)
			roll2[amount - 1].setVisible(true);

	}

	@Override
	public boolean buyOrRentProperty(int buyAmount, int rentAmount, String player, String AssetName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updatePlayerProperties(String nickname, Double cash, Integer strikes, Double assetsWorth,
			Integer assetsAmount) {
		Logger.log("Attempting to update player " + nickname + " (" + playerList.size() + "): "
				+ playerList.toArray().toString());
		playerList.get(nickname).updateData(cash, strikes, assetsWorth, assetsAmount);
	}

	@Override
	public void allowFinishTurn(Boolean enabled) {
		btnFinishTurn.setDisable(!enabled);

	}

	@Override
	public void markTile(Integer tileNumber, NamedColor playerColor) {
		_tiles.get(tileNumber).setStyle("-fx-background-color: " + playerColor + "; -fx-opacity: 0.5;");
		_tiles.get(tileNumber).setEffect(new Glow(1.0));
		_tiles.get(tileNumber).applyCss();

	}

	////////////////////////////////////////////////// initialize

	private void initializeDicesFirstTime() {
		roll1[0] = roll1_1;
		roll1[1] = roll1_2;
		roll1[2] = roll1_3;
		roll1[3] = roll1_4;
		roll1[4] = roll1_5;
		roll1[5] = roll1_6;
		roll2[0] = roll2_1;
		roll2[1] = roll2_2;
		roll2[2] = roll2_3;
		roll2[3] = roll2_4;
		roll2[4] = roll2_5;
		roll2[5] = roll2_6;

		for (int i = 0; i < 6; i++) {
			roll1[i].setVisible(false);
			roll2[i].setVisible(false);
		}
	}

	@FXML
	void initializeTiles() {
		/*
		 * panes.add(pane0); panes.add(pane1);
		 */

	}

	@FXML
	void initialize() {
		Logger.log("Initializing new Game UI");
		_instance = this;
		playerList = new SpecialList<>();

		btnBailOut.setVisible(false);

		/**
		 * Sets the content panes and labels according to player numbers
		 */
		_playersAnchorPanes = new AnchorPane[] { player1Container, player2Container, player3Container,
				player4Container };
		_playersNames = new Label[] { txtPlayer1Name, txtPlayer2Name, txtPlayer3Name, txtPlayer4Name };
		_playersImages = new ImageView[] { imgPlayer1, imgPlayer2, imgPlayer3, imgPlayer4 };
		_playersStrikes = new Label[] { strikesPlayer1, strikesPlayer2, strikesPlayer3, strikesPlayer4 };
		_playersCash = new Label[] { moneyPlayer1, moneyPlayer2, moneyPlayer3, moneyPlayer4 };
		_playersValue = new Label[] { valuePlayer1, valuePlayer2, valuePlayer3, valuePlayer4 };
		_answerPanes = new Pane[] { txtAnswerPane1, txtAnswerPane2, txtAnswerPane3, txtAnswerPane4 };
		_txtAnswerAreas = new TextArea[] { txtAnsw1, txtAnsw2, txtAnsw3, txtAnsw4 };
		for (AnchorPane p : _playersAnchorPanes)
			p.setVisible(false);

		/**
		 * Build game tiles
		 */

		_tiles = new SpecialList<FlowPane>();
		_tiles.addItem(tile00).addItem(tile01).addItem(tile02).addItem(tile03).addItem(tile04).addItem(tile05)
				.addItem(tile06).addItem(tile07).addItem(tile08).addItem(tile09).addItem(tile10).addItem(tile11)
				.addItem(tile12).addItem(tile13).addItem(tile14).addItem(tile15).addItem(tile16).addItem(tile17)
				.addItem(tile18).addItem(tile19).addItem(tile20).addItem(tile21).addItem(tile22).addItem(tile23)
				.addItem(tile24).addItem(tile25).addItem(tile26).addItem(tile27).addItem(tile28).addItem(tile29)
				.addItem(tile30).addItem(tile31).addItem(tile32).addItem(tile33).addItem(tile34).addItem(tile35)
				.addItem(tile36).addItem(tile37).addItem(tile38).addItem(tile39);

		Logger.log("Initiated " + _tiles + " game tiles.");
		inBoardPanes = new Pane[] { txtAnswerPane, buyRentPane, sellTradePane };
		ge = GameEngine.getInstance();
		ge.build(this);

		// add answer checkbox to arraylist
		_ansBox.add(cb1);
		_ansBox.add(cb2);
		_ansBox.add(cb3);
		_ansBox.add(cb4);

		initializeTiles();
		initializeDicesFirstTime();
		BuildBoard();
	}

	@Override
	public void build(List<Player> playerList) {
		// Activate containers and player data according to the players given
		int i = 0;
		this.playerList = new SpecialList<>();
		for (Player p : playerList) {
			Logger.log("Adding player " + p + " to Game UI");
			PlayerUI newPlayer = new PlayerUI(i, p.getNickName(), p.getPlayerColor(), _playersAnchorPanes[i],
					_playersCash[i], _playersStrikes[i], _playersValue[i], _playersNames[i], _playersImages[i]);
			i++;
			this.playerList.add(newPlayer);
			_tiles.get(0).getChildren().add(newPlayer.getNewImage());
			newPlayer.getRecentImage().setOpacity(1.0);
		}

		// this.playersList.addAll(playerList);

	}

	@Override
	public void allowSellProperty(Boolean allow) {
		btnSellProperty.setDisable(!allow);
	}

	@FXML
	void btnBailOut(ActionEvent event) {
		ge.btnBailOut();
	}

	@Override
	public void showBailOut(Boolean show) {
		btnBailOut.setVisible(show);
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

	@FXML
	void btnQMShow(ActionEvent event) {
		ge.btnQMShow(qmSelectTag.getSelectionModel().getSelectedItem());
	}

	void setInMenuPanesInVisible() {
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
		ge.btnPayRent();
	}

	@FXML
	void btnSellProperty(ActionEvent event) {
		ge.btnSellProperty();
	}

	@Override
	public void showPlayInformation(String txt) {
		disableAllPanes();
		buyRentPane.setVisible(true);
		playerXRentOrBuy.setText(txt);
	}

	@Override
	public void updateRounds(Integer roundNumber) {
		round.setText(roundNumber.toString());
	}

	@Override
	public void displayQMList(String currentPlayer) {
		disableAllPanes();
		qmPlayerText.setText(currentPlayer + ", please choose a tag from the list below.");
		qmPane.setVisible(true);
		List<QuestionTag> qtList = new ArrayList<QuestionTag>();
		qtList.addAll(Arrays.asList(QuestionTag.values()));

		ObservableList<QuestionTag> obs = FXCollections.observableArrayList(qtList);
		qmSelectTag.setItems(obs);

	}

	@Override
	public void blinkImage() {
	}

	@Override
	public void removePlayer(String playerToRemove) {
		_playersAnchorPanes[playerList.indexOf(playerToRemove)].setVisible(false);
	}

	@Override
	public void displayQuestion(Question question, String player) {
		// reset and hide all fields
		resetAnsBox();

		// show only possible answers

		for (int i = 0; i < 4; i++) {
			_answerPanes[i].setVisible(false);
			// showAnswerClicked(_answerPanes[i], false, _txtAnswerAreas[i]);
			_txtAnswerAreas[i].setVisible(false);
		}

		char temp[] = { 'a', 'b', 'c', 'd' };
		gameLogScrollPane.setVisible(false);
		questionsPane.setVisible(true);
		txtAnswerPane.setVisible(true);
		questionsPaneContainer.setVisible(true);
		playerXIsAnswering.setText(player + " is answering question :");
		theQuestion.setText(question.getqQuestion());

		int i = 0;
		for (Answer a : question.getqAnswers()) {
			Logger.log(a.toString());
			_txtAnswerAreas[i].setText(temp[i] + ". " + a.toString());
			_txtAnswerAreas[i].setVisible(true);
			_ansBox.get(i).setVisible(true);
			// _answerPanes[i].setVisible(true);
			i++;
		}

	}

	@FXML
	void sendAnswerBtn(MouseEvent event) {
		// TODO - Update this method to support check box
		// required change - for each checkbox add answer number if selected

		List<Integer> answers = new ArrayList<Integer>();
		answers = getPlayerAnswers();

		// for (int i = 0; i < _answerPanes.length; i++)
		// if (_answerPanes[i].isVisible())
		// answers.add(i);

		Logger.log("Sending answers: " + answers + " to GameEngine");
		ge.AnswerQuestion(answers);
	}

	private void resetAnsBox() {
		for (int i = 0; i < _ansBox.size(); i++) {
			_ansBox.get(i).setSelected(false); // reset check box
			_ansBox.get(i).setVisible(false);
			_txtAnswerAreas[i].setText(""); // reset answer text
		}
	}

	private List<Integer> getPlayerAnswers() {
		List<Integer> answers = new ArrayList<Integer>();

		for (int i = 0; i < _ansBox.size(); i++) {
			if (_ansBox.get(i).isSelected()) {
				answers.add(i);
			}
		}

		return answers;
	}

}
