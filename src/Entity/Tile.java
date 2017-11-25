package Entity;

import java.util.HashSet;
import java.util.Set;

import Utils.TileType;

public class Tile implements Tilable {

	private Integer _tileNumber;
	private String _tileName;
	private Set<Player> _currentPlayers;
	public TileType _tileType;
	
	public Tile(Integer tileNumber, String tileName, TileType tileType) {
		super();
		_tileNumber = tileNumber;
		_tileName = tileName;
		_currentPlayers = new HashSet<>();
		_tileType = tileType;

	}
	
	public Tile(int tileNumber) {
		_tileNumber = tileNumber;
	}

	public String getTileName() {
		return _tileName;
	}

	public void setTileName(String tileName) {
		_tileName = tileName;
	}

	public TileType getTileType() {
		return _tileType;
	}

	public void setTileType(TileType tileType) {
		_tileType = tileType;
	}

	public void setTileNumber(Integer tileNumber) {
		_tileNumber = tileNumber;
	}

	public void setCurrentPlayers(Set<Player> currentPlayers) {
		_currentPlayers = currentPlayers;
	}

	public Integer getTileNumber() {
		return _tileNumber;
	}

	public Set<Player> getCurrentPlayers() {
		return _currentPlayers;
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
		return _currentPlayers.add(p);
		
	}

	private boolean removePlayer(Player p) {
		if (p == null) return false;
		return _currentPlayers.remove(p);
		
	}
	
}
