/**
 * Sample Skeleton for 'Questions.fxml' Controller Class
 */

package View.Admin.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import Controller.iWindow;
import Entity.MonDB;
import Entity.Question;
import Utils.QuestionStrength;
import Utils.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Questions {
	
	Question question;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private Button save; // Value injected by FXMLLoader

    @FXML // fx:id="edit"
    private Button edit; // Value injected by FXMLLoader

    @FXML // fx:id="TrueBu"
    private RadioButton TrueBu; // Value injected by FXMLLoader

    @FXML // fx:id="FalseBu"
    private RadioButton FalseBu; // Value injected by FXMLLoader

    @FXML // fx:id="TrueBu3"
    private RadioButton TrueBu3; // Value injected by FXMLLoader

    @FXML // fx:id="FalseBu3"
    private RadioButton FalseBu3; // Value injected by FXMLLoader

    @FXML // fx:id="FalseBu4"
    private RadioButton FalseBu4; // Value injected by FXMLLoader

    @FXML // fx:id="TrueBu4"
    private RadioButton TrueBu4; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer4"
    private TextField txtanswer4; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer3"
    private TextField txtanswer3; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer2"
    private TextField txtanswer2; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer1"
    private TextField txtanswer1; // Value injected by FXMLLoader

    @FXML // fx:id="txtQuestion"
    private TextField txtQuestion; // Value injected by FXMLLoader

    @FXML // fx:id="txtQuestion1"
    private TextField txtQuestion1; // Value injected by FXMLLoader

    @FXML // fx:id="List2"
    private ListView<String> List2; // Value injected by FXMLLoader

    @FXML // fx:id="RightImg"
    private ImageView RightImg; // Value injected by FXMLLoader

    @FXML // fx:id="LeftImg"
    private ImageView LeftImg; // Value injected by FXMLLoader

    @FXML // fx:id="List1"
    private ListView<String> List1; // Value injected by FXMLLoader

    @FXML // fx:id="DiffComboox"
    private ComboBox<String> DiffComboox; // Value injected by FXMLLoader

    @FXML // fx:id="managequestion"
    private Label managequestion; // Value injected by FXMLLoader

    @FXML // fx:id="diff"
    private Label diff; // Value injected by FXMLLoader

    @FXML // fx:id="TagCombo"
    private Label TagCombo; // Value injected by FXMLLoader

    @FXML // fx:id="Answer1"
    private Label Answer1; // Value injected by FXMLLoader

    @FXML // fx:id="answer2"
    private Label answer2; // Value injected by FXMLLoader

    @FXML // fx:id="answer3"
    private Label answer3; // Value injected by FXMLLoader

    @FXML // fx:id="answer4"
    private Label answer4; // Value injected by FXMLLoader
    
    @FXML // fx:id="TrueBu2"
    private RadioButton TrueBu2; // Value injected by FXMLLoader

    @FXML // fx:id="FalseBu2"
    private RadioButton FalseBu2; // Value injected by FXMLLoader

    @FXML
    void CheckDiffAndSetAns(MouseEvent event) {

    }

    @FXML
    void ChooseDiff(ActionEvent event) {
    	
     	if(DiffComboox.getSelectionModel().getSelectedItem()=="Easy")
    	{
     	
    		List1.setItems(list);
    	}
    	 if((DiffComboox.getSelectionModel().getSelectedItem()=="Medium")||(DiffComboox.getSelectionModel().getSelectedItem()=="Hard"))
    	{
    		List1.getItems().clear();
    		List2.getItems().clear();
    	}
    }

    @FXML
    void FromList2ToList1(MouseEvent event) {
    	if(List2.getSelectionModel().isEmpty())
    	{
    		return ;
    	}
    	List1.getItems().add(List2.getSelectionModel().getSelectedItem());
    	List2.getItems().remove(List2.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Menu);
    }

    @FXML
    void doSwapMusic(MouseEvent event) {

    }

    @FXML
    void moveTag(MouseEvent event) {
    	if(List1.getSelectionModel().isEmpty())
    	{
    	
    		return ;
    	}
    	List2.getItems().add(List1.getSelectionModel().getSelectedItem());
    	List1.getItems().remove(List1.getSelectionModel().getSelectedIndex());
    }
   

    ObservableList<String> list=FXCollections.observableArrayList("1","2","3","4");
    ObservableList<String> list1=FXCollections.observableArrayList("Easy","Medium","Hard");

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	DiffComboox.setItems(list1);
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Questions.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'Questions.fxml'.";
        assert edit != null : "fx:id=\"edit\" was not injected: check your FXML file 'Questions.fxml'.";
        assert TrueBu != null : "fx:id=\"TrueBu\" was not injected: check your FXML file 'Questions.fxml'.";
        assert FalseBu != null : "fx:id=\"FalseBu\" was not injected: check your FXML file 'Questions.fxml'.";
        assert FalseBu2 != null : "fx:id=\"FalseBu2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert TrueBu2 != null : "fx:id=\"TrueBu2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert TrueBu3 != null : "fx:id=\"TrueBu3\" was not injected: check your FXML file 'Questions.fxml'.";
        assert FalseBu3 != null : "fx:id=\"FalseBu3\" was not injected: check your FXML file 'Questions.fxml'.";
        assert FalseBu4 != null : "fx:id=\"FalseBu4\" was not injected: check your FXML file 'Questions.fxml'.";
        assert TrueBu4 != null : "fx:id=\"TrueBu4\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer4 != null : "fx:id=\"txtanswer4\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer3 != null : "fx:id=\"txtanswer3\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer2 != null : "fx:id=\"txtanswer2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer1 != null : "fx:id=\"txtanswer1\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtQuestion != null : "fx:id=\"txtQuestion\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtQuestion1 != null : "fx:id=\"txtQuestion1\" was not injected: check your FXML file 'Questions.fxml'.";
        assert List2 != null : "fx:id=\"List2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert RightImg != null : "fx:id=\"RightImg\" was not injected: check your FXML file 'Questions.fxml'.";
        assert LeftImg != null : "fx:id=\"LeftImg\" was not injected: check your FXML file 'Questions.fxml'.";
        assert List1 != null : "fx:id=\"List1\" was not injected: check your FXML file 'Questions.fxml'.";
        assert DiffComboox != null : "fx:id=\"DiffComboox\" was not injected: check your FXML file 'Questions.fxml'.";
        assert managequestion != null : "fx:id=\"managequestion\" was not injected: check your FXML file 'Questions.fxml'.";
        assert diff != null : "fx:id=\"diff\" was not injected: check your FXML file 'Questions.fxml'.";
        assert TagCombo != null : "fx:id=\"TagCombo\" was not injected: check your FXML file 'Questions.fxml'.";
        assert Answer1 != null : "fx:id=\"Answer1\" was not injected: check your FXML file 'Questions.fxml'.";
        assert answer2 != null : "fx:id=\"answer2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert answer3 != null : "fx:id=\"answer3\" was not injected: check your FXML file 'Questions.fxml'.";
        assert answer4 != null : "fx:id=\"answer4\" was not injected: check your FXML file 'Questions.fxml'.";
        FalseBu.setSelected(true);
        FalseBu2.setSelected(true);
        FalseBu3.setSelected(true);
        FalseBu4.setSelected(true);
    
      
        
        
    }
    
    @FXML
    void CangeTrueBu(MouseEvent event) {
    	FalseBu.setSelected(false);
    	TrueBu.setSelected(true);
    }
    
    @FXML
    void ChangeFalseBu(MouseEvent event) {
    	TrueBu.setSelected(false);
    	FalseBu.setSelected(true);
    }
    
    @FXML
    void ChangeTrueBu2(MouseEvent event) {
    	FalseBu2.setSelected(false);
    	TrueBu2.setSelected(true);
    }
    
    @FXML
    void ChangeFalseBu2(MouseEvent event) {
    	TrueBu2.setSelected(false);
    	FalseBu2.setSelected(true);
    }

    @FXML
    void ChangeFalseBu3(MouseEvent event) {
    	TrueBu3.setSelected(false);
    	FalseBu3.setSelected(true);
    }

    @FXML
    void ChangeTrueBu3(MouseEvent event) {
    	FalseBu3.setSelected(false);
    	TrueBu3.setSelected(true);
    }
    @FXML
    void ChangeFalseBu4(MouseEvent event) {
    	TrueBu4.setSelected(false);
    	FalseBu4.setSelected(true);
    }
    
    @FXML
    void ChangeTrueBu4(MouseEvent event) {
    	FalseBu4.setSelected(false);
    	TrueBu4.setSelected(true);
    }


}
