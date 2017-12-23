import static org.junit.Assert.*;

import org.junit.Test;

import Entity.Dice;

public class monopolyTest1 {
	Dice dice= new Dice();
	@Test
	public void rollDiceSum(){
		int sum=dice.getDice1()+dice.getDice2();
		if (sum>2 && sum<12){
			assertTrue(true);
		}
		else
			assertFalse(false);
		
	}
	@Test
	public void rollDice1(){
		int first= dice.getDice1();
		if (first>0 && first<7){
			assertTrue(true);
		}
		else
			assertFalse(false);
	}
	@Test
	public void rollDice2(){
		int second= dice.getDice2();
		if (second>0 && second<7){
			assertTrue(true);
		}
		else
			assertFalse(false);
	}
	

}
