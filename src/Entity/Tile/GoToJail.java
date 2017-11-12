package Entity.Tile;

import Entity.MonDB;
import Entity.Player;
import Utils.TileType;

public class GoToJail extends Tile   {

	public GoToJail(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.GoToJail);
	}
	
	
	//TODO - Take player to jail
	public void go(Player currentPlayer){
		
	}
	
	@Override
	public void preVisit(Player currentPlayer) {
		//Should be empty since nothing happens when a player passes this tile
	}
	@Override
	public void visit(Player currentPlayer) {
		MonDB.getInstance().getCurrentGame().movePlayer(currentPlayer, 29);
	}
	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.postVisit(currentPlayer);
	}
	
}
