package View;

import java.util.List;

import Entity.Dice;
import Entity.Game;
import Entity.Player;
import Entity.Question;
import Entity.Tile;

public interface IBoard {

	
	/**
	 * Methods TO DO
	 */
	
	
	//public Game getCurrentGame();
	/**
	 * 
	 * @param game - sends the current game
	 * @return gets the player nickname who need to play next
	 */
	public String whosTurn(int gameNum);
	
	/**
	 * 
	 * @param gameNum sends the game
	 * @return gets players cash by order player1,player2,...
	 */
	public List<Integer> getPlayersCash(int gameNum);
	
	/**
	 * 
	 * @param gameNum sends the game
	 * @return gets players strikes by order player1,player2,...
	 */
	public List<Integer> getPlayersStrikes(int gameNum);
	
	/**
	 * 
	 * @param gameNum sends the game
	 * @return gets players names by order player1,player2,...
	 */
	public List<String> getPlayersNickNames(int gameNum);
	
	/**
	 * 
	 * @return current game number
	 */
	public Integer getCurrentGameNum();
	
	
	
	
	
	/**
	 * 
	 * @param playerNickname - the player who need to play next
	 * @param gameNum - sends the current game
	 * @param tileNum - gets the player's current tile
	 * @return gets list of both dices
	 */
	public List<Integer> rollADice(String playerNickname, int gameNum, int tileNum );
	
	/**
	 * 
	 * @param playerNickname - sends a player
	 * @return Tile - gets the player's current tile number
	 */
	public Integer getCurrentTile(String playerNickname);
	
	/**
	 * 
	 * @param tile - sends the tile num
	 * @return relevant Random Questions or null if not relevant
	 */
	public List<Question> getQuestionsRelevantToTheProperty(Integer tileNum);
	
	/**
	 * 
	 * @param question 
	 * @param player - the player who try to answer the question
	 * @return true or false if player answered correctly
	 */
	public Boolean isPlayerRight(Question question, Player player);
	
	/**
	 * 
	 * @param gameNum the number of the game
	 * @return current round of the game
	 */
	public int getRound(int gameNum);

}
