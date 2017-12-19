package Entity;

public class PlayerStats extends Player {

	private Integer counter_Games;
	private Integer counter_Wins;
	private Integer counter_Questions;
	private Integer counter_Wrong;
	private Integer counter_Strikes;

	public PlayerStats(String nickname) {
		super(nickname);
		this.counter_Games = 0;
		this.counter_Questions = 0;
		this.counter_Strikes = 0;
		this.counter_Wins = 0;
		this.counter_Wrong = 0;
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

	public void addStrikes(Integer strikes) {
		counter_Strikes+=strikes;
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

	public Integer getCounter_Strikes() {
		return counter_Strikes;
	}

	public Double getWinRate() {
		if(getCounter_Games()==0)
			return 0.0;
		return getCounter_Wins().doubleValue() / getCounter_Games().doubleValue();
	}

}
