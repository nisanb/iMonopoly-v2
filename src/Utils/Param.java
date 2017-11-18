package Utils;

import Entity.MonDB;

public enum Param {
	STARTING_CASH(500000), 	//Defines all players' starting cash
	RENT_PERCENT(0.15),  	//Defines the rent percent a user must pay on an owned property
	BUY_PERCENT(1.5),		//Defines the purchase price when a user lands on an owned property
	MIN_LUCK(10000),		//Defines the minimum cash given on luck tile
	MAX_LUCK(250000000),
	START_TILE_PASS(200),
	START_TILE_VISIT(200);	//Defines the maximum cash given on luck tile
	
	
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
