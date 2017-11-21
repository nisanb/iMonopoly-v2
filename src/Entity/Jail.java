package Entity;

import Controller.Logger;
import Utils.TileType;

public class Jail extends Tile {

	public Jail(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.Jail);
	}
	
	@Override
	public void preVisit(Player currentPlayer) {
		//Empty
	}
	@Override
	public void visit(Player currentPlayer) {
		//Player enters jail
		Logger.gameLog("Welcome to jail "+currentPlayer+"!");
	}
	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.postVisit(currentPlayer);
	}
	
}
