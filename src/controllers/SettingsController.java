
package controllers;

import arachne.Key;
import arachne.Settings;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SettingsController implements Initializable {

    @FXML Button upButton, downButton, leftButton, rightButton; 
    
    @FXML
    private void cancel(ActionEvent event) throws IOException { 
        Key.tempUp = Key.up;        
        Key.tempDown = Key.down; 
        Key.tempLeft = Key.left; 
        Key.tempRight = Key.right;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MainMenu.fxml"));
        Parent root = loader.load(); 
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
    }
    
    @FXML private void save(ActionEvent event) throws IOException {
        Key.up = Key.tempUp;        
        Key.down = Key.tempDown; 
        Key.left = Key.tempLeft; 
        Key.right = Key.tempRight;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MainMenu.fxml"));
        Parent root = loader.load();
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
    }
    
    @FXML private void upKey(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/KeyChange.fxml"));
        Parent root = loader.load();
        KeyChangeController controller = loader.getController();
        controller.setOpenedFrom("UP");
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        
        root.setFocusTraversable(true); 
        root.requestFocus(); 
    }
    
    @FXML private void downKey(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/KeyChange.fxml"));
        Parent root = loader.load();
        KeyChangeController controller = loader.getController();
        controller.setOpenedFrom("DOWN");
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        
        root.setFocusTraversable(true); 
        root.requestFocus(); 
    }
    
    @FXML private void leftKey(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/KeyChange.fxml"));
        Parent root = loader.load();
        KeyChangeController controller = loader.getController();
        controller.setOpenedFrom("LEFT");
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        
        root.setFocusTraversable(true); 
        root.requestFocus(); 
    }
    
    @FXML private void rightKey(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/KeyChange.fxml"));
        Parent root = loader.load();
        KeyChangeController controller = loader.getController();
        controller.setOpenedFrom("RIGHT");        
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
        
        root.setFocusTraversable(true); 
        root.requestFocus(); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        upButton.setText("Key " + Key.tempUp);
        downButton.setText("Key " + Key.tempDown);
        leftButton.setText("Key " + Key.tempLeft);
        rightButton.setText("Key " + Key.tempRight);      
    }    
    
}
