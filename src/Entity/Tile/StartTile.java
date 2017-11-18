package Entity.Tile;

import Entity.MonDB;
import Entity.Player;
import Utils.Param;
import Utils.TileType;

public class StartTile extends Tile implements Tilable {

	public StartTile(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.StartPoint);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void preVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		currentPlayer.addCash(MonDB.getInstance().getParam(Param.START_TILE_PASS));
	}
	@Override
	public void visit(Player currentPlayer) {
		// TODO Auto-generated method stub
		currentPlayer.addCash(MonDB.getInstance().getParam(Param.START_TILE_VISIT));
	}
	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.postVisit(currentPlayer);
	}
}
