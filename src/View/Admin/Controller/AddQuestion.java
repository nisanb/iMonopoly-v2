/**
 * Sample Skeleton for 'AddQuestion.fxml' Controller Class
 */

package View.Admin.Controller;

import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Controller.iWindow;
import Entity.Answer;
import Entity.Question;
import Utils.QuestionStrength;
import Utils.QuestionTag;
import Utils.Team;
import Utils.Window;
import View.IManagement;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class AddQuestion {
	
	// For radio button//
	ToggleGroup group1 =new ToggleGroup();
	ToggleGroup group2 =new ToggleGroup();
	ToggleGroup group3 =new ToggleGroup();
	ToggleGroup group4 =new ToggleGroup();
	

	
	private IManagement mng = iWindow.getManagement();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private Button save; // Value injected by FXMLLoader

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

    @FXML // fx:id="List2"
    private ListView<QuestionTag> List2; // Value injected by FXMLLoader

    @FXML // fx:id="RightImg"
    private ImageView RightImg; // Value injected by FXMLLoader

    @FXML // fx:id="LeftImg"
    private ImageView LeftImg; // Value injected by FXMLLoader

    @FXML // fx:id="List1"
    private ListView<QuestionTag> List1; // Value injected by FXMLLoader

    @FXML // fx:id="DiffComboox"
    private ComboBox<QuestionStrength> DiffComboox; // Value injected by FXMLLoader

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

    @FXML // fx:id="txtQuestion1"
    private TextField txtQuestion1; // Value injected by FXMLLoader

    @FXML
    private ComboBox<Team> TeamComboBox;
    
    @FXML Label lblError;
    
    
    //local variables
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    boolean a1, a2, a3, a4;
    String question;
    long qNum=10;
    QuestionStrength qStrength;
    ArrayList<QuestionTag> tags;
    Team team;
    
    
    
    
  /*  @FXML
    void CangeTrueBu(MouseEvent event) {
    	TrueBu.setSelected(true);
    	FalseBu.setSelected(false);
    }

    @FXML
    void ChangeFalseBu(MouseEvent event) {
    	TrueBu.setSelected(false);
    	FalseBu.setSelected(true);
    }*/

   /* @FXML
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
    void ChangeFalseBu4(MouseEvent event) {
    	TrueBu4.setSelected(false);
    	FalseBu4.setSelected(true);
    }

    @FXML
    void ChangeTrueBu2(MouseEvent event) {
    	TrueBu2.setSelected(true);
    	FalseBu2.setSelected(false);
    }

    @FXML
    void ChangeTrueBu3(MouseEvent event) {
    	TrueBu3.setSelected(true);
    	FalseBu3.setSelected(false);
    }

    @FXML
    void ChangeTrueBu4(MouseEvent event) {
    	TrueBu4.setSelected(true);
    	FalseBu4.setSelected(false);
    }*/

    @FXML
    void CheckDiffAndSetAns(MouseEvent event) {

    }

    @FXML
    void ChooseDiff(ActionEvent event) {
    	if (DiffComboox.getSelectionModel().getSelectedIndex() == 0){
    		qStrength = null;
    		return;
    	}
    	qStrength = DiffComboox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void FromList2ToList1(MouseEvent event) {
    	if(List2.getSelectionModel().isEmpty())
    	{
    		return ;
    	}
    	List1.getItems().add(List2.getSelectionModel().getSelectedItem());
    	List2.getItems().remove(List2.getSelectionModel().getSelectedIndex());
    	tags = new ArrayList<QuestionTag>();
    	for (QuestionTag t:List2.getSelectionModel().getSelectedItems()){
    		tags.add(t);
    	}
    	
    }

    @FXML
    void back(ActionEvent event) {
    	iWindow.swap(Window.Admin_Questions);
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
    


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert TrueBu != null : "fx:id=\"TrueBu\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert FalseBu != null : "fx:id=\"FalseBu\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert TrueBu3 != null : "fx:id=\"TrueBu3\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert FalseBu3 != null : "fx:id=\"FalseBu3\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert FalseBu4 != null : "fx:id=\"FalseBu4\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert TrueBu4 != null : "fx:id=\"TrueBu4\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert txtanswer4 != null : "fx:id=\"txtanswer4\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert txtanswer3 != null : "fx:id=\"txtanswer3\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert txtanswer2 != null : "fx:id=\"txtanswer2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert txtanswer1 != null : "fx:id=\"txtanswer1\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert txtQuestion != null : "fx:id=\"txtQuestion\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert List2 != null : "fx:id=\"List2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert RightImg != null : "fx:id=\"RightImg\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert LeftImg != null : "fx:id=\"LeftImg\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert List1 != null : "fx:id=\"List1\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert DiffComboox != null : "fx:id=\"DiffComboox\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert managequestion != null : "fx:id=\"managequestion\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert diff != null : "fx:id=\"diff\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert TagCombo != null : "fx:id=\"TagCombo\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert Answer1 != null : "fx:id=\"Answer1\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert answer2 != null : "fx:id=\"answer2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert answer3 != null : "fx:id=\"answer3\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert answer4 != null : "fx:id=\"answer4\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert TrueBu2 != null : "fx:id=\"TrueBu2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert FalseBu2 != null : "fx:id=\"FalseBu2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert txtQuestion1 != null : "fx:id=\"txtQuestion1\" was not injected: check your FXML file 'AddQuestion.fxml'.";
       
        getQuestionStrength();
        getTeam();
        getTag();
        SetButtonToFalse();
    
        
        
        
        // ans1//
        group1.getToggles().add(TrueBu);
        group1.getToggles().add(FalseBu);
     // ans2//
        group2.getToggles().add(TrueBu2);
        group2.getToggles().add(FalseBu2);
     // ans3//
        group3.getToggles().add(TrueBu3);
        group3.getToggles().add(FalseBu3);
     // ans4//
        group4.getToggles().add(TrueBu4);
        group4.getToggles().add(FalseBu4);
        
        
    }
    
    
    
    //====================================================methods============================//
    
    private void getQuestionStrength()
    {
    	 ObservableList<QuestionStrength> list2=FXCollections.observableArrayList(QuestionStrength.values());
    	 DiffComboox.setItems(list2);
    }
    
    private void getTeam()
    {
   	 ObservableList<Team> list3=FXCollections.observableArrayList(Team.values());
   	 TeamComboBox.setItems(list3);
    }
    
    private void getTag()
    {
      	 ObservableList<QuestionTag> list4=FXCollections.observableArrayList(QuestionTag.values());
      	 List1.setItems(list4);
      
    }
    
    private void SetButtonToFalse()
    {
    	FalseBu.setSelected(true);
    	FalseBu2.setSelected(true);
    	FalseBu3.setSelected(true);
    	FalseBu4.setSelected(true);
    }
    
    @FXML
    private void setTeam(ActionEvent e){
    	if (TeamComboBox.getSelectionModel().getSelectedIndex() == 0){
    		team = null;
    		return;
    	}
    	
    	team = TeamComboBox.getSelectionModel().getSelectedItem();
    }
    
    
    
    
    @FXML
    void AddQuestion(ActionEvent event) {
    	System.out.println("1");
    	if (!event.getSource().equals(save)) return;
    	int numOfAnswers = 0,numOftrues=0;
    	if (ans1 != null) {
    		numOfAnswers++;
    		if (TrueBu.isSelected()) numOftrues++;
    	}
    	if (ans2 != null){
    		numOfAnswers++;
    		if (TrueBu2.isSelected()) numOftrues++;
    		
    	}
    	if (ans3 != null){
    		numOfAnswers++;
    		if (TrueBu3.isSelected()) numOftrues++;
    	}
    	if (ans4 != null){
    		numOfAnswers++;
    		if (TrueBu4.isSelected()) numOftrues++;
    	}
    	
    	
    	
    	
    	if (numOfAnswers < 2 && numOftrues < 1 ){
    		errorLabelControl("Qustion must contain at least 2 posible answers and 1 true", true);
    		return;
    	}
    	else if (question == null || question.length() < 5){
    		errorLabelControl("Qustion must have more than 5 letters", true);
    		return;
    	}
    	else if (tags.size() < 1){
    		errorLabelControl("You must add at least one tag", true);
    		return;
    	}
    	else if (team == null){
    		errorLabelControl("You must select team", true);
    		return;
    	}
    	else if (qStrength == null){
    		errorLabelControl("You must select quetion difficulty", true);
    	}
    	
    	errorLabelControl(null, false);
    	
    	qNum = mng.getNextQuestionNum();
    	ArrayList<Answer> ans = new ArrayList<Answer>();
    	//add answers to list if not null
    	
    	Question q = new Question(qNum, qStrength, ans1, a1, ans, ans1, tags);
    	System.out.println(q.toString());
    	mng.addQuestion(q);
    }



    
    
    /**
     * This method controls the error label
     * @param msg - message to present
     * @param visiblity - show or not show the label
     */
    private void errorLabelControl(String msg, boolean visiblity) {
    	this.lblError.setVisible(visiblity);
    	if (msg == null) {
    		this.lblError.setText(" ");
    	}
    	else {
    		this.lblError.setText("Error: " + msg);
    	}
    }
    
    
    
}
