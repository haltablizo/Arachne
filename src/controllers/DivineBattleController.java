
package controllers;

import arachne.Divine;
import arachne.Equipment;
import arachne.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class DivineBattleController implements Initializable {

    Equipment e = new Equipment("E"); 
    Divine tyche =  new Divine("Tyche", e);
    
    @FXML
    private void hit(ActionEvent event) {
        tyche.createDeck();
        Player.hit(tyche);
    }

    @FXML
    private void stand(ActionEvent event) {
        Player.endDivineGame(tyche); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
