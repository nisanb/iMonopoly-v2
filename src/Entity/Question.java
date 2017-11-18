package Entity;

import java.util.List;

import Utils.QuestionStrength;

public class Question {

	
	private Integer qNumber;
	private QuestionStrength qStrength;
	private String qQuestion;
	private String team;
	private List<String> qAnswers;
	private Integer rightAnswer;
	
	public Question(Integer qNumber, QuestionStrength qStrength, String qQuestion, List<String> qAnswers,
			Integer rightAnswer, String team) {
		this.qNumber = qNumber;
		this.qStrength = qStrength;
		this.qQuestion = qQuestion;
		this.qAnswers = qAnswers;
		this.rightAnswer = rightAnswer;
	}
	
	public Boolean isCorrect(Integer aNumber){
		return aNumber.equals(this.rightAnswer);
	}
	
	public Integer getqNumber() {
		return qNumber;
	}
	public void setqNumber(Integer qNumber) {
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
	public List<String> getqAnswers() {
		return qAnswers;
	}
	public void setqAnswers(List<String> qAnswers) {
		this.qAnswers = qAnswers;
	}
	public Integer getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(Integer rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	
	
	
	
	
	
	
}
