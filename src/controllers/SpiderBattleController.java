
package controllers;

import arachne.Player;
import arachne.Spider;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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


public class SpiderBattleController implements Initializable {


    @FXML Button runButton, atkButton; 
    @FXML ImageView opponentIcon; 
    private Spider spid; 
    
    
    public void setSpider(Spider s) {
        this.spid = s; 
        opponentIcon.setImage(new Image(spid.getNeutralIcon(), 450, 450, false, false));
        
    }
    
    @FXML void attack(ActionEvent event) throws InterruptedException, IOException {
        if (Player.attack(spid)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/WinScreen.fxml")); 
            Parent root = loader.load(); 

            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();

            root.setFocusTraversable(true);
            root.requestFocus();
        }
        opponentIcon.setImage(new Image(spid.getAttackedIcon(), 450, 450, false, false));
    }
    
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
    
    @FXML
    private void openInv(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Inventory.fxml")); 
        Parent root = loader.load(); 
        InventoryController controller = loader.getController();
        controller.setOpenedFrom("SpiderBattle");        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
               
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
