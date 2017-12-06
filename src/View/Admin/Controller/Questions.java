/**
 * Sample Skeleton for 'Questions.fxml' Controller Class
 */

package View.Admin.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.sun.javafx.css.Combinator;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Questions {

	//========================================== FX COMPONENTS ================================================
	
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
	
	@FXML
	private ComboBox<Team> comboTeams;

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

	@FXML // fx:id="Edit"
	private Button Edit; // Value injected by FXMLLoader

	@FXML // fx:id="TrueBu2"
	private RadioButton TrueBu2; // Value injected by FXMLLoader

	@FXML // fx:id="FalseBu2"
	private RadioButton FalseBu2; // Value injected by FXMLLoader

	@FXML
	private ComboBox<Integer> NumQuestionCombo;
	
	@FXML
	private Label lblError;

	ToggleGroup group1 =new ToggleGroup();
	ToggleGroup group2 =new ToggleGroup();
	ToggleGroup group3 =new ToggleGroup();
	ToggleGroup group4 =new ToggleGroup();
	
	
	//========================================== CALASS VARIABLES ===========================================
	private long _qnum = -1;
	private QuestionStrength _curerntChosenSterngth;
	private int _indexToRemoveFromCombo;
	private boolean inEditMode = false;
	private String _ans1;
	private String _ans2;
	private String _ans3;
	private String _ans4;
	private String _ques;
	private boolean _a1, _a2, _a3, _a4;
	private ArrayList<QuestionTag> _tags;
	private Team _team;
	
    private IManagement _mng = iWindow.getManagement();
    private Question _question;

    
	@FXML // fx:id="AnchoarPane"
	private AnchorPane AnchoarPane; // Value injected by FXMLLoader

	
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		ObservableList<QuestionStrength> list2=FXCollections.observableArrayList(QuestionStrength.values());
		DiffComboox.setItems(list2);
				
        ObservableList<Team> list4 = FXCollections.observableArrayList(Team.values());
        comboTeams.setItems(list4);
        comboTeams.setDisable(true);
		
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
	
	//========================================== ACTION EVENTS ===============================================
	
	@FXML
	void CheckDiffAndSetAns(MouseEvent event) {

	}

	@FXML
	void OpenAddQuestion(ActionEvent event) {
		iWindow.swap(Window.Admin_AddQuesion);
	}

	@FXML
	void ChooseDiff(ActionEvent event) // do more Efficient//
	{
		_curerntChosenSterngth = DiffComboox.getSelectionModel().getSelectedItem();
//		System.out.println(_curerntChosenSterngth);

		GetAndSend(_curerntChosenSterngth);
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
    	_tags = new ArrayList<QuestionTag>();
    	for (QuestionTag t:List2.getItems()){
    		_tags.add(t);
    	}
    }
	

    @FXML
    void NumByDiff(ActionEvent event) {
    	if (NumQuestionCombo.getSelectionModel().getSelectedItem() == null) return;
    	//System.out.println((long)NumQuestionCombo.getSelectionModel().getSelectedItem());
    	_qnum = (long)NumQuestionCombo.getSelectionModel().getSelectedItem();
    	_indexToRemoveFromCombo = NumQuestionCombo.getSelectionModel().getSelectedIndex();

    	List<Question> list = _mng.getQuestionsByDifficulty(_curerntChosenSterngth);
    	for (Question q:list){
    		if (NumQuestionCombo.getSelectionModel().getSelectedItem()!=null){
    			Integer Selected = NumQuestionCombo.getSelectionModel().getSelectedItem();
    			if(q.getqNumber() == Selected){
    				_question = q;
    				txtQuestion.setText(q.getqQuestion());
    				//Get the question tags
    				List1.getItems().clear();
    				List2.getItems().clear();
    				List2.getItems().addAll(q.getTags());
    				List1.getItems().addAll(QuestionTag.values());
    				List1.getItems().removeAll(q.getTags());
    				_tags = new ArrayList<QuestionTag>(q.getTags());
    				_team = q.getTeam();
    				comboTeams.setValue(q.getTeam());
    				SetAnswer(Selected);
    			}

    		}
    	}
    }




	//===============================================  METHODS ============================================

	@FXML
	void DeleteQuestion(ActionEvent event) {
		setDiffBGC("white");
		setQnumBGC("white");
		
		if (_curerntChosenSterngth == null) {
			setDiffBGC("red");
			return;
		}
		else if (_qnum < 0) {
			setQnumBGC("red");
			return;
		}
		
		
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Remove Question Confirmation");
    	alert.setHeaderText("You are about to remove a question. \n"
    			+ "This action can not be undone!");
    	alert.setContentText("Do you want to remove this question?");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	
    	if (result.get() == ButtonType.OK){
    		Question q = null;
    		int index = _mng.getQuestions().indexOf(new Question(_qnum));
    		System.err.println("index = " + index);

    		if (index > -1) q = _mng.getQuestions().get(index);
    		if (_mng.removeQuestion(q)) {
    			NumQuestionCombo.getItems().remove(_indexToRemoveFromCombo);
    			setDiffBGC("white");
    			setQnumBGC("white");
    			_qnum = -1;
    		}
    	} else 
    		
    	{
    	    return;
    	}
		
	}

	/**
	 * Gets the full question object from user 
	 * @param diff
	 */
	private void GetAndSend(QuestionStrength diff)
	{
		NumQuestionCombo.getItems().clear();
		comboTeams.setDisable(true);
		txtQuestion.clear();
		txtanswer1.clear();
		txtanswer2.clear();
		txtanswer3.clear();
		txtanswer4.clear();
		FalseBu.setSelected(true);
		FalseBu2.setSelected(true);
		FalseBu3.setSelected(true);
		FalseBu4.setSelected(true);
		TrueBu.setSelected(false);
		TrueBu2.setSelected(false);
		TrueBu3.setSelected(false);
		TrueBu4.setSelected(false);

		answer3.setVisible(true);
		txtanswer3.setVisible(true);
		TrueBu3.setVisible(true);
		FalseBu3.setVisible(true);

		answer4.setVisible(true);
		txtanswer4.setVisible(true);
		TrueBu4.setVisible(true);
		FalseBu4.setVisible(true);

		List1.getItems().clear();
		_qnum = -1;
		
		List <Question> list = _mng.getQuestionsByDifficulty(diff);
		for (Question q:list){
			NumQuestionCombo.getItems().add((int) q.getqNumber());
		}

	}


	private void SetAnswer (Integer num)
	{
		Question q = null;
		List<Question> list = _mng.getQuestionsByDifficulty(_curerntChosenSterngth);
		int index = list.indexOf(new Question(num));
		if (index > -1) q  = list.get(index);

		List<Answer> name= q.getqAnswers();
		CheckIsTrue(name);

		for(int i=name.size()-1;i<name.size();i++)
		{	
			if(name.size()==2){
				txtanswer1.setText(name.get(i-i).getText());	
				txtanswer2.setText(name.get(i-i+1).getText());
			}
			else{
				txtanswer1.setText(name.get(i-i).getText());
				txtanswer2.setText(name.get(i-i+1).getText());
				txtanswer3.setText(name.get(i-i+2).getText());
				txtanswer4.setText(name.get(i).getText());}
		}
	}

	/**
	 * set the radio buttons to be the same as question's
	 * @param a
	 */
	private void CheckIsTrue(List<Answer> a)
	{
		List<Answer> name=a;
		for(int i=name.size()-1;i<name.size();i++)
		{
			if(name.size()==2)
			{
				answer3.setVisible(false);
				txtanswer3.setVisible(false);
				TrueBu3.setVisible(false);
				FalseBu3.setVisible(false);

				answer4.setVisible(false);
				txtanswer4.setVisible(false);
				TrueBu4.setVisible(false);
				FalseBu4.setVisible(false);

				if(name.get(i-i).getIsTrue(name.get(i-i)))
				{
					TrueBu.setSelected(true);
					FalseBu.setSelected(false);
				}
				else
				{
					FalseBu.setSelected(true);
					TrueBu.setSelected(false);
				}

				if(name.get(i-i+1).getIsTrue(name.get(i-i+1)))
				{
					TrueBu2.setSelected(true);
					FalseBu2.setSelected(false);
				}
				else
				{
					FalseBu2.setSelected(true);
					TrueBu2.setSelected(false);
				}
			}
			else
			{
				if(name.get(i-i).getIsTrue(name.get(i-i)))
				{
					TrueBu.setSelected(true);
					FalseBu.setSelected(false);
				}
				else
				{
					FalseBu.setSelected(true);
					TrueBu.setSelected(false);
				}

				if(name.get(i-i+1).getIsTrue(name.get(i-i+1)))
				{
					TrueBu2.setSelected(true);
					FalseBu2.setSelected(false);
				}
				else
				{
					FalseBu2.setSelected(true);
					TrueBu2.setSelected(false);
				}

				if(name.get(i-i+2).getIsTrue(name.get(i-i+2)))
				{
					TrueBu3.setSelected(true);
					FalseBu3.setSelected(false);
				}
				else
				{
					FalseBu3.setSelected(true);
					TrueBu3.setSelected(false);
				}
				if(name.get(i-i+3).getIsTrue(name.get(i-i+3)))
				{
					TrueBu4.setSelected(true);
					FalseBu4.setSelected(false);
				}
				else
				{
					FalseBu4.setSelected(true);
					TrueBu4.setSelected(false);
				}

			}
		}
	}
	
	/**
	 * Get the team from user input
	 * @param e
	 */
	@FXML
	void setTeam(ActionEvent e) {
		if (e.getSource().equals(comboTeams)) {
			_team = comboTeams.getSelectionModel().getSelectedItem();
			//System.out.println(_team);
		}
	}
	
    //========================================= EDIT FORM CONTROL ==============================================
	/**
	 * Set the chosen question to be editable
	 * @param event
	 */
	@FXML
	void openEditQuestion(ActionEvent event) {
		setDiffBGC("white");
		setQnumBGC("white");
		
		if (_curerntChosenSterngth == null) {
			setDiffBGC("red");
			return;
		}
		else if (_qnum < 0) {
			setQnumBGC("red");
			return;
		}
		
		inEditMode = true;
		
		//set fields to editable
		txtanswer1.setEditable(true);
		txtanswer2.setEditable(true);
		txtanswer3.setEditable(true);
		txtanswer4.setEditable(true);
		comboTeams.setDisable(false);
		DiffComboox.setEditable(false);
		NumQuestionCombo.setEditable(false);
		DiffComboox.setDisable(true);
		NumQuestionCombo.setDisable(true);
		TrueBu.setDisable(false);
		TrueBu2.setDisable(false);
		TrueBu3.setDisable(false);
		TrueBu4.setDisable(false);
		FalseBu.setDisable(false);
		FalseBu2.setDisable(false);
		FalseBu3.setDisable(false);
		FalseBu4.setDisable(false);
		List1.setDisable(false);
		List2.setDisable(false);
		List1.setEditable(true);
		List2.setEditable(true);
		
		
		//iWindow.swap(Window.Admin_editQuestion);
	}
	
	
	@FXML
	void selectTeam(ActionEvent e) {
		if (!inEditMode) return;
		if (e.getSource().equals(comboTeams)) {
			_team = comboTeams.getSelectionModel().getSelectedItem();
		}
	}
	
	/**
	 * Thin method verifies all user inputs and builds the new question to replace with old one
	 * @param event
	 */
    @FXML
    void saveClicked (ActionEvent event) {
    	if (!event.getSource().equals(save)) return;
    	if (!inEditMode) return;
    	//reset errors
    	setAnsBGC("white");
    	setQquestionBGC("white");
    	setTagsBGC("white");
    	setDiffBGC("white");
    	setTeamBGC("white");
    	
    	//get field values
    	_a1 = TrueBu.isSelected();
    	_a2 = TrueBu2.isSelected();
    	_a3 = TrueBu3.isSelected();
    	_a4 = TrueBu4.isSelected();
    	_ans1 = txtanswer1.getText();
    	_ans2 = txtanswer2.getText();
    	_ans3 = txtanswer3.getText();
    	_ans4 = txtanswer4.getText();
    	_ques = txtQuestion.getText();
    	ArrayList<Answer> ans = new ArrayList<Answer>();
    	
    	txtanswer1.setStyle("-fx-background-color: white;"); // change backgroud in runtime
    	
    	//check anwser validity
    	int numOfAnswers = 0,numOftrues=0;
    	if (_ans1 != null && _ans1.length() > 1) {
    		numOfAnswers++;
    		ans.add(new Answer(_ans1, _a1));
    		if (TrueBu.isSelected()) numOftrues++;
    	}
    	if (_ans2 != null && _ans2.length() > 1){
    		numOfAnswers++;
    		ans.add(new Answer(_ans2, _a2));
    		if (TrueBu2.isSelected()) numOftrues++;  		
    	}
    	if (_ans3 != null && _ans3.length() > 1){
    		numOfAnswers++;
    		ans.add(new Answer(_ans3, _a3));
    		if (TrueBu3.isSelected()) numOftrues++;
    	}
    	if (_ans4 != null && _ans4.length() > 1){
    		numOfAnswers++;
    		ans.add(new Answer(_ans4, _a4));
    		if (TrueBu4.isSelected()) numOftrues++;
    	}

    	boolean isMultiple = false;
    	if (numOftrues > 1) isMultiple = true;
    	
    	//check all fields are filled properly
    	if (numOfAnswers < 2 || numOftrues < 1 ){
    		errorLabelControl("Qustion must contain at least 2 posible answers and 1 true", true);
    		setAnsBGC("red");
    		return;
    	}
    	else if (_ques == null || _ques.length() < 1){
    		errorLabelControl("Qustion must have more than 5 letters", true);
    		setQquestionBGC("red");
    		return;
    	}
    	else if (_tags == null || _tags.size() < 1){
    		errorLabelControl("You must add at least one tag", true);
    		setTagsBGC("red");
    		return;
    	}
    	else if (_team == null){
    		errorLabelControl("You must select team", true);
    		setTeamBGC("red");
    		return;
    	}
    	else if (_curerntChosenSterngth == null){
    		errorLabelControl("You must select quetion difficulty", true);
    		setDiffBGC("red");
    		return;
    	}
    	errorLabelControl(null, false);
    	
    	
    	//set the updated question ans switch the old one with the new one
    	Question q = new Question(_qnum, _curerntChosenSterngth, _ques, isMultiple , ans, _team, _tags);
    	if (_mng.updateQuestion(_question, q)){
    		//System.err.println(q);
    		iWindow.swap(Window.Admin_Questions); 
    	}
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
    		System.out.println(msg);
    	}
    }
    
    //========================================== CSS ===========================================================
    
    /**
     * CSS change
     */
    private void setAnsBGC(String color) {
    	txtanswer1.setStyle("-fx-background-color:" + color +";");
    	txtanswer2.setStyle("-fx-background-color:" + color +";");
    	txtanswer3.setStyle("-fx-background-color:" + color +";");
    	txtanswer4.setStyle("-fx-background-color:" + color +";");
    }
    
    private void setQquestionBGC(String color) {
    	txtQuestion.setStyle("-fx-background-color:" + color +";");
    }
    
    private void setTagsBGC(String color) {
    	List2.setStyle("-fx-background-color:" + color +";");
    }
    
    private void setTeamBGC(String color) {
    	//TeamComboBox.setStyle("-fx-background-color:" + color +";");
    	// TODO
    }
    
    private void setDiffBGC(String color) {
    	DiffComboox.setStyle("-fx-background-color:" + color +";");
    }
    
    private void setQnumBGC(String color) {
    	NumQuestionCombo.setStyle("-fx-background-color:" + color +";");
    }
    
}


