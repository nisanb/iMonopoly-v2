/**
 * Sample Skeleton for 'Statistics.fxml' Controller Class
 */

package View.Admin.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.iWindow;
import Utils.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Statistics {
    @FXML
    private Label Players;

    @FXML
    private Label Questions;

    @FXML
    private Label easy;

    @FXML
    private Label Hard;

    @FXML
    private Label Games_Played;

    @FXML
    private Label medium;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="piechart"
    private PieChart piechart; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Menu);
    }



    @FXML
    void doSwapMusic(MouseEvent event) {

    }
    
    @FXML
    public void btn(ActionEvent event)
    {
    	ObservableList <Data> list=FXCollections.observableArrayList(
    			new PieChart.Data("worng", 22),
    			new PieChart.Data("easy", 10),
    			new PieChart.Data("hard", 5),
    			new PieChart.Data("meduim", 5)
    			);
    	piechart.setData(list);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Statistics.fxml'.";
        assert piechart != null : "fx:id=\"piechart\" was not injected: check your FXML file 'Statistics.fxml'.";
        ObservableList <Data> list=FXCollections.observableArrayList(
    			new PieChart.Data("worng", 22),
    			new PieChart.Data("easy", 10),
    			new PieChart.Data("hard", 5),
    			new PieChart.Data("meduim", 5)
    			);
    	piechart.setData(list);
    	piechart.setLegendVisible(false);
    	piechart.setPrefHeight(5.5);
    }
}
