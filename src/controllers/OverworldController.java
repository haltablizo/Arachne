
package controllers;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class OverworldController implements Initializable {

    @FXML GridPane grid;
    
    Image img = new Image("/images/charIcons/down.png", 250, 250, false, false); 
    ImageView im = new ImageView(img); 

    String[] fn = {"/images/charIcons/up.png", "/images/charIcons/left.png", "/images/charIcons/down.png", "/images/charIcons/right.png"};
    private int index; 
    
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
        grid.getChildren().remove(im);
              
        switch(event.getCode()) {
            case W:
                if (Player.coordY!=0) Player.coordY--; 
                index = 0; 
                break;
            case A:
                if ((Player.coordX)%4==0) {
                    System.out.println("df");
                    setup(1);
                    //setup((Player.coordX+1)/4 + 1);
                }
                
                if(Player.coordX!=0) Player.coordX--;
                index = 1; 

                break;     
            case S:    
                if(Player.coordY!=2)Player.coordY++;
                index = 2; 
                break;
            case D:
                if ((Player.coordX+1)%4==0) {
                    System.out.println("df");
                    setup(2);
                    //setup((Player.coordX+1)/4 + 1);
                }
                
                if ((Player.coordX+1)/4!=Player.level) Player.coordX++;
                
                index = 3; 
                break;
            case ESCAPE: 
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MainMenu.fxml"));
                Parent root = loader.load();

                Scene subjectScene = new Scene(root);
                Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                thisStage.hide();
                thisStage.setScene(subjectScene);
                thisStage.show();
                break; 
            default: 
                break;
        }
        
        Object s = Map.game.get(Player.level-1)[Player.coordX][Player.coordY];
        
        if(s instanceof Spider) {
            System.out.println("sf");
        }
        
        //setting the images
        img = new Image(fn[index], 250, 250, false, false); 
        im = new ImageView(img);
        grid.add(im, Player.coordX%4, Player.coordY);
    }    
    
    private void setup(int x) {
        grid.getChildren().clear();
        
        Image spid = new Image("/images/spiderIcon.png", 250, 250, false, false);
        ImageView sp = new ImageView(spid); 
                
        Object[][] a = Map.game.get(Player.level-1);
        for (int i=0; i<3; i++) {
            for (int j=(x-1)*4; j<x*4; j++) {
                
                if (a[j][i] instanceof Spider) {
                    grid.add(sp, j%4, i); 
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setup(1);
        grid.add(im, Player.coordX, Player.coordY);     
    }   
    
    
}