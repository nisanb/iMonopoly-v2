package Entity;

public class PlayerStats extends Player {

	private Integer counter_Games;
	private Integer counter_Wins;
	private Integer counter_Questions;
	private Integer counter_Strikes;
	private Integer leadboardPosition;

	public PlayerStats(String nickname) {
		super(nickname);
		this.leadboardPosition = 0;
		this.counter_Games = 0;
		this.counter_Questions = 0;
		this.counter_Strikes = 0;
		this.counter_Wins = 0;
	}

	public void addGame() {
		counter_Games++;
	}

	public void addWin() {
		counter_Wins++;
	}

	public void addQuestions(Integer questionsNum) {
		counter_Questions += questionsNum;
	}

	public void setLeadBoardPosition(Integer pos) {
		this.leadboardPosition = pos;
	}

	public Integer getLeaderBoardPosition() {
		return this.leadboardPosition;
	}

	public void addStrikes(Integer strikes) {
		counter_Strikes += strikes;
	}

	public Integer getCounter_Games() {
		return counter_Games;
	}

	public Integer getCounter_Wins() {
		return counter_Wins;
	}

	public Integer getCounter_Questions() {
		return counter_Questions;
	}

	public Integer getCounter_Wrong() {
		return counter_Strikes;
	}

	public String getQuestionRatio() {
		if (counter_Questions == 0)
			return "N/A";
		return (counter_Strikes.doubleValue() / counter_Questions * 100) + "%";
	}

	public Integer getCounter_Strikes() {
		return counter_Strikes;
	}

	public Double getWinRate() {
		if (getCounter_Games() == 0)
			return 0.0;
		return getCounter_Wins().doubleValue() / getCounter_Games().doubleValue();
	}

	public int compareTo(PlayerStats o) {
		return o.getWinRate().compareTo(this.getWinRate());
	}
}
