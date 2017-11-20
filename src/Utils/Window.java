package Utils;

public enum Window {
<<<<<<< HEAD
	Login("login"), MainBoard("Board"), Login2("login2"),
	Player_Menu("Player_Menu"),
	Player_Statistics("Player_Statistics"),
	SASGOASJG("Player_Statistics"),
	Num_Of_Players("NumOfPlayers"),
	WelcomeAdmin("WelcomeAdmin"),
	EnterAdmin("EnterAdmin"),
	AdminStatistics("AdminStatistics"),
	SystemParameters("SystemParameters");
=======
	Login("login"), MainBoard("Board"), Login2("login2"), MainBoardTal("TalUI");
>>>>>>> Added new board UI and images
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
