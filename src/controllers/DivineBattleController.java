
package controllers;

import arachne.Divine;
import arachne.Equipment;
import arachne.Map;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class DivineBattleController implements Initializable {

    Equipment e = new Equipment("E", "/images/equipmentIcons/iel.png"); 
    Divine tyche =  new Divine("Tyche", e);

    List<Integer> images ; 
    
    @FXML ImageView firstCard, secondCard, thirdCard, fourthCard, fifthCard;
    String[] cardImgs = {"cardOne.png", "cardTwo.png", "cardThree.png", "cardFour.png", "cardFive.png", 
    "cardSix.png", "cardSeven.png", "cardEight.png", "cardNine.png", "cardTen.png"}; 
    
    @FXML ImageView firstOppCard, secondOppCard, thirdOppCard, fourthOppCard, fifthOppCard;
    ImageView[] oppCards = {firstOppCard, secondOppCard, thirdOppCard, fourthOppCard, fifthOppCard};
    
    @FXML Button hitButton, standButton; 
    
    private boolean win = false; 
    
    @FXML
    private void hit(ActionEvent event) {
        standButton.setDisable(false);
        int[] returnVal = Player.hit(tyche);
        int cardValue = returnVal[0]; 
        int turn = returnVal[1];
        int bust = returnVal[2]; 
        
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
        
        if (bust!=3) {
            stand(); 
            end(); 
        }
    }

    @FXML
    private void stand(ActionEvent event) { 
        stand();   
        end(); 
    }
    
    public void stand() {
        int status = Player.endDivineGame(tyche); 
        switch (status) {
            case 0: 
                win = false; 
                dialogue("BUST!");
                break;
            case 1: 
                win = true; 
                dialogue("WIN!"); 
                break; 
            case 2: 
                win = false; 
                dialogue("DRAW!");
                break; 
        }
    }
    
    private void end() {
                //show cards 
        if (Player.hand.size()>=1) firstOppCard.setImage(new Image("/images/divineCards/" + cardImgs[tyche.hand.get(0)-1], 100, 125, false, false));
        if (Player.hand.size()>=2) secondOppCard.setImage(new Image("/images/divineCards/" + cardImgs[tyche.hand.get(1)-1], 100, 125, false, false));
        if (Player.hand.size()>=3) thirdOppCard.setImage(new Image("/images/divineCards/" + cardImgs[tyche.hand.get(2)-1], 100, 125, false, false));
        if (Player.hand.size()>=4) fourthOppCard.setImage(new Image("/images/divineCards/" + cardImgs[tyche.hand.get(3)-1], 100, 125, false, false));
        if (Player.hand.size()>=5) fifthOppCard.setImage(new Image("/images/divineCards/" + cardImgs[tyche.hand.get(4)-1], 100, 125, false, false));
        
        Player.hand.clear();
        tyche.hand.clear(); 
        tyche.deck.clear(); 
        
        //disable buttons
        hitButton.setDisable(true); 
        standButton.setDisable(true);    
    }
    
    private void dialogue(String s) {
        Alert ac = new Alert(Alert.AlertType.INFORMATION);
        ac.setTitle(s);
        ac.showAndWait();
    }
    
    @FXML
    private void exit(ActionEvent event) throws IOException  {
                
        if (win) {
            Map.divineChecker(); 
        }
        
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
        standButton.setDisable(true);
    }    
    
}
