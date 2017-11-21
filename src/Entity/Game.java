package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer gameNum;
	Map<Player, Integer> playerList;
	private Date gameDate;
	private Integer currentRound;
	private Boolean gameFinished;
	private User currentLoggedUser;
	
	protected Game() {

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
		
		build();
	}
	
	/**
	 * Build current game - happens after START GAME is clicked
	 */
	protected void build(){
		/**
		 * Build players
		 */
		
	}
	
	protected void run(){
		//This will start the game
		
		//This will build the players' cycle
		LinkedList<Player> playList = new LinkedList<>();
		for(Player p : playerList.keySet())
			playList.add(p);
			
		while(!gameFinished){
			Player currentPlayer = playList.get(currentRound%playList.size());
			currentPlayer.addCash(1000);
			//Players turn
			//TODO Implement ..
		}
		
	}

	//Adds a player to the game
	protected void addPlayer(Player player) {
		this.playerList.put(player, 0);
	}

	protected Integer rollDice() {
		return Dice.roll();
	}

	public Date getGameDate() {
		return gameDate;
	}

	protected void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Integer getCurrentRound() {
		return currentRound;
	}

	protected void setCurrentRound(Integer currentRound) {
		this.currentRound = currentRound;
	}

	/**
	 * Will move a player to the tile given
	 * @param player
	 * @param tileNum
	 */
	protected void movePlayer(Player player, Integer tileNum){
		
	}

	public User getCurrentLoggedUser() {
		return currentLoggedUser;
	}

	protected void setCurrentLoggedUser(User currentLoggedUser) {
		this.currentLoggedUser = currentLoggedUser;
	}
	
	
	public void play() {
		int currentPlayer;
		int maxRounds = 50;
		
		//count Rounds
		//use nisan's methodology of pre/post visit
		while (this.currentRound < maxRounds) {
			//roll dice (if double turn on flag and decide what to do with him)
				//disable roll dice button and activate game buttons**
			//move the player to the correct tile **
			//set location - switch pointer of player and tile **
			//check type of tile (make a move according to tile) **
				//luck, property, jail, start
			//check if this tile belongs to someone
					//if he doesn't want to buy it get rent **
					//get player's input (buy, sell)
					//get correct (strength) question and present it to player **
						//switch log window and question window
						//disable all buttons (answer question buttons working)
						//get player's answer **
						//check player's answer **
						//update player's parameters (total answers and correct answers)
			//if question was answered correctly
				//switch pointers of player and tile **
				//take money from player **
			//if double flag give him another round (count round and don't switch player)
			//else count round and get next player
			
			
			//**private helper method
			
		}
			
			
	}

}
