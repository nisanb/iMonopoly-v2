package View;

import View.Game.Controller.UI;

public interface IGameEngine {

	// please add any extra variables inside the methods if needed
	/**
	 * Sets the Game UI Object
	 * DO NOT TOUCH
	 */
	public void setUI(UI ui);
	
	/**
	 * Button Clicked methods sent from UI
	 */
	public void btnNextTurn();
	public void btnBuyProperty();
	public void btnPayRent();
	public void btnSellProperty();
	public void btnOfferTrade();
	public void btnQuitGame();
	public void btnRollDice();
	public void btnFinishTurn();
	
	/**
	 * Take a player to jail
	 */
	public void goToJail();
	
	/**
	 * Forward a string to the game log in the UI
	 * @param str
	 */
	public void gameLog(String str);
	
	/**
	 * player lands on a go tile
	 */
	public void landOnAGoTileButtonsDisplay();
	
	/**
	 *  player landing on a jail tile
	 */
	public void landOnAJailButtonsDisplay();
	/**
	 * player finished with his turn after landing on a tile/jail/etc
	 */
	public void finishedATileButtonsDisplay();
	/**
	 * player lands on a lucky tile
	 */
	public void landOnLuckyTileButtonsDisplay();
	/**
	 * player start his turn
	 */
	public void beforeRollDiceButtonsDisplay();
	/**
	 * player lands on a question mark tile
	 */
	public void landOnQuestionMarkButtonsDisplay();
	/**
	 * player lands on a propery that someone else own
	 */
	public void landOnOwnerPropertyButtonsDisplay();
	
	/**
	 * player lands on a property that no one own
	 */
	public void landOnEmptyPropertyButtonsDisplay();
	
	/**
	 * player lands on a property that he owns
	 */
	public void landOnHisOwnPropertyButtonsDisplay();
	
	
	
	
	/**
	 * 
	 * @param answerNum 1/2/3/4 -- not 0
	 */
	public void AnswerQuestion(int answerNum);
	
	
	

}
