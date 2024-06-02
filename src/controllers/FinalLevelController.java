
package controllers;

import arachne.Divine;
import arachne.Human;
import arachne.Key;
import arachne.Map;
import arachne.Player;
import arachne.Settings;
import arachne.Spider;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class FinalLevelController implements Initializable {

    String[] fn = {"/images/charIcons/up.png", "/images/charIcons/left.png", "/images/charIcons/down.png", "/images/charIcons/right.png"};

    @FXML ProgressBar progBar;
   
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progBar.setProgress(Player.level/9.0);
    }   
    
    
}