package Controller;

import java.util.List;

import Entity.Dice;
import Entity.Game;
import Entity.Player;
import Entity.Question;
import Entity.Tile;
import View.IBoard;

public class Board implements IBoard{

	private static Board instance = null;
	
	private Board(){}
	
	public static Board getInstance(){
		if(instance == null)
			instance = new Board();
		return instance;
	}
	
	@Override
	public Player whosTurn(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dice> rollADice(Player player, Game game, Tile CurrentTile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tile getCurrentTile(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionsRelevantToTheProperty(Tile tile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game getCurrentGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isPlayerRight(Question question, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
