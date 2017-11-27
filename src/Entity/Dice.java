package Entity;

import java.util.Random;

public class Dice {
	private Integer dice1;
	private Integer dice2;
	
	
	public Dice() {
		roll();
	}
	
	
	public void roll(){
		Random r = new Random();
		dice1 = r.nextInt(6)+1;
		dice2 = r.nextInt(6)+1;

	}
	
	public Integer getDice1(){
		return dice1;
	}
	
	public Integer getDice2(){
		return dice2;
	}


	public Integer getSum() {
		return dice1+dice2;
	}
	
	
}
