
package controllers;

import arachne.Divine;
import arachne.Equipment;
import arachne.Player;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class DivineBattleController implements Initializable {

    Equipment e = new Equipment("E"); 
    Divine tyche =  new Divine("Tyche", e);

    List<Integer> images ; 
    
    @FXML ImageView firstCard, secondCard, thirdCard, fourthCard, fifthCard;
    String[] cardImgs = {"cardOne.png", "cardTwo.png", "cardThree.png", "cardFour.png", "cardFive.png", 
    "cardSix.png", "cardSeven.png", "cardEight.png", "cardNine.png", "cardTen.png"}; 
    
    @FXML
    private void hit(ActionEvent event) {
        int[] returnVal = Player.hit(tyche);
        int cardValue = returnVal[0]; 
        int turn = returnVal[1];
        
        switch (turn-1) {
            case 0: 
                firstCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                break; 
            case 1: 
                secondCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                break; 
            case 2: 
                thirdCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                break; 
            case 3: 
                fourthCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                break; 
            case 4: 
                fifthCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                break; 
            
        }
    }

    @FXML
    private void stand(ActionEvent event) {
        Player.endDivineGame(tyche); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tyche.createDeck(); 
    }    
    
}
