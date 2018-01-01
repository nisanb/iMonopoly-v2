import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

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

public class monopolyTest1 {
	Dice dice = new Dice();
	Player p;
	Player p2;

	@Test
	public void initialize() {
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");
		MonDB.getInstance().buildGame(list, new HashMap<>());
		p = new Player("player1", 5655.0, NamedColor.BLUE);
		p2 = new Player("player2", 5655.0, NamedColor.RED);
	}

	@Test
	public void checkSellProperty() {
		p = new Player("player1", 5655.0, NamedColor.BLUE);
		p2 = new Player("player2", 5655.0, NamedColor.RED);
		PropertyTile pro = new PropertyTile(1, "test tile", QuestionStrength.EASY);
		pro.addPlayer(p);
		pro.setCurrentPrice(909090000);
		p.setCurrentTile(pro);
		pro.getInitialPrice();
		Double cashBeforeSell = p.getCash();
		p.sellProperty();
		System.out.println("cash at start : " + cashBeforeSell + "\n cash now: " + p.getCash());
		System.out.println(cashBeforeSell < p.getCash());
		assertTrue(cashBeforeSell < p.getCash());
	}

	@Test
	public void checkPropertyStrength() {
		Logger.initializeMyFileWriter();
		MonDB.getInstance().getCurrentGame();
		PropertyTile pro = new PropertyTile(1, "test tile", QuestionStrength.EASY);
		pro.setCurrentPrice(90909999);
		System.out.println(pro.getPropertyStrength().toString());
		System.out.println(PropertyType.HARD);
		assertTrue(pro.getPropertyStrength().toString().equals(PropertyType.HARD.toString()));
	}

	@Test
	public void playerMoveNotInJail() {
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");
		MonDB.getInstance().buildGame(list, new HashMap<>());
		Player p = new Player("player1", 5655.0, NamedColor.BLUE);
		Player p2 = new Player("player2", 5655.0, NamedColor.RED);
		int currentTile = MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCurrentTile().getTileNumber();
		int dice = RollDice();
		int afterRollTile = MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCurrentTile().getTileNumber();
		assertTrue(currentTile + dice == afterRollTile);
	}

	@Test
	public void playerMoveInJail() {
		Logger.initializeMyFileWriter();
		MonDB.getInstance().resetParamsToDefault();
		MonDB.getInstance().getCurrentGame();
		List<String> list = new ArrayList<>();
		list.add("player1");
		list.add("player2");
		MonDB.getInstance().buildGame(list, new HashMap<>());
		Player p = new Player("player1", 5655.0, NamedColor.BLUE);
		Player p2 = new Player("player2", 5655.0, NamedColor.RED);
		MonDB.getInstance().getCurrentGame().getCurrentPlayer()
				.setCurrentTile(MonDB.getInstance().getCurrentGame().getTile(10));
		MonDB.getInstance().getCurrentGame().getCurrentPlayer().setState(PlayerState.JAILED);
		int currentTile = MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCurrentTile().getTileNumber();
		RollDice();
		int afterRollTile = MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCurrentTile().getTileNumber();
		assertTrue(currentTile == afterRollTile);
	}

	public int RollDice() {
		boolean flag = true;
		Game _game = MonDB.getInstance().getCurrentGame();
		Dice dice = _game.rollDice();
		System.out.println("Player " + _game.getCurrentPlayer() + " rolled " + dice.getSum() + " !");
		Player currentPlayer = _game.getCurrentPlayer();
		/**
		 * Jail Treatment
		 */
		if (MonDB.getInstance().getCurrentGame().getCurrentPlayer().isInJail()) {
			flag = false;
			if (dice.getDice1().equals(dice.getDice2())) {
				System.out.println("Player " + currentPlayer + " rolled a double and is free from jail!");
				currentPlayer.setState(PlayerState.WAITING);
			} else {
				System.out.println("Player " + currentPlayer + " did not roll a double. Moving on to next turn.");
			}
		}
		System.out.println("Current Player: " + currentPlayer);
		System.out.println("Current Tile: " + currentPlayer.getCurrentTile());
		System.out.println("Current Tile # " + currentPlayer.getCurrentTile().getTileNumber());
		if (flag) {
			Integer moveToTile = (dice.getSum()
					+ MonDB.getInstance().getCurrentGame().getCurrentPlayer().getCurrentTile().getTileNumber()) % 40;
			System.out.println("move to tile  " + moveToTile);
			MonDB.getData().getCurrentGame().getCurrentPlayer().setCurrentTile(_game.getTile(moveToTile));
		}
		return dice.getDice1() + dice.getDice2();
	}

}