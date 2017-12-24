package Entity;

import java.util.ArrayList;
import java.util.List;

import Controller.GameEngine;
import Controller.Logger;
import Utils.QuestionStrength;
import Utils.TileType;

public class LuckTile extends Tile {

	List<Boolean> answers;

	public LuckTile(Integer tileNumber, String tileName) {
		super(tileNumber, tileName, TileType.LuckyDraw);
		answers = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	// TODO Return 2 random questions;
	public List<Question> generateTwoQuestions() {
		List<Question> qlList = new ArrayList<Question>();
		qlList.add(MonDB.getInstance().getRandomQuestion(QuestionStrength.HARD));
		qlList.add(MonDB.getInstance().getRandomQuestion(QuestionStrength.MEDIUM));
		return qlList;
	}

	@Override
	public void preVisit(Player currentPlayer) {
		// TODO Auto-generated method stub

		super.preVisit(currentPlayer);
	}

	@Override
	public void visit(Player currentPlayer) {
		// Dont allow finish turn
		GameEngine.getInstance().allowFinishTurn(false);
		answers.clear();
		Logger.gameLog("Player " + currentPlayer + " reached Lucky Tile!");
		Logger.gameLog("System is generating 2 questions..");
		GameEngine.getInstance().displayQuestions(generateTwoQuestions());
	}

	@Override
	public void postVisit(Player currentPlayer) {
		// TODO Auto-generated method stub
		super.postVisit(currentPlayer);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Boolean answered(Boolean result) {
		answers.add(result);
		if (answers.size() == 2)
			return true;
		return false;
	}

	public void checkResults(Player p) {
		if (answers.get(0) && answers.get(1)) {
			// User is right on both
			Double receivedCash = GameEngine.getInstance().getLuckyTileAward();
			p.addCash(receivedCash);
			GameEngine.getInstance().showInfo("Player " + p + ", You received " + displayPrice(receivedCash)
					+ "\nfor answering right on both questions!");
			GameEngine.getInstance().allowFinishTurn(true);
			return;
		}
		String results = "Player " + p + ",\n";
		// User is wrong on medium question
		if (!answers.get(0)) {
			p.deductCash(50000);
			p.addStrike();
			results += "You were fined for " + displayPrice(50000.0) + ", \n"
					+ "and were added a strike, for failing to answer the medium question.\n\n";
		}

		if (!answers.get(1)) {
			p.deductCash(25000);
			results += "You were fined for " + displayPrice(25000.0) + " for failing to answer the hard question.";
		}

		GameEngine.getInstance().showInfo(results);
		GameEngine.getInstance().allowFinishTurn(true);
	}

	private String displayPrice(Double price) {
		return GameEngine.getInstance().displayPrice(price);
	}

}
