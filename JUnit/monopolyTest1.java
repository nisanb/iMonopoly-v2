import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Entity.Dice;

public class monopolyTest1 {
	Dice dice = new Dice();

	@Test
	public void rollDiceSum() {

		// Why check this method? are you checking JAVAs' random ?
		// Instead you could check if a user position is correct after rolling a
		// dice..
		// Same applies to rollDice1 and rollDice2
		int sum = dice.getDice1() + dice.getDice2();

		// You can just-
		// assertTrue(sum>=2&&sum<=12);
		// instead of if and else
		// What about sum=2 or sum=12?
		if (sum > 2 && sum < 12) {
			// Why use assertTrue(true)?
			assertTrue(true);
		} else
			// this always returns true...
			assertFalse(false);

	}

	@Test
	public void rollDice1() {
		int first = dice.getDice1();
		if (first > 0 && first < 7) {
			assertTrue(true);
		} else
			assertFalse(false);
	}

	@Test
	public void rollDice2() {
		int second = dice.getDice2();
		if (second > 0 && second < 7) {
			assertTrue(true);
		} else
			assertFalse(false);
	}

}
