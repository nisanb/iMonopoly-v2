package Entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Controller.Logger;
import Utils.NamedColor;
import Utils.Param;
import Utils.PlayerAuth;
import Utils.QuestionStrength;
import Utils.QuestionTag;

public class MonDB implements Serializable {

	/**
	 * Class Definitions
	 */
	private static final long serialVersionUID = 1L;
	private static MonDB Data;
	private Map<Param, Object> DBParams;
	
	/*
	 * Tmp params - params only valid for current game
	 */
	private transient Map<Param, Object> tmpParams;
	
	transient private Game currentGame;
	transient private User currentUser;
	private List<Tilable> tileSet;

	/**
	 * Game Statistics & Data
	 */
	private List<User> playerData;
	transient private Map<QuestionStrength, List<Question>> gameQuestions;
	private Map<Integer, Game> gameData;

	/**
	 * Constructor
	 */
	private MonDB() {
		Data = this;
		playerData = new ArrayList<>();
		tmpParams = new HashMap<>();
		this.gameQuestions = JSON.getInstance().loadQuestions();
		tileSet = new LinkedList<>();
		gameData = new HashMap<>();
		initParams();
		initTiles();
		Logger.log("Finished creating new instance of DB");
		currentGame = null;
	}

	//========================================== BOARD =======================================================
	
