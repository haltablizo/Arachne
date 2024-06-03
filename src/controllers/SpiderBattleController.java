
package controllers;

import arachne.Arachne;
import arachne.Map;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class SpiderBattleController implements Initializable {
    @FXML Button runButton, atkButton; 
    @FXML ImageView opponentIcon; 
    private Spider spid; 
    private int index;
    @FXML ProgressBar spiderHp, arachneHp;
    
    private int arachneCurrentHp; 
    
    public void setSpider(Spider s) {
        this.spid = s;
        opponentIcon.setImage(new Image(spid.getFn(), 250, 250, false, false)); 
    }
    
    public void setIndex(int x) {
        this.index = x; 
    }
    
    @FXML void attack(ActionEvent event) throws InterruptedException, IOException {
        boolean[] x = Player.attack(spid); 
        arachneHp.setProgress((float) Player.getHp()/Player.getMaxHp());
        spiderHp.setProgress((float) spid.getHp()/spid.getMaxHp());
        
        if (x[0] && !x[1]) {
            Map.incSpid();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/WinScreen.fxml")); 
            Parent root = loader.load(); 
            WinScreenController controller = loader.getController();
            controller.setSilk(spid.getAmtOfSilk()); 
            
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();

            root.setFocusTraversable(true);
            root.requestFocus();
        }
        else if (x[1]) {
            spid.resetHp();
            Player.setHp(arachneCurrentHp);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/GameOverScreen.fxml")); 
            Parent root = loader.load(); 
            GameOverScreenController controller = loader.getController();
            controller.setIndex(index); 
            
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();

            root.setFocusTraversable(true);
            root.requestFocus();
        }
        else {
            //blank else 
        }
    }
    
    @FXML 
    private void runAway(ActionEvent event) throws IOException {
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
        
        System.out.println(Player.coordX + ", " + Player.coordY); 
        
        spid.resetHp(); 
        Player.setHp(arachneCurrentHp); 
        
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

        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();

        root.setFocusTraversable(true);
        root.requestFocus();
               
    }
    
    @FXML
    private void stat(ActionEvent event) {
        Alert statsAlert = new Alert(Alert.AlertType.INFORMATION);
        statsAlert.setHeaderText("Battle Stats");

        String playerStatText = "Arachne" + "\n\t"
                + "Current HP/Max HP: " + Player.getHp() + "/" + Player.getMaxHp() + "\n\t"
                + "Attack: " + Player.getAtk() + "\n\t"
                + "Defense: " + Player.getDef() + "\n\n"
                + "Spider name: " + spid.getName() + "\n\t"
                + "Current HP/Max HP: " + spid.getHp() + "/" + spid.getMaxHp() + "\n\t"
                + "Attack: " + spid.getAtk() + "\n\t"
                + "Silk dropped: " + spid.getAmtOfSilk();               ; 

        statsAlert.setContentText(playerStatText);
        statsAlert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       arachneHp.setProgress((float) Player.getHp()/Player.getMaxHp());
       arachneCurrentHp = Player.getHp(); 
    }    
    
}