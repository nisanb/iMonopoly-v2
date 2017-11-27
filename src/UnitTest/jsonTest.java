package UnitTest;


import java.awt.event.WindowStateListener;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import Controller.iWindow;
import Entity.JSON;
import Entity.MonDB;
import Entity.Question;
import Utils.Param;
import Utils.*;

public class jsonTest {

	@Test
	public void test() {
		Map<QuestionStrength, List<Question>> list = JSON.getInstance().loadQuestions();
		//JSON.getInstance().saveQuestions(list);
		
		//System.out.println(Param.valueOf(Param.MAX_ROUNDS.toString()));
		
	}

}
