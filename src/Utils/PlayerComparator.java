package Utils;

import java.util.Comparator;

import Entity.Player;

public class PlayerComparator implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		return p2.getTotalValue().compareTo(p1.getTotalValue());
	}

	
}
