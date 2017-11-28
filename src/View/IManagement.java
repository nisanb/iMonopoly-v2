package View;

import java.util.List;
import java.util.Map;

import Entity.Answer;
import Entity.Question;
import Utils.QuestionStrength;
import Utils.Param;

public interface IManagement {

	/**
	 * Methods DONE
	 */
	public List<Question> getQuestions();
	public String getLoggedPlayer();
	

	/**
	 * Methods TO DO
	 */
	
	// this method add new question //
	public void addQuestion(Question q);
	
	//this method remove question //
	public void removeQuestion(Question q);
	
	/**
	 * Returns list of questions
	 * @return
	 */
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs);
		
	/*
	 * return String of User who login to System
	 */
	public String GetLoginUser(String UserNickName);
	public void build(List<String> playerList);
	public void login(String nickname);
	
	
	/**
	 * This method returns the parameters from monDB (check if requred)
	 * @return - sysParam
	 */
	public Map<Param, Object> getSavedParams();
	
	
	
	
	
	
	
	
	
	
	

	Object getParam(Param p);


	void setParam(Param p, Object value);


	void resetParamsToDefault();
	
}
