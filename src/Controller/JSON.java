package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Entity.Answer;
import Entity.Question;
import Utils.QuestionStrength;
import Utils.QuestionTag;

public class JSON {
	private static JSON json;
	private static String JsonPath = "Resources/JSON/questions.json";
	
	public JSON () {
		json = new JSON();
	}
	
	public static JSON getInstance() {
		if (json == null) {
			json = new JSON();
		}
		
		return json;
	}
	

	/**
	 * Will read questions from JSON File/
	 * @return TODO: READ QUESTIONS FROM JSON
	 */ 
	public Map<QuestionStrength, List<Question>> loadQuestions() {
		
		HashMap<QuestionStrength, List<Question>> questions = new HashMap<QuestionStrength, List<Question>>();
		JSONParser parser = new JSONParser();
		
		try {
			//get json file
			InputStream is = getClass().getResourceAsStream(JsonPath);		
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			Object obj = parser.parse(reader);
			JSONObject jo = (JSONObject) obj;
			
			//cast json file to array - get the array form the map
			JSONArray quesArray = (JSONArray) jo.get("questions");
			
			//iterate over the values (questions)
			Iterator<JSONObject> quesIterator = quesArray.iterator();
			while(quesIterator.hasNext()) {
				JSONObject q = quesIterator.next();
			
				//get question's answers and iterate over it
				JSONArray ansArray = (JSONArray) q.get("answers");
				Iterator<JSONObject> ansIterator = ansArray.iterator();
				
				//add all answers to arraylist
				ArrayList<Answer> answers = new ArrayList<Answer>();
				while(ansIterator.hasNext()) {
					JSONObject a = ansIterator.next();
					answers.add(new Answer((String)a.get("text"), (boolean)a.get("isCorrect")));
					
				}
				
				//add all tags to arraylist
				JSONArray tagsArray = (JSONArray) q.get("tags");
				ArrayList<QuestionTag> tags = new ArrayList<QuestionTag>();
				
				for (int i = 0; i < tagsArray.size(); i++) {
					tags.add(QuestionTag.valueOf(tagsArray.get(i).toString()));
				}
				
//				System.out.println(q.get("isMultipleChoice").getClass());
				
				//build question object and add it to questions map
				Question toAdd = new Question((long)q.get("id"),
											  getQuestionStrength((long)q.get("difficulty")),
											  (String)q.get("text"),
											  (boolean)q.get("isMultipleChoice"),
											  answers, 
											  (String)q.get("team"),
											  tags);
				
				//Add the question to question map
				if (!questions.containsKey(toAdd.getqStrength())) {
					questions.put(toAdd.getqStrength(), new ArrayList<Question>());
				}
				else {
					questions.get(toAdd.getqStrength()).add(toAdd);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return questions;
	}
	
	/**
	 * This method gets map of questions and saves it as json object
	 * @param questions
	 */
	public void saveQuestions(Map<QuestionStrength, List<Question>> questions) {
		JSONArray JSONquestions = new JSONArray();
		
		
		JSONObject jo = new JSONObject();
		//go over all questions and add every question to json file
		for (Map.Entry<QuestionStrength, List<Question>> list:questions.entrySet()) {
			for (Question q:list.getValue()) {
				JSONObject ans = new JSONObject();
				
				//get questions properties from object to json objects and arrays
				for (Answer a: q.getqAnswers()) {
					ans.put("text", a.getText());
					ans.put("isCorrect", a.isTrue());
				}
				JSONArray tags = new JSONArray();
				for (QuestionTag t:q.getTags()) {
					tags.add(t);
				}
				
				jo.put("id", q.getqNumber());
				jo.put("text", q.getqQuestion());
				jo.put("difficulty", getQuestionStrengthAsLong(q.getqStrength()));
				jo.put("isMultipleChoice", q.isMultipleChoise());
				jo.put("team", q.getTeam());
				jo.put("tags", tags);
				jo.put("answers", ans);
				
			}
			
			//add question to JSONArray
			JSONquestions.add(jo);
		}
		//write the JSONObject to .json file

		
		File quesFile = new File("./bin/Resources/JSON/questions.json");
		try (FileWriter file = new FileWriter(quesFile)) {
			file.write(JSONquestions.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

//		File scores = new File("./bin/json/questions.json");
//		try (FileWriter file = new FileWriter(scores)) {
//			file.write(fobj.toJSONString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
	
	
	/**
	 * Helper method to define question strength
	 */
	private QuestionStrength getQuestionStrength(long strength) {
		if (strength == 0)
			return QuestionStrength.EASY;
		else if (strength == 1)
			return QuestionStrength.MEDIUM;
		else if (strength == 2)
			return QuestionStrength.HARD;
		
		return QuestionStrength.MEDIUM;
	}
	
	/**
	 * Helper method to convert QuestionStrength to long for json
	 */
	private long getQuestionStrengthAsLong(QuestionStrength value) {
		if (value == QuestionStrength.EASY)
			return 0;
		else if (value == QuestionStrength.MEDIUM)
			return 1;
		else if (value == QuestionStrength.HARD)
			return 2;
		
		return 1;
	}
	
}
