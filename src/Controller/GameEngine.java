package Controller;

import Entity.Dice;
import Entity.Game;
import Entity.MonDB;
import Entity.Player;
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

	public void setUI(UI ui){
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

	}

	@Override
	public void btnBuyProperty() {
		// TODO Auto-generated method stub

	}

	@Override
	public void btnPayRent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void btnSellProperty() {
		// TODO Auto-generated method stub

	}

	@Override
	public void btnOfferTrade() {
		// TODO Auto-generated method stub

	}

	@Override
	public void btnQuitGame() {
		// TODO Auto-generated method stub

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

		Integer moveToTile = dice.getSum() + currentPlayer().getCurrentTile().getTileNumber() % 40;
		Integer currentLocation = currentPlayer().getCurrentTile().getTileNumber();

		while (currentLocation != moveToTile) {
			currentPlayer().getCurrentTile().postVisit(currentPlayer());
			currentLocation %= 40;
			
			ui.movePlayer(currentPlayer().getNickName(), currentLocation, currentLocation + 1);
			currentPlayer().setCurrentTile(_game.getTile(currentLocation+1));
			currentLocation++;
			
			currentPlayer().getCurrentTile().preVisit(currentPlayer());
		}
		currentPlayer().getCurrentTile().visit(currentPlayer());

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

	private void updatePlayerProperties(Player player){
		ui.updatePlayerProperties(player.getNickName(), player.getCash(), player.getStrikesNum(), player.getTotalAssetsWorth(), player.getTotalAssets());
	}
}
