
package controllers;

import arachne.Key;
import arachne.Player;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class FinalLevelController implements Initializable {

    String[] fn = {"/images/charIcons/up.png", "/images/charIcons/left.png", "/images/charIcons/down.png", "/images/charIcons/right.png"};
    @FXML GridPane grid;
    
    Image img = new Image("/images/charIcons/down.png", 250, 250, false, false); 
    ImageView im = new ImageView(img); 
    
    Image portal = new Image("/images/divinePlaceholder.png", 250, 250, false, false);
    ImageView p = new ImageView(portal);
    
    private int index = 0; 
        
    @FXML 
    private void movement(KeyEvent event) throws IOException {
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
                    
        if (Player.coordX == 2 && Player.coordY == 1) {    
            dialogue(); 
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/AthenaBattle.fxml"));
            Parent root = loader.load();

            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();
        }
         
        //setting the images
        img = new Image(fn[index], 250, 250, false, false); 
        im = new ImageView(img);
        grid.add(im, Player.coordX%4, Player.coordY);
    }
    
    private void dialogue() {
        Alert ac = new Alert(AlertType.INFORMATION);
        ac.setTitle("Jadwon");
        ac.showAndWait();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grid.add(im, Player.coordX, Player.coordY); 
        grid.add(p, 2, 1); 
    }   
    
    
}