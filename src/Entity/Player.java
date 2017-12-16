package Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Logger;
import Utils.NamedColor;
import Utils.PlayerAuth;
import Utils.PlayerState;

public class Player extends User implements Comparable<Player> {

	private static final long serialVersionUID = 1L;

	private Double _cash;
	private Integer _strikesNum;
	private NamedColor _playerColor;
	private Map<Question, Boolean> _userAnswers;
	private List<PropertyTile> _propertyList;
	private Tilable _currentTile;
	private PlayerState _state;
	//calculated params for statistics
	private transient Integer games = 0, wins = 0, leadBoardPosition = Integer.MAX_VALUE;
	private transient String winRatio = "null";
	private transient String questionRatio = "null";
	
	/** 
	 * Player Constructor
	 * @param nickname
	 * @param cash
	 */
	public Player(String nickname, Double cash, NamedColor playerColor) {
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
	
	
	public Player(String nickname, Double cash) {
		super(nickname, PlayerAuth.PLAYER);
		_cash = cash;
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

	public Double getCash() {
		return _cash;
	}

	protected void setCash(Double cash) {
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
		_cash += Double.parseDouble(amount.toString());
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

	public Double getTotalAssetsWorth(){
		Double amount = 0.0;
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
	
	public void calcWinRation() {
		if (this.games < 1) winRatio = "0.0";
		else winRatio = (double)wins/(double)games+"";
		if (winRatio.length() > 3) winRatio = winRatio.substring(0, 3);
	}
	
	public void clacQuestionRatio() {
		if (getTotalAnswers() < 1) questionRatio = "0.0";
		else questionRatio = ((double)getCorrectAnswers()/(double)getTotalAnswers() + "");
		if (questionRatio.length() > 3) questionRatio = questionRatio.substring(0, 3);
	}
	
	public void setLeeadboardPosition(int value) {
		leadBoardPosition = value;
	}
	
	
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("TEST: " + this + " - " + obj + " " + super.equals(obj));
		return super.equals(obj);
	}
	
	
}
