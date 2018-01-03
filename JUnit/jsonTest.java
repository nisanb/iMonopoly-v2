


import static org.junit.Assert.assertTrue;

import java.util.HashSet;
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
		
		Map<QuestionStrength, List<Question>> list1 = JSON.getInstance().loadQuestions();
		JSON.getInstance().saveQuestions(list1);
		
		//read json into output after save
		Map<QuestionStrength, List<Question>> list2 = JSON.getInstance().loadQuestions();
		
		System.out.println(list1.equals(list2));
		
		
		//check if both question lists are equal
		assertTrue("Successful", list1.equals(list2));
		
		
	}

}
