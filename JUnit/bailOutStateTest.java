import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import Controller.GameEngine;
import Controller.Logger;
import Entity.Dice;
import Entity.Game;
import Entity.MonDB;
import Entity.Player;
import Entity.PropertyTile;
import Utils.NamedColor;
import Utils.PlayerState;
import Utils.PropertyType;
import Utils.QuestionStrength;

public class bailOutStateTest {

	@Test
	public void bailOutState() {
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
		System.out.println("Before bail out - player is in state: "+MonDB.getInstance().getCurrentGame().
				getCurrentPlayer().getState());
		/////trying to bail out of jail method
		GameEngine.getInstance().bailOut();
		////after bailed out
		System.out.println("After bail out - player is in state: "+MonDB.getInstance().getCurrentGame().
				getCurrentPlayer().getState());
		assertTrue(!MonDB.getInstance().getCurrentGame().getCurrentPlayer().getState().equals(PlayerState.JAILED));
	}


}