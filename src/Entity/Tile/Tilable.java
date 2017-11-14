package Entity.Tile;

import Entity.Player;

public interface Tilable {
	public void preVisit(Player currentPlayer);
	public void visit(Player currentPlayer);
	public void postVisit(Player currentPlayer);
}
