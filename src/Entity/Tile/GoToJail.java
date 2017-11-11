package Entity.Tile;

import Entity.Player;
import Utils.TileType;

public class GoToJail extends Tile {

	public GoToJail(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.GoToJail);
	}
	
	
	//TODO - Take player to jail
	public void go(Player currentPlayer){
		
	}
	
	@Override
	public void preVisit(Player currentPlayer) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		super.preVisit(currentPlayer);
	}
	
}
