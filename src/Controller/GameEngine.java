package Controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import Entity.Dice;
import Entity.Game;
import Entity.MonDB;
import Entity.Player;
import Entity.PropertyTile;
import Entity.Question;
import Utils.Param;
import Utils.PlayerState;
import Utils.QuestionStrength;
import Utils.TileType;
import View.IGameEngine;
import View.Game.Controller.UI;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class GameEngine implements IGameEngine {

	private UI ui;
	private static GameEngine _instance = null;
	private Game _game;

	/**
	 * GameEngine Private Variable for game play
	 */
	private Question currentQuestion = null;
	
	/**
	 * Private constructor
	 */
	private GameEngine() {
		_game = MonDB.getInstance().getCurrentGame();
	}

	/**
	 * Singleton instance
	 * 
	 * @return
	 */
	public static GameEngine getInstance() {
		if (_instance == null)
			_instance = new GameEngine();
		return _instance;
	}

	/**
	 * build Method Initiates only once from callback of UI.java initialize
	 */
	public void build(UI ui) {
		this.ui = ui;
		ui.build(_game.getGamePlayers());
		ui.gameLog("A new game has been initiated.");
		for (Player p : _game.getGamePlayers()) {
			ui.gameLog("Player " + p + " has joined the game.");
			updatePlayerProperties(p);
		}

		btnNextTurn();
	}

	/**
	 * This will transfer the board state to a new players' turn based on the
	 * players' linked list
	 */
	@Override
	public void btnNextTurn() {
		// Disable all buttons
		disableAll();

		// Enable Roll Dice
		ui.updateCurrentPlayer(_game.nextPlayer().getNickName());
		ui.gameLog(currentPlayer() + "s' turn");
		if (currentPlayer().isInJail()) {
			ui.gameLog("Player " + currentPlayer() + " will not attempt to roll a double to get out of jail!");
		}
		ui.allowRollDice(true);

	}

	/**
	 * Once buy property button is clicked - initiate buy property methodology
	 */
	@Override
	public void btnBuyProperty() {
		disableAll();
		
		if(currentPlayer().getState() == PlayerState.ANSWERED_FOR_PURCHASE){
			PropertyTile pt = (PropertyTile) currentPlayer().getCurrentTile();
			if (pt.purchaseProperty(currentPlayer())){
				updatePlayerProperties(currentPlayer());
				ui.markTile(currentPlayer().getCurrentTile().getTileNumber(), currentPlayer().getPlayerColor());
			}
			disableAll();
			ui.allowFinishTurn(true);
			currentPlayer().setState(PlayerState.WAITING);
			return;
		}
		
		currentPlayer().setState(PlayerState.WANTS_TO_PURCHASE);
		QuestionStrength qs = ((PropertyTile)currentPlayer().getCurrentTile()).getPropertyStrength();
		displayQuestion(qs);
		
		ui.allowFinishTurn(true);
	}

	/**
	 * Once pay rent is clicked in the UI Initiate pay rent methodology
	 */
	@Override
	public void btnPayRent() {
		// Get the tiles' amount of rent
		disableAll();
		PropertyTile rentTile = (PropertyTile) currentPlayer().getCurrentTile();
		rentTile.payRent(currentPlayer());
		updatePlayerProperties(currentPlayer().getCurrentProperty().getCurrentOwner());
		updatePlayerProperties(currentPlayer());
		ui.allowFinishTurn(true);
	}

	/**
	 * Once sell property is clicked, initiate sell property methodology
	 */
	@Override
	public void btnSellProperty() {
		ui.allowSellProperty(false);
		ui.gameLog(currentPlayer().sellProperty());
	}

	/**
	 * Once offer trade button is clicked, initiate trade methodology
	 */
	@Override
	public void btnOfferTrade() {
		// TODO Auto-generated method stub

	}

	/**
	 * Forward a message to the game log
	 */
	public void gameLog(String str) {
		ui.gameLog(str);
	}

	/**
	 * When a game is finished, initiate a finish game sequence
	 */
	@Override
	public void btnQuitGame() {
		// TODO Auto-generated method stub
		Music.getInstance().swap("ui_1.mp3");
		ui.finishGame();
	}

	/**
	 * Will roll dice and order "MOVE PLAYER" to FE
	 */
	@Override
	public void btnRollDice() {
		disableAll();
		Dice dice = _game.rollDice();
		ui.allowRollDice(false);
		ui.allowFinishTurn(false);
		ui.gameLog("Player " + _game.getCurrentPlayer() + " rolled " + dice.getSum() + " !");
		ui.changeDice(1, dice.getDice1());
		ui.changeDice(2, dice.getDice2());

		/**
		 * Jail Treatment
		 */
		if (currentPlayer().isInJail()) {
			if (dice.getDice1().equals(dice.getDice2())) {
				ui.gameLog("Player " + currentPlayer() + " rolled a double and is free from jail!");
				currentPlayer().setState(PlayerState.WAITING);
			} else {
				ui.gameLog("Player " + currentPlayer() + " did not roll a double. Moving on to next turn.");
				btnNextTurn();
				return;
			}
		}


		Integer moveToTile = (dice.getSum() + currentPlayer().getCurrentTile().getTileNumber()) % 40;
		ui.movePlayer(currentPlayer().getNickName(), currentPlayer().getCurrentTile().getTileNumber(), moveToTile);
		ui.allowFinishTurn(true);
	}

	/**
	 * Once answer question is clicked - check the answers according to the
	 * question given
	 */
	@Override
	public void AnswerQuestion(List<Integer> answers) {
		if(currentPlayer().getState() == PlayerState.WANTS_TO_PURCHASE){
			if(currentQuestion.checkCorrect(answers)){
				//Give discount
				showInfo(currentPlayer()+" You have answered correct!\n"
						+ "You received a discount of " + displayPrice(currentPlayer().getCurrentProperty().getBuyPrice()-currentPlayer().getCurrentProperty().getBuyPriceDiscount()) + "\n"
								+ "You may now purchase this property for " + displayPrice(currentPlayer().getCurrentProperty().getBuyPriceDiscount())
						+"\n Click on \"Buy Property\" button in order to purchase\n or \"Finish Turn\" to skip your turn.");
				
				Music.getInstance().play("correct.mp3");
			}
			else{
				currentPlayer().addStrike();
				//Display original price
				showInfo(currentPlayer()+" You have failed to answer.\nYou may still purchase this property at original price of: "+displayPrice(currentPlayer().getCurrentProperty().getBuyPrice())
						+"\n Click on \"Buy Property\" button in order to purchase\n or \"Finish Turn\" to skip your turn.");
				Music.getInstance().play("wrong.mp3");
			}
			
		}
		currentPlayer().setState(PlayerState.ANSWERED_FOR_PURCHASE);
		updatePlayerProperties(currentPlayer());
		ui.allowPurchase(true);

	}

	/**
	 * Once finish turn is clicked - forward a call to the next players' turn
	 */
	@Override
	public void btnFinishTurn() {
		// TODO Auto-generated method stub
		if(currentPlayer().getState() != PlayerState.JAILED)
			currentPlayer().setState(PlayerState.WAITING);
		ui.updateRounds(_game.nextRound());
		btnNextTurn();
		
	}

	/**
	 * Display information for player on screen
	 * @param txt
	 */
	public void showInfo(String txt){
		ui.showPlayInformation(txt);
	}
	
	/**
	 * Private Methods
	 */
	
	
	/**
	 * Disable all in-game buttons
	 */
	private void disableAll() {
		ui.allowPurchase(false);
		ui.allowRent(false);
		ui.allowRollDice(false);
		ui.allowFinishTurn(false);
		ui.allowSellProperty(false);
	}
	
	@Override
	public void moveTo(Integer tileTo){
		ui.movePlayer(currentPlayer().getNickName(), currentPlayer().getCurrentTile().getTileNumber(), tileTo);
	}
	/**
	 * Return the current player whos turn his
	 * 
	 * @return
	 */
	private Player currentPlayer() {
		return _game.getCurrentPlayer();
	}

	/**
	 * Launch a call to ui - update players' properties displayed in the UI
	 * 
	 * @param player
	 */
	private void updatePlayerProperties(Player player) {
		ui.updatePlayerProperties(player.getNickName(), player.getCash(), player.getStrikesNum(),
				player.getTotalAssetsWorth(), player.getTotalAssets());
	}

	/**
	 * Occures when player is hovering for the first time on a tile
	 */
	@Override
	public void preVisit(Integer tileNumber){
		currentPlayer().setCurrentTile(_game.getTile(tileNumber));
		currentPlayer().getCurrentTile().preVisit(currentPlayer());
	}
	
	/**
	 * Occures when a player is arriving to a specific tile number
	 */
	@Override
	public void Visit(Integer tileNumber) {
		currentPlayer().getCurrentTile().visit(currentPlayer());
		if(currentPlayer().getCurrentTile().getTileType() == TileType.Property){
			PropertyTile pt = (PropertyTile)currentPlayer().getCurrentTile();
			ui.allowPurchase(true);
			if(pt.isOwned())
				ui.allowRent(true);
		}
	}
	
	/**
	 * Occures when a player is leaving a specific tile
	 */
	@Override
	public void postVisit(Integer tileNumber) {
		currentPlayer().getCurrentTile().postVisit(currentPlayer());
	}

	/**
	 * Will display a question for the current player in-game
	 */
	@Override
	public void displayQuestion(QuestionStrength qs){
		ui.gameLog("New "+qs+" question generated for player " + currentPlayer());
		currentQuestion = MonDB.getInstance().getRandomQuestion(qs);
		ui.displayQuestion(currentQuestion, currentPlayer().getNickName());
	}
	
	/**
	 * Returns a string that represent a price
	 */
	@Override
	public String displayPrice(Integer price){
		return "$"+NumberFormat.getNumberInstance(Locale.US).format(price);
	}
}
