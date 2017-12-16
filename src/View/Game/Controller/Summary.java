package View.Game.Controller;

import java.util.List;
import Controller.iWindow;
import Entity.Player;
import Utils.Window;
import View.IGameEngine;
import View.IManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


public class Summary {
	//======================================= FX COMPONENTS ==================================================
    
	@FXML
    private ImageView btnVolume;

    @FXML
    private TableColumn<Player,String> number;

    @FXML
    private TableColumn<Player,String> name;

    @FXML
    private TableColumn<Player,String> net;

    @FXML
    private TableColumn<Player,String> cash;
    
    @FXML
    private TableView<Player> tableView;
	
    
    //LOCAL VARIABLES
	IGameEngine _eng = iWindow.getGameEngine();
	
	
	//=========================================== METHODS ===================================================
    @FXML
    void initialize() {
    	//get game data
    	List<Player> players = _eng.getCurrntGame().getSummary();
    	ObservableList<Player> data = FXCollections.observableArrayList(players);
    	
    	
    	//add data to colomns
    	number.		setCellValueFactory		(new PropertyValueFactory<Player, String>("leadBoardPosition"));
        name.		setCellValueFactory		(new PropertyValueFactory<Player, String>("nickName"));
        net.		setCellValueFactory		(new PropertyValueFactory<Player, String>("games"));
        cash.		setCellValueFactory		(new PropertyValueFactory<Player, String>("_cash"));
        
        
        //winRatio = new TableColumn();        
        tableView.setItems(data);
    	    	
    }
    
    
    @FXML
    void back(ActionEvent event) {
    	_eng.destroy();
    	iWindow.swap(Window.Player_Menu);
    }
}
	
