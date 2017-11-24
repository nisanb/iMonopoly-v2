package View;

import java.util.List;

import Entity.Answer;
import Entity.Player;
import Entity.Question;

public interface IBoard {

	/**
	 * When player clicks on answer question, send the data to the backend
	 * @param question
	 * @param playerAnswers
	 */
	public void answerQuestion(Question question, List<Answer> playerAnswers);

	/**
	 * Returns the current game players
	 * @return
	 */
	public List<Player> getGamePlayers();

	// please add any extra variables inside the methods if needed
	
	public void nextTurn();
	public void buyProperty();
	public void payRent();
	public void offerATrade();
	public void sellProperty();
	public void offerTrade();
	public void quitGame();
	public void rollDice();
	public void AnswerQuestion(int answerNum);
	

}
