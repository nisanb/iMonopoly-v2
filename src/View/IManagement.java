package View;

import java.util.List;
import java.util.Map;

import Entity.Answer;
import Entity.Game;
import Entity.Player;
import Entity.Question;
import Entity.User;
import Utils.QuestionStrength;
import View.Admin.Controller.SysParam;
import javafx.scene.control.Spinner;
import Utils.Param;

public interface IManagement {
	
	//=================================== GAME AND USER ============================================
	
	/**
	 * Methods return the current user
	 */
	public String getLoggedPlayer();					//logged user as String
	public String GetLoginUser(String UserNickName);	//logged user by nick name
	public void login(String nickname);					//WTF
	
	public void build(List<String> playerList);			//builds a game with given players

	
	// =================================== 	QUESTIONS ==============================================

	/**
	 * Methods to manage questioln
	 */
	public boolean addQuestion(Question q);
	public boolean removeQuestion(Question q);	
	public boolean updateQuestion(Question qBefore, Question qAfter);	
	public List<Question> getQuestions();								 //get all questions as list
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs); //get all question in given difficulty
	public Map<QuestionStrength, List<Question>> getQuestionMap();		 //get all question as map
	
	

	
	//================================== SYSTEM PARAMS AND DATA ==============================================
	
	/**
	 * Methods to control params in sysParam view
	 */
	public Object getParam(Param p);						//get specific param by name
	public void setParam(Param p, Object value);			//set value of param
	public void resetParamsToDefault();						//call to reset all params
	public Map<Integer, Game> getGameData();				//get all game history data
	public List<User> getListOfPlayers();
	
	/**
	 * This button allows the user to change the game settings
	 */
	public void btnSave(List<Player>a,Spinner NumOfRounds,Spinner InitialSumOFMoney,Spinner Bankrupt,Spinner PaymentRelaseFromJail );
		
	public void exportDB();

	void btnSave();
	
	public long getNextQuestionNum();
	
}
