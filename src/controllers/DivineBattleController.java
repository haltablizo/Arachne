
package controllers;

import arachne.Divine;
import arachne.Equipment;
import arachne.Player;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class DivineBattleController implements Initializable {

    Equipment e = new Equipment("E"); 
    Divine tyche =  new Divine("Tyche", e);

    List<Integer> images ; 
    
    @FXML ImageView firstCard, secondCard, thirdCard, fourthCard, fifthCard;
    String[] cardImgs = {"cardOne.png", "cardTwo.png", "cardThree.png", "cardFour.png", "cardFive.png", 
    "cardSix.png", "cardSeven.png", "cardEight.png", "cardNine.png", "cardTen.png"}; 
    
    @FXML ImageView firstOppCard, secondOppCard, thirdOppCard, fourthOppCard, fifthOppCard;
    
    @FXML Button hitButton, standButton; 
    
    @FXML
    private void hit(ActionEvent event) {
        int[] returnVal = Player.hit(tyche);
        int cardValue = returnVal[0]; 
        int turn = returnVal[1];
        
        switch (turn-1) {
            case 0: 
                firstCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                firstOppCard.setImage(new Image("/images/placeholder.jpg", 100, 125, false, false));
                break; 
            case 1: 
                secondCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                secondOppCard.setImage(new Image("/images/placeholder.jpg", 100, 125, false, false));
                break; 
            case 2: 
                thirdCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                thirdOppCard.setImage(new Image("/images/placeholder.jpg", 100, 125, false, false));
                break; 
            case 3: 
                fourthCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                fourthOppCard.setImage(new Image("/images/placeholder.jpg", 100, 125, false, false));
                break; 
            case 4: 
                fifthCard.setImage(new Image("/images/divineCards/" + cardImgs[cardValue-1], 100, 125, false, false));
                fifthOppCard.setImage(new Image("/images/placeholder.jpg", 100, 125, false, false));
                break; 
            
        }
    }

    @FXML
    private void stand(ActionEvent event) {
        
        int status = Player.endDivineGame(tyche); 
        switch (status) {
            case 0: 
                System.out.println("you lose"); 
                break;
            case 1: 
                System.out.println("you win"); 
                break; 
            case 2: 
                System.out.println("draw"); 
                break; 
        }
        
        //show cards 
        
        //disable buttons
        hitButton.setDisable(true); 
        standButton.setDisable(true); 
    }
    
    @FXML
    private void exit(ActionEvent event) throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Overworld.fxml"));
        Parent root = loader.load();
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        root.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tyche.createDeck(); 
    }    
    
}
