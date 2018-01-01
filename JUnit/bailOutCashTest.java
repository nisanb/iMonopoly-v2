import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Controller.GameEngine;
import Controller.Logger;
import Entity.MonDB;
import Utils.PlayerState;

public class bailOutCashTest {

	@Test
	public void bailOutCash() {
		//initialize a simulation
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");
		MonDB.getInstance().buildGame(list, new HashMap<>());
		MonDB.getInstance().getCurrentGame().getCurrentPlayer()
			.setCurrentTile(MonDB.getInstance().getCurrentGame().getTile(10));
		MonDB.getInstance().getCurrentGame().getCurrentPlayer().setState(PlayerState.JAILED);
		//finished simulation - player1 is in jail
		Double cashBeforeBailOut=MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCash();
		System.out.println("Before bail out - player got cash : "+MonDB.getInstance().getCurrentGame().
			getCurrentPlayer().getCash());
		/////trying to bail out of jail method
		GameEngine.getInstance().bailOut();
		////after bailed out
		Double cashAfterBailOut=MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCash();
		System.out.println("After bail out -  player got cash : "+MonDB.getInstance().getCurrentGame().
			getCurrentPlayer().getCash());
		assertTrue(cashBeforeBailOut<cashAfterBailOut);
	}

}
