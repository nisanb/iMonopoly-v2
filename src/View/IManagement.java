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
	
	
	/**
	 * this method check the status of the answer. if true setvisible true else setvisible of answe false
	 * @param a
	 */
	public void CheckIsTrue(List<Answer>a);
	
	
	/*
	 * this method get number of question and set in textbox the answer of the question
	 */
	 public void SetAnswer (Integer x);


	Object getParam(Param p);


	void setParam(Param p, Object value);


	void resetParamsToDefault();
	
}
