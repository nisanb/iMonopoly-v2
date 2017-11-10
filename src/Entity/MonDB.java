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

	/**
	 * Game Statistics & Data
	 */
	private Set<User> playerData;
	transient private Map<QuestionStrength, List<Question>> gameQuestions;
	private Map<Integer, Game> gameData;

	private MonDB() {
		playerData = new HashSet<>();
		this.gameQuestions = loadQuestions();
	}

	public static MonDB getInstance() {
		if (Data == null) {
			Data = importData();
		}

		return Data;
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

}
