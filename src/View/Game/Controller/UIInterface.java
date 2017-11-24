package View.Game.Controller;

import Entity.Player;
import Entity.Question;

public interface UIInterface {

	
	/**
	 * Return the UI.java object
	 * -> getUI(){
	 * 		return this;
	 * 	  }
	 * @return
	 */
	public UI getUI();
	
	/**
	 * Move a player from a tile to a tile
	 * @param playerNumber
	 * @param tileNumber
	 */
	public void movePlayer(int playerNumber, int tileFrom, int tileTo);
	
	/**
	 * if allow==true - display purchase option
	 * if allow==false - hide purchase option
	 * @param allow
	 */
	public void allowPurchase(Boolean allow);
	public void allowRent(Boolean allow);
	
	/**
	 * if enabled==true - rollDice button = enabled
	 * if enabled==false - rollDice button - disabled
	 * @param allow
	 */
	public void allowRollDice(Boolean enabled);
	
	/**
	 * Will display score board sorted by player total property value and cash
	 */
	public void finishGame();
	
	/**
	 * Will display a question on-screen with possible answers
	 * @param question
	 */
	public void displayQuestion(Question question);
		
	/**
	 * When activated, will update the players' properties:
	 * 	- Cash
	 *  - Strikes
	 *  - Assets
	 * @param player
	 */
	public void updatePlayerProperties(Player player);
	
	/**
	 * Will highlight the current player who is playing
	 * @param player
	 */
	public void updateCurrentPlayer(Player player);
	
	
	
}
