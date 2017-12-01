package Entity;

import java.util.Random;

import Controller.Logger;
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
			min = (Integer) Param.get(Param.PROPERTY_MINPRICE_EASY);
			max = (Integer) Param.get(Param.PROPERTY_PRICE_EASY_MAX);
			break;
		case MEDIUM:
			min = (Integer) Param.get(Param.PROPERTY_MINPRICE_MEDIUM);
			max = (Integer) Param.get(Param.PROPERTY_PRICE_MEDIUM_MAX);
			break;
		case HARD:
			min = (Integer) Param.get(Param.PROPERTY_MINPRICE_HARD);
			max = (Integer) Param.get(Param.PROPERTY_PRICE_HARD_MAX);
			break;

		}
		Random r = new Random();
		Integer chosenPrice = r.nextInt(max - min) + min;
		this.initialPrice = chosenPrice;
		this.currentPrice = chosenPrice;
		Logger.log("Setting price $" + chosenPrice + " for tile #" + getTileNumber() + " - " + toString());
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

	/**
	 * When a visitor wishes to pay rent
	 * @param visitor
	 * @return
	 */
	public Boolean payRent(Player visitor){
		
		if(!isOwned()){
			Logger.log("Why would player "+visitor+" need to pay rent for "+this+" when it isn't owned by anyone?");
			return false;
		}
		
		if(!visitor.hasEnough(getRentPrice())){
			Logger.gameLog("Player "+visitor+" has insufficient funds to rent property "+this+" from "+currentOwner);
			return false;
		}
		
		visitor.deductCash(getRentPrice());
		currentOwner.addCash(getRentPrice());
		Logger.gameLog("Player "+visitor+" paid "+currentOwner+" $"+getRentPrice()+" for visiting "+this);
		
		return true;
		
	}

	/**
	 * When a buyer wants to buy the property
	 * 
	 * @param newBuyer
	 * @return
	 */
	public Boolean purchaseProperty(Player newBuyer) {
		Logger.log("Player " + newBuyer + " attempts to purchase property " + this);
		// In case somebody already owns it or its the same owner
		if (currentOwner != null)
			if (currentOwner == newBuyer) {
				Logger.gameLog("Cancelled purchase. Player " + newBuyer + " attempted to purchase his own property");
				return false;
			}

		// In case buyer don't have enough cash
		if (newBuyer.getCash() < getBuyPrice()) {
			Logger.gameLog("Player " + newBuyer + " has insufficient funds to buy property " + this);
			return false;
		}

		// Proceed with purchase
		if (currentOwner != null) {
			currentOwner.removeProperty(this);
			currentOwner.addCash(getCurrentPrice());
		}

		currentOwner = newBuyer;
		newBuyer.deductCash(getBuyPrice());
		newBuyer.addProperty(this);
		Logger.gameLog("Player " + newBuyer + " purchased property " + this + " for " + getBuyPrice());
		currentPrice = getCurrentPrice();

		return true;
	}

	public void setCurrentOwner(Player currentOwner) {
		this.currentOwner = currentOwner;
	}

	public Boolean isOwned() {
		return currentOwner != null;
	}

	public int getBuyPrice() {
		return (currentPrice * ((Double) Param.get(Param.BUY_PERCENT)).intValue());
	}

	public int getRentPrice() {
		return (currentPrice * ((Double) Param.get(Param.RENT_PERCENT)).intValue());
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	public Integer getSellPrice(){
		return (int) (currentPrice * 0.5);
	}
	
}
