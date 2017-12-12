package View.Game.Controller;

import java.util.List;

import Entity.Player;
import Entity.Question;
import Utils.NamedColor;

public interface UIInterface {

	
	/**
	 * Move a player from a tile to a tile
	 * @param playerNumber
	 * @param tileNumber
	 */
	public void movePlayer(String player, int tileFrom, int tileTo);
	
	/**
	 * if allow==true - allow option
	 * if allow==false - hide option
	 * @param allow
	 */
	public void allowPurchase(Boolean allow);
	public void allowSellProperty(Boolean allow);
	public void allowRent(Boolean allow);
	public void allowRollDice(Boolean enabled);
	public void allowFinishTurn(Boolean enabled);
	
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
	public void updatePlayerProperties(String nickname, Double cash, Integer strikes, Double assetsWorth, Integer assetsAmount);
	
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
	public void gameLogDisplay();
	
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
	
	/**
	 * Build the game board and send the player list to initialize
	 * @param playerList
	 */
	public void build(List<Player> playerList);
	
	/**
	 * Display a relevent information to the player
	 * @param txt
	 */
	public void showPlayInformation(String txt);
	
	/**
	 * Marks a tile as purchased by a player color
	 * @param tileNumber
	 */
	public void markTile(Integer tileNumber, NamedColor playerColor);

	/**
	 * Update the current game round
	 */
	public void updateRounds(Integer roundNumber);

	/**
	 * Will display the QM Choices for question tags
	 * @param currentPlayer
	 */
	void displayQMList(String currentPlayer);
}
