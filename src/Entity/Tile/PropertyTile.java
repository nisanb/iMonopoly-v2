package Entity.Tile;

import Entity.MonDB;
import Entity.Player;
import Utils.Param;
import Utils.QuestionStrength;
import Utils.TileType;

public class PropertyTile extends Tile {

	private Integer initialPrice;
	private Integer currentPrice;
	private Player currentOwner;
	private QuestionStrength propertyStrength;

	public PropertyTile(Integer tileNumber, String tileName, QuestionStrength qs) {
		super(tileNumber, tileName, TileType.Property);
		this.propertyStrength = qs;
		this.currentOwner = null;

		setInitialPrice();
	}

	private void setInitialPrice() {
		// TODO Generate a price according the the questions strength
		Integer price = 0;
		this.initialPrice = price;
		this.currentPrice = price;
	}

	public QuestionStrength getPropertyStrength() {
		return propertyStrength;
	}

	public void setPropertyStrength(QuestionStrength propertyStrength) {
		this.propertyStrength = propertyStrength;
	}

	public Integer getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Integer initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Integer getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Integer currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Player getCurrentOwner() {
		return currentOwner;
	}

	public void setCurrentOwner(Player currentOwner) {
		this.currentOwner = currentOwner;
	}

	public Boolean isOwned() {
		return currentOwner != null;
	}

	public int getBuyPrice(){
		return currentPrice * (Integer) MonDB.getInstance().getParam(Param.BUY_PERCENT);
	}
}
