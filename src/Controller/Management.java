package Controller;

import java.util.ArrayList;
import java.util.List;
import Entity.MonDB;
import Entity.Question;
import Entity.User;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoggedPlayer() {
		return MonDB.getInstance().getCurrentPlayer().getNickName();
	}

	public void login(String nickname){
		_db.login(nickname);
	}
	
}
