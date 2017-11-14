package Entity.Tile;

import Entity.Player;
import Utils.TileType;

public class Jail extends Tile {

	public Jail(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.Jail);
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
