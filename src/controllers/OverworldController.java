
package controllers;

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
    private int coordX = 0;     
    private int coordY = 0;
    private int index; 
    
    @FXML
    private void openInv(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Inventory.fxml"));
        Parent root = loader.load(); 
        InventoryController controller = loader.getController();
        controller.setOpenedFrom("Overworld");
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        root.setFocusTraversable(true);
        root.requestFocus();
    }
    
    @FXML 
    private void movement(KeyEvent event) throws IOException {
        grid.getChildren().remove(im);
              
        switch(event.getCode()) {
            case W:
                if (coordY!=0) coordY--; 
                index = 0; 
                break;
            case A:
                if(coordX!=0) coordX--;
                index = 1; 

                break;     
            case S:    
                if(coordY!=2)coordY++;
                index = 2; 
                break;
            case D:
                if(coordX!=3) coordX++; 
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
           
        img = new Image(fn[index], 250, 250, false, false); 
        im = new ImageView(img);
        grid.add(im, coordX, coordY);
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grid.add(im, coordX, coordY);     
    }   
    
}
