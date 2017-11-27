package View;

import java.util.List;
import java.util.Map;

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
	 * This method returns the parameters from monDB 
	 * @return - sysParam
	 */
	public void resetParamsToDefault();
	
	/**
	 * This method will set the changed param to monDB
	 * @param p
	 * @param value
	 */
	public void setParam(Param p, Object value);
	
	/**
	 * This method gets param from monDB
	 * @param p
	 * @return
	 */
	public Object getParam(Param p);
	
}
