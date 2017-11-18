package Entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import Controller.Logger;
import Entity.Tile.*;
import Utils.QuestionStrength;

public class MonDB implements Serializable {

	/**
	 * Class Definitions
	 */
	private static final long serialVersionUID = 1L;
	private static MonDB Data;
	private static Map<String, Object> DBValues;
	transient private Game currentGame;
	private static Set<Tilable> tileSet;

	/**
	 * Game Statistics & Data
	 */
	private Set<User> playerData;
	transient private Map<QuestionStrength, List<Question>> gameQuestions;
	private Map<Integer, Game> gameData;

	private MonDB() {
		playerData = new HashSet<>();
		this.gameQuestions = loadQuestions();
		tileSet = new HashSet<>();
		initParams();
		initTiles();
		currentGame = null;
	}

	/**
	 * Initiation of tile list
	 */
	public static void initTiles(){
		
		//Starting Tile
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
		
		
		
		
	}
	
	public static MonDB getData() {
		return Data;
	}



	public static void setData(MonDB data) {
		Data = data;
	}



	public static Map<String, Object> getDBValues() {
		return DBValues;
	}



	public static void setDBValues(Map<String, Object> dBValues) {
		DBValues = dBValues;
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
	 * This will initiate the first params to the system.
	 * DO NOT CHANGE
	 * @return
	 * TODO Keep adding required system parameters
	 */
	private void initParams() {
		Logger.log("Initiating System Params..");
		DBValues = new HashMap<>();
		DBValues.put("STARTING_CASH", new Integer(500000));
		DBValues.put("RENT_PERCENT", new Double(0.15));
		DBValues.put("BUY_PERCENT", new Double(1.5));
		DBValues.put("MIN_LUCK", new Integer(10000));
		DBValues.put("MAX_LUCK", new Integer(250000000)); /* Check to make sure thats what they meant TODO */
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
	 * 
	 * @return TODO: READ QUESTIONS FROM JSON
	 */
	private Map<QuestionStrength, List<Question>> loadQuestions() {
		Map<QuestionStrength, List<Question>> toReturn = new HashMap<QuestionStrength, List<Question>>();

		return toReturn;
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

	public void setGameData(Map<Integer, Game> gameData) {
		this.gameData = gameData;
	}

	public Set<User> getPlayerData() {
		return playerData;
	}

	public void setPlayerData(Set<User> playerData) {
		this.playerData = playerData;
	}

	
	public Object getParam(String paramName){
		return DBValues.get(paramName);
	}
	
	
}
