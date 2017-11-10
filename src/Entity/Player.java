package Entity;

import Utils.PlayerAuth;

public class Player extends User implements Comparable<Player>{

	private static final long serialVersionUID = 1L;

	private Integer cash;
	private Integer currentTile;
	private Integer strikesNum;
	private Boolean inJail;
	
	public Player(String nickname, Integer cash){
		super(nickname, PlayerAuth.PLAYER);
		
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
