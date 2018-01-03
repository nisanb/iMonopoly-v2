import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Controller.GameEngine;
import Controller.Logger;
import Entity.MonDB;
import Entity.Player;
import Utils.PlayerState;

public class bailOutStateTest {

	@Test
	public void bailOutState() {

		// initialize a simulation
		Logger.initializeMyFileWriter();
		MonDB.getInstance().clearCurrentGame();
		MonDB.getInstance().resetParamsToDefault();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");
		MonDB.getInstance().buildGame(list, new HashMap<>());

		// Aquire current player
		Player currentPlayer = MonDB.getInstance().getCurrentGame().getCurrentPlayer();

		// Set to jail tile
		currentPlayer.setCurrentTile(MonDB.getInstance().getCurrentGame().getTile(10));
		currentPlayer.setState(PlayerState.JAILED);
		assertEquals(currentPlayer.getState(), PlayerState.JAILED);
		// finished simulation - player1 is in jail
		System.out.println(currentPlayer + " Before bail out - player is in state: " + currentPlayer.getState());
		///// trying to bail out of jail method
		GameEngine.getInstance().bailOut();
		currentPlayer.setState(PlayerState.WAITING);
		//// after bailed out
		System.out.println(currentPlayer + " After bail out - player is in state: " + currentPlayer.getState());
		assertEquals(currentPlayer.getState(), PlayerState.WAITING);
	}

}