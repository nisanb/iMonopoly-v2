

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import Entity.Answer;
import Entity.JSON;
import Entity.Question;
import Utils.QuestionStrength;

public class QuestionTest {

	@Test
	public void test() {
		//load questions and convert it to list
		List<Question> questions = new ArrayList<Question>();
		for (Map.Entry<QuestionStrength, List<Question>> ls : JSON.getInstance().loadQuestions(null).entrySet()) {
			for (Question q : ls.getValue()) {
				questions.add(q);
			}
		}	
		
		System.out.println("STARTING TO CHECK " + questions.size() + " QUESTIONS");
		List<Integer> answers = new ArrayList<Integer>();
		
		
		
		//iterate over questions
		for (Question q:questions) {			
			
			//get correct answer of  the question
			answers.clear();
			int i = 0;
			String correct = "";
			for(Answer a : q.getqAnswers()) {
				if (a.isTrue()) {
					answers.add(i);
					correct += "" + i + " - ";
				}
				i++;		
			}
		
			
			//check question method 
			//System.out.println("CHECKING QUESTION " + q.getqNumber() + " Correct Answers Are: " + correct + "AFTER CHECKED: " + q.checkCorrect(answers, null));
			assertTrue(q.checkCorrect(answers, null));
			System.out.println("Passed " + q.getqNumber());	
		}
		
		System.err.println("Finished - Question.chackCorrect method is working well!");
		
	}

}
