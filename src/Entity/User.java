package Entity;

import java.io.Serializable;

import Utils.PlayerAuth;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class User implements Serializable {

	private static final long serialVersionUID = 2L;

	private String nickName;
	private PlayerAuth playerAuth;
	private int correctAnswers;
	private int totalAnswers;
	private int totalStrikes;

	public int getTotalStrikes() {
		return totalStrikes;
	}

	public void setTotalStrikes(int totalStrikes) {
		this.totalStrikes = totalStrikes;
	}

	public User(String nickname) {
		this.nickName = nickname;
	}

	public User(String nickName, PlayerAuth playerAuth) {
		this.nickName = nickName;
		this.playerAuth = playerAuth;
		this.correctAnswers = 0;
		this.totalAnswers = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		User other = (User) obj;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public PlayerAuth getPlayerAuth() {
		return playerAuth;
	}

	public void setPlayerAuth(PlayerAuth playerAuth) {
		this.playerAuth = playerAuth;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getTotalAnswers() {
		return totalAnswers;
	}

	public void setTotalAnswers(int totalAnswers) {
		this.totalAnswers = totalAnswers;
	}

	public String getNickName() {
		return this.nickName;
	}

	public ObservableValue<String> getLeadboardNickName() {
		StringProperty toReturn = new SimpleStringProperty(nickName);
		return toReturn;
	}

	public void addSingleStrike() {
		this.totalStrikes++;

	}

	@Override
	public String toString() {
		return nickName;
	}

}
