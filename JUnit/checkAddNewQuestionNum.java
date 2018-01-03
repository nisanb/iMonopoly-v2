import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Controller.Logger;
import Controller.iWindow;
import Entity.MonDB;
import Entity.Question;
import View.IManagement;

public class checkAddNewQuestionNum {
	@Test
	public void test() {
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		MonDB _db = MonDB.getInstance();
		
		//  get all question//
		List<Question> toReturn = new ArrayList<Question>();
		for (List<Question> ql : _db.getGameQuestions().values())
			toReturn.addAll(ql);
		
		
		long expected=toReturn.size()+1;
		IManagement mng = iWindow.getManagement();
		long questionNum=mng.getNextQuestionNum(toReturn);
		assertEquals(expected,questionNum);
		
	}
}
