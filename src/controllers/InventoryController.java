
package controllers;

import arachne.Inventory;
import static arachne.Inventory.invPowerup;
import arachne.Powerup;
import arachne.Spider;
import arachne.Storeable;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    
    
    private void itemClicked(int index) {
        List<Entry<Powerup, Integer>> indexedList = new ArrayList<>(Inventory.invPowerup.entrySet());
        Map.Entry<Powerup, Integer> entry  = indexedList.get(index);
        Powerup key = entry.getKey();
        Integer value = entry.getValue();
                    
        Image img = new Image(key.getFn(), 150, 150, false, false);
        itemImage.setImage(img);
        itemName.setText("[" + value + "] " + key.getName());        
        itemDesc.setText(key.getDesc());

        useButton.setVisible(true);
        dropButton.setVisible(true);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemImage.setImage(null);
        itemName.setText("");        
        itemDesc.setText("");

        useButton.setVisible(false);
        dropButton.setVisible(false);
        
        int tempI = Inventory.invPowerup.size()/3; 
        int tempJ = Inventory.invPowerup.size()%3; 
                
        for (int i=0; i<tempI; i++) {
            for(int j=0; j<3; j++) {
                Image img = new Image("/images/spiderIcon.png", 150, 150, false, false); 
                ImageView im = new ImageView(img);
                potionGrid.add(im,j,i);
                int x = i*3+j;
                
                im.setOnMouseClicked(e -> {
                    itemClicked(x); 
                });
            }
        }
        for (int i=0; i<tempJ; i++) {
            Image img = new Image("/images/spiderIcon.png", 150, 150, false, false); 
            ImageView im = new ImageView(img);
            potionGrid.add(im, i, tempI);
            
            int x = tempI*3+i; 
            
            im.setOnMouseClicked(e -> {
                itemClicked(x); 
            });
        }
        
    }
    
}
