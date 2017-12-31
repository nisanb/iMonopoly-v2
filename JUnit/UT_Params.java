

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.Logger;
import Entity.MonDB;
import Utils.Param;

public class UT_Params {

	@Test
	public void test() {
		//Try to initiate DB
		Logger.initializeMyFileWriter();
		MonDB db = MonDB.getInstance();
		System.out.println(db.getParam(Param.STARTING_CASH));
		
		//change param and check if it changed in db
		db.setParam(Param.STARTING_CASH, 200000.0);
		assertEquals(200000.0, db.getParam(Param.STARTING_CASH));
	
		//reset params and check if it changed in db
		db.resetParamsToDefault();
		assertEquals(500000.0, db.getParam(Param.STARTING_CASH));
	}

}
