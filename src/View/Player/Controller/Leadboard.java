package View.Player.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Controller.iWindow;
import Entity.Player;
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
    private TableColumn<Player,String> number;

    @FXML
    private TableColumn<Player,String> name;

    @FXML
    private TableColumn<Player,String> games;

    @FXML
    private TableColumn<Player,String> wins;

    @FXML
    private TableColumn<Player,String> winRatio;

    @FXML
    private TableColumn<Player,String> quesRatio;
    
    @FXML
    private TableView<Player> tableView;
	
    
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
    	
    	List<Player> players = _mng.getLeadBoard();
    	//add players to list
    	ObservableList<Player> data = FXCollections.observableArrayList(players);
    	
    	
    	//add data to colomns
    	number.		setCellValueFactory		(new PropertyValueFactory<Player, String>("leadBoardPosition"));
        name.		setCellValueFactory		(new PropertyValueFactory<Player, String>("nickName"));
        games.		setCellValueFactory		(new PropertyValueFactory<Player, String>("games"));
        wins.		setCellValueFactory		(new PropertyValueFactory<Player, String>("wins"));
        winRatio.	setCellValueFactory		(new PropertyValueFactory<Player, String>("winRatio"));
        quesRatio.	setCellValueFactory		(new PropertyValueFactory<Player, String>("questionRatio"));
        
        //winRatio = new TableColumn();        
        tableView.setItems(data);
    	    	
    }
    
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Menu);
    }
}
	
