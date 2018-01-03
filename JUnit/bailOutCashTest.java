import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Controller.GameEngine;
import Controller.Logger;
import Entity.MonDB;
import Entity.Player;
import Utils.Param;
import Utils.PlayerState;

public class bailOutCashTest {

	@Test
	public void bailOutCash() {
		// initialize a simulation
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");

		MonDB.getInstance().buildGame(list, new HashMap<>());
		Player currentPlayer = MonDB.getInstance().getCurrentGame().getCurrentPlayer();

		// Set player at jail tile
		currentPlayer.setCurrentTile(MonDB.getInstance().getCurrentGame().getTile(10));
		MonDB.getInstance().getCurrentGame().getCurrentPlayer().setState(PlayerState.JAILED);

		// finished simulation - player1 is in jail
		Double cashBeforeBailOut = MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCash();

		// trying to bail out of jail method
		GameEngine.getInstance().bailOut();

		//// after bailed out
		Double cashAfterBailOut = MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCash();

		System.out.println("Before: " + cashBeforeBailOut + " After: " + cashAfterBailOut);

		MonDB.getInstance().getCurrentGame().getCurrentPlayer().addCash(Param.get(Param.RELEASE_FROM_JAIL));

		assertTrue(cashBeforeBailOut > cashAfterBailOut && currentPlayer.getCash().equals(cashBeforeBailOut));
	}

}
