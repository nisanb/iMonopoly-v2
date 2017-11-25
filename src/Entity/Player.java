package Entity;

import java.awt.Color;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Controller.Logger;
import Utils.PlayerAuth;

public class Player extends User implements Comparable<Player>{

	private static final long serialVersionUID = 1L;

	private Integer cash;
	private Integer currentTile;
	private Integer strikesNum;
	private Boolean inJail;
	private Color playerColor;
	private Map<Question, Boolean> userAnswers;
	private Set<PropertyTile> propertyList;
	private int sktrikes;
	


	/**
	 * Player Constructor
	 * @param nickname
	 * @param cash
	 */
	protected Player(String nickname, Integer cash, Color playerColor){
		super(nickname, PlayerAuth.PLAYER);
		this.propertyList = new HashSet<>();
		this.userAnswers = new HashMap<>();
		this.strikesNum 	= 0;
		this.currentTile	= 0;
		this.cash 			= cash;
		this.playerColor 	= playerColor;
		this.inJail 		= false;
		 
	}
	
	
	public Set<PropertyTile> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(Set<PropertyTile> propertyList) {
		this.propertyList = propertyList;
	}

	public int getSktrikes() {
		return sktrikes;
	}

	public void setSktrikes(int sktrikes) {
		this.sktrikes = sktrikes;
	}

	@Override
	public int compareTo(Player o) {
		return this.getTotalPropertyValue().compareTo(getTotalPropertyValue());
	}

	public Integer getTotalPropertyValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected Boolean addProperty(PropertyTile pro){
		return this.propertyList.add(pro);
	}

	protected Boolean removeProperty(PropertyTile pro){
		return this.propertyList.remove(pro);
	}
	
	protected Integer getCash() {
		return cash;
	}

	protected void setCash(Integer cash) {
		this.cash = cash;
	}

	protected Integer getCurrentTile() {
		return currentTile;
	}

	protected void setCurrentTile(Integer currentTile) {
		this.currentTile = currentTile;
	}

	protected Integer getStrikesNum() {
		return strikesNum;
	}

	protected void setStrikesNum(Integer strikesNum) {
		this.strikesNum = strikesNum;
	}

	protected Boolean getInJail() {
		return inJail;
	}

	protected void setInJail(Boolean inJail) {
		this.inJail = inJail;
	}

	public Map<Question, Boolean> getUserAnswers() {
		return Collections.unmodifiableMap(userAnswers);
	}

	protected void setUserAnswers(Map<Question, Boolean> userAnswers) {
		this.userAnswers = userAnswers;
	}
	
	public void addCash(Object amount){
		this.cash += Integer.parseInt(amount.toString());
		Logger.log("Added $"+amount+" to "+getNickName());
	}
	
	protected void deductCash(Integer amount){
		this.cash -= amount;
	}
	
	public Boolean hasEnough(Integer amount){
		return amount>=this.cash;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}
	
	
}
