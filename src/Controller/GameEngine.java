package Controller;

import java.util.List;

import Entity.Answer;
import Entity.Player;
import Entity.Question;
import View.IGameEngine;

public class GameEngine implements IGameEngine{

	private static GameEngine _instance = null;
	
	private GameEngine(){}
	
	public static GameEngine getInstance(){
		if(_instance == null)
			_instance = new GameEngine();
		return _instance;
	}

	@Override
	public void btnNextTurn() {
		// TODO Auto-generated method stub
		
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

	
	



	
}
