package Entity;

import java.util.HashMap;
import java.util.Map;

import Utils.PlayerAuth;

public class Player extends User implements Comparable<Player>{

	private static final long serialVersionUID = 1L;

	private Integer cash;
	private Integer currentTile;
	private Integer strikesNum;
	private Boolean inJail;
	private Map<Question, Boolean> userAnswers;
	
	/**
	 * Player Constructor
	 * @param nickname
	 * @param cash
	 */
	public Player(String nickname, Integer cash){
		super(nickname, PlayerAuth.PLAYER);
		
		this.userAnswers = new HashMap<>();
		this.strikesNum 	= 0;
		this.currentTile	= 0;
		this.cash 			= cash;
		this.inJail 		= false;
		 
	}

	@Override
	public int compareTo(Player o) {
		return this.getTotalPropertyValue().compareTo(getTotalPropertyValue());
	}

	private Integer getTotalPropertyValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer getCash() {
		return cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

	public Integer getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(Integer currentTile) {
		this.currentTile = currentTile;
	}

	public Integer getStrikesNum() {
		return strikesNum;
	}

	public void setStrikesNum(Integer strikesNum) {
		this.strikesNum = strikesNum;
	}

	public Boolean getInJail() {
		return inJail;
	}

	public void setInJail(Boolean inJail) {
		this.inJail = inJail;
	}

	public Map<Question, Boolean> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(Map<Question, Boolean> userAnswers) {
		this.userAnswers = userAnswers;
	}
	
	
	
	
	
	
}
