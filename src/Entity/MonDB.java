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
import java.util.Random;
import java.util.Set;

import Controller.Logger;
import Utils.QuestionStrength;

public class MonDB implements Serializable {

	/**
	 * Class Definitions
	 */
	private static final long serialVersionUID = 1L;
	private static MonDB Data;
	private static Map<String, Object> DBValues;

	/**
	 * Game Statistics & Data
	 */
	private Set<User> playerData;
	transient private Map<QuestionStrength, List<Question>> gameQuestions;
	private Map<Integer, Game> gameData;

	private MonDB() {
		playerData = new HashSet<>();
		this.gameQuestions = loadQuestions();
		initParams();
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
	 * TODO Keep adding requiered system parameters
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

	
	
}
