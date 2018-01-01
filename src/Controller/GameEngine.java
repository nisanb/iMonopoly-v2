package Controller;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import Entity.Dice;
import Entity.Game;
import Entity.LuckTile;
import Entity.MonDB;
import Entity.Player;
import Entity.PropertyTile;
import Entity.Question;
import Utils.Param;
import Utils.PlayerState;
import Utils.QuestionStrength;
import Utils.QuestionTag;
import Utils.Window;
import View.IGameEngine;
import View.Game.Controller.UI;

public class GameEngine implements IGameEngine {

	private UI ui;
	private static GameEngine _instance = null;
	private Game _game;

	/**
	 * GameEngine Private Variable for game play
	 */
	private Question currentQuestion = null;
	private Stack<Question> questionStack = null;
	private Boolean cycleThroughPlayers = false;
	private Map<Player, Boolean> playerAnswers;

	/**
	 * Private constructor
	 */
	private GameEngine() {
		_game = MonDB.getInstance().getCurrentGame();
		questionStack = new Stack<>();
		playerAnswers = new HashMap<>();
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
	@Override
	public void build(UI ui) {
		Logger.log("Updating Game UI in Backend");
		this.ui = ui;
		this._game = MonDB.getInstance().getCurrentGame();
		ui.build(_game.getGamePlayers());
		ui.gameLog("A new game has been initiated.");
		for (Player p : _game.getGamePlayers()) {
			ui.gameLog("Player " + p + " has joined the game.");
			p.setCurrentTile(_game.getTile(0));
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
			ui.showBailOut(true);
			ui.gameLog("Player " + currentPlayer() + " will now attempt to roll a double to get out of jail!");

		} else {
			ui.showBailOut(false);
		}
		ui.allowRollDice(true);

	}

	/**
	 * Once a question tag was chosen - display the questions
	 */
	@Override
	public void btnQMShow(QuestionTag qt) {
		disableAll();
		if (qt == null)
			return;
		ui.gameLog("Player " + currentPlayer() + " selected Question Tag: " + qt);
		Logger.log("Will not generate " + _game.getGamePlayers().size() + " questions for the players.");
		Question generatedQuestion = MonDB.getInstance().getRandomQuestion(qt);

		// Fill the stack with amount of questions == game players
		for (int i = 0; i < _game.getGamePlayers().size(); i++)
			questionStack.push(generatedQuestion);

		cycleThroughPlayers = true;
		currentQuestion = questionStack.pop();
		ui.displayQuestion(currentQuestion, currentPlayer().getNickName());

	}

	public void displayQuestions(List<Question> questionList) {
		for (Question q : questionList)
			questionStack.push(q);

		currentPlayer().setState(PlayerState.LUCKY_TILE);
		// Display the first question for the player
		currentQuestion = questionStack.pop();

		ui.displayQuestion(currentQuestion, currentPlayer().getNickName());

	}

	/**
	 * Once buy property button is clicked - initiate buy property methodology
	 */
	@Override
	public void btnBuyProperty() {
		disableAll();

		if (currentPlayer().getState() == PlayerState.ANSWERED_FOR_PURCHASE) {
			PropertyTile pt = (PropertyTile) currentPlayer().getCurrentTile();
			if (pt.purchaseProperty(currentPlayer())) {
				Music.getInstance().play("cash_in.mp3");
				updatePlayerProperties(currentPlayer());
				ui.markTile(currentPlayer().getCurrentTile().getTileNumber(), currentPlayer().getPlayerColor());
			}
			disableAll();
			ui.allowFinishTurn(true);
			currentPlayer().setState(PlayerState.WAITING);
			return;
		}

		currentPlayer().setState(PlayerState.WANTS_TO_PURCHASE);
		QuestionStrength qs = ((PropertyTile) currentPlayer().getCurrentTile()).getPropertyStrength();
		displayQuestion(qs);

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
		Music.getInstance().play("cash_in.mp3");
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
		updatePlayerProperties(currentPlayer());
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
	@Override
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

		Logger.log("Current Player: " + currentPlayer());
		Logger.log("Current Tile: " + currentPlayer().getCurrentTile());
		Logger.log("Current Tile # " + currentPlayer().getCurrentTile().getTileNumber());

		Integer moveToTile = (dice.getSum() + currentPlayer().getCurrentTile().getTileNumber()) % 40;
		ui.allowFinishTurn(true);
		ui.movePlayer(currentPlayer().getNickName(), currentPlayer().getCurrentTile().getTileNumber(), moveToTile);
	}

	/**
	 * Once answer question is clicked - check the answers according to the
	 * question given
	 */
	@Override
	public void AnswerQuestion(List<Integer> answers) {

		if (currentPlayer().getState() == PlayerState.LUCKY_TILE) {
			LuckTile lt = ((LuckTile) currentPlayer().getCurrentTile());

			if (!lt.answered(currentQuestion.checkCorrect(answers, currentPlayer()))) {
				currentQuestion = questionStack.pop();
				ui.displayQuestion(currentQuestion, currentPlayer().getNickName());
			} else {
				// Result time..
				lt.checkResults(currentPlayer());
				updatePlayerProperties(currentPlayer());
			}

		}

		if (currentPlayer().getState() == PlayerState.WANTS_TO_PURCHASE) {
			if (currentQuestion.checkCorrect(answers, currentPlayer())) {
				// Give discount
				showInfo(currentPlayer() + " You have answered correct!\n" + "You received a discount of "
						+ displayPrice(currentPlayer().getCurrentProperty().getBuyPrice()
								- currentPlayer().getCurrentProperty().getBuyPriceDiscount())
						+ "\n" + "You may now purchase this property for "
						+ displayPrice(currentPlayer().getCurrentProperty().getBuyPriceDiscount())
						+ "\n Click on \"Buy Property\" button in order to purchase\n or \"Finish Turn\" to skip your turn.");

				Music.getInstance().play("correct.mp3");
			} else {
				currentPlayer().addStrike();
				// Display original price
				showInfo(currentPlayer()
						+ " You have failed to answer.\nYou may still purchase this property at original price of: "
						+ displayPrice(currentPlayer().getCurrentProperty().getBuyPrice())
						+ "\n Click on \"Buy Property\" button in order to purchase\n or \"Finish Turn\" to skip your turn.");
				Music.getInstance().play("wrong.mp3");
			}

			currentPlayer().setState(PlayerState.ANSWERED_FOR_PURCHASE);
			ui.allowPurchase(true);
		}

		if (cycleThroughPlayers) {
			if (!questionStack.isEmpty()) {
				Logger.log("Transferring question to the next player..");
				Logger.log("Player " + currentPlayer() + " answered "
						+ currentQuestion.checkCorrect(answers, currentPlayer()));
				playerAnswers.put(currentPlayer(), currentQuestion.checkCorrect(answers, currentPlayer()));
				// This means we need to let the next player answer the same
				// question
				currentQuestion = questionStack.pop();
				ui.displayQuestion(currentQuestion, _game.nextPlayer().getNickName());

				ui.updateCurrentPlayer(currentPlayer().getNickName());
				return;
			}

			// Analyze last answer
			Logger.log("Player " + currentPlayer() + " answered "
					+ currentQuestion.checkCorrect(answers, currentPlayer()));
			playerAnswers.put(currentPlayer(), currentQuestion.checkCorrect(answers, currentPlayer()));

			// Everyone finished..
			cycleThroughPlayers = false;

			// Analyze Results
			String results = "";

			ui.updateCurrentPlayer(_game.nextPlayer().getNickName());

			/**
			 * Analyze the results for question mark
			 */
			// If the current player is wrong ->
			if (!playerAnswers.get(currentPlayer())) {
				// Fine the player for 50k
				currentPlayer().deductCash(50000);
				results += "Player " + currentPlayer() + " was fined for $50,000\n";
				for (Map.Entry<Player, Boolean> entry : playerAnswers.entrySet()) {
					if (!entry.getValue()) {
						entry.getKey().addStrike();
						results += "Player " + entry.getKey() + " was given a strike.\n";
					}
				}
			} else {

				// Current player is right

				Boolean everyoneRight = true;
				Boolean atleastOne = false;
				for (Map.Entry<Player, Boolean> entry : playerAnswers.entrySet()) {
					if (entry.getKey().equals(currentPlayer()))
						continue;
					if (!entry.getValue()) {
						entry.getKey().addStrike();
						results += "Player " + entry.getKey() + " was given a strike.\n";
						everyoneRight = false;
					} else {
						atleastOne = true;
					}
				}

				if (everyoneRight) {
					// Give 10k to everyone
					for (Map.Entry<Player, Boolean> entry : playerAnswers.entrySet()) {
						if (entry.getKey().equals(currentPlayer()))
							continue;
						entry.getKey().addCash(10000);
						results += "Player " + entry.getKey() + " was awarded for $10,000\n";
					}
				} else if (atleastOne) {
					for (Map.Entry<Player, Boolean> entry : playerAnswers.entrySet()) {
						if (entry.getKey().equals(currentPlayer())) {
							entry.getKey().addCash(50000);
							results += "Player " + entry.getKey() + " was awarded with $50,000\n";
							continue;
						}

						if (entry.getValue()) {
							entry.getKey().addCash(75000);
							results += "Player " + entry.getKey() + " was awarded with $75,000\n";
						}
					}
				} else {
					// Everyone was wrong
					currentPlayer().addCash(250000);
					results += "Player " + currentPlayer() + " was awarded with $250,000\n";
				}

			}

			ui.showPlayInformation("Everyone finished answering..\nPlayers Result: \n\n" + results);
			for (Player p : playerAnswers.keySet())
				updatePlayerProperties(p);
			playerAnswers.clear();
			currentQuestion = null;
			ui.allowFinishTurn(true);

		}

	}

	/**
	 * Once finish turn is clicked - forward a call to the next players' turn
	 */
	@Override
	public void btnFinishTurn() {
		currentPlayer().verifyStrikes();
		currentPlayer().verifyBankrupt();
		updatePlayerProperties(currentPlayer());
		if (currentPlayer().getState() != PlayerState.JAILED)
			currentPlayer().setState(PlayerState.WAITING);
		ui.updateRounds(_game.nextRound());
		if (_game.isFinished()) {
			Music.getInstance().stop("ui_1.mp3");
			Music.getInstance().swap("theme.mp3");
			iWindow.swap(Window.Game_Summary);
		}
		btnNextTurn();

	}

	@Override
	public void btnBailOut() {
		
		ui.gameLog(currentPlayer() + " has bailed out of jail!");
		bailOut();
		
		//updatePlayer(currentPlayer());
		ui.showBailOut(false);
		
	}
	
	public void bailOut(){
		currentPlayer().deductCash((Integer) Param.get(Param.RELEASE_FROM_JAIL));
		currentPlayer().setState(PlayerState.WAITING);
		
	}

	/**
	 * Display information for player on screen
	 *
	 * @param txt
	 */
	public void showInfo(String txt) {
		if (ui == null)
			Logger.log("For some reason UI is NULL!");
		else
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
		ui.allowTrade(false);
	}

	@Override
	public void moveTo(Integer tileTo) {
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
	public void updatePlayerProperties(Player player) {
		ui.updatePlayerProperties(player.getNickName(), player.getCash(), player.getStrikesNum(),
				player.getTotalAssetsWorth(), player.getTotalAssets());
	}

	/**
	 * Occures when player is hovering for the first time on a tile
	 */
	@Override
	public void preVisit(Integer tileNumber) {
		currentPlayer().getCurrentTile().preVisit(currentPlayer());
	}

	/**
	 * Occures when a player is arriving to a specific tile number
	 */
	@Override
	public void Visit(Integer tileNumber) {
		currentPlayer().setCurrentTile(_game.getTile(tileNumber));
		disableAll();
		ui.allowFinishTurn(true);
		currentPlayer().getCurrentTile().visit(currentPlayer());

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
	public void displayQuestion(QuestionStrength qs) {
		ui.gameLog("New " + qs + " question generated for player " + currentPlayer());
		currentQuestion = MonDB.getInstance().getRandomQuestion(qs);
		ui.displayQuestion(currentQuestion, currentPlayer().getNickName());
	}

	/**
	 * Returns a string that represent a price
	 */
	@Override
	public String displayPrice(Double price) {
		return "$" + NumberFormat.getNumberInstance(Locale.US).format(price);
	}

	public String displayPrice(Integer price) {
		return displayPrice(price.doubleValue());
	}

	public void displayQMTile() {
		disableAll();
		ui.displayQMList(currentPlayer().getNickName());
	}

	/**
	 * Calculates the amount needed to be given to a player when he is right on
	 * both questions on a lucky tile
	 *
	 * @return
	 */
	public Double getLuckyTileAward() {
		Double value = 100000.0;
		Double avg = 0.0;
		for (Player p : _game.getPlayers()) {
			avg += p.getTotalAssetsWorth();
		}
		avg /= _game.getPlayers().size();
		return value + avg;
	}

	@Override
	public Game getCurrntGame() {
		return this._game;
	}

	/**
	 * This method resets the game engine
	 */
	@Override
	public void closeGame() {
		MonDB.getInstance().closeGame();
		_instance = new GameEngine();

	}

	public void allowFinishTurn(boolean b) {
		ui.allowFinishTurn(b);
	}

	public void allowSellProperty(boolean b) {
		ui.allowSellProperty(true);
	}

	public void allowPurchaseProperty(boolean b) {
		ui.allowPurchase(true);
	}

	public void allowRent(boolean b) {
		ui.allowRent(true);
	}

	/**
	 * This will remove a player from the game if he is bankrupt.
	 *
	 * @param player
	 */
	public void removePlayer(Player player) {
		_game.removePlayer(player);
		ui.removePlayer(player.getNickName());

	}

}
