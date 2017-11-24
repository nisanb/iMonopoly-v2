package View;

import java.util.List;

import Entity.Answer;
import Entity.Question;

public interface IBoard {

	/**
	 * When player clicks on answer question, send the data to the backend
	 * @param question
	 * @param playerAnswers
	 */
	public void answerQuestion(Question question, List<Answer> playerAnswers);
}
