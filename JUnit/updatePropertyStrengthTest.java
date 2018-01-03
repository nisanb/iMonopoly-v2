import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Controller.Logger;
import Entity.MonDB;
import Entity.Player;
import Entity.PropertyTile;
import Utils.NamedColor;
import Utils.PropertyType;
import Utils.QuestionStrength;

public class updatePropertyStrengthTest {

	@Test
	public void test() {
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");
		MonDB.getInstance().buildGame(list, new HashMap<>());
		PropertyTile pro = new PropertyTile(1, "test tile", QuestionStrength.EASY);
		pro.setCurrentPrice(90909999);
		System.out.println(pro.getPropertyStrength().toString());
		System.out.println(PropertyType.HARD);
		assertTrue(pro.getPropertyStrength().toString().equals(PropertyType.HARD.toString()));
	}

}
