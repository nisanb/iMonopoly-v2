package Entity;

import java.util.Random;

import Controller.GameEngine;
import Controller.Logger;
import Utils.Param;
import Utils.QuestionStrength;
import Utils.TileType;

public class PropertyTile extends Tile {

	private Double initialPrice;
	private Double currentPrice;
	private Double tmpDiscount;
	private Player currentOwner;
	private QuestionStrength propertyStrength;

	public PropertyTile(Integer tileNumber, String tileName, QuestionStrength qs) {
		super(tileNumber, tileName, TileType.Property);
		this.propertyStrength = qs;
		this.currentOwner = null;
		tmpDiscount = 0.0;
		setInitialPrice();
	}

	private void setInitialPrice() {
		// TODO Generate a price according the the questions strength
		Integer min = 0, max = 0;
		switch (propertyStrength) {
		case EASY:
			min = (Integer) Param.get(Param.PROPERTY_MINPRICE_EASY);
			max = (Integer) Param.get(Param.PROPERTY_MINPRICE_MEDIUM);
			break;
		case MEDIUM:
			min = (Integer) Param.get(Param.PROPERTY_MINPRICE_MEDIUM);
			max = (Integer) Param.get(Param.PROPERTY_MINPRICE_HARD);
			break;
		case HARD:
			min = (Integer) Param.get(Param.PROPERTY_MINPRICE_HARD);
			max = (Integer) Param.get(Param.PROPERTY_PRICE_HARD_MAX);
			break;

		}
		Random r = new Random();
		Integer chosenPriceInteger = (r.nextInt(max - min) + min);
		Double chosenPrice = chosenPriceInteger.doubleValue();
		this.initialPrice = chosenPrice;
		this.currentPrice = chosenPrice;
		Logger.log("Setting price $" + chosenPrice + " for tile #" + getTileNumber() + " - " + toString());
	}

	public QuestionStrength getPropertyStrength() {
		Integer propertyMinPrice_Hard = (Integer) Param.get(Param.PROPERTY_MINPRICE_HARD);
		if (this.currentPrice.compareTo(propertyMinPrice_Hard.doubleValue()) > 0)
			return QuestionStrength.HARD;
		Integer propertyMinPrice_Medium = (Integer) Param.get(Param.PROPERTY_MINPRICE_MEDIUM);
		if (this.currentPrice.compareTo(propertyMinPrice_Medium.doubleValue()) > 0)
			return QuestionStrength.MEDIUM;

		return QuestionStrength.EASY;
	}

	public void setPropertyStrength(QuestionStrength propertyStrength) {
		this.propertyStrength = propertyStrength;
	}

	public Double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Player getCurrentOwner() {
		return currentOwner;
	}

	/**
	 * When a visitor wishes to pay rent
	 *
	 * @param visitor
	 * @return
	 */
	public Boolean payRent(Player visitor) {

		if (!isOwned()) {
			Logger.gameLog("Why would player " + visitor + " need to pay rent for " + this
					+ " when it isn't owned by anyone?");
			return false;
		}

		/*
		 * if (!visitor.hasEnough(getRentPrice())) { Logger.gameLog( "Player " +
		 * visitor + " has insufficient funds to rent property " + this +
		 * " from " + currentOwner); Logger.gameLog("Rent Price: " +
		 * getRentPrice() + " Visitor Cash: " + visitor.getCash()); return
		 * false; }
		 */

		visitor.deductCash(getRentPrice() + 500000);
		currentOwner.addCash(getRentPrice());
		Logger.gameLog("Player " + visitor + " paid " + currentOwner + " $" + getRentPrice() + " for visiting " + this);

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

		Double currentPurchasePrice = tmpDiscount > 0 ? tmpDiscount : getBuyPrice();
		tmpDiscount = 0.0;
		// In case buyer don't have enough cash
		if (newBuyer.getCash() < currentPurchasePrice) {
			Logger.gameLog("Player " + newBuyer + " has insufficient funds to buy property " + this);
			return false;
		}

		// Proceed with purchase
		if (currentOwner != null) {
			Logger.log("Tile " + this + " already has an owner: " + currentOwner);
			currentOwner.removeProperty(this);
			currentOwner.addCash(currentPurchasePrice);
			GameEngine.getInstance().updatePlayerProperties(currentOwner);
		}

		currentOwner = newBuyer;
		newBuyer.deductCash(currentPurchasePrice.intValue());
		newBuyer.addProperty(this);
		Logger.gameLog("Player " + newBuyer + " purchased property " + this + " for "
				+ GameEngine.getInstance().displayPrice(currentPurchasePrice.doubleValue()));
		currentPrice = getBuyPrice().doubleValue();

		return true;
	}

	public void setCurrentOwner(Player currentOwner) {
		this.currentOwner = currentOwner;
	}

	public Boolean isOwned() {
		return currentOwner != null;
	}

	public Integer getBuyPrice() {
		Double amt = (currentPrice * ((Double) Param.get(Param.BUY_PERCENT)));
		return amt.intValue();
	}

	public Integer getBuyPriceDiscount() {
		Double newPrice = 0.0;
		switch (getPropertyStrength()) {
		case EASY:
			newPrice = getBuyPrice() * (1 - (Double) Param.get(Param.PROPERTY_EASY_DISCOUNT));
			break;
		case MEDIUM:
			newPrice = getBuyPrice() * (1 - (Double) Param.get(Param.PROPERTY_EASY_DISCOUNT));
			break;
		case HARD:
			newPrice = getBuyPrice() * (1 - (Double) Param.get(Param.PROPERTY_EASY_DISCOUNT));
			break;
		}
		tmpDiscount = newPrice;
		return tmpDiscount.intValue();
	}

	public Integer getRentPrice() {
		Double rentPrice = currentPrice.doubleValue();
		rentPrice *= (Double) Param.get(Param.RENT_PERCENT);
		return rentPrice.intValue();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Integer getSellPrice() {
		return (int) (currentPrice * 0.5);
	}

	@Override
	public void visit(Player currentPlayer) {

		String txtToDispaly = "Player " + currentPlayer + ", you have landed on property " + this + " .\n";

		if (!isOwned()) {
			txtToDispaly += "You may purchase this property for a total of "
					+ GameEngine.getInstance().displayPrice(getBuyPrice().doubleValue()) + ".\n"
					+ "Click on \"Buy Property\" in order to purchase,\n"
					+ "or \"Finish Turn\" in order to skip your turn.";
			GameEngine.getInstance().allowPurchaseProperty(true);
			GameEngine.getInstance().allowFinishTurn(true);
		} else {
			if (!currentOwner.equals(currentPlayer)) {
				// The current owner is not the player whos' turn is now
				txtToDispaly += "This property is currently owned by " + currentOwner + "\n"
						+ "You can attempt to purchase this property by clicking \"Buy Property\",\n"
						+ "or pay the rent which is a total of "
						+ GameEngine.getInstance().displayPrice(getRentPrice().doubleValue());
				GameEngine.getInstance().allowPurchaseProperty(true);
				GameEngine.getInstance().allowRent(true);

			} else {
				txtToDispaly += "This property is owned by yourself.\nYou may choose to sell this property for "
						+ displayPrice(getSellPrice().doubleValue()) + "\n"
						+ "or click on \"Finish Turn\" in order to skip your turn.";
				GameEngine.getInstance().allowFinishTurn(true);
				GameEngine.getInstance().allowSellProperty(true);
			}
		}

		GameEngine.getInstance().showInfo(txtToDispaly);
	}

	private String displayPrice(Double price) {
		return GameEngine.getInstance().displayPrice(price);
	}

}
