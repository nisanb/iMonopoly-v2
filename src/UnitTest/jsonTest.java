package UnitTest;


import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import Entity.JSON;
import Entity.Question;
import Utils.*;

public class jsonTest {

	@Test
	public void test() {
		//read json into string after load
		String input = JSON.getInstance().getFileAsString();
		
		Map<QuestionStrength, List<Question>> list = JSON.getInstance().loadQuestions();
		JSON.getInstance().saveQuestions(list);
		
		//read json into output after save
		String output = JSON.getInstance().getFileAsString();
		
		//check if the file has the same content
		assertTrue("Successful", input.equals(output));
		
	}

}
