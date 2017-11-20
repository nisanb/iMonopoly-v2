package Entity.Tile;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.helpers.NotIdentifiableEventImpl;

import Entity.Player;
import Utils.TileType;

public class Tile implements Tilable {

	private Integer tileNumber;
	private String tileName;
	private Set<Player> currentPlayers;
	public TileType tileType;
	private double xPos;
	private double yPos;
	
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

	

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
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

	
	
}
