package webbrowser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/*
 * @author Alyythy
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txt;
    @FXML
    private Button btn;
    @FXML
    private Button backBtn;
    @FXML
    private AnchorPane anc;
    @FXML
    private WebView webView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        WebEngine web = webView.getEngine();
        web.setJavaScriptEnabled(true);
        EventHandler<ActionEvent> enter = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                web.load(txt.getText().startsWith("www") ? "https://" + txt.getText() : "https://duckduckgo.com/" + txt.getText());

            }
        };
        txt.setOnAction(enter);
        btn.setOnAction(enter);

        web.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                txt.setText(newValue);
            }
        });
        
  

    }

    @FXML
    private void handle(ActionEvent event) {

        //txt.setText("Webview");
    }

}
