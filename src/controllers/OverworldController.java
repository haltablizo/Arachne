
package controllers;

import arachne.Player;
import arachne.Settings;
import arachne.Spider;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
    
    Spider a = new Spider("a", 0,0,0, 1, 1); //level 1
    
    Spider b = new Spider("b", 0,0,0, 1, 2); //level 2
    Spider c = new Spider("c", 0,0,0, 2, 2); //level 3 
    
    private Object[][] levelOneMap = {
        {0,0,4},
        {0,1,0},
        {0,0,0},
        {0,0,0}
    }; 
      
    private Object[][] levelTwoMap = { //level*4 - 1 
        {0,0,4},
        {0,0,0},
        {0,0,0},
        {0,3,0},
        {0,0,4},
        {0,0,0},
        {0,0,0},
        {0,3,0}
    };     
    
    @FXML
    private void openInv(Event event) throws IOException {

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
                if(Player.coordX!=0) Player.coordX--;
                index = 1; 

                break;     
            case S:    
                if(Player.coordY!=2)Player.coordY++;
                index = 2; 
                break;
            case D:
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
        
        System.out.println("" + Player.coordX + Player.coordY);
        
        //System.out.println(levelTwoMap[Player.coordX][Player.coordY]);
        
        //setting the images
        img = new Image(fn[index], 250, 250, false, false); 
        im = new ImageView(img);
        grid.add(im, Player.coordX%4, Player.coordY);
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grid.add(im, Player.coordX, Player.coordY);     
    }   
    
}