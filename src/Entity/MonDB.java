package Entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import Controller.Logger;
import Entity.Tile.*;
import Utils.Param;
import Utils.QuestionStrength;

public class MonDB implements Serializable {

	/**
	 * Class Definitions
	 */
	private static final long serialVersionUID = 1L;
	private static MonDB Data;
	private Map<Param, Object> DBParams;
	transient private Game currentGame;
	private List<Tilable> tileSet;

	/**
	 * Game Statistics & Data
	 */
	private static List<User> playerData;
	transient private Map<QuestionStrength, List<Question>> gameQuestions;
	private static HashMap<Integer, Game> gameData;

	private MonDB() {
		Data = this;
		playerData = new ArrayList<>();
		this.gameQuestions = loadQuestions();
		tileSet = new LinkedList<>();
		
		initParams();
		initTiles();
		Logger.log("Finished creating new instance of DB");
		currentGame = null;
	}

	/**
	 * Initiation of tile list
	 */
	public void initTiles() {
		
		Logger.log("Initiating Game Board Tiles..");
		// Starting Tile
		tileSet.add(new StartTile(0, "Starting Point"));
		tileSet.add(new PropertyTile(1, "uTorrent", QuestionStrength.MEDIUM));
		tileSet.add(new QMTile(2, "Question Mark"));
		tileSet.add(new PropertyTile(3, "Bittorrent", QuestionStrength.MEDIUM));
		tileSet.add(new PropertyTile(4, "Opera", QuestionStrength.EASY));
		tileSet.add(new LuckTile(5, "Lucky Shot"));
		tileSet.add(new PropertyTile(6, "FireFox", QuestionStrength.EASY));
		tileSet.add(new QMTile(7, "Question Mark"));
		tileSet.add(new PropertyTile(8, "Safari", QuestionStrength.HARD));
		tileSet.add(new PropertyTile(9, "Pied Piper", QuestionStrength.HARD));
		tileSet.add(new Jail(10, "Jail"));
		tileSet.add(new PropertyTile(11, "Instagram", QuestionStrength.MEDIUM));
		tileSet.add(new QMTile(12, "Question Mark"));
		tileSet.add(new PropertyTile(13, "Android", QuestionStrength.MEDIUM));
		tileSet.add(new PropertyTile(14, "Windows", QuestionStrength.HARD));
		tileSet.add(new LuckTile(15, "Lucky Shot"));
		tileSet.add(new PropertyTile(16, "Internet Explorer", QuestionStrength.EASY));
		tileSet.add(new QMTile(17, "Question Mark"));
		tileSet.add(new PropertyTile(18, "Google Drive", QuestionStrength.EASY));
		tileSet.add(new PropertyTile(19, "Waze", QuestionStrength.EASY));
		tileSet.add(new LuckTile(20, "Lucky Shot"));
		tileSet.add(new PropertyTile(21, "YouTube", QuestionStrength.HARD));
		tileSet.add(new QMTile(22, "Question Mark"));
		tileSet.add(new PropertyTile(23, "Facebook", QuestionStrength.HARD));
		tileSet.add(new PropertyTile(24, "Whatsapp", QuestionStrength.HARD));
		tileSet.add(new LuckTile(25, "Lucky Shot"));
		tileSet.add(new PropertyTile(26, "Twitter", QuestionStrength.MEDIUM));
		tileSet.add(new PropertyTile(27, "LG", QuestionStrength.MEDIUM));
		tileSet.add(new QMTile(28, "Question Mark"));
		tileSet.add(new PropertyTile(29, "Intel", QuestionStrength.MEDIUM));
		tileSet.add(new GoToJail(30, "Go To Jail"));
		tileSet.add(new PropertyTile(31, "Viber", QuestionStrength.EASY));
		tileSet.add(new PropertyTile(32, "Netflix", QuestionStrength.EASY));
		tileSet.add(new LuckTile(33, "Lucky Shot"));
		tileSet.add(new PropertyTile(34, "Microsoft", QuestionStrength.EASY));
		tileSet.add(new QMTile(35, "Question Mark"));
		tileSet.add(new PropertyTile(36, "Eclipse", QuestionStrength.HARD));
		tileSet.add(new PropertyTile(37, "Google", QuestionStrength.HARD));
		tileSet.add(new LuckTile(38, "Lucky Shot"));
		tileSet.add(new PropertyTile(39, "Apple", QuestionStrength.HARD));

		Logger.log("Finished initiating tiles");
	}

