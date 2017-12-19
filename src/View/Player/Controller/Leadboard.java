package View.Player.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Controller.iWindow;
import Entity.Player;
import Entity.PlayerStats;
import Utils.Window;
import View.IManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


public class Leadboard {
	//======================================= FX COMPONENTS ==================================================
    
	@FXML
    private ImageView btnVolume;

    @FXML
    private TableColumn<PlayerStats,String> number;

    @FXML
    private TableColumn<PlayerStats,String> name;

    @FXML
    private TableColumn<PlayerStats,String> games;

    @FXML
    private TableColumn<PlayerStats,String> wins;

    @FXML
    private TableColumn<PlayerStats,String> winRatio;

    @FXML
    private TableColumn<PlayerStats,String> quesRatio;
    
    @FXML
    private TableView<PlayerStats> tableView;
	
    
    //LOCAL VARIABLES
	IManagement _mng = iWindow.getManagement();
	
	
	
	//=========================================== METHODS ===================================================
    @FXML
    void initialize() {
    	
//    	//create players for testing
//    	List<Player> players = new ArrayList<Player>();
//    	Random rand = new Random();
//    	for (int i = 0; i < 5; i++) {
//    		players.add(new Player("P"+(i+1), i*100000.0));
//    		players.get(i).setCorrectAnswers(10*i+rand.nextInt(50));
//    		players.get(i).setTotalAnswers(20*i+rand.nextInt(50));
//    		players.get(i).setWins(10*i+rand.nextInt(50));
//    		players.get(i).setGames(15*i+rand.nextInt(50));
//    		players.get(i).calcWinRation();
//    		players.get(i).clacQuestionRatio();
//    		players.get(i).setLeeadboardPosition(i+1);
//		}
    	
    	List<PlayerStats> players = _mng.getLeadBoard();
    	//add players to list
    	ObservableList<PlayerStats> data = FXCollections.observableArrayList(players);
    	
    	
    	//add data to colomns
    	number.		setCellValueFactory		(new PropertyValueFactory<PlayerStats, String>("counter_Games"));
        name.		setCellValueFactory		(new PropertyValueFactory<PlayerStats, String>("nickName"));
        games.		setCellValueFactory		(new PropertyValueFactory<PlayerStats, String>("counter_Games"));
        wins.		setCellValueFactory		(new PropertyValueFactory<PlayerStats, String>("counter_Wins"));
        winRatio.	setCellValueFactory		(new PropertyValueFactory<PlayerStats, String>("WinRate"));
        quesRatio.	setCellValueFactory		(new PropertyValueFactory<PlayerStats, String>("counter_Questions"));
        
        //winRatio = new TableColumn();        
        tableView.setItems(data);
    	    	
    }
    
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Player_Menu);
    }
}
	
