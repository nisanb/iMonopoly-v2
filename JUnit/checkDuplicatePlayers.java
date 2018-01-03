import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Controller.Logger;
import Entity.MonDB;
import View.Player.Controller.GameSettings;

public class checkDuplicatePlayers {
	@Test
	public void test() {
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		
		 List<String> check= new ArrayList();
		 check.add("p1");
		 check.add("p1");
		 check.add("p4");
		 check.add("p3");
		 boolean expected=true;
		MonDB.getInstance().buildGame(check,new HashMap<>());

		 
		 GameSettings gs= new GameSettings();
		boolean output= gs.duplicates(check);
		
		
		assertEquals(output,expected);

	}
}
