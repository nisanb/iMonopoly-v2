package UnitTest;

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
		Object p = db.getParam(Param.STARTING_CASH);
		System.out.println(p.getClass());
		assertEquals(500000, db.getParam(Param.STARTING_CASH));
		db.setParam(Param.STARTING_CASH, 200000);
		assertEquals(200000, db.getParam(Param.STARTING_CASH));
		
	}

}
