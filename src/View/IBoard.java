package View;

import java.util.List;

import Entity.Answer;
import Entity.Player;
import Entity.Question;

public interface IBoard {

	// please add any extra variables inside the methods if needed
	
	public void nextTurn();
	public void buyProperty();
	public void payRent();
	public void sellProperty();
	public void offerTrade();
	public void quitGame();
	public void rollDice();
	public void AnswerQuestion(int answerNum);
	

}
