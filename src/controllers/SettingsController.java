
package controllers;

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

    @FXML
    private void cancel(ActionEvent event) throws IOException { 
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MainMenu.fxml"));
        Parent root = loader.load(); 
        
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
    }
    
    @FXML private void save(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/MainMenu.fxml"));
        Parent root = loader.load();
        Scene subjectScene = new Scene(root);
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisStage.hide();
        thisStage.setScene(subjectScene);
        thisStage.show();
    }
    
    @FXML private void changeKey(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/KeyChange.fxml"));
        Parent root = loader.load();
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

    }    
    
}
