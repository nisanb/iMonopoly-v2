package Entity;

import Utils.TileType;

public interface Tilable {
	public void preVisit(Player currentPlayer);
	public void visit(Player currentPlayer);
	public void postVisit(Player currentPlayer);
	public Integer getTileNumber();
	public String toString();
	public TileType getTileType();
}