	/**
	 * Initiation of tile list
	 */
	protected void initTiles() {

		Logger.log("Initiating Game Board Tiles..");

		// Initialise all tiles
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

	//========================================== SETTERS & GETTERS =============================================

	public static MonDB getData() {
		return Data;
	}

	protected static void setData(MonDB data) {
		Data = data;
	}

	public Map<Param, Object> getDBValues() {
		return DBParams;
	}

	protected void setDBParams(Map<Param, Object> dbParamGiven) {
		DBParams = dbParamGiven;
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	protected void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

	public Map<QuestionStrength, List<Question>> getGameQuestions() {
		return gameQuestions;
	}

	protected void setGameQuestions(Map<QuestionStrength, List<Question>> gameQuestions) {
		this.gameQuestions = gameQuestions;
	}

	public static MonDB getInstance() {
		if (Data == null) {
			Data = importData();
		}
		return Data;
	}
	

	/**
	 * Randomly generate a question by question strength
	 * @param str
	 * @return
	 */
	public Question getRandomQuestion(QuestionStrength str) {
		List<Question> qlist = gameQuestions.get(str);
		Random r = new Random();

		return qlist.get(r.nextInt(qlist.size()));
	}

	/**
	 * Randomly generate a question by question tag
	 * @param str
	 * @return
	 */
	public Question getRandomQuestion(QuestionTag tag) {
		List<Question> toBeGenerated = new ArrayList<Question>();
		for(List<Question> allQList : gameQuestions.values())
			for(Question q : allQList)
				if(q.getTags().contains(tag))
					toBeGenerated.add(q);
		
		if(toBeGenerated.isEmpty()){
			Logger.log("Could not display questions to that tag.");
			Logger.log("Generating a random question..");
			return getRandomQuestion(QuestionStrength.HARD);
		}else{
		
		Random r = new Random();
		return toBeGenerated.get(r.nextInt(toBeGenerated.size()));}
		
	}

	public Map<Integer, Game> getGameData() {
		return gameData;
	}

	protected void setGameData(HashMap<Integer, Game> gameData) {
		this.gameData = gameData;
	}

	public List<User> getPlayerData() {
		return Collections.unmodifiableList(playerData);
	}

	public void setPlayerData(List<User> playerData) {
		this.playerData = playerData;
	}

	public Object getParam(Param p) {
		return tmpParams.containsKey(p) ? tmpParams.get(p) : DBParams.get(p);
	}

	public void setParam(Param p, Object value) {
		// TODO Auto-generated method stub
		DBParams.put(p, value);
	}
	
	public void setTmpParam(Param p, Object value) {
		tmpParams.put(p, value);
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentPlayer) {
		this.currentUser = currentPlayer;
	}

	/**
	 * Logs in the user to the system
	 * @param nickname
	 */
	public String login(String nickname) {
		setCurrentUser(new User(verifyPlayer(nickname)));
		return nickname;
	}

	public List<Tilable> getTileSet() {
		return tileSet;
	}

	protected void setTileSet(List<Tilable> tileSet) {
		this.tileSet = tileSet;
	}
	
	
	
	//============================================ INIT AND DATA ============================================
	

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

	/**
	 * Seraialize all relevant data
	 * @return
	 */
	private static MonDB importData() {
		try {
			String fileName = "MonDB.cer";
			FileInputStream input = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(input);
			MonDB Data = (MonDB) objInput.readObject();
			Logger.log("Successfully imported Data.cer");
			Data.gameQuestions = JSON.getInstance().loadQuestions();
			Data.tmpParams = new HashMap<>();
			objInput.close();
			
			return Data;
		} catch (Exception e) {
			Logger.log("Failed to import database");
			return new MonDB();
		}
	}

	/**
	 * Deserialize data
	 */
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
	 * This method calls to reset all params method
	 */
	public void resetParamsToDefault() {
		Logger.log("Resetting params to default..");
		initParams();
		Logger.log("Finished resetting params");
	}
	
	
	public static void main() {
		MonDB d = new MonDB();
		d.initTiles();
	}

	// ======================================= GAME & PLAYER CONTROL =========================================
	

	/**
	 * This method checks if user is already exists in system
	 * @param nickname
	 * @return player name
	 */
	public String verifyPlayer(String nickname) {
		if(playerData == null)
			playerData = new ArrayList<>();
		if (!playerData.contains(nickname)) {
			Logger.log("Added player " + nickname + " to database.");
			playerData.add(new User(nickname, PlayerAuth.PLAYER));
			exportData();
		}

		return playerData.get(playerData.indexOf(new User(nickname))).getNickName();
	}
	
	/**
	 * This method builds a new game 
	 * @param playerList - players in the game
	 */
	public void buildGame(List<String> playerList, Map<Param, Object> paramList){
		
		//Set temporary game params
		for(Map.Entry<Param, Object> entry : paramList.entrySet()){
			Logger.log("Temporary param was set for current game: " + entry.getKey() + " - " + entry.getValue());
			setTmpParam(entry.getKey(), entry.getValue());
		}
		
		//Sets the current game players randomly
		List<Player> newPlayerList = new ArrayList<>();
		NamedColor[] clist = {NamedColor.BLUE, NamedColor.GREEN, NamedColor.YELLOW, NamedColor.RED};
		int i=0;
		currentGame = new Game();
		for(String s : playerList){
			Logger.log("Adding player " + s + " with color " + clist[i]);
			newPlayerList.add(new Player(MonDB.getInstance().login(s), 999999999.0, clist[i++]));
		}
	
		currentGame.build(newPlayerList);
	}
	
	
	/**
	 * Add game to game data. the method won't add game until finding free index in map.
	 * export the data at the end when game is added.
	 * @param game
	 */
	public void addGame(Game game) {
		this.gameData.put(game.getGameNum(), game);
		exportData();
		
	}
	
	
	
	//========================================= QUSESTIONS CONTROL ============================================

	
	/**
	 * This method removes specific question from map and json
	 * @param question
	 *            q
	 * @return true of removed
	 */
	public boolean deleteQuestion(Question q) {
		
		System.out.println(q);
		if (this.gameQuestions == null)
			return false;
		
		if (this.gameQuestions.get(q.getqStrength()) == null){
			return false;
		}

		// get the correct list
		int indexToDelete = this.gameQuestions.get(q.getqStrength()).indexOf(q);
		
				
		// if object was found delete it, save the new json, and return true
		if (indexToDelete > -1) {

			this.gameQuestions.get(q.getqStrength()).remove(indexToDelete);
			JSON.getInstance().saveQuestions(this.gameQuestions);
			return true;
		}
		return false;
	}

	/**
	 * This method adds new question to the map and saves it to json
	 * @param q
	 * @return
	 */
	public boolean addQuesiton(Question q) {
		// if map or list are empty initialise the data structure
		if (this.gameQuestions == null)
			this.gameQuestions = new HashMap<QuestionStrength, List<Question>>();
		if (this.gameQuestions.get(q.getqStrength()) == null)
			this.gameQuestions.put(q.getqStrength(), new ArrayList<Question>());
		
		// add the new question to the correct list and save the json
		if (this.gameQuestions.get(q.getqStrength()).add(q)) {
			JSON.getInstance().saveQuestions(this.gameQuestions);		
			return true;
		}

		return false;
	}

	/**
	 * Update question by deleting it and add the new one
	 * @param qBefore
	 * @param qAfter
	 * @return true if succefull
	 */
	public boolean updateQuestion(Question qBefore, Question qAfter) {
		if (deleteQuestion(qBefore))
			if (addQuesiton(qAfter))
				return true;

		return false;
	}

	/**
	 * This method returns the question map as list
	 * @return
	 */
	public List<Question> getQuestionsAsList() {
		List<Question> list = new ArrayList<Question>();
		for (Map.Entry<QuestionStrength, List<Question>> ls : gameQuestions.entrySet()) {
			for (Question q : ls.getValue()) {
				list.add(q);
			}
		}

		return list;
	}

	/**
	 * This method gets a list of questions and sets it as the game question list
	 * @param list of questions
	 */
	public void setQuestionList(List<Question> list) {
		Map<QuestionStrength, List<Question>> toSet = new HashMap<QuestionStrength, List<Question>>();
		for (Question q : list) {
			toSet.get(q.getqStrength()).add(q);
		}
		
		this.gameQuestions = toSet;
	}
	
	
	
}
