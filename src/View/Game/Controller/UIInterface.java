package View.Game.Controller;

import Entity.Question;

public interface UIInterface {

	
	/**
	 * Move a player from a tile to a tile
	 * @param playerNumber
	 * @param tileNumber
	 */
	public void movePlayer(String player, int tileFrom, int tileTo);
	
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
	public void displayQuestion(Question question, String nickname);
		
	/**
	 * When activated, will update the players' properties:
	 * 	- Cash
	 *  - Strikes
	 *  - Assets Worth
	 *  - Assets Amount
	 * @param player
	 */
	public void updatePlayerProperties(String nickname, Integer cash, Integer strikes, Integer assetsWorth, Integer assetsAmount);
	
	/**
	 * Will highlight the current player who is playing
	 * @param player
	 */
	public void updateCurrentPlayer(String player);
	
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
	
	
	/**
	 * Will change the dice visibility with the 'amount' number
	 * @param diceNumber - 1 or 2
	 * @param amount - 1 to 6
	 */
	public void changeDice(int diceNumber, int amount);
	
	/**
	 * 
	 * @param buyAmount the amount money you need to buy the asset (switch owner)
	 * @param rentAmount the amount money you need to rent the asset (doesnt switch owner)
	 * @param player to show on screen
	 * @param AssetName to show on screen
	 * @return true for buy - false for rent
	 */
	public boolean buyOrRentProperty(int buyAmount, int rentAmount, String player, String AssetName);
	
	
}
