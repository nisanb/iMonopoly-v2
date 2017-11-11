package Entity.Tile;

import Entity.Player;
import Utils.TileType;

public class Jail extends Tile {

	public Jail(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.Jail);
	}
	
	@Override
	public void preVisit(Player currentPlayer) throws ClassNotFoundException {
		// TODO Previsit - what happens when a player steps on "Jail" (Should be nothing..)
		super.preVisit(currentPlayer);
	}
	
}
