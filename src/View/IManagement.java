package View;

import java.util.List;

import Entity.Question;
import Utils.QuestionStrength;

public interface IManagement {

	/**
	 * Methods DONE
	 */
	

	public List<Question> getQuestions();

	
	public String getLoggedPlayer();
	
	

	/**
	 * Methods TO DO
	 */
	
	/**
	 * Returns list of questions
	 * @return
	 */
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs);
	
	
	
	/*
	 * return String of User who login to System
	 */
	public String GetLoginUser(String UserNickName);
	
	
	
}
