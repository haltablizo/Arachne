
package arachne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Arachne extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Powerup a = new Powerup("a", 0,0,0,0, "h");        
        Powerup b = new Powerup("b", 0,0,0,0, "q"); 
        Powerup c = new Powerup("c", 0,0,0,0, "a"); 
        Powerup d = new Powerup("d", 0,0,0,0, "d"); 
        Powerup e = new Powerup("e", 0,0,0,0, "d");         
        Powerup f = new Powerup("f", 0,0,0,0, "sad"); 
        Powerup g = new Powerup("g", 0,0,0,0, "a"); 

 
        Inventory.store(a,1);        
        Inventory.store(b,1);
        Inventory.store(c,1);
        Inventory.store(d,1);
        Inventory.store(e,1);
        Inventory.store(f,1);
        Inventory.store(g,1);
        
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
