package Entity;

public class Answer {
	private String text;
	private boolean isTrue;

	public Answer(String text, boolean isTrue) {
		super();
		this.text = text;
		this.isTrue = isTrue;
	}

	public String getText() {
		return text;
	}

	protected void setText(String text) {
		this.text = text;
	}

	protected boolean isTrue() {
		return isTrue;
	}

	protected void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [text=" + text + ", isTrue=" + isTrue + "]";
	}

}