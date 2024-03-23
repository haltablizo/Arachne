
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class OverworldController implements Initializable {

    @FXML GridPane grid; 
    @FXML ImageView inventoryIcon;
    Image img = new Image("/images/placeholderIcon.png", 250, 250, false, false); 
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
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        root.setFocusTraversable(true);
        root.requestFocus();
    }
    
    @FXML 
    private void tesdt(KeyEvent event) {
        grid.getChildren().remove(im);
        
        
        switch(event.getCode()) {
            case W:
                coordY--; 
                index = 0; 
                break;
            case A:
                coordX--;
                index = 1; 

                break;     
            case S:    
                coordY++;
                index = 2; 
                break;
            case D:
                coordX++; 
                index = 3; 
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
