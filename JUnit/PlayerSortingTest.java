

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import Entity.Player;
import Utils.PlayerComparator;

public class PlayerSortingTest {

	@Test
	public void test() {
		List<Player> toReturn = new ArrayList<>();
		toReturn.add(new Player("P1", 900.0));
		toReturn.add(new Player("P2", 600.0));
		toReturn.add(new Player("P3", 700.0));
		toReturn.add(new Player("P4", 800.0));

		// the comparator to be tested
		Collections.sort(toReturn, new PlayerComparator());

		String expected = "P1 P4 P3 P2 ";
		String runResault = "";
		for (Player p : toReturn) {
			runResault += p.toString() + " ";
		}

		System.out.println(runResault + "vs. " + expected);

		assertTrue("Successfull", runResault.equals(expected));

	}

}
