package Entity;

import Controller.GameEngine;
import Controller.Logger;
import Utils.TileType;

public class QMTile extends Tile {

	public QMTile(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.QuestionMark);
	}

	//TODO
	public Question generateQuestion(){
		return null;
	}
	
	@Override
	public void preVisit(Player currentPlayer) {
		super.preVisit(currentPlayer);
	}
	@Override
	public void visit(Player currentPlayer) {
		Logger.log("Initiating question tile sequance..");
		GameEngine.getInstance().displayQMTile();
	}
	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.postVisit(currentPlayer);
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
