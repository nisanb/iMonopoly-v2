package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Entity.*;
import Utils.Param;
import Utils.PlayerAuth;
import Utils.QuestionStrength;
import View.IManagement;
import javafx.scene.control.Spinner;

/**
 * This class connects the view and controller of admin windows
 * singelton class
 */

public class Management implements IManagement{

	private static Management instance = null;
	private static MonDB _db = MonDB.getInstance();
	private Management(){}

	protected static Management getInstance(){
		if(instance == null)
			instance = new Management();
		return instance;
	}

	/**
	 * This method returns all questions from monDB as list
	 */
	@Override
	public List<Question> getQuestions() {
		List<Question> toReturn = new ArrayList<Question>();
		for(List<Question> ql : _db.getGameQuestions().values())
			toReturn.addAll(ql);
		return toReturn;
	}

	/**
	 * this method returns a list of questions of given difficulty
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
	public void login(String nickname){
		_db.login(nickname);
	}

	/**
	 * get the logged in user
	 * @param user's nick name
	 */
	@Override
	public String GetLoginUser(String nickname) {

		User u = new User(nickname, PlayerAuth.PLAYER);
		if(!_db.getPlayerData().contains(u))
			_db.getPlayerData().add(u);

		return u.getNickName();
	}

	/**
	 * calls to build game method
	 */
	@Override
	public void build(List<String> playerList, Map<Param, Object> paramList){
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
	 * @param q - question to delete
	 */
	@Override
	public boolean addQuestion(Question q) {
		return _db.addQuesiton(q);
	}

	/**
	 * remove question from questions map
	 * @param q - question to delete
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
	public void btnSave(List<Player> a, Spinner NumOfRounds, Spinner InitialSumOFMoney, Spinner Bankrupt,
			Spinner PaymentRelaseFromJail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportDB(){
		MonDB.exportData();
	}

	/**
	 * this method returns the next question num to create
	 */
	@Override
	public long getNextQuestionNum() {
		List<Question> list = getQuestions();
		long qnum = 0;
		for (Question q: list) {
			if (q.getqNumber() > qnum) qnum = q.getqNumber();
		}
		return qnum+1;
	}


	@Override
	public Map<Integer, Game> getGameData() {
		return _db.getGameData();
	}

	@Override
	public List<User> getListOfPlayers() {
		return _db.getPlayerData();
	} 
	
	
	
	
	//=========================================== QUERIES ===============================================
	/**
	 * This method get all params required to create the lead board
	 * @return all required data for lead board (top 10 players)
	 */
	@Override
	public List<Player> getLeadBoard() {
		
		//calculate the statistics values
		Map<Integer, Game> games = _db.getGameData();
		List<Player> leadboard = new ArrayList<Player>();
		
		
		for (Game game:games.values()) {
			Player winner = game.getWinner();
			Set<Player> losers = new HashSet<>();
			losers.addAll(game.getGamePlayers());
			losers.addAll(game.getPlayers());
			losers.remove(winner);
			
			//add the winner to lead board
			if (!leadboard.contains(winner)) {
				winner.setGames(1);
				winner.setWins(1);
				leadboard.add(winner);
			}
			else {
				int index = leadboard.indexOf(winner);
				leadboard.get(index).setGames(leadboard.get(index).getGames()+1);
				leadboard.get(index).setWins(leadboard.get(index).getWins()+1);
			}
			
			//add the losers to lead board
			for (Player p:losers) {
				if (!leadboard.contains(p)) {
					p.setGames(1);
					p.setWins(0);
					leadboard.add(p);
				}
				else {
					int index = leadboard.indexOf(p);
					leadboard.get(index).setGames(leadboard.get(index).getGames()+1);
				}
			}				
		}
		
		//sort players for leadboard
		Collections.sort(leadboard, new Comparator<Player>() {

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getWins().compareTo(p1.getWins());
			}
		});
		
		//set position in player and calculate statistics
		for (int i = 0; i < leadboard.size(); i++) {
			leadboard.get(i).setLeeadboardPosition(i+1);
			leadboard.get(i).calcWinRation();
			leadboard.get(i).clacQuestionRatio();
			System.out.println(leadboard.get(i));
		}
				
		//return top 10 players
		if (leadboard.size() < 10) return leadboard;		
		return leadboard.subList(0, 9);
	}
	
	
	/**
	 * This method gets all required data fot player statistics
	 */
	@Override
	public Player getPlayerData() {
		Player player = new Player (_db.getCurrentUser().getNickName());
		Map<Integer, Game> games = _db.getGameData();
		
		//count game and wins
		for (Game game:games.values()) {
			if (game.getGamePlayers().contains(player)) player.setGames(player.getGames()+1);
			else if (game.getPlayers().contains(player)) player.setWins(player.getWins()+1);
			else continue;
			
		}	
		
		return player;
	}

	@Override
	public void addGameToDB(Game game) {
		_db.addGame(game);
		
	}
	
	

}
