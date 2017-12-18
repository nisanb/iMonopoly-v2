package UnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import Controller.Logger;
import Entity.Player;

public class SortingTest {

	@Test
	public void test() {
		List<Player> toReturn = new ArrayList<>();
		Random rand = new Random();
		toReturn.add(new Player("P1", 900.0));
		toReturn.add(new Player("P2", 600.0));
		toReturn.add(new Player("P3", 700.0));
		toReturn.add(new Player("P4", 800.0));
		
		//the comparator to be tested
		Collections.sort(toReturn, (Comparator<Player>) (Player p1, Player p2)-> p2.getTotalValue().compareTo(p1.getTotalValue()));
		
		
		String expected = "P1 P4 P3 P2 ";
		String runResault = "";
		for (Player p:toReturn) {
			runResault += p.toString() + " ";
		}
		
		System.out.println(runResault +"vs. " +expected);
		
		assertTrue("Successfull", runResault.equals(expected));
		
	}

}
