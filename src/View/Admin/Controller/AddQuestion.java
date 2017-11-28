/**
 * Sample Skeleton for 'AddQuestion.fxml' Controller Class
 */

package View.Admin.Controller;

import java.net.URL;
import java.util.ResourceBundle;
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

public class AddQuestion {

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
    private ListView<?> List2; // Value injected by FXMLLoader

    @FXML // fx:id="RightImg"
    private ImageView RightImg; // Value injected by FXMLLoader

    @FXML // fx:id="LeftImg"
    private ImageView LeftImg; // Value injected by FXMLLoader

    @FXML // fx:id="List1"
    private ListView<?> List1; // Value injected by FXMLLoader

    @FXML // fx:id="DiffComboox"
    private ComboBox<?> DiffComboox; // Value injected by FXMLLoader

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

    @FXML // fx:id="txtQuestion2"
    private TextField txtQuestion2; // Value injected by FXMLLoader

    @FXML // fx:id="DiffComboox1"
    private ComboBox<?> DiffComboox1; // Value injected by FXMLLoader

    @FXML
    void CangeTrueBu(MouseEvent event) {

    }

    @FXML
    void ChangeFalseBu(MouseEvent event) {

    }

    @FXML
    void ChangeFalseBu2(MouseEvent event) {

    }

    @FXML
    void ChangeFalseBu3(MouseEvent event) {

    }

    @FXML
    void ChangeFalseBu4(MouseEvent event) {

    }

    @FXML
    void ChangeTrueBu2(MouseEvent event) {

    }

    @FXML
    void ChangeTrueBu3(MouseEvent event) {

    }

    @FXML
    void ChangeTrueBu4(MouseEvent event) {

    }

    @FXML
    void CheckDiffAndSetAns(MouseEvent event) {

    }

    @FXML
    void ChooseDiff(ActionEvent event) {

    }

    @FXML
    void FromList2ToList1(MouseEvent event) {

    }

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void doSwapMusic(MouseEvent event) {

    }

    @FXML
    void moveTag(MouseEvent event) {

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
        assert diff != null : "fx:id=\"diff\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert TagCombo != null : "fx:id=\"TagCombo\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert Answer1 != null : "fx:id=\"Answer1\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert answer2 != null : "fx:id=\"answer2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert answer3 != null : "fx:id=\"answer3\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert answer4 != null : "fx:id=\"answer4\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert TrueBu2 != null : "fx:id=\"TrueBu2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert FalseBu2 != null : "fx:id=\"FalseBu2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert txtQuestion2 != null : "fx:id=\"txtQuestion2\" was not injected: check your FXML file 'AddQuestion.fxml'.";
        assert DiffComboox1 != null : "fx:id=\"DiffComboox1\" was not injected: check your FXML file 'AddQuestion.fxml'.";

    }
}
