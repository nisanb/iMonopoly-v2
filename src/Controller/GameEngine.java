package Controller;

import Entity.Dice;
import Entity.Game;
import Entity.MonDB;
import Entity.Player;
import Entity.PropertyTile;
import Utils.Param;
import Utils.PlayerState;
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
		PropertyTile pt = (PropertyTile) currentPlayer().getCurrentTile();
		if (pt.purchaseProperty(currentPlayer()))
			updatePlayerProperties(currentPlayer());
		ui.allowFinishTurn(true);
	}

	/**
	 * Once pay rent is clicked in the UI Initiate pay rent methodology
	 */
	@Override
	public void btnPayRent() {
		// Get the tiles' amount of rent
		ui.allowRent(false);
		PropertyTile rentTile = (PropertyTile) currentPlayer().getCurrentTile();
		currentPlayer().deductCash(rentTile.getRentPrice());
		ui.gameLog("Player " + currentPlayer() + " paid $" + rentTile.getRentPrice() + " of rent "
				+ rentTile.getCurrentOwner());
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
	 * Order a player to proceed to jail
	 */
	@Override
	public void goToJail() {

		// Activate siren sound
		Music.getInstance().play("siren.wav");

		ui.gameLog("Player " + currentPlayer() + " is being taken to jail!");

		// Set new player state
		currentPlayer().setState(PlayerState.JAILED);

		// Take player to jail
		goToTile(10);
	}

	/**
	 * When a game is finished, initiate a finish game sequence
	 */
	@Override
	public void btnQuitGame() {
		// TODO Auto-generated method stub
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

		System.out.println(dice.getSum());
		System.out.println(currentPlayer().getCurrentTile());

		Integer moveToTile = (dice.getSum() + currentPlayer().getCurrentTile().getTileNumber()) % 40;

		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						goToTile(moveToTile);
						updatePlayerProperties(currentPlayer());
						currentPlayer().setState(PlayerState.WAITING);
					}
				});
				return null;
			}
		};
		task.run();
		while (currentPlayer().getState() == PlayerState.MOVING) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (task.isRunning()) {
		}
		if (currentPlayer().getCurrentTile().getTileType() == TileType.Property)
			ui.allowPurchase(true);

		ui.allowFinishTurn(true);

	}

	/**
	 * Once answer question is clicked - check the answers according to the
	 * question given
	 */
	@Override
	public void AnswerQuestion(int answerNum) {
		// TODO Auto-generated method stub

	}

	/**
	 * Once finish turn is clicked - forward a call to the next players' turn
	 */
	@Override
	public void btnFinishTurn() {
		// TODO Auto-generated method stub
		btnNextTurn();
	}

	/**
	 * Private Methods
	 */
	private void disableAll() {
		ui.allowPurchase(false);
		ui.allowRent(false);
		ui.allowRollDice(false);
		ui.allowFinishTurn(false);
		ui.allowSellProperty(false);
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
	 * Private method to initiate a call for a player movment in-tile
	 * 
	 * @param tileNo
	 */
	private void goToTile(Integer tileNo) {
		Integer currentLocation = currentPlayer().getCurrentTile().getTileNumber();
		while (currentLocation != tileNo) {
			currentPlayer().getCurrentTile().postVisit(currentPlayer());

			currentLocation %= 40;
			Integer nextLocation = (currentLocation + 1) % 40;

			ui.movePlayer(currentPlayer().getNickName(), currentLocation, nextLocation);
			currentPlayer().setCurrentTile(_game.getTile(nextLocation));
			currentLocation++;

			currentPlayer().getCurrentTile().preVisit(currentPlayer());

			if (currentPlayer().getCurrentTile().getTileType().equals(TileType.StartPoint)) {
				// Player passed by start point
				ui.gameLog("Player " + currentPlayer() + " has passed by Starting Point (0) and received "
						+ Param.get(Param.START_TILE_VISIT));
			}
		}
		ui.gameLog("Player " + currentPlayer() + " has arrived to " + currentPlayer().getCurrentTile() + " ("
				+ currentPlayer().getCurrentTile().getTileNumber() + ")");
		currentPlayer().getCurrentTile().visit(currentPlayer());
		if (currentPlayer().getCurrentTile().getTileType().equals(TileType.StartPoint)) {
			// Player passed by start point
			ui.gameLog("Player " + currentPlayer() + " has arrived to Starting Point (0) and received "
					+ Param.get(Param.START_TILE_VISIT));
		}

	}

}
