package Entity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Logger;
import Utils.PlayerAuth;

public class Player extends User implements Comparable<Player> {

	private static final long serialVersionUID = 1L;

	private Integer _cash;
	private Integer _strikesNum;
	private Boolean _inJail;
	private Color _playerColor;
	private Map<Question, Boolean> _userAnswers;
	private List<PropertyTile> _propertyList;
	private Tilable _currentTile;

	/**
	 * Player Constructor
	 * 
	 * @param nickname
	 * @param cash
	 */
	protected Player(String nickname, Integer cash, Color playerColor) {
		super(nickname, PlayerAuth.PLAYER);
		_propertyList = new ArrayList<>();
		_userAnswers = new HashMap<>();
		_strikesNum = 0;
		_currentTile = MonDB.getInstance().getCurrentGame().getTile(0);
		_cash = cash;
		_playerColor = playerColor;
		_inJail = false;

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

	protected Integer getCash() {
		return _cash;
	}

	protected void setCash(Integer cash) {
		_cash = cash;
	}

	protected Tilable getCurrentTile() {
		return _currentTile;
	}

	protected void setCurrentTile(Tilable currentTile) {
		_currentTile = currentTile;
	}

	protected Integer getStrikesNum() {
		return _strikesNum;
	}

	protected void setStrikesNum(Integer strikesNum) {
		_strikesNum = strikesNum;
	}

	protected Boolean getInJail() {
		return _inJail;
	}

	protected void setInJail(Boolean inJail) {
		_inJail = inJail;
	}

	public Map<Question, Boolean> getUserAnswers() {
		return Collections.unmodifiableMap(_userAnswers);
	}

	public void addCash(Object amount) {
		_cash += Integer.parseInt(amount.toString());
		Logger.log("Added $" + amount + " to " + getNickName());
	}

	protected void deductCash(Integer amount) {
		_cash -= amount;
	}

	public Boolean hasEnough(Integer amount) {
		return amount >= _cash;
	}

	public Color getPlayerColor() {
		return _playerColor;
	}

	public void setPlayerColor(Color playerColor) {
		_playerColor = playerColor;
	}

}
