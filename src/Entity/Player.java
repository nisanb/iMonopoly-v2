package Entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Controller.Logger;
import Entity.Tile.PropertyTile;
import Utils.PlayerAuth;

public class Player extends User implements Comparable<Player>{

	private static final long serialVersionUID = 1L;

	private Integer cash;
	private Integer currentTile;
	private Integer strikesNum;
	private Boolean inJail;
	private Map<Question, Boolean> userAnswers;
	private Set<PropertyTile> propertyList;
	/**
	 * Player Constructor
	 * @param nickname
	 * @param cash
	 */
	public Player(String nickname, Integer cash){
		super(nickname, PlayerAuth.PLAYER);
		this.propertyList = new HashSet<>();
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
	
	public Boolean addProperty(PropertyTile pro){
		return this.propertyList.add(pro);
	}

	public Boolean removeProperty(PropertyTile pro){
		return this.propertyList.remove(pro);
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
	
	public void addCash(Object amount){
		this.cash += Integer.parseInt(amount.toString());
		Logger.log("Added $"+amount+" to "+getNickName());
	}
	
	public void deductCash(Integer amount){
		this.cash -= amount;
	}
	
	public Boolean hasEnough(Integer amount){
		return amount>=this.cash;
	}
	
	
	
}
