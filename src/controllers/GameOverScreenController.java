
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.ESCAPE;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.W;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class GameOverScreenController implements Initializable {

    @FXML
    private void quitGame(KeyEvent event) {
        System.out.println("ran");
        switch(event.getCode()) {

        case ESCAPE: 
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
            stage.close(); 
        default: 
            break;
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
