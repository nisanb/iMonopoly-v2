package Utils;

public enum Window {
	/**
	 * General
	 */
	Login("login"),
	
	/**
	 * Player Menus
	 */
	Player_Menu("Player/Menu"),
	Player_Statistics("Player/Statistics"),
	Player_GameSettings("Player/GameSettings"),
	Rules_Window("Player/Rules"),
	Player_LeadBoard("Player/Leadboard"),
	
	
	/**
	 * Admin Menus
	 */
	Admin_Menu("Admin/Menu"),
	Admin_Login("Admin/Login"),
	Admin_Statistics("Admin/Statistics"),
	Admin_SysParams("Admin/SysParam"),
	Admin_Questions("Admin/Questions"),
	Admin_AddQuesion("Admin/AddQuestion"),
	Admin_editQuestion("Admin/editQuestion"),
	
	/**
	 * Game
	 */
	Game_UI("Game/UI");
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
