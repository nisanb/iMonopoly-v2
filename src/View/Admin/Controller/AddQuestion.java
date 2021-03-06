/**
 * Sample Skeleton for 'AddQuestion.fxml' Controller Class
 */

package View.Admin.Controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import Controller.iWindow;
import Entity.Answer;
import Entity.JSON;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class AddQuestion {

	// ======================================== FX COMPONENTS
	// ================================================

	// For radio button//
	ToggleGroup group1 = new ToggleGroup();
	ToggleGroup group2 = new ToggleGroup();
	ToggleGroup group3 = new ToggleGroup();
	ToggleGroup group4 = new ToggleGroup();

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
	private ComboBox<QuestionStrength> DiffComboox; // Value injected by
													// FXMLLoader

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

	@FXML
	private Label lblError;
	
	@FXML 
	private Button ext;

	// local variables
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private boolean a1, a2, a3, a4;
	private String question;
	private long qNum;
	private QuestionStrength qStrength;
	private ArrayList<QuestionTag> tags;
	private Team team;
	private IManagement mng = iWindow.getManagement();
	private List<Question> getAllQuestion= new ArrayList();

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		getQuestionStrength();
		getTeam();
		getTag();
		SetButtonToFalse();
		
		//get all question//
		List<Question> a= mng.getQuestions();
		// get qnum
		qNum = JSON.getInstance().getNextQuestionNum();
		txtQuestion1.setText(qNum + "");

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

		errorLabelControl(null, false);
		lblError.setStyle("-fx-color: red;");
	}

	// ============================================= ACTION EVENTS
	// ==============================================

	@FXML
	void CheckDiffAndSetAns(MouseEvent event) {

	}

	@FXML
	void ChooseDiff(ActionEvent event) {
		// if (DiffComboox.getSelectionModel().getSelectedIndex() == 0){
		// qStrength = null;
		// return;
		// }
		qStrength = DiffComboox.getSelectionModel().getSelectedItem();
	}

	/**
	 * Move the tags selected back
	 * 
	 * @param event
	 */
	@FXML
	void FromList2ToList1(MouseEvent event) {
		if (List2.getSelectionModel().isEmpty()) {
			return;
		}
		List1.getItems().add(List2.getSelectionModel().getSelectedItem());
		List2.getItems().remove(List2.getSelectionModel().getSelectedIndex());

	}

	@FXML
	void back(ActionEvent event) {
		iWindow.swap(Window.Admin_Questions);
	}

	@FXML
	void doSwapMusic(MouseEvent event) {

	}

	/**
	 * Move the tags between lists
	 * 
	 * @param event
	 */
	@FXML
	void moveTag(MouseEvent event) {
		if (List1.getSelectionModel().isEmpty()) {
			return;
		}
		List2.getItems().add(List1.getSelectionModel().getSelectedItem());
		List1.getItems().remove(List1.getSelectionModel().getSelectedIndex());
		tags = new ArrayList<QuestionTag>();
		for (QuestionTag t : List2.getItems()) {
			tags.add(t);
		}
	}

	/**
	 * Get the question avalible diff
	 */
	private void getQuestionStrength() {
		ObservableList<QuestionStrength> list2 = FXCollections.observableArrayList(QuestionStrength.values());
		DiffComboox.setItems(list2);
	}

	/**
	 * Import the avaiable teams to combobox
	 */
	private void getTeam() {
		ObservableList<Team> list3 = FXCollections.observableArrayList(Team.values());
		// sort list
		Collections.sort(list3, new Comparator<Team>() {
			@Override
			public int compare(Team t1, Team t2) {
				return t1.toString().compareTo(t2.toString());
			}
		});
		TeamComboBox.setItems(list3);
	}

	/**
	 * Get the chosen tags for the quesiton
	 */
	private void getTag() {
		ObservableList<QuestionTag> list4 = FXCollections.observableArrayList(QuestionTag.values());
		List1.setItems(list4);

	}

	/**
	 * Reset all groups to be set to falses
	 */
	private void SetButtonToFalse() {
		FalseBu.setSelected(true);
		FalseBu2.setSelected(true);
		FalseBu3.setSelected(true);
		FalseBu4.setSelected(true);
	}

	/**
	 * Set the team for the new Question
	 * 
	 * @param e
	 */
	@FXML
	private void setTeam(ActionEvent e) {
		// if (TeamComboBox.getSelectionModel().getSelectedIndex() == 0){
		// team = null;
		// return;
		// }

		team = TeamComboBox.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	public void addFromFile(ActionEvent e) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("json", "*.json"));
		fc.setTitle("Import JSON File");
		File file = fc.showOpenDialog(null);
		
		
		if(file == null) {
			errorLabelControl("Something went wrong with file import", true);
			return;
		}
		
		else {
			errorLabelControl("", false);
			Map<QuestionStrength, List<Question>> temp = JSON.getInstance().loadQuestions(file.getAbsolutePath());

			//add the questions to the question map
			if (temp == null) errorLabelControl("Something went wrong with file", true);
			for (Map.Entry<QuestionStrength, List<Question>> ls : temp.entrySet()) {
				for (Question q : ls.getValue()) {
					mng.addQuestion(q);					
				}
			}
			
			errorLabelControl("Qustion file was added", true);
		}
		
		qNum = JSON.getInstance().getNextQuestionNum();
		txtQuestion1.setText(""+qNum);
	}
	

	

	// ========================================= FORM CONTROLS
	// =================================================
	/**
	 * This method verifies user input validity and creates new question to be
	 * added
	 * 
	 * @param event
	 */
	@FXML
	void addQuestion(ActionEvent event) {
		if (!event.getSource().equals(save))
			return;
		// reset errors
		setAnsBGC("white");
		setQquestionBGC("white");
		setTagsBGC("white");
		setDiffBGC("white");
		setTeamBGC("white");

		// get field values
		a1 = TrueBu.isSelected();
		a2 = TrueBu2.isSelected();
		a3 = TrueBu3.isSelected();
		a4 = TrueBu4.isSelected();
		ans1 = txtanswer1.getText();
		ans2 = txtanswer2.getText();
		ans3 = txtanswer3.getText();
		ans4 = txtanswer4.getText();
		question = txtQuestion.getText();
		ArrayList<Answer> ans = new ArrayList<Answer>();

		txtanswer1.setStyle("-fx-background-color: white;"); // change backgroud
																// in runtime

		int numOfAnswers = 0, numOftrues = 0;
		if (ans1 != null && ans1.length() > 1) {
			numOfAnswers++;
			ans.add(new Answer(ans1, a1));
			if (TrueBu.isSelected())
				numOftrues++;
		}
		if (ans2 != null && ans2.length() > 1) {
			numOfAnswers++;
			ans.add(new Answer(ans2, a2));
			if (TrueBu2.isSelected())
				numOftrues++;
		}
		if (ans3 != null && ans3.length() > 1) {
			numOfAnswers++;
			ans.add(new Answer(ans3, a3));
			if (TrueBu3.isSelected())
				numOftrues++;
		}
		if (ans4 != null && ans4.length() > 1) {
			numOfAnswers++;
			ans.add(new Answer(ans4, a4));
			if (TrueBu4.isSelected())
				numOftrues++;
		}

		boolean isMultiple = false;
		if (numOftrues > 1)
			isMultiple = true;

		if (numOfAnswers < 2 || numOftrues < 1) {
			errorLabelControl("Qustion must contain at least 2 posible answers and 1 true", true);
			setAnsBGC("red");
			return;
		} else if (question == null || question.length() < 5) {
			errorLabelControl("Qustion must have more than 5 letters", true);
			setQquestionBGC("red");
			return;
		} else if (tags == null || tags.size() < 1) {
			errorLabelControl("You must add at least one tag", true);
			setTagsBGC("red");
			return;
		} else if (team == null) {
			errorLabelControl("You must select team", true);
			setTeamBGC("red");
			return;
		} else if (qStrength == null) {
			errorLabelControl("You must select quetion difficulty", true);
			setDiffBGC("red");
			return;
		}
		errorLabelControl(null, false);

		Question q = new Question(qNum, qStrength, question, isMultiple, ans, team, tags);
		if (mng.addQuestion(q)) {
			iWindow.swap(Window.Admin_AddQuesion);
			JSON.getInstance().addQuestionNum();
		}
	}

	/**
	 * This method controls the error label
	 * 
	 * @param msg
	 *            - message to present
	 * @param visiblity
	 *            - show or not show the label
	 */
	private void errorLabelControl(String msg, boolean visiblity) {
		this.lblError.setVisible(visiblity);
		if (msg == null) {
			this.lblError.setText(" ");
		} else {
			this.lblError.setText("Note: " + msg);
			System.out.println(msg);
		}
	}

	// ========================================== CSS
	// ===========================================================

	/**
	 * CSS change
	 */
	private void setAnsBGC(String color) {
		txtanswer1.setStyle("-fx-background-color:" + color + ";");
		txtanswer2.setStyle("-fx-background-color:" + color + ";");
		txtanswer3.setStyle("-fx-background-color:" + color + ";");
		txtanswer4.setStyle("-fx-background-color:" + color + ";");
	}

	private void setQquestionBGC(String color) {
		txtQuestion.setStyle("-fx-background-color:" + color + ";");
	}

	private void setTagsBGC(String color) {
		List2.setStyle("-fx-background-color:" + color + ";");
	}

	private void setTeamBGC(String color) {
		TeamComboBox.setStyle("-fx-background-color:" + color + ";");
	}

	private void setDiffBGC(String color) {
		DiffComboox.setStyle("-fx-background-color:" + color + ";");
	}

}
