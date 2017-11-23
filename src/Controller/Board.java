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
	public String whosTurn(int gameNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getPlayersCash(int gameNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getPlayersStrikes(int gameNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlayersNickNames(int gameNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCurrentGameNum() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Question> getQuestionsRelevantToTheProperty(Integer tileNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isPlayerRight(Question question, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRound(int gameNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getCurrentTile(String playerNickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> rollADice(String playerNickname, int gameNum, int tileNum) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
