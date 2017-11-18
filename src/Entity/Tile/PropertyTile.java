package Entity.Tile;

import java.util.Random;

import Controller.Logger;
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
		Integer min = 0, max = 0;
		switch (propertyStrength) {
		case EASY:
			min = (Integer) Param.get(Param.PROPERTY_PRICE_EASY_MIN);
			max = (Integer) Param.get(Param.PROPERTY_PRICE_EASY_MAX);
			break;
		case MEDIUM:
			min = (Integer) Param.get(Param.PROPERTY_PRICE_MEDIUM_MIN);
			max = (Integer) Param.get(Param.PROPERTY_PRICE_MEDIUM_MAX);
			break;
		case HARD:
			min = (Integer) Param.get(Param.PROPERTY_PRICE_HARD_MIN);
			max = (Integer) Param.get(Param.PROPERTY_PRICE_HARD_MAX);
			break;

		}
		Random r = new Random();
		Integer chosenPrice = r.nextInt(max-min)+min;
		this.initialPrice = chosenPrice;
		this.currentPrice = chosenPrice;
		Logger.log("Setting price $"+chosenPrice+" for tile #"+getTileNumber()+" - "+toString());
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

	public int getBuyPrice() {
		return currentPrice * (Integer) Param.get(Param.BUY_PERCENT);
	}
	
	@Override
	public String toString() {
		return this.getTileName();
	}
}
