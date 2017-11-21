package Controller;

import java.util.List;

import Entity.Question;
import Utils.QuestionStrength;
import View.IBoard;

public class Board implements IBoard{

	private static Board instance = null;
	
	private Board(){}
	
	public static Board getInstance(){
		if(instance == null)
			instance = new Board();
		return instance;
	}
	
	@Override
	public List<Question> getQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
