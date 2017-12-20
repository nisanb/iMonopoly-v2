package Entity;

import Controller.GameEngine;
import Controller.Music;
import Utils.Param;
import Utils.TileType;

public class StartTile extends Tile implements Tilable {

	public StartTile(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.StartPoint);
		// TODO Auto-generated constructor stub, 
	}

	@Override
	public void preVisit(Player currentPlayer) {
		if(!verifyRights(currentPlayer))
			return;
		
		currentPlayer.addCash(Param.get(Param.START_TILE_VISIT));
		Music.getInstance().play("cash_in.mp3");
	}
	@Override
	public void visit(Player currentPlayer) {
		if(!verifyRights(currentPlayer))
			return;
		
		currentPlayer.addCash(Param.get(Param.START_TILE_VISIT));
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
	
	private Boolean verifyRights(Player currentPlayer){
		return !currentPlayer.isInJail() && GameEngine.getInstance().getCurrntGame().getPlayers().size() < GameEngine.getInstance().getCurrntGame().getCurrentRound();
	}
}
