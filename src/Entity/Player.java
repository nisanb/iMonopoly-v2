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
		return this.cash.compareTo(o.cash);
	}
	
	
	
	
	
}
