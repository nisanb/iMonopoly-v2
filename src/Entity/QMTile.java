package Entity;

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
