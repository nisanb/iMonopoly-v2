package Entity;

import java.util.HashSet;
import java.util.Set;

import Utils.TileType;

public class Tile implements Tilable {

	private Integer tileNumber;
	private String tileName;
	private Set<Player> currentPlayers;
	public TileType tileType;
	
	public Tile(Integer tileNumber, String tileName, TileType tileType) {
		super();
		this.tileNumber = tileNumber;
		this.tileName = tileName;
		this.currentPlayers = new HashSet<>();
		this.tileType = tileType;

	}
	
	public String getTileName() {
		return tileName;
	}

	public void setTileName(String tileName) {
		this.tileName = tileName;
	}

	public TileType getTileType() {
		return tileType;
	}

	public void setTileType(TileType tileType) {
		this.tileType = tileType;
	}

	public void setTileNumber(Integer tileNumber) {
		this.tileNumber = tileNumber;
	}

	public void setCurrentPlayers(Set<Player> currentPlayers) {
		this.currentPlayers = currentPlayers;
	}

	public Integer getTileNumber() {
		return tileNumber;
	}

	public Set<Player> getCurrentPlayers() {
		return currentPlayers;
	}

	
	@Override
	public void preVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Player currentPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean addPlayer(Player p) {
		if (p == null) return false;
		return this.currentPlayers.add(p);
		
	}

	private boolean removePlayer(Player p) {
		if (p == null) return false;
		return this.currentPlayers.remove(p);
		
	}
	
}
