package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import Utils.Param;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Game Properties
	 */
	private Integer _gameNum;
	private Date _gameDate;

	/**
	 * Lists
	 */
	private List<Tilable> _gameTiles;
	private LinkedList<Player> _playList;
	private List<Player> _gamePlayers;

	/**
	 * Current
	 */
	private User _currentLoggedUser;
	private Player _currentPlayer;
	private Integer _currentRound;

	protected Game() {

		/**
		 * Generate Game Number
		 */
		Random r = new Random();
		do {
			_gameNum = r.nextInt(999999) + 111111;
		} while (MonDB.getInstance().getGameData().containsKey(_gameNum));

		/**
		 * Set Date
		 */
		this.setGameDate(new Date());
		this.setCurrentRound(0);
		this._gameTiles = new ArrayList<>();
		this._gameTiles.addAll(MonDB.getInstance().getTileSet());
	}

	/**
	 * Build current game - happens after START GAME is clicked
	 */
	public void build(List<Player> playerList) {

		System.out.println(playerList);
		/**
		 * Build players
		 */
		if (_gameTiles.size() != 40) {
			throw new NullPointerException("Cannot initiate game - no tiles were set.");
		}

		/**
		 * Set Players
		 */
		_playList = new LinkedList<>();
		_playList.addAll(playerList);
		_currentPlayer = nextPlayer();
		_gamePlayers = playerList;

	}

	protected void run() {
		// This will start the game

		// This will build the players' cycle

		/**
		 * Why is this here? TODO Mickey
		 * 
		 * LinkedList<Player> playList = new LinkedList<>(); for(Player p :
		 * _playerList.keySet()) playList.add(p);
		 * 
		 * while(!isFinished()){ Player currentPlayer =
		 * playList.get(_currentRound%playList.size());
		 * currentPlayer.addCash(1000); //Players turn //TODO Implement .. }
		 * 
		 **/
	}

	// Adds a player to the game
	protected void addPlayer(Player player) {
		_playList.add(player);
		_gamePlayers.add(player);
	}

	public Dice rollDice() {
		return new Dice();
	}

	public Date getGameDate() {
		return _gameDate;
	}

	protected void setGameDate(Date gameDate) {
		this._gameDate = gameDate;
	}

	public Integer getCurrentRound() {
		return _currentRound;
	}

	protected void setCurrentRound(Integer currentRound) {
		this._currentRound = currentRound;
	}

	/**
	 * Will move a player to the tile given
	 * 
	 * @param player
	 * @param tileNum
	 */
	protected void movePlayer(Player player, Integer tileNum) {

	}

	public User getCurrentLoggedUser() {
		return _currentLoggedUser;
	}

	protected void setCurrentLoggedUser(User currentLoggedUser) {
		_currentLoggedUser = currentLoggedUser;
	}

	/**
	 * This method checks if the conditions to end game have reached
	 * 
	 * @return
	 */
	public boolean isFinished() {

		/**
		 * In case rounds exceeded max rounds
		 */
		if (_currentRound > (Integer) Param.get(Param.MAX_ROUNDS)) // update max
																	// rounds
																	// and
																	// bankruptcy
																	// to value
																	// from enum
			return true;

		/**
		 * In case only 1 player left to play
		 */
		if (_playList.size() == 1)
			return true;

		return false;
	}

	/**
	 * This method sums the value of players properties
	 * 
	 * @param p
	 * @return
	 */
	private int getPropertyVlaue(Player p) {
		int value = 0;
		for (PropertyTile pt : p.getPropertyList()) {
			value += pt.getCurrentPrice();
		}

		return value;
	}

	public Tilable getTile(int tileNumber) {
		try {
			return _gameTiles.get(tileNumber);
		} catch (Exception e) {
			return null;
		}
	}

	public Tilable getTile(Tile tile) {
		try {
			return _gameTiles.get(_gameTiles.indexOf(tile));
		} catch (Exception e) {
			return null;
		}
	}

	public Player nextPlayer() {
		Player nextPlayer = _playList.removeFirst();
		_playList.addLast(nextPlayer);
		return _playList.peekFirst();
	}

	public Player getCurrentPlayer() {
		return _playList.peekFirst();
	}

	public List<String> getPlayerList() {
		List<String> newList = new ArrayList<String>();
		for (Player p : _playList)
			newList.add(p.getNickName());

		return newList;
	}

	public List<Player> getPlayers() {
		return this._playList;
	}

	public LinkedList<Player> getPlayList() {
		return _playList;
	}

	public List<Player> getGamePlayers() {
		return _gamePlayers;
	}

}
