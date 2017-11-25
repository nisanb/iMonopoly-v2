package Controller;

import View.IGameEngine;

public class GameEngine implements IGameEngine{

	private static GameEngine _instance = null;
	
	private GameEngine(){}
	
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
		//Enable Roll Dice
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AnswerQuestion(int answerNum) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	/**
	 * Private Methods
	 */
	private void disableAll(){
		
	}


	
}
