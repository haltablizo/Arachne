
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class KeyChangeController implements Initializable {
    
        private String openedFrom; 
    
    public void setOpenedFrom(String s) {
        openedFrom = s; 
    }

    @FXML 
    private void setKey(KeyEvent event) throws IOException {
        String code = event.getCode().toString();

        if ((code.length() == 1 && Character.isLetter(code.charAt(0))) || "UP".equals(code) || "DOWN".equals(code) || "LEFT".equals(code) || "RIGHT".equals(code)) {
            System.out.println(event.getCode());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/Settings.fxml"));
            Parent root = loader.load();
            Scene subjectScene = new Scene(root);
            Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            thisStage.hide();
            thisStage.setScene(subjectScene);
            thisStage.show();          
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
