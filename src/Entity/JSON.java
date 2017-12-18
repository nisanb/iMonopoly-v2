package Entity;

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

import Utils.QuestionStrength;
import Utils.QuestionTag;
import Utils.Team;

public class JSON {
	private static JSON json;
	private static String JsonPath = "/Resources/JSON/save.json";
	private static int autoQuestionNumber = 1;
	private static boolean reNumber = false;
	
	private JSON () {}
	
	public static JSON getInstance() {
		if (json == null) {
			json = new JSON();
		}
		
		return json;
	}
	

	
	/**
	 * Will read questions from JSON File
	 * @return TODO: READ QUESTIONS FROM JSON
	 */
	@SuppressWarnings("unchecked")
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
				ArrayList<Answer> answers = new ArrayList<Answer>();
				for (int i = 0; i < ansArray.size(); i++) {
					JSONObject a = (JSONObject)ansArray.get(i);
					answers.add(new Answer((String)a.get("text"), (boolean)a.get("isCorrect")));
				} 
				
				
				
				//add all tags to arraylist
				JSONArray tagsArray = (JSONArray) q.get("tags");
				ArrayList<QuestionTag> tags = new ArrayList<QuestionTag>();
				
				for (int i = 0; i < tagsArray.size(); i++) {
					String str = tagsArray.get(i).toString();
					try{
						tags.add(QuestionTag.getValueOf(str));

					}
					catch (Exception e){
						
					}
					//System.err.println(QuestionTag.valueOf(str));
				}
				
				
//				System.out.println(q.get("isMultipleChoice").getClass());
				
				//build question object and add it to questions map
				long qnum = (long) q.get("id");
				if (reNumber) {qnum = autoQuestionNumber; autoQuestionNumber ++;} 	//for renumbering (set renumber true)
				
				Question toAdd = new Question(qnum,
											  getQuestionStrength((long)q.get("difficulty")),
											  (String)q.get("text"),
											  (boolean)q.get("isMultipleChoice"),
											  answers,
											  Team.valueOf((String)q.get("team")),
											  tags);
				
				//Add the question to question map
				if (!questions.containsKey(toAdd.getqStrength())) {
					questions.put(toAdd.getqStrength(), new ArrayList<Question>());
					questions.get(toAdd.getqStrength()).add(toAdd);
					//System.out.println(toAdd.toString());
				}
				else {
					questions.get(toAdd.getqStrength()).add(toAdd);
					//System.out.println(toAdd.toString());
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		//print questions
//		for (List<Question> q:questions.values()) {
//			for (Question temp:q) {
//				System.out.println(temp);
//			}
//		}
		
		
		return questions;
	}
	
	
	
	/**
	 * This method gets map of questions and saves it as json object
	 * @param questions
	 */
	@SuppressWarnings("unchecked")
	public void saveQuestions(Map<QuestionStrength, List<Question>> questions) {
		JSONArray JSONquestions = new JSONArray();	
		JSONObject toWrite = new JSONObject();
		
		//go over all questions and add every question to json file
		for (Map.Entry<QuestionStrength, List<Question>> list:questions.entrySet()) {
			if (list.getValue() == null) continue;
			
			//get each question from the list
			for (Question q:list.getValue()) {
				JSONObject jo = new JSONObject();
				JSONArray ans = new JSONArray();
				//get questions properties from object to json objects and arrays
				for (Answer a: q.getqAnswers()) {
					JSONObject tmp = new JSONObject();	
					tmp.put("text", a.getText());
					tmp.put("isCorrect", a.isTrue());
					
					ans.add(tmp);
				}
				
				//get all tags
				JSONArray tags = new JSONArray();
				for (QuestionTag t : q.getTags()) {
					tags.add(t.getName());
					//System.err.println(t.getName().getClass().toString());
				}
				

				//put fields in the object
				jo.put("id", q.getqNumber());
				jo.put("text", q.getqQuestion());
				jo.put("difficulty", getQuestionStrengthAsLong(q.getqStrength()));
				jo.put("isMultipleChoice", q.isMultipleChoise());
				jo.put("team", q.getTeam().toString());
				jo.put("tags", tags);
				jo.put("answers", ans);
				
				//add the object to json array
				JSONquestions.add(jo);
				//System.err.println(JSONquestions.toString());
				
			}
			
			//add json array to object question
			toWrite.put("questions", JSONquestions);
		}
		

		//write the JSONObject to .json file		
		File f = new File("./bin"+JsonPath);
		try (FileWriter file = new FileWriter(f)) {
			file.write(toWrite.toJSONString());
//			Logger.log("Question JSON was saved");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}


	
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
	
	
	public String getFileAsString() {
		String str = "";		
		JSONParser parser = new JSONParser();
		
		try {
			//get json file
			InputStream is = getClass().getResourceAsStream(JsonPath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			Object obj = parser.parse(reader);
			JSONObject jo = (JSONObject) obj;
			str = obj.toString();
		} catch (Exception e) {
			
		}
		
		return str;
	}
	
}
