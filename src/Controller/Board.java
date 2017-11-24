package Controller;

import java.util.List;

import Entity.Answer;
import Entity.Player;
import Entity.Question;
import View.IBoard;

public class Board implements IBoard{

	private static Board _instance = null;
	
	private Board(){}
	
	public static Board getInstance(){
		if(_instance == null)
			_instance = new Board();
		return _instance;
	}

	@Override
	public void answerQuestion(Question question, List<Answer> playerAnswers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Player> getGamePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nextTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyProperty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payRent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void offerATrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sellProperty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void offerTrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollDice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AnswerQuestion(int answerNum) {
		// TODO Auto-generated method stub
		
	}




	
}
