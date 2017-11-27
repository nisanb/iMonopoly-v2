package Controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import Entity.Answer;
import Entity.MonDB;
import Entity.Question;
import Entity.User;
import Utils.Param;
import Utils.PlayerAuth;
import Utils.QuestionStrength;
import View.IManagement;

public class Management implements IManagement{

	private static Management instance = null;
	private static MonDB _db = MonDB.getInstance();
	private Management(){}
	
	protected static Management getInstance(){
		if(instance == null)
			instance = new Management();
		return instance;
	}
	
	@Override
	public List<Question> getQuestions() {
		List<Question> toReturn = new ArrayList<Question>();
		for(List<Question> ql : MonDB.getInstance().getGameQuestions().values())
			toReturn.addAll(ql);
		return toReturn;
	}

	@Override
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs) {
		return _db.getGameQuestions().get(qs);
	}

	public String getLoggedPlayer() {
		return MonDB.getInstance().getCurrentUser().getNickName();
	}

	public void login(String nickname){
		_db.login(nickname);
	}

	public String GetLoginUser(String nickname) {

		User u = new User(nickname, PlayerAuth.PLAYER);
		if(!_db.getPlayerData().contains(u))
			_db.getPlayerData().add(u);
		
		return u.getNickName();
	}

	public void build(List<String> playerList){
		_db.buildGame(playerList);
	}

	@Override



	public void resetParamsToDefault() {
		_db.resetParamsToDefault();
		
	}

	@Override
	public void setParam(Param p, Object value) {
		_db.setParam(p, value);	
	}

	@Override
	public Object getParam(Param p) {
		return _db.getParam(p);
		
	}
	
	

	public Map<Param, Object> getSavedParams() {
		// TODO Auto-generated method stub
		return null;
	}

@Override
public void CheckIsTrue(List<Answer> a) {
	// TODO Auto-generated method stub
	
}

@Override
public void SetAnswer(Integer x) {
	// TODO Auto-generated method stub
	
} 

}
