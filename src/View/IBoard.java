package View;

import java.util.List;

import Entity.Question;
import Utils.QuestionStrength;

public interface IBoard {

	/**
	 * Methods DONE
	 */
	

	public List<Question> getQuestions();
	
	
	
	
	/**
	 * Methods TO DO
	 */
	
	/**
	 * Returns list of questions
	 * @return
	 */
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs);
	
}
