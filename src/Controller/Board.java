package Controller;

import java.util.List;

import Entity.Answer;
import Entity.Question;
import View.IBoard;

public class Board implements IBoard{

	private static Board _instance = null;
	
	private Board(){}
	
	public static Board getInstance(){
		if(_instance == null)
			_instance = new Board();
		return _instance;
	}

	@Override
	public void answerQuestion(Question question, List<Answer> playerAnswers) {
		// TODO Auto-generated method stub
		
	}


	
}
