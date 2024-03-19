
package controllers;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class OverworldController implements Initializable {


    @FXML ImageView inventoryIcon;
    
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
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
