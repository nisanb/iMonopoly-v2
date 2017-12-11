package Entity;

import Controller.GameEngine;
import Controller.Logger;
import Controller.Music;
import Utils.TileType;

public class GoToJail extends Tile   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoToJail(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.GoToJail);
	}
	
	public void go(Player currentPlayer){
		Music.getInstance().play("siren.wav");
		GameEngine.getInstance().moveTo(10);
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
