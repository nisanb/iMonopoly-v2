package Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.GameEngine;
import Controller.Logger;
import Utils.NamedColor;
import Utils.PlayerAuth;
import Utils.PlayerState;
import javafx.beans.property.Property;

public class Player extends User implements Comparable<Player> {

	private static final long serialVersionUID = 1L;

	private Double _cash;
	private Integer _strikesNum;
	private NamedColor _playerColor;
	private Integer _totalQuestions;
	private Integer _totalFailedAnswers;
	private List<PropertyTile> _propertyList;
	private Tilable _currentTile;
	private PlayerState _state;
	// calculated params for statistics
	private transient Integer games = 0, wins = 0, leadBoardPosition = Integer.MAX_VALUE;
	private transient String winRatio = "null";
	private transient String questionRatio = "null";

	/**
	 * Player Constructor
	 * 
	 * @param nickname
	 * @param cash
	 */
	public Player(String nickname, Double cash, NamedColor playerColor) {
		super(nickname, PlayerAuth.PLAYER);
		_propertyList = new ArrayList<>();
		_totalFailedAnswers = 0;
		_totalQuestions = 0;
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

	public PlayerState getState() {
		return _state;
	}

	public void setState(PlayerState ps) {
		_state = ps;
	}

	public List<PropertyTile> getPropertyList() {
		return _propertyList;
	}

	@Override
	public int compareTo(Player o) {
		return this.getTotalValue().compareTo(o.getTotalValue());
	}

	/**
	 * ] Get total value of properties + cash
	 * 
	 * @return
	 */
	public Double getTotalValue() {
		double value = 0;
		if (_propertyList == null)
			return _cash;
		for (PropertyTile p : _propertyList) {
			value += p.getCurrentPrice();
		}
		if (_cash != null)
			value = value + _cash;

		return value;
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

	public void addQuestionAnswered(Boolean isRight) {
		_totalQuestions++;
		if (!isRight)
			_totalFailedAnswers++;
	}

	public Integer getTotalQuestions(){
		return _totalQuestions;
	}
	
	public Integer getTotalFailed(){
		return _totalFailedAnswers;
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

	public void addStrike() {
		super.addSingleStrike();
		_strikesNum++;
		if(_strikesNum==3){
			GameEngine.getInstance().gameLog("Player " + this + " reached 3 strikes and is being taken to jail.");
			MonDB.getInstance().getTileSet().get(30).visit(this);
			_strikesNum = 0;
			GameEngine.getInstance().updatePlayerProperties(this);
		}
	}

	public Double getTotalAssetsWorth() {
		Double amount = 0.0;
		for (PropertyTile p : _propertyList)
			amount += p.getCurrentPrice();

		return amount;
	}

	public Integer getTotalAssets() {
		return _propertyList.size();
	}

	@Override
	public String toString() {
		return getNickName();
	}

	public String toString2() {
		return "Player [_cash=" + _cash + ", _strikesNum=" + _strikesNum + ", getNickName()=" + getNickName() + "]";
	}

	public String sellProperty() {
		PropertyTile pt = (PropertyTile) getCurrentTile();
		addCash(pt.getSellPrice());
		_propertyList.remove(pt);
		pt.setCurrentOwner(null);
		return "Player " + toString() + " has sold " + pt + " for $" + pt.getSellPrice();
	}

	public PropertyTile getCurrentProperty() {
		return (PropertyTile) getCurrentTile();
	}

	// =================================== Setters & Getters for statistics
	// ==================================

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

	// ====================================== GAME STATISTICS
	// ===============================================

	public void calcWinRation() {
		if (this.games < 1)
			winRatio = "0.0";
		else
			winRatio = (double) wins / (double) games + "";
		if (winRatio.length() > 4)
			winRatio = winRatio.substring(0, 4);
	}

	public void clacQuestionRatio() {
		if (getTotalAnswers() < 1)
			questionRatio = "0.0";
		else
			questionRatio = ((double) getCorrectAnswers() / (double) getTotalAnswers() + "");
		if (questionRatio.length() > 4)
			questionRatio = questionRatio.substring(0, 4);
	}

	public void setLeeadboardPosition(int value) {
		leadBoardPosition = value;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("TEST: " + this + " - " + obj + " " + super.equals(obj));
		return super.equals(obj);
	}

	/**
	 * @return the leadBoardPosition
	 */
	public Integer getLeadBoardPosition() {
		return leadBoardPosition;
	}

	/**
	 * @return the winRatio
	 */
	public String getWinRatio() {
		return winRatio;
	}

	/**
	 * @param winRatio
	 *            the winRatio to set
	 */
	public void setWinRatio(String winRatio) {
		this.winRatio = winRatio;
	}

	/**
	 * @return the questionRatio
	 */
	public String getQuestionRatio() {
		return questionRatio;
	}

	/**
	 * @param questionRatio
	 *            the questionRatio to set
	 */
	public void setQuestionRatio(String questionRatio) {
		this.questionRatio = questionRatio;
	}

	public void setGameMoney() {
		games = (int) (getTotalValue() + _cash.doubleValue());
	}

}
