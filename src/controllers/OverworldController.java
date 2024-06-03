
package controllers;

import arachne.Divine;
import arachne.Human;
import arachne.Inventory;
import arachne.Key;
import arachne.Map;
import arachne.Player;
import arachne.Settings;
import arachne.Spider;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class OverworldController implements Initializable {

    Object[][] map; 
    
    @FXML GridPane grid;
    @FXML ImageView overworldBackground;
    
    
    Image img = new Image("/images/charIcons/down.png", 250, 250, false, false); 
    ImageView im = new ImageView(img); 

    String[] fn = {"/images/charIcons/up.png", "/images/charIcons/left.png", "/images/charIcons/down.png", "/images/charIcons/right.png"};
    private int index = 2; 
    
    Image spid = new Image("/images/spiderIcon.png", 250, 250, false, false);
    ImageView sp = new ImageView(spid); 
    
    Image hum = new Image("/images/placeholder.jpg", 250, 250, false, false);
    ImageView h = new ImageView(hum); 
    
    Image portal = new Image("/images/divinePlaceholder.png", 250, 250, false, false);
    ImageView p = new ImageView(portal); 
    
    
    @FXML ProgressBar progBar;
    
    @FXML
    private void openInv(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Inventory.fxml"));
        Parent root = loader.load();

        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
    }
    
    @FXML 
    private void movement(KeyEvent event) throws IOException {
        System.out.println("SILK: " + Inventory.silk);
        grid.getChildren().remove(im);
        
        KeyCode upKey = KeyCode.valueOf(Key.up);
        KeyCode downKey = KeyCode.valueOf(Key.down);
        KeyCode leftKey = KeyCode.valueOf(Key.left);
        KeyCode rightKey = KeyCode.valueOf(Key.right);
              
        if (event.getCode() == upKey) {
            if (Player.coordY!=0) Player.coordY--; 
                index = 0; 
        }
        else if (event.getCode() == leftKey) {
            

            if (Player.coordX != 0) {
                if ((Player.coordX) % 4 == 0) {
                    setup((Player.coordX) / 4);
                }
                Player.coordX--;
            }
            index = 1;
        }
        
        else if (event.getCode() == downKey){
            if (Player.coordY != 2) {
                Player.coordY++;
            }
            index = 2;
        }
        
        else if (event.getCode() == rightKey){
            if ((Player.coordX + 1) % 4 == 0 && (Player.coordX + 1) / 4 != Player.level) {
                //setup(2);
                setup((Player.coordX + 1) / 4 + 1);
            }
            if ((Player.coordX + 1) / 4 != Player.level) {
                Player.coordX++;
            }

            index = 3;
        }
        
        else if (event.getCode() == ESCAPE){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MainMenu.fxml"));
            Parent root = loader.load();

            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();
        }
        
        else {
            
        }
        
        Object s = map[Player.coordX][Player.coordY];
        
        if(s instanceof Spider && Map.spider == true) {
            Spider a = (Spider) s; 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/SpiderBattle.fxml")); 
            Parent root = loader.load(); 
            SpiderBattleController controller = loader.getController();
            controller.setSpider(a);
            controller.setIndex(index);

            
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();

            root.setFocusTraversable(true);
            root.requestFocus();
        }
                
        if (Player.coordX==0 && Player.coordY==2 && Map.humanFirst == true) {
            firstDialogue();
            Map.humanFirstChecker();
            setup((Player.coordX) / 4 + 1);
        }
        
        if (s instanceof Divine && Map.divine == true) {
            Divine a = (Divine) s; 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/DivineBattle.fxml"));
            Parent root = loader.load();
            DivineBattleController controller = loader.getController();
            controller.setDivine(a); 

            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();
        }
        
        if (Player.coordX==Player.level*4-1 && Player.coordY==0 && Map.humanSecond == true) {
            secondDialogue();
        }
        
        if (s instanceof Divine && Map.portal == true) {
            Map.reset(); 
            Player.level++; 
            Player.coordX = 0; Player.coordY = 0; 
            
            if (Player.level == 8) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/FinalLevel.fxml"));
                Parent root = loader.load();

                Scene subjectScene = new Scene(root);
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                thisStage.hide();
                thisStage.setScene(subjectScene);
                thisStage.show();

                root.setFocusTraversable(true);
                root.requestFocus();
            }
            
            else {
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
        }
         
        //setting the images
        img = new Image(fn[index], 250, 250, false, false); 
        im = new ImageView(img);
        grid.add(im, Player.coordX%4, Player.coordY);
    }    
    
    private void firstDialogue() {        
        Alert ac = new Alert(AlertType.INFORMATION);
        ac.setTitle("Quest");
        ac.setContentText("Please kill " + Player.level + " spiders"); 
        ac.showAndWait();
    }
    
    private void secondDialogue() {        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Would You Like To Save Your Console Output?");
        alert.setContentText("Please choose an option.");

        ButtonType yesButton = new ButtonType("ACCEPT");
        ButtonType noButton = new ButtonType("REFUSE");

        alert.getButtonTypes().setAll(yesButton, noButton);
        
        alert.showAndWait();
        Player.coordX--; 
    }
    
    private void setup(int x) {
        grid.getChildren().clear();
        
        if (x==1 && Map.humanFirst == true) {
            grid.add(sp, 0, 2);
        }
        
        for (int i=0; i<3; i++) {
            for (int j=(x-1)*4; j<x*4; j++) {
                
                if (map[j][i] instanceof Spider && Map.spider == true) {
                    grid.add(sp, j%4, i); 
                }
            }
        }
        
        Map.spiderChecker();
        
        if(x==Player.level && Map.divine == true) {
            grid.add(sp, 3, 1); 
        }
        
        if (x==Player.level && Map.portal == true) {
            grid.add(p, 3, 1); 
            grid.add(h, 3, 0); 
        }
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        map = Map.game.get(Player.level-1); 
        
        progBar.setProgress((Player.level-1)/9.0);
        
        setup(Player.coordX/4 + 1);
        
        grid.add(im, Player.coordX%4, Player.coordY);  
        String file = "/images/overworldBg/" + "level" + Player.level + ".png";
        Image ov = new Image(file, 1000, 750, false, false); 
        overworldBackground.setImage(ov);
        
    }   
    
    
}