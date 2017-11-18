package Entity;

public class Answer{
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
	public void setText(String text) {
		this.text = text;
	}
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}


	@Override
	public String toString() {
		return "Answer [text=" + text + ", isTrue=" + isTrue + "]";
	}
	
	
	
	
}