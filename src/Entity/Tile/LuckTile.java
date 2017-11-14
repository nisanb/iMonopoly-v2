package Entity.Tile;

import java.util.List;

import Entity.Player;
import Entity.Question;
import Utils.TileType;

public class LuckTile extends Tile {

	public LuckTile(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.LuckyDraw);
		// TODO Auto-generated constructor stub
	}
	
	//TODO Return 2 random questions;
	public List<Question> generateTwoQuestions(){
		return null;
	}
	
	@Override
	public void preVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.preVisit(currentPlayer);
	}
	@Override
	public void visit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.visit(currentPlayer);
	}
	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.postVisit(currentPlayer);
	}

}
