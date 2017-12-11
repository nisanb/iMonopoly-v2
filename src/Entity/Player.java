package Entity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Logger;
import Utils.NamedColor;
import Utils.PlayerAuth;
import Utils.PlayerState;
import javafx.beans.value.ObservableValue;

public class Player extends User implements Comparable<Player> {

	private static final long serialVersionUID = 1L;

	private Integer _cash;
	private Integer _strikesNum;
	private NamedColor _playerColor;
	private Map<Question, Boolean> _userAnswers;
	private List<PropertyTile> _propertyList;
	private Tilable _currentTile;
	private PlayerState _state;
	private transient Integer games = 0, wins = 0;
	
	/**
	 * Player Constructor
	 * @param nickname
	 * @param cash
	 */
	public Player(String nickname, Integer cash, NamedColor playerColor) {
		super(nickname, PlayerAuth.PLAYER);
		_propertyList = new ArrayList<>();
		_userAnswers = new HashMap<>();
		_strikesNum = 0;
		_currentTile = MonDB.getInstance().getCurrentGame().getTile(0);
		_cash = cash;
		_playerColor = playerColor;
		_state = PlayerState.WAITING;

	}

	public Player(String nickname) {
		super(nickname, PlayerAuth.PLAYER);
	}
	
	public PlayerState getState(){
		return _state;
	}
	
	public void setState(PlayerState ps){
		_state = ps;
	}

	public List<PropertyTile> getPropertyList() {
		return _propertyList;
	}

	@Override
	public int compareTo(Player o) {
		return this.getTotalPropertyValue().compareTo(getTotalPropertyValue());
	}

	public Integer getTotalPropertyValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected Boolean addProperty(PropertyTile pro) {
		return _propertyList.add(pro);
	}

	protected Boolean removeProperty(PropertyTile pro) {
		return _propertyList.remove(pro);
	}

	public Integer getCash() {
		return _cash;
	}

	protected void setCash(Integer cash) {
		_cash = cash;
	}

	public Tilable getCurrentTile() {
		return _currentTile;
	}

	public void setCurrentTile(Tilable currentTile) {
		_currentTile = currentTile;
	}

	public Integer getStrikesNum() {
		return _strikesNum;
	}

	protected void setStrikesNum(Integer strikesNum) {
		_strikesNum = strikesNum;
	}

	public Boolean isInJail() {
		return _state == PlayerState.JAILED;
	}

	public Map<Question, Boolean> getUserAnswers() {
		return Collections.unmodifiableMap(_userAnswers);
	}

	public void addCash(Object amount) {
		_cash += Integer.parseInt(amount.toString());
		Logger.log("Added $" + amount + " to " + getNickName());
	}

	public void deductCash(Integer amount) {
		_cash -= amount;
	}

	public Boolean hasEnough(Integer amount) {
		return amount < _cash;
	}

	public NamedColor getPlayerColor() {
		return _playerColor;
	}

	public void setPlayerColor(NamedColor playerColor) {
		_playerColor = playerColor;
	}
	
	public void addStrike(){
		_strikesNum++;
	}

	public Integer getTotalAssetsWorth(){
		Integer amount = 0;
		for(PropertyTile p : _propertyList)
			amount+=p.getCurrentPrice();
		
		return amount;
	}
	
	public Integer getTotalAssets(){
		return _propertyList.size();
	}
	
	
	@Override
	public String toString() {
		return getNickName();
	}

	public String sellProperty(){
		PropertyTile pt = (PropertyTile) getCurrentTile();
		addCash(pt.getSellPrice());
		_propertyList.remove(pt);
		pt.setCurrentOwner(null);
		return "Player "+toString()+" has sold "+pt+" for $"+pt.getSellPrice();
	}
	
	public PropertyTile getCurrentProperty(){
		return (PropertyTile) getCurrentTile();
	}

	
	
	
	//=================================== Setters & Getters for statistics ==================================
	
	
	public Integer getGames() {
		return games;
	}

	public void setGames(Integer games) {
		this.games = games;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}
	
	
	
	
}
