
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
        switch(event.getCode()) {
            case W:
                System.out.println("up");
                break;
            case A:
                System.out.println("left");
                break;     
            case S:                
                System.out.println("down");
                break;
            case D:
                System.out.println("right");
                break;
            default: 
                break;
        }
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        grid.add(im, 0, 1);        
        grid.add(im, 0, 0);


    }   
    
}
