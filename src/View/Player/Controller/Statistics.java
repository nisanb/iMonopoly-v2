package View.Player.Controller;

import java.util.ResourceBundle;
import java.net.URL;

import Controller.Logger;
import Controller.Music;
import Controller.iWindow;
import Entity.Player;
import Utils.Window;
import View.IManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Statistics {
	//========================================= FX COMPONENTS ==================================================
    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField txtTotalGames;

    @FXML
    private TextField txtTotalStrikes;

    @FXML
    private TextField txtTotalWins;

    @FXML
    private TextField txtWinLossRatio;

    @FXML
    private TextField txtTotalAnswers;

    @FXML
    private TextField txtTotalQuestions;  

    @FXML
    private URL location;

    @FXML
    private ImageView btnVolume;

    @FXML
    private TextField frmNickname;

    @FXML
    private Button btnLogin;
    
    @FXML
    private PieChart piechart;

    IManagement _mng = iWindow.getManagement();
    
    
    //============================================ METHODS ===================================================
    
    
    @FXML
    void MouseEntered(MouseEvent event) {
    	Music.getInstance().play("hover.mp3");
    }

    @FXML
    void doSwapMusic(MouseEvent event) {
    	Music.getInstance().swap("theme.mp3");
    }
    
    
    @FXML
    void doLogin(ActionEvent event) {
    	Music.getInstance().play("click.wav");
    	Logger.log("Attempting to log in with user "+frmNickname.getText());
    	/**
    	 * Sagi - fix it using interface
    	 * MonDB.getInstance().setCurrentGame(new Game());
    	 * MonDB.getInstance().getCurrentGame().setCurrentLoggedUser((new User(frmNickname.getText(), PlayerAuth.PLAYER)));
    	 */
    	
    	iWindow.swap(Window.Player_Menu);
    }
    
    
    @FXML
    void initialize() {
    	//add data to pie
    	Player player = _mng.getPlayerData();
        ObservableList <Data> list=FXCollections.observableArrayList(
    			new PieChart.Data("Wins", player.getWins()),
    			new PieChart.Data("Loses", player.getGames() - player.getWins())
    			);
    	piechart.setData(list);
    	piechart.setLegendVisible(true);
    	piechart.setPrefHeight(15);
   
    	//add data to fields
    	txtTotalAnswers.setText(player.getCorrectAnswers() +"");
    	txtTotalGames.setText(player.getGames() +"");
    	txtTotalQuestions.setText(player.getTotalAnswers() +"");
    	txtTotalStrikes.setText(player.getTotalStrikes() + "");
    	txtTotalWins.setText(player.getWins() + "");
    	if (player.getGames() == 0) txtWinLossRatio.setText("0");
    	else txtWinLossRatio.setText(player.getWins()/(player.getGames()) + "");
    	
    }
    

    
    public void back(ActionEvent event)
    {
    	iWindow.swap(Window.Player_Menu);
    }
}
