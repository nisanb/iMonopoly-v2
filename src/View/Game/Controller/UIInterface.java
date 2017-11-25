package View.Game.Controller;

import Entity.Player;
import Entity.Question;
import javafx.fxml.FXML;

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
	public void movePlayer(Player player, int tileFrom, int tileTo);
	
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
	 *  @param player the player who is trying to answer this question
	 */
	public void displayQuestion(Question question, Player player);
		
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
	
	/**
	 * Get a message to print in game log
	 * @param message
	 */
	public void gameLog(String message);
	
	/**
	 * Display the history of game log
	 * @param display
	 */
	public void gameLogDisplay(Boolean display);
	
	public void BuildBoard();
	/**
	 * 
	 * @param answerNum show the right answer
	 */
	public void showAnswer(int answerNum);
	
	
	
	

	
}
