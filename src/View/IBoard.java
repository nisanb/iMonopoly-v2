package View;

import java.util.List;

import Entity.Dice;
import Entity.Game;
import Entity.Player;
import Entity.Question;
import Entity.Tile.Tile;
import Utils.QuestionStrength;

public interface IBoard {

	
	/**
	 * Methods TO DO
	 */
	
	/**
	 * 
	 * @return current Game with all parameters
	 */
	public Game getCurrentGame();
	/**
	 * 
	 * @param game - sends the current game
	 * @return gets the player who need to play next
	 */
	public Player whosTurn(Game game);
	
	/**
	 * 
	 * @param player - the player who need to play next
	 * @param game - sends the current game
	 * @param tile - gets the player's current tile
	 * @return gets list of both dices
	 */
	public List<Dice> rollADice(Player player, Game game, Tile CurrentTile );
	
	/**
	 * 
	 * @param player - sends a player
	 * @return Tile - gets the player's current tile 
	 */
	public Tile getCurrentTile(Player player);
	
	/**
	 * 
	 * @param tile - sends the tile
	 * @return relevant Random Questions or null if not relevant
	 */
	public List<Question> getQuestionsRelevantToTheProperty(Tile tile);
	
	/**
	 * 
	 * @param question 
	 * @param player - the player who try to answer the question
	 * @return true or false if player answered correctly
	 */
	public Boolean playerAnswerQuestion(Question question, Player player);
	
	
	public Boolean 
}
