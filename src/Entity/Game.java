package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer gameNum;
	Map<Player, Integer> playerList;
	private Date gameDate;
	private Integer currentRound;
	private Boolean gameFinished;
	private User currentLoggedUser;
	
	public Game() {

		/**
		 * Generate Game Number
		 */
		Random r = new Random();
		do {
			gameNum = r.nextInt(999999) + 111111;
		} while (MonDB.getInstance().getGameData().containsKey(gameNum));

		/**
		 * Set Date
		 */
		this.setGameDate(new Date());
		this.playerList = new TreeMap<Player, Integer>();
		this.setCurrentRound(0);
		this.gameFinished = false;
	}
	
	public void run(){
		//This will start the game
		
		//This will build the players' cycle
		LinkedList<Player> playList = new LinkedList<>();
		for(Player p : playerList.keySet())
			playList.add(p);
			
		while(!gameFinished){
			Player currentPlayer = playList.get(currentRound%playList.size());
			//Players turn
			//TODO Implement ..
		}
		
	}

	//Adds a player to the game
	public void addPlayer(Player player) {
		this.playerList.put(player, 0);
	}

	public Integer rollDice() {
		return Dice.roll();
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Integer getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(Integer currentRound) {
		this.currentRound = currentRound;
	}

	/**
	 * Will move a player to the tile given
	 * @param player
	 * @param tileNum
	 */
	public void movePlayer(Player player, Integer tileNum){
		
	}

	public User getCurrentLoggedUser() {
		return currentLoggedUser;
	}

	public void setCurrentLoggedUser(User currentLoggedUser) {
		this.currentLoggedUser = currentLoggedUser;
	}

}
