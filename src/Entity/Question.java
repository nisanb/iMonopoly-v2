package Entity;

import java.util.ArrayList;
import java.util.List;

import Utils.QuestionStrength;

public class Question {

	
	private long qNumber;
	private QuestionStrength qStrength;
	private String qQuestion;
	private boolean isMultipleChoise;
	private List<Answer> qAnswers;
	private String team;
	
	public Question(long qNumber, QuestionStrength qStrength, String qQuestion, boolean isMultiple ,List<Answer> qAnswers, String team) {
		super();
		this.qNumber = qNumber;
		this.qStrength = qStrength;
		this.qQuestion = qQuestion;
		this.qAnswers = qAnswers;
		this.team = team;
		this.isMultipleChoise = isMultiple;
	}
	
	public long getqNumber() {
		return qNumber;
	}
	public void setqNumber(long qNumber) {
		this.qNumber = qNumber;
	}
	public QuestionStrength getqStrength() {
		return qStrength;
	}
	public void setqStrength(QuestionStrength qStrength) {
		this.qStrength = qStrength;
	}
	public String getqQuestion() {
		return qQuestion;
	}
	public void setqQuestion(String qQuestion) {
		this.qQuestion = qQuestion;
	}
	public List<Answer> getqAnswers() {
		return qAnswers;
	}
	public void setqAnswers(List<Answer> qAnswers) {
		this.qAnswers = qAnswers;
	}

	public boolean isMultipleChoise() {
		return isMultipleChoise;
	}

	public void setMultipleChoise(boolean isMultipleChoise) {
		this.isMultipleChoise = isMultipleChoise;
	}
	
	public void addAnswer(Answer a1) {
		if (this.qAnswers == null)
			this.qAnswers = new ArrayList<Answer>();
		this.qAnswers.add(a1);
	}

	@Override
	public String toString() {
		return "Question [qNumber=" + qNumber + ", qStrength=" + qStrength + ", qQuestion=" + qQuestion
				+ ", isMultipleChoise=" + isMultipleChoise + ", qAnswers=" + qAnswers + ", team=" + team + "]";
	}
	
	
	
	
	
	
	
}
