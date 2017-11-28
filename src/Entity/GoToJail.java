package Entity;

import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Utils.TileType;

public class GoToJail extends Tile   {

	public GoToJail(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.GoToJail);
	}
	
	
	//TODO - Take player to jail
	public void go(Player currentPlayer){
		iWindow.getGameEngine().goToJail();
	}
	
	@Override
	public void preVisit(Player currentPlayer) {
		//Should be empty since nothing happens when a player passes this tile
	}
	@Override
	public void visit(Player currentPlayer) {
		Logger.gameLog("Player "+currentPlayer+" is going to jail!");
		go(currentPlayer);
	}
	@Override
	public void postVisit(Player currentPlayer) {
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
