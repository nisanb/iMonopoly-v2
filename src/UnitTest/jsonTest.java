package UnitTest;


import java.util.List;
import java.util.Map;

import org.junit.Test;

import Entity.JSON;
import Entity.Question;
import Utils.*;

public class jsonTest {

	@Test
	public void test() {
		Map<QuestionStrength, List<Question>> list = JSON.getInstance().loadQuestions();
		JSON.getInstance().saveQuestions(list);
		
		//System.out.println(Param.valueOf(Param.MAX_ROUNDS.toString()));
		
	}

}
