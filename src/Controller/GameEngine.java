package Controller;

import Entity.Dice;
import Entity.Game;
import Entity.MonDB;
import View.IGameEngine;
import View.Game.Controller.UI;

public class GameEngine implements IGameEngine{

	private UI ui = UI.getInstance();
	private static GameEngine _instance = null;
	private Game _game;
	private GameEngine(){
		_game = MonDB.getInstance().getCurrentGame();
	}
	
	public static GameEngine getInstance(){
		if(_instance == null)
			_instance = new GameEngine();
		return _instance;
	}

	
	/**
	 * This will transfer the board state to a new players' turn based on the players' linked list
	 */
	@Override
	public void btnNextTurn() {
		//Disable all buttons
		disableAll();
		
		//Enable Roll Dice
		ui.updateCurrentPlayer(_game.nextPlayer());
		
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

	@Override
	public void btnRollDice() {
		Dice dice = _game.rollDice();
		ui.gameLog("Player "+_game.getCurrentPlayer() + " rolled "+dice.getSum()+" !");
		ui.allowRollDice(false);
	}

	@Override
	public void AnswerQuestion(int answerNum) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	/**
	 * Private Methods
	 */
	private void disableAll(){
		ui.allowPurchase(false);
		ui.allowRent(false);
		ui.allowRollDice(false);
	}
	


	
}
