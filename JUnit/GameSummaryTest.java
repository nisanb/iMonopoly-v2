import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.Test;

import Entity.*;

public class GameSummaryTest {

	@Test
	public void test() {
		//create list of players
		//test2
		LinkedList<Player> toReturn = new LinkedList<>();
		toReturn.add(new Player("P1", 900.0));
		toReturn.add(new Player("P2", 600.0));
		toReturn.add(new Player("P3", 700.0));
		toReturn.add(new Player("P4", 800.0));
		String expected1 = "1 - P1, Cash 900.0\r\n" + 
						  "2 - P4, Cash 800.0\r\n" + 
						  "3 - P3, Cash 700.0\r\n" + 
						  "4 - P2, Cash 600.0\r\n";
		
		testGameSummary(toReturn, expected1, 1);
		
		
		//test2
		toReturn = new LinkedList<>();
		toReturn.add(new Player("P1", 918000.0));
		toReturn.add(new Player("P2", 880000.0));
		toReturn.add(new Player("P3", 708020.0));
		toReturn.add(new Player("P4", 60220.0));
		String expected2 = "1 - P1, Cash 918000.0\r\n" + 
						   "2 - P2, Cash 880000.0\r\n" + 
						   "3 - P3, Cash 708020.0\r\n" + 
						   "4 - P4, Cash 60220.0\r\n";
				
		testGameSummary(toReturn, expected2, 2);
		
	}
	
	
	private void testGameSummary(LinkedList<Player> list, String expected, int testNum) {
		//create game and add players
		Game game = new Game(true, list);
		
		//get game summary, should return ordered list of players
		String output = "";
		for (Player p: game.getSummary()) {
			output += p.get_leadboardPosition()+ " - " +p.getNickName() + ", Cash " + p.getTotalValue() + "\r\n";
			//System.out.println(p.get_leadboardPosition()+ " - " +p.getNickName() + ", Cash " + p.getTotalValue());
			
		}
		
		if (expected.equals(output)) System.out.println("Test " + testNum + " Success\n");
		else System.out.println("Test " + testNum + " Failed\n");
		assertTrue("Success", expected.equals(output));
	}

}
