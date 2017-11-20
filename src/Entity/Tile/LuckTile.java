package Entity.Tile;

import java.util.List;

import Controller.Logger;
import Entity.MonDB;
import Entity.Player;
import Entity.Question;
import Utils.QuestionStrength;
import Utils.TileType;

public class LuckTile extends Tile {

	public LuckTile(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.LuckyDraw);
		// TODO Auto-generated constructor stub
	}
	
	//TODO Return 2 random questions;
	public List<Question> generateTwoQuestions(){
		MonDB.getInstance().getRandomQuestion(QuestionStrength.MEDIUM);
		MonDB.getInstance().getRandomQuestion(QuestionStrength.HARD);
		
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
		Logger.gameLog("Player "+currentPlayer+" reached Lucky Tile!");
		Logger.gameLog("System is generating 2 questions..");
		generateTwoQuestions();
	}
	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.postVisit(currentPlayer);
	}

}
