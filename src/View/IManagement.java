package View;

import java.util.List;

import Entity.Question;
import Utils.QuestionStrength;

public interface IManagement {

	/**
	 * Methods DONE
	 */
	
	
	
	
	
	
	/**
	 * Methods TO DO
	 */
	
	/**
	 * Returns list of questions
	 * @return
	 */
	public List<Question> getQuestions();
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs);
	
	
}
