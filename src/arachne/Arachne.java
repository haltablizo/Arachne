
package arachne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Arachne extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Powerup ambrosia = new Powerup("Ambrosia", 0,0,0,0, "h", "/images/powerupIcons/ambrosia.png");        
        Powerup goldenApple = new Powerup("Golden Apple", 0,0,0,0, "q", "/images/powerupIcons/goldenApple.png"); 
        Powerup lotus = new Powerup("Lotus", 0,0,0,0, "a", "/images/powerupIcons/lotus.png"); 
        Powerup wheat = new Powerup("Wheat", 0,0,0,0, "d", "/images/powerupIcons/wheat.png"); 
        Powerup wine = new Powerup("Wine", 0,0,0,0, "d", "/images/powerupIcons/wine.png");   

 
        Inventory.store(ambrosia,5);        
        Inventory.store(goldenApple,1);
        Inventory.store(lotus,3);
        Inventory.store(wheat,7);
        Inventory.store(wine,1);
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/DivineBattle.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        root.setFocusTraversable(true);
        root.requestFocus();
        stage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
