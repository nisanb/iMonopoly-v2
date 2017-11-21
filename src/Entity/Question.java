package Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utils.QuestionStrength;
import Utils.QuestionTag;

public class Question {

	
	private long qNumber;
	private QuestionStrength qStrength;
	private String qQuestion;
	private boolean isMultipleChoise;
	private List<Answer> qAnswers;
	private String team;
	private List<QuestionTag> tags;
	
	protected Question(long qNumber, QuestionStrength qStrength, String qQuestion, boolean isMultiple, 
			List<Answer> qAnswers, String team, List<QuestionTag> tags) {
		super();
		this.qNumber = qNumber;
		this.qStrength = qStrength;
		this.qQuestion = qQuestion;
		this.qAnswers = qAnswers;
		this.team = team;
		this.isMultipleChoise = isMultiple;
		this.tags = tags;
	}
	
	public String getTeam() {
		return team;
	}

	protected void setTeam(String team) {
		this.team = team;
	}

	public List<QuestionTag> getTags() {
		return tags;
	}

	protected void setTags(List<QuestionTag> tags) {
		this.tags = tags;
	}

	public long getqNumber() {
		return qNumber;
	}
	protected void setqNumber(long qNumber) {
		this.qNumber = qNumber;
	}
	public QuestionStrength getqStrength() {
		return qStrength;
	}
	protected void setqStrength(QuestionStrength qStrength) {
		this.qStrength = qStrength;
	}
	public String getqQuestion() {
		return qQuestion;
	}
	protected void setqQuestion(String qQuestion) {
		this.qQuestion = qQuestion;
	}
	public List<Answer> getqAnswers() {
		return qAnswers;
	}
	protected void setqAnswers(List<Answer> qAnswers) {
		this.qAnswers = qAnswers;
	}

	public boolean isMultipleChoise() {
		return isMultipleChoise;
	}

	protected void setMultipleChoise(boolean isMultipleChoise) {
		this.isMultipleChoise = isMultipleChoise;
	}
	
	protected void addAnswer(Answer a1) {
		if (this.qAnswers == null)
			this.qAnswers = new ArrayList<Answer>();
		this.qAnswers.add(a1);
	}

	@Override
	public String toString() {
		return "Question [qNumber=" + qNumber + ", qStrength=" + qStrength + ", qQuestion=" + qQuestion
				+ ", isMultipleChoise=" + isMultipleChoise + ", qAnswers=" + qAnswers + ", team=" + team + ", tags="+printTags()+"]";
	}
	
	private String printTags() {
		String tag ="";
		for (int i = 0; i < this.tags.size(); i++) {
			tag += this.tags.get(i) +" ";
		}
		return tag;
	}
	
	/**
	 * Will check that given answers from FE to a question are exactly the answers expected
	 * @param answers
	 * @return
	 */
	public boolean checkCorrect(List<Answer> answers){
		
		//If size isn't equal
		if(answers.size() != qAnswers.size())
			return false;
		
		Set<Answer> hashSet = new HashSet<>();
		hashSet.addAll(answers);
		hashSet.addAll(qAnswers);
		
		if(hashSet.size() != qAnswers.size())
			return false;
		
		return true;
	}
		
}
