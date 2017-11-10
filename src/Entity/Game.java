package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer gameNum;
	Set<Player> playerList;
	private Date gameDate;
	private Integer currentRound;

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
		this.playerList = new TreeSet<Player>();
		this.setCurrentRound(0);

	}

	public Boolean addPlayer(Player player) {
		return this.playerList.add(player);
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

}
