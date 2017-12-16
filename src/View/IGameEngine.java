package View;

import java.util.List;

import Entity.Game;
import Utils.QuestionStrength;
import Utils.QuestionTag;
import View.Game.Controller.UI;

public interface IGameEngine {

	// please add any extra variables inside the methods if needed
	/**
	 * Sets the Game UI Object
	 * DO NOT TOUCH
	 */
	public void build(UI ui);
	
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
	public void btnQMShow(QuestionTag qt);
	
	/**
	 * Forward a string to the game log in the UI
	 * @param str
	 */
	public void gameLog(String str);
	
	/**
	 * 
	 * @param answers 1/2/3/4 -- not 0
	 */
	public void AnswerQuestion(List<Integer> answers);

	/**
	 * Tile previsit, postvisit and visit
	 * @param tileNumber
	 */
	void preVisit(Integer tileNumber);
	void Visit(Integer tileNumber);
	void postVisit(Integer tileNumber);
	void moveTo(Integer tileTo);

	public void displayQuestion(QuestionStrength qs);
	public String displayPrice(Double price);

	
	
	/**
	 * End of game methods
	 */
	public Game getCurrntGame();
}