	public static MonDB getData() {
		return Data;
	}

	public static void setData(MonDB data) {
		Data = data;
	}

	public Map<Param, Object> getDBValues() {
		return DBParams;
	}

	public void setDBParams(Map<Param, Object> dbParamGiven) {
		DBParams = dbParamGiven;
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

	public Map<QuestionStrength, List<Question>> getGameQuestions() {
		return gameQuestions;
	}

	public void setGameQuestions(Map<QuestionStrength, List<Question>> gameQuestions) {
		this.gameQuestions = gameQuestions;
	}

	public static MonDB getInstance() {
		if (Data == null) {
			Data = importData();
		}
		return Data;
	}

	/**
	 * This will initiate the first params to the system. DO NOT CHANGE
	 * 
	 * @return
	 */
	private void initParams() {
		Logger.log("Initiating System Params..");
		DBParams = new HashMap<>();
		for (Param p : Param.values()) {
			DBParams.put(p, p.o);
		}
		Logger.log("Finished initiating system params");
	}

	private static MonDB importData() {
		try {
			String fileName = "MonDB.cer";
			FileInputStream input = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(input);
			MonDB Data = (MonDB) objInput.readObject();
			Logger.log("Successfully imported Data.cer");
			objInput.close();
			return Data;
		} catch (Exception e) {
			Logger.log("Failed to import database");
			return new MonDB();
		}
	}

	public static void exportData() {
		try {
			String fileName = "MonDB.cer";
			FileOutputStream output = new FileOutputStream(fileName);
			ObjectOutputStream objoutput = new ObjectOutputStream(output);
			objoutput.writeObject(Data);
			objoutput.close();
			Logger.log("Exported Data to \"" + fileName + "\"");

		} catch (Exception e) {
			System.err.println("Could not export database\n" + e.toString());

		}
	}

	/**
	 * Will read questions from JSON File
	 * @return TODO: READ QUESTIONS FROM JSON
	 */
	public Map<QuestionStrength, List<Question>> loadQuestions() {
		
		HashMap<QuestionStrength, List<Question>> questions = new HashMap<QuestionStrength, List<Question>>();
		JSONParser parser = new JSONParser();
		
		try {
			//get json file
			InputStream is = getClass().getResourceAsStream("/JSON/questions.json");		
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
				
//				System.out.println(q.get("isMultipleChoice").getClass());
				
				//build question object and add it to questions map
				Question toAdd = new Question((long)q.get("id"),
											  getQuestionStrength((long)q.get("difficulty")),
											  (String)q.get("text"),
											  (boolean)q.get("isMultipleChoice"), 
											  answers, 
											  (String)q.get("team"));
				
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
	
	
	/**
	 * Randomly generate a question by question strength
	 * 
	 * @param str
	 * @return
	 */
	public Question getRandomQuestion(QuestionStrength str) {
		List<Question> qlist = gameQuestions.get(str);
		Random r = new Random();

		return qlist.get(r.nextInt(qlist.size()));
	}

	public Map<Integer, Game> getGameData() {
		return gameData;
	}

	public void setGameData(HashMap<Integer, Game> gameData) {
		MonDB.gameData = gameData;
	}

	public List<User> getPlayerData() {
		return playerData;
	}

	public void setPlayerData(List<User> playerData) {
		MonDB.playerData = playerData;
	}

	public Object getParam(Param p) {
		return DBParams.get(p);
	}

	public void setParam(Param p, Object value) {
		// TODO Auto-generated method stub
		DBParams.put(p, value);
	}
	
	public void resetParamsToDefault(){
		Logger.log("Resetting params to default..");
		initParams();
		Logger.log("Finished resetting params");
	}

}
