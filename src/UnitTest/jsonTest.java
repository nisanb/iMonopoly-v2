package UnitTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import Controller.JSON;
import Entity.Question;
import Utils.QuestionStrength;

public class jsonTest {

	@Test
	public void test() {
		Map<QuestionStrength, List<Question>> list = JSON.getInstance().loadQuestions();
		JSON.getInstance().saveQuestions(list);
	}

}
