
package controllers;

import arachne.Inventory;
import arachne.Powerup;
import arachne.Spider;
import arachne.Storeable;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InventoryController implements Initializable {
   
    
    @FXML Button useButton, dropButton;
    @FXML ImageView itemImage; 
    @FXML Label itemDesc, itemName; 
    
    @FXML GridPane potionGrid; 
    
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
            calamari.setIcons("/images/calamari/neutralIcon.png", "/images/calamari/attackedIcon.png", "/images/calamari/attackingIcon.png");
            controller.setSpider(calamari);
            
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();
            root.requestFocus();
        }
    }
    
    @FXML
    public void openStats(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Stats.fxml"));
            Parent root = loader.load();
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();
            root.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemImage.setImage(null);
        itemName.setText("");        
        itemDesc.setText("");

        useButton.setVisible(false);
        dropButton.setVisible(false);
        
        
        
//        int lastBox = 7%3 ;
//        int lastRow = 7/3 ; 
//        
//        for (int i=0; i<lastRow+1; i++) {
//            int c = 3; 
//            if (i==lastRow) {
//                c = lastBox; 
//            }
//            
//            for (int j=0; j<c; j++) {
//                Image img = new Image("/images/spiderIcon.png", 150, 150, false, false); 
//                ImageView im = new ImageView(img);
//                potionGrid.add(im,j,i);
//            }
//        }
        
        int tempI = Inventory.invPowerup.size()/3; 
        int tempJ = Inventory.invPowerup.size()%3; 
                
        for (int i=0; i<tempI; i++) {
            for(int j=0; j<3; j++) {
                Image img = new Image("/images/spiderIcon.png", 150, 150, false, false); 
                ImageView im = new ImageView(img);
                potionGrid.add(im,j,i);
            }
        }
        for (int i=0; i<tempJ; i++) {
            Image img = new Image("/images/spiderIcon.png", 150, 150, false, false); 
            ImageView im = new ImageView(img);
            potionGrid.add(im, i, tempI);
        }
    }
    
}
