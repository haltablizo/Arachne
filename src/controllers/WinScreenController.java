
package controllers;

import arachne.Inventory;
import arachne.Map;
import arachne.Player;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WinScreenController implements Initializable {
    
    private int silk; 
    
    @FXML Label reward;
    
    public void setSilk(int s) {
        silk =  s; 
        reward.setText(" Reward: +" + silk + " silk"); 
    }
    
    @FXML
    private void move(ActionEvent event) throws IOException {
        Inventory.pickUpSilk(silk); 
        Map.game.get(Player.level-1)[Player.coordX][Player.coordY] = 0;
        
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
        
        
    }    
    
}
