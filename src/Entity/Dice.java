package Entity;

import java.util.Random;

public abstract class Dice {
	static private Integer dice1;
	static private Integer dice2;
	
	public static Integer roll(){
		Random r = new Random();
		dice1 = r.nextInt(6)+1;
		dice2 = r.nextInt(6)+1;
		
		return (dice1+dice2);
	}
	
	public Integer getDice1(){
		return dice1;
	}
	
	public Integer getDice2(){
		return dice2;
	}
	
	
}
