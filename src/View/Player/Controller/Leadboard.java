package View.Player.Controller;

import Controller.iWindow;
import Entity.Player;
import Utils.Window;
import View.IManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;


public class Leadboard {
	//======================================= FX COMPONENTS ==================================================
    
	@FXML
    private ImageView btnVolume;

    @FXML
    private TableColumn<?, ?> number;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> games;

    @FXML
    private TableColumn<?, ?> wins;

    @FXML
    private TableColumn<?, ?> winRatio;

    @FXML
    private TableColumn<?, ?> quesRatio;
    
    @FXML
    private TableView<Player> tableView;
	
    
    //LOCAL VARIABLES
	IManagement _mng = iWindow.getManagement();
	
	
	
	//=========================================== METHODS ===================================================
    @FXML
    void initialize() {
    	/*
    	ObservableList<Player> data = FXCollections.observableArrayList(_mng.getLeadBoard());
    	
    	tableView = new TableView<Player>(data);

    	TableColumn<Player,String> name = new TableColumn<Player, String>("nickName");
    	name.setCellValueFactory(new Callback<CellDataFeatures<Player, String>, ObservableValue<String>>() {
    		public ObservableValue<String> call(CellDataFeatures<Player, String> p) {
    			// p.getValue() returns the Person instance for a particular TableView row
    			return p.getValue().getLeadboardNickName();	
    			}
    	});

    	tableView.getColumns().add(name);
    	
    	System.out.println(data.toString());
    	*/
    	
    }
    
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Menu);
    }
}
	
