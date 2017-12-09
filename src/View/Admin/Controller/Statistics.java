/**
 * Sample Skeleton for 'Statistics.fxml' Controller Class
 */

package View.Admin.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.QuestionStrength;
import Utils.Window;
import View.IManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Statistics {
	
	//========================================== FX COMPONENTS ===============================================
	
	@FXML
    private Label lblPlayers;

    @FXML
    private Label lblQuestions;

    @FXML
    private Label lblEasy;

    @FXML
    private Label lblHard;

    @FXML
    private Label lblGamesPlayed;

    @FXML
    private Label lblMedium;
    
    @FXML
    private TextField players;

    @FXML
    private TextField questions;

    @FXML
    private TextField easy;

    @FXML
    private TextField medium;

    @FXML
    private TextField hard;

    @FXML
    private TextField gamesPlayed;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="piechart"
    private PieChart piechart; // Value injected by FXMLLoader

	private IManagement _mng = iWindow.getManagement();
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	ObservableList <Data> list=FXCollections.observableArrayList(
    			new PieChart.Data("Easy", _mng.getQuestionMap().get(QuestionStrength.EASY).size()),
    			new PieChart.Data("Hard", _mng.getQuestionMap().get(QuestionStrength.HARD).size()),
    			new PieChart.Data("Meduim", _mng.getQuestionMap().get(QuestionStrength.MEDIUM).size()));
    			
    	piechart.setData(list);
    	piechart.setLegendVisible(true);
    	piechart.setPrefHeight(15);
    	players.setText(_mng.getListOfPlayers().size()+ "");
    	questions.setText(_mng.getQuestions().size() + "");;
    	gamesPlayed.setText(_mng.getGameData().size() + " ");
    	easy.setText(_mng.getQuestionMap().get(QuestionStrength.EASY).size() + "");
    	medium.setText(_mng.getQuestionMap().get(QuestionStrength.MEDIUM).size() + "");
    	hard.setText(_mng.getQuestionMap().get(QuestionStrength.HARD).size() + "");
    	
    	setTexfFieldColor();
    	
    }
    
    //============================================ ACTION EVETNS ===============================================
    
    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Menu);
    }



    @FXML
    void doSwapMusic(MouseEvent event) {

    }
    
    
    
    //============================================== CSS ===================================================

    private void setTexfFieldColor() {
    	players.setStyle("-fx-font-weight: bold; -fx-background-color: white; -fx-font-alignment: center; -fx-text-fill: black; -fx-font-size: 14;");
    }

}
