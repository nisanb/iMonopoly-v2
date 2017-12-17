package Utils;

import Entity.MonDB;

public enum Param {
	STARTING_CASH(500000), 	//Defines all players' starting cash
	RENT_PERCENT(0.15),  	//Defines the rent percent a user must pay on an owned property
	BUY_PERCENT(1.5),		//Defines the purchase price when a user lands on an owned property
	MIN_LUCK(10000),		//Defines the minimum cash given on luck tile
	MAX_LUCK(250000000),
	LUCK_MEDIUM_FAIL_FINE(50000),
	LUCK_HARD_FAIL_FINE(25000),
	QM_WRONG_ANSWER_FINE(50000),
	QM_ONLY_ONE_RIGHT(250000),
	QM_PLAYER_RIGHT_ANSWER(50000),
	QM_OTHER_PLAYER_RIGHT_ANSWER(75000),
	START_TILE_VISIT(200),	//Defines the maximum cash given on luck tile
	PROPERTY_EASY_DISCOUNT(0.05),
	PROPERTY_MEDIUM_DISCOUNT(0.15),
	PROPERTY_HARD_DISCOUNT(0.25),
	MAX_ROUNDS(50),
	RELEASE_FROM_JAIL(100000),
	BANKRUPTCY(-100000),
	
	
	PROPERTY_MINPRICE_EASY(50000),
	PROPERTY_MINPRICE_MEDIUM(250000),
	PROPERTY_MINPRICE_HARD(2000000),
	//PROPERTY_PRICE_EASY_MAX(250000),
	//PROPERTY_PRICE_MEDIUM_MAX(2000000),
	PROPERTY_PRICE_HARD_MAX(50000000);
	
	
	public Object o;
	
	Param(Object o){
		this.o = o;
	}
	
	public static Object get(Param p){
		return MonDB.getInstance().getParam(p);
	}
	
	public static void set(Param p, Object value){
		MonDB.getInstance().setParam(p, value);
	}
	
	

	

	
}
