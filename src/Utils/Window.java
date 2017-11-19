package Utils;

public enum Window {
	Login("login"), MainBoard("Board"), Login2("login2"),
	Player_Menu("Player_Menu");
	String fxmlFile;
	
	Window(String fxmlFile){
		this.fxmlFile = fxmlFile;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.fxmlFile;
	}
	
}
