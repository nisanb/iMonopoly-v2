package View;

import java.util.List;

import Entity.Answer;
import Entity.Player;
import Entity.Question;

public interface IGameEngine {

	// please add any extra variables inside the methods if needed
	
	
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
	
	
	
	
	
	/**
	 * 
	 * @param answerNum 1/2/3/4 -- not 0
	 */
	public void AnswerQuestion(int answerNum);
	
	
	

}
