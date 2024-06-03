
package controllers;

import arachne.Player;
import arachne.Spider;
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
import javafx.stage.Stage;


public class GameOverScreenController implements Initializable {

    private int index;
    private Spider sp; 
    
    public void setSpider(Spider s) {
        this.sp = s;
    }
    
    public void setIndex(int x) {
        this.index = x; 
    }
    
    @FXML
    private void overworld(ActionEvent event) throws IOException {
        switch (index) {
            case 0:
                Player.coordY++;
                break;
            case 1:
                Player.coordX++;
                break;
            case 2:
                Player.coordY--;
                break;
            case 3:
                Player.coordX--;
                break;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Overworld.fxml"));
        Parent root = loader.load();

        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();

        root.setFocusTraversable(true);
        root.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
