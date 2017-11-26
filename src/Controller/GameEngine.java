package Controller;

import Entity.Dice;
import Entity.Game;
import Entity.MonDB;
import Entity.Player;
import Entity.PropertyTile;
import View.IGameEngine;
import View.Game.Controller.UI;

public class GameEngine implements IGameEngine {

	private UI ui;
	private static GameEngine _instance = null;
	private Game _game;

	private GameEngine() {
		_game = MonDB.getInstance().getCurrentGame();
	}

	public static GameEngine getInstance() {
		if (_instance == null)
			_instance = new GameEngine();
		return _instance;
	}

	public void setUI(UI ui) {
		this.ui = ui;
		ui.build(_game.getPlayerList());
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

	@Override
	public void btnBuyProperty() {
		ui.allowPurchase(false);

	}

	/**
	 * Player clicked pay rent
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
	 * Allow a player to sell his property
	 */
	@Override
	public void btnSellProperty() {
		ui.allowSellProperty(false);
		ui.gameLog(currentPlayer().sellProperty());
	}

	@Override
	public void btnOfferTrade() {
		// TODO Auto-generated method stub

	}

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
		Dice dice = _game.rollDice();
		ui.allowRollDice(false);
		ui.gameLog("Player " + _game.getCurrentPlayer() + " rolled " + dice.getSum() + " !");
		ui.changeDice(1, dice.getDice1());
		ui.changeDice(2, dice.getDice2());

		/**
		 * Jail Treatment
		 */
		if (currentPlayer().isInJail()) {
			if (dice.getDice1().equals(dice.getDice2())) {
				ui.gameLog("Player " + currentPlayer() + " rolled a double and is free from jail!");
				currentPlayer().setIsInJail(false);
			} else {
				ui.gameLog("Player " + currentPlayer() + " did not roll a double. Moving on to next turn.");
				btnNextTurn();
				return;
			}
		}

		System.out.println(dice.getSum());
		System.out.println(currentPlayer().getCurrentTile());

		Integer moveToTile = dice.getSum() + currentPlayer().getCurrentTile().getTileNumber() % 40;
		

		Thread doChangeLocation = new Thread() {
			@Override
			public void run() {
				Integer currentLocation = currentPlayer().getCurrentTile().getTileNumber();
				while (currentLocation != moveToTile) {
					currentPlayer().getCurrentTile().postVisit(currentPlayer());
					currentLocation %= 40;

					ui.movePlayer(currentPlayer().getNickName(), currentLocation, currentLocation + 1);
					currentPlayer().setCurrentTile(_game.getTile(currentLocation + 1));
					currentLocation++;

					currentPlayer().getCurrentTile().preVisit(currentPlayer());

					currentPlayer().getCurrentTile().visit(currentPlayer());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		};
		doChangeLocation.start();
	
	ui.allowFinishTurn(true);

	}

	@Override
	public void AnswerQuestion(int answerNum) {
		// TODO Auto-generated method stub

	}

	/**
	 * Private Methods
	 */
	private void disableAll() {
		ui.allowPurchase(false);
		ui.allowRent(false);
		ui.allowRollDice(false);
	}

	private Player currentPlayer() {
		return _game.getCurrentPlayer();
	}

	private void updatePlayerProperties(Player player) {
		ui.updatePlayerProperties(player.getNickName(), player.getCash(), player.getStrikesNum(),
				player.getTotalAssetsWorth(), player.getTotalAssets());
	}

	@Override
	public void btnFinishTurn() {
		// TODO Auto-generated method stub
		btnNextTurn();
	}
}
