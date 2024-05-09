
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

        Coat she = new Coat("she", "/images/equipmentIcons/she.png", 12);        
        Coat iel = new Coat("iel", "/images/equipmentIcons/iel.png", 23);
        Coat eld = new Coat("eld", "/images/equipmentIcons/eld.png", 40);
        Needle swo = new Needle("swo", "/images/equipmentIcons/swo.png", 12);
        Needle wor = new Needle("wor", "/images/equipmentIcons/wor.png", 1);
        Needle ord = new Needle("ord", "/images/equipmentIcons/ord.png", 25);

        Inventory.store(she);        
        Inventory.store(iel);
        Inventory.store(eld);
        Inventory.store(swo);
        Inventory.store(wor);
        Inventory.store(ord);

        
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/Inventory.fxml"));
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
