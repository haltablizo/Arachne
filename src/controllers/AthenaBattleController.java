
package controllers;

import arachne.Divine;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class AthenaBattleController implements Initializable {
    
    Divine Athena =  new Divine("Athena");
    
    @FXML ImageView firstCard, secondCard, thirdCard, fourthCard, fifthCard;
    
    @FXML ImageView firstOppCard, secondOppCard, thirdOppCard, fourthOppCard, fifthOppCard;
    ImageView[] oppCards = {firstOppCard, secondOppCard, thirdOppCard, fourthOppCard, fifthOppCard};
    
    private int turn = 1;
    
    String[] cardImgs = {"cardOne.png", "cardTwo.png", "cardThree.png", "cardFour.png", "cardFive.png", 
    "cardSix.png", "cardSeven.png", "cardEight.png", "cardNine.png", "cardTen.png"}; 
    
    @FXML ImageView athena;  
    
    @FXML
    private void hit(ActionEvent event) {
        
        switch (turn-1) {
            case 0: 
                firstCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
                firstOppCard.setImage(new Image("/images/divineCards/cardBack.png", 100, 125, false, false));
                break; 
            case 1: 
                secondCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
                secondOppCard.setImage(new Image("/images/divineCards/cardBack.png", 100, 125, false, false));
                break; 
            case 2: 
                thirdCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
                thirdOppCard.setImage(new Image("/images/divineCards/cardBack.png", 100, 125, false, false));
                break; 
            case 3: 
                fourthCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
                fourthOppCard.setImage(new Image("/images/divineCards/cardBack.png", 100, 125, false, false));
                end();
                athena.setImage(new Image("/images/divine/athenaEnd.png", 100, 125, false, false));
                Alert ac = new Alert(Alert.AlertType.WARNING);
                ac.setTitle("I CAN SEE YOU");
                ac.setContentText("CHEATER");
                ac.showAndWait();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        stage.close(); 
                break;        
            }
        turn++; 
    }
    
    private void end() {
                //show cards 
        firstOppCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
        secondOppCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
        thirdOppCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
        fourthOppCard.setImage(new Image("/images/divineCards/" + cardImgs[6], 100, 125, false, false));
        
    }
    
    private void dialogue(String s) {
        Alert ac = new Alert(Alert.AlertType.INFORMATION);
        ac.setTitle(s);
        ac.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
