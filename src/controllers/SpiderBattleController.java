
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class SpiderBattleController implements Initializable {


    @FXML Button runButton; 
    
    @FXML 
    private void runAway(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Overworld.fxml"));
        Parent root = loader.load(); 
        OverworldController controller = loader.getController();
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        
        root.setFocusTraversable(true);
        root.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
