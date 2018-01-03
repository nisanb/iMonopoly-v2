package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
	transient private List<Tilable> _gameTiles;
	private LinkedList<Player> _playList;
	
	public void set_playList(LinkedList<Player> _playList) {
		this._playList = _playList;
	}

	private List<Player> _gamePlayers;

	/**
	 * Current
	 */
	private User _currentLoggedUser;
	private Integer _currentRound;

	public Game() {
		setGameNum();
		/**
		 * Set Date
		 */
		this.setGameDate(new Date());
		this.setCurrentRound(1);
		this._gameTiles = new ArrayList<>();
		this._gameTiles.addAll(MonDB.getInstance().getTileSet());
	}
	
	//this constructor is for testing
	public Game(boolean isTest, LinkedList<Player> list) {
		this._gameNum = 1;
		this.setGameDate(new Date());
		this.setCurrentRound(1);
		this._gamePlayers = list;		
	}

	private void setGameNum() {
		_gameNum = 0;
		Random r = new Random();
		while (_gameNum == 0) {
			int num = r.nextInt(9999999) + 1000000;
			if (MonDB.getInstance().getGameData().containsKey(num))
				continue;
			else
				_gameNum = num;
		}

	}

	public int getGameNum() {
		return _gameNum;
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
			MonDB.getInstance().initTiles();
			_gameTiles.addAll(MonDB.getInstance().getTileSet());
		}

		/**
		 * Set Players
		 */
		_playList = new LinkedList<>();
		_playList.addAll(playerList);
		_gamePlayers = playerList;

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
		if (_currentRound > (Integer) Param.get(Param.MAX_ROUNDS))

			return true;

		/**
		 * In case only 1 player left to play
		 */
		if (_playList.size() == 1)
			return true;

		return false;
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

	public Integer nextRound() {
		return ++_currentRound;
	}

	public Player getWinner() {
		if (this._playList == null)
			return null;
		double max = 0;
		Player winner = null;
		for (Player p : _playList) {
			if (p.getTotalValue() > max) {
				max = p.getTotalValue();
				winner = p;
			}
		}

		return winner;
	}

	// ===================================== Game Statistics ===================================

	/**
	 * This method makes the summary of the game
	 *
	 * @return list of players sorted by total value on cash and properties
	 */
	public List<Player> getSummary() {
		Set<Player> list = new HashSet<>();
		if (_playList !=null) list.addAll(_playList);
		if (_gamePlayers !=null) list.addAll(_gamePlayers);

		// calc total value of the player

		List<Player> toReturn = new ArrayList<>();
		toReturn.addAll(list);

		Collections.sort(toReturn,
				(Comparator<Player>) (Player p1, Player p2) -> p2.getTotalValue().compareTo(p1.getTotalValue()));
		int i = 1;
		for (Player p : toReturn)
			p.set_leadboardPosition(i++);

		return toReturn;
	}

	public void removePlayer(Player player) {
		_playList.remove(player);
	}

}
