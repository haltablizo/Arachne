
package controllers;

import arachne.Spider;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InventoryController implements Initializable {
   
    
    @FXML Button useButton, dropButton;
    @FXML ImageView itemImage; 
    @FXML Label itemDesc, itemName; 
    private String openedFrom; 
    
    public void setOpenedFrom(String s) {
        openedFrom = s;
    }
    
    @FXML 
    private void closeInv(ActionEvent event) throws IOException {
        FXMLLoader loader; 
        
        if (openedFrom.equals("Overworld")) {
            loader = new FXMLLoader(getClass().getResource("/screens/Overworld.fxml"));
            Parent root = loader.load();
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();
            root.requestFocus();
        }
        else {
            loader = new FXMLLoader(getClass().getResource("/screens/SpiderBattle.fxml"));
            Parent root = loader.load(); 
            SpiderBattleController controller = loader.getController();
            Spider calamari = new Spider("Calamari", 1, 10, 30, 5);
            controller.setSpider(calamari);
            
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();
            root.requestFocus();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemImage.setImage(null);
        itemName.setText("");        
        itemDesc.setText("");

        useButton.setVisible(false);
        dropButton.setVisible(false);
    }    
    
}
