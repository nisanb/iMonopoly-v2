package Entity;

import java.util.ArrayList;
import java.util.List;

import Controller.GameEngine;
import Controller.Logger;
import Utils.NamedColor;
import Utils.Param;
import Utils.PlayerAuth;
import Utils.PlayerState;

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
	private Integer _leadboardPosition;

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
		_leadboardPosition = 0;

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

	public synchronized void setState(PlayerState ps) {
		_state = ps;
	}

	public List<PropertyTile> getPropertyList() {
		return _propertyList;
	}

	public void set_leadboardPosition(Integer pos) {
		this._leadboardPosition = pos;
	}

	public Integer get_leadboardPosition() {
		return _leadboardPosition;
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

	public Integer getTotalQuestions() {
		return _totalQuestions;
	}

	public Integer getTotalFailed() {
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

	public void verifyStrikes() {
		if (_strikesNum > 2) {
			GameEngine.getInstance().gameLog("Player " + this + " reached 3 strikes and is being taken to jail.");
			MonDB.getInstance().getTileSet().get(30).visit(this);
			_strikesNum = 0;
			GameEngine.getInstance().updatePlayerProperties(this);
		}
	}

	public void verifyBankrupt() {
		// TODO Auto-generated method stub
		Double bankrupt = ((Integer) Param.get(Param.BANKRUPTCY)).doubleValue();
		if (_cash < bankrupt) {
			GameEngine.getInstance().removePlayer(this);
		}

	}

	// =================================== Setters & Getters for statistics
	// ==================================

}
