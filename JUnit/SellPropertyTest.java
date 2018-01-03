import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Controller.Logger;
import Entity.MonDB;
import Entity.Player;
import Entity.PropertyTile;
import Utils.NamedColor;
import Utils.QuestionStrength;

public class SellPropertyTest {

	@Test
	public void checkSellProperty() {
		// initialize simulation of a game
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");
		MonDB.getInstance().buildGame(list, new HashMap<>());
		Player p = new Player("player1", 5655.0, NamedColor.BLUE);
		PropertyTile pro = new PropertyTile(1, "test tile", QuestionStrength.EASY);
		pro.addPlayer(p);
		pro.setCurrentPrice(909090000.0);
		p.setCurrentTile(pro);
		pro.getInitialPrice();
		Double cashBeforeSell = p.getCash();
		// finished the initialization - player1 owns a property named "test
		// tile" and trying to sell it
		p.sellProperty();
		System.out.println("cash before sale : " + cashBeforeSell);
		System.out.println("cash after sale : " + p.getCash());
		assertTrue(cashBeforeSell < p.getCash());
	}

}
