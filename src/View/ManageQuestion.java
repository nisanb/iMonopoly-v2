/**
 * Sample Skeleton for 'Questions.fxml' Controller Class
 */

package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ManageQuestion {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnVolume"
    private ImageView btnVolume; // Value injected by FXMLLoader

    @FXML // fx:id="managequestion"
    private Label managequestion; // Value injected by FXMLLoader

    @FXML // fx:id="Answer1"
    private Label Answer1; // Value injected by FXMLLoader

    @FXML // fx:id="answer2"
    private Label answer2; // Value injected by FXMLLoader

    @FXML // fx:id="answer3"
    private Label answer3; // Value injected by FXMLLoader

    @FXML // fx:id="answer4"
    private Label answer4; // Value injected by FXMLLoader

    @FXML // fx:id="diff"
    private Label diff; // Value injected by FXMLLoader

    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader

    @FXML // fx:id="button2"
    private Button button2; // Value injected by FXMLLoader

    @FXML // fx:id="button3"
    private Button button3; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer1"
    private TextField txtanswer1; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer2"
    private TextField txtanswer2; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer3"
    private TextField txtanswer3; // Value injected by FXMLLoader

    @FXML // fx:id="txtanswer4"
    private TextField txtanswer4; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private Button save; // Value injected by FXMLLoader

    @FXML // fx:id="edit"
    private Button edit; // Value injected by FXMLLoader

    @FXML // fx:id="back"
    private Button back; // Value injected by FXMLLoader

    @FXML
    void doSwapMusic(MouseEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVolume != null : "fx:id=\"btnVolume\" was not injected: check your FXML file 'Questions.fxml'.";
        assert managequestion != null : "fx:id=\"managequestion\" was not injected: check your FXML file 'Questions.fxml'.";
        assert Answer1 != null : "fx:id=\"Answer1\" was not injected: check your FXML file 'Questions.fxml'.";
        assert answer2 != null : "fx:id=\"answer2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert answer3 != null : "fx:id=\"answer3\" was not injected: check your FXML file 'Questions.fxml'.";
        assert answer4 != null : "fx:id=\"answer4\" was not injected: check your FXML file 'Questions.fxml'.";
        assert diff != null : "fx:id=\"diff\" was not injected: check your FXML file 'Questions.fxml'.";
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'Questions.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer1 != null : "fx:id=\"txtanswer1\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer2 != null : "fx:id=\"txtanswer2\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer3 != null : "fx:id=\"txtanswer3\" was not injected: check your FXML file 'Questions.fxml'.";
        assert txtanswer4 != null : "fx:id=\"txtanswer4\" was not injected: check your FXML file 'Questions.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'Questions.fxml'.";
        assert edit != null : "fx:id=\"edit\" was not injected: check your FXML file 'Questions.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Questions.fxml'.";

    }
}
