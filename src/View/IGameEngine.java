package View;

import View.Game.Controller.UI;

public interface IGameEngine {

	// please add any extra variables inside the methods if needed
	/**
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
	 * 
	 * @param answerNum 1/2/3/4 -- not 0
	 */
	public void AnswerQuestion(int answerNum);
	
	
	

}
