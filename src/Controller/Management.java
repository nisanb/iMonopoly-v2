package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import Entity.Game;
import Entity.MonDB;
import Entity.Player;
import Entity.PlayerStats;
import Entity.Question;
import Entity.User;
import Utils.Param;
import Utils.PlayerAuth;
import Utils.QuestionStrength;
import View.IManagement;

/**
 * This class connects the view and controller of admin windows singelton class
 */

public class Management implements IManagement {

	private static Management instance = null;
	private static MonDB _db = MonDB.getInstance();

	private Management() {
	}

	protected static Management getInstance() {
		if (instance == null)
			instance = new Management();
		return instance;
	}

	/**
	 * This method returns all questions from monDB as list
	 */
	@Override
	public List<Question> getQuestions() {
		List<Question> toReturn = new ArrayList<Question>();
		for (List<Question> ql : _db.getGameQuestions().values())
			toReturn.addAll(ql);
		return toReturn;
	}

	/**
	 * this method returns a list of questions of given difficulty
	 *
	 * @param difficulty
	 */
	@Override
	public List<Question> getQuestionsByDifficulty(QuestionStrength qs) {
		return _db.getGameQuestions().get(qs);
	}

	/**
	 * This method returns the map of questions form mondb
	 */
	@Override
	public Map<QuestionStrength, List<Question>> getQuestionMap() {
		return _db.getGameQuestions();
	}

	/**
	 * get the logged user as string
	 */
	@Override
	public String getLoggedPlayer() {
		return _db.getCurrentUser().getNickName();
	}

	/**
	 * set logged in user
	 */
	@Override
	public void login(String nickname) {
		_db.login(nickname);
	}

	@Override
	public void login(String nickname, Boolean force) {
		_db.login(nickname, true);
	}

	/**
	 * get the logged in user
	 *
	 * @param user's
	 *            nick name
	 */
	@Override
	public String GetLoginUser(String nickname) {

		User u = new User(nickname, PlayerAuth.PLAYER);
		if (!_db.getPlayerData().contains(u))
			_db.getPlayerData().add(u);

		return u.getNickName();
	}

	/**
	 * calls to build game method
	 */
	@Override
	public void build(List<String> playerList, Map<Param, Object> paramList) {
		_db.buildGame(playerList, paramList);
	}

	@Override

	/**
	 * calls to reset all params in mondb
	 */
	public void resetParamsToDefault() {
		_db.resetParamsToDefault();

	}

	/**
	 * this method gets param from user and set it's new value
	 */
	@Override
	public void setParam(Param p, Object value) {
		_db.setParam(p, value);
	}

	@Override
	public Object getParam(Param p) {
		return _db.getParam(p);

	}

	/**
	 * add question to game questions
	 *
	 * @param q
	 *            - question to delete
	 */
	@Override
	public boolean addQuestion(Question q) {
		return _db.addQuesiton(q);
	}

	/**
	 * remove question from questions map
	 *
	 * @param q
	 *            - question to delete
	 */
	@Override
	public boolean removeQuestion(Question q) {
		System.out.println("Management: " + q);
		return _db.deleteQuestion(q);

	}

	/**
	 * calls to update question in mondb and replaces one quesion with another
	 */
	@Override
	public boolean updateQuestion(Question qBefore, Question qAfter) {
		return _db.updateQuestion(qBefore, qAfter);
	}

	@Override
	public void exportDB() {
		MonDB.exportData();
	}

	/**
	 * this method returns the next question num to create
	 */
	@Override
	public long getNextQuestionNum(List<Question> toReturn) {
		List<Question> list = getQuestions();
		long qnum = 0;
		for (Question q : list) {
			if (q.getqNumber() > qnum)
				qnum = q.getqNumber();
		}
		return qnum + 1;
	}

	@Override
	public Map<Integer, Game> getGameData() {
		return _db.getGameData();
	}

	@Override
	public List<User> getListOfPlayers() {
		return _db.getPlayerData();
	}

	// =========================================== QUERIES
	// ===============================================
	/**
	 * This method get all params required to create the lead board
	 *
	 * @return all required data for lead board (top 10 players)
	 */
	@Override
	public List<PlayerStats> getLeadBoard() {

		// calculate the statistics values
		List<PlayerStats> leadboard = new ArrayList<PlayerStats>();

		for (User u : _db.getPlayerData()) {
			leadboard.add(new PlayerStats(u.getNickName()));
		}
		Logger.log("Collected " + leadboard.size() + "leadboards users from " + _db.getPlayerData().size());
		for (PlayerStats ps : leadboard) {
			ps = getPlayerData(ps);
		}

		Collections.sort(leadboard, new Comparator<PlayerStats>() {
			@Override
			public int compare(PlayerStats o1, PlayerStats o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		int i = 1;
		for (PlayerStats ps : leadboard)
			ps.setLeadBoardPosition(i++);

		return leadboard;
	}

	/**
	 * Override for getPlayerData
	 */
	@Override
	public PlayerStats getPlayerData() {
		return getPlayerData(new PlayerStats(_db.getCurrentUser().getNickName()));
	}

	/**
	 * Update playerstats with the player given
	 *
	 * @param ps
	 * @return
	 */
	@Override
	public PlayerStats getPlayerData(PlayerStats ps) {

		// Go through all games
		Map<Integer, Game> games = _db.getGameData();
		Logger.log("Player " + ps + " is being reviewed.");
		Player tmp = new Player(ps.getNickName());
		// count game and wins
		for (Game game : games.values()) {
			if (!game.getGamePlayers().contains(tmp)) {
				Logger.log("Player " + ps + " is not in the list + " + game.getPlayers().toString());
				continue;
			}

			Player p = game.getGamePlayers().get(game.getGamePlayers().indexOf(ps));
			ps.addGame();
			if (game.getWinner().equals(p))
				ps.addWin();

			ps.addQuestions(p.getTotalQuestions());
			ps.addStrikes(p.getTotalFailed());

		}

		return ps;
	}

	@Override
	public void addGameToDB(Game game) {
		_db.addGame(game);

	}

}
