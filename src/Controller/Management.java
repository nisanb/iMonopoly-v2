package Controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import Entity.Answer;
import Entity.MonDB;
import Entity.Player;
import Entity.Question;
import Entity.User;
import Utils.Param;
import Utils.PlayerAuth;
import Utils.QuestionStrength;
import View.IManagement;
import View.Admin.Controller.SysParam;
import javafx.scene.control.Spinner;

/**
 * This class connects the view and controller of admin windows
 * singelton class
 */

public class Management implements IManagement{

	private static Management instance = null;
	private static MonDB _db = MonDB.getInstance();
	private Management(){}

	protected static Management getInstance(){
		if(instance == null)
			instance = new Management();
		return instance;
	}

	/**
	 * This method returns all questions from monDB as list
	 */
	@Override
	public List<Question> getQuestions() {
		List<Question> toReturn = new ArrayList<Question>();
		for(List<Question> ql : MonDB.getInstance().getGameQuestions().values())
			toReturn.addAll(ql);
		return toReturn;
	}

	/**
	 * this method returns a list of questions of given difficulty
	 * @param difficulty
	 */
	@Override
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs) {
		return _db.getGameQuestions().get(qs);
	}
	
	/**
	 * This method returns the map of questions form mondb
	 */
	@Override
	public Map<QuestionStrength, List<Question>> getQuestionMap() {
		return _db.getGameQuestions();
	}

	/**
	 * get the logged user as string
	 */
	public String getLoggedPlayer() {
		return MonDB.getInstance().getCurrentUser().getNickName();
	}
	
	/**
	 * set logged in user
	 */
	public void login(String nickname){
		_db.login(nickname);
	}

	/**
	 * get the logged in user
	 * @param user's nick name
	 */
	public String GetLoginUser(String nickname) {

		User u = new User(nickname, PlayerAuth.PLAYER);
		if(!_db.getPlayerData().contains(u))
			_db.getPlayerData().add(u);

		return u.getNickName();
	}

	/**
	 * calls to build game method
	 */
	public void build(List<String> playerList){
		_db.buildGame(playerList);
	}

	@Override


	/**
	 * calls to reset all params in mondb
	 */
	public void resetParamsToDefault() {
		_db.resetParamsToDefault();

	}

	/**
	 * this method gets param from user and set it's new value
	 */
	@Override
	public void setParam(Param p, Object value) {
		_db.setParam(p, value);	
	}
	
	
	@Override
	public Object getParam(Param p) {
		return _db.getParam(p);

	}

	/**
	 * add question to game questions
	 * @param q - question to delete
	 */
	@Override
	public boolean addQuestion(Question q) {
		return MonDB.getInstance().addQuesiton(q);
	}

	/**
	 * remove question from questions map
	 * @param q - question to delete
	 */
	@Override
	public boolean removeQuestion(Question q) {
		System.out.println("Management: " + q);
		return MonDB.getInstance().deleteQuestion(q);

	}

	/**
	 * calls to update question in mondb and replaces one quesion with another
	 */
	@Override
	public boolean updateQuestion(Question qBefore, Question qAfter) {
		return MonDB.getInstance().updateQuestion(qBefore, qAfter);
	}

	
	@Override
	public void btnSave(List<Player> a, Spinner NumOfRounds, Spinner InitialSumOFMoney, Spinner Bankrupt,
			Spinner PaymentRelaseFromJail) {
		// TODO Auto-generated method stub

	}

	public void exportDB(){
		MonDB.exportData();
	}

	/**
	 * this method returns the next question num to create
	 */
	@Override
	public long getNextQuestionNum() {
		List<Question> list = getQuestions();
		long qnum = 0;
		for (Question q: list) {
			if (q.getqNumber() > qnum) qnum = q.getqNumber();
		}
		return qnum+1;
	}

	@Override
	public void btnSave() {
		// TODO Auto-generated method stub

	} 

}
