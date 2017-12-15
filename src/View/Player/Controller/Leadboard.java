package View.Player.Controller;

import java.util.ArrayList;
import java.util.List;

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
    	List<Player> players = new ArrayList<Player>();
    	for (int i = 0; i < 5; i++) {
    		players.add(new Player("P"+(i+1), i*100000.0));
    		players.get(i).setCorrectAnswers(10*i);
    		players.get(i).setTotalAnswers(20*i);
    		players.get(i).setWins(10*i);
    		players.get(i).setGames(15*i);
    		System.out.println(players.get(i));
		}
    	
    	ObservableList<Player> data = FXCollections.observableArrayList(players);
    	
        name = new TableColumn("First Name");
        name.setCellValueFactory(new PropertyValueFactory<Player,String>("firstName"));

        games = new TableColumn("Last Name");
        games.setCellValueFactory(new PropertyValueFactory<Player,String>("nickName"));

        wins = new TableColumn("games"); 
        wins.setCellValueFactory(new PropertyValueFactory<Player,String>("wins"));
                                     
        tableView.setItems(data);
    	    	
    }
    
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Menu);
    }
}
	
