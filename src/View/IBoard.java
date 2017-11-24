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

	public void nextTurn();
	
	/**
	 * 
	 * @param player
	 * @return R for RED, B for BLUE, G for GREEN and Y for YELLOW
	 */
	public char getPlayerColor(Player player);
}
