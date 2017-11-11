package Entity.Tile;

import Entity.Player;
import Entity.Question;
import Utils.TileType;

public class QMTile extends Tile {

	public QMTile(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.QuestionMark);
		// TODO add requiered fields
	}

	//TODO
	public Question generateQuestion(){
		return null;
	}
	
	@Override
	public void preVisit(Player currentPlayer) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		super.preVisit(currentPlayer);
	}
	
}
