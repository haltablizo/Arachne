
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

        
        Spider a = new Spider("a", 0,0,0); //level 1 
        
        Object[][] firstMap = {
            {0,0,0},
            {0,a,0},
            {0,0,0},
            {0,0,0}
        };
        Map levelOne = new Map(firstMap);
        
        Spider b = new Spider("b", 0,0,0); //level 2
        Spider c = new Spider("c", 0,0,0); //level 2
        
        Object[][] secondMap = { //level*4 - 1 
            {0,0,0},
            {0,0,b},
            {0,0,0},
            {0,0,0},
            {0,0,0},
            {c,0,0},
            {0,0,0},
            {0,0,0}
        };
        Map levelTwo = new Map(secondMap);
        
        Spider d = new Spider("d", 0,0,0); //level 3
        Spider e = new Spider("e", 0,0,0); //level 3 
        Spider f = new Spider("f", 0,0,0); //level 3 
        
        Object[][] thirdMap = { 
            {0,0,0},
            {0,d,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {e,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,0,0},
            {0,0,f} 
        };
        Map levelThree = new Map(thirdMap);
        
        Spider g = new Spider("g", 0,0,0); //level 4
        Spider h = new Spider("h", 0,0,0); //level 4 
        Spider i = new Spider("i", 0,0,0); //level 4 
        Spider j = new Spider("j", 0,0,0); //level 4
       
        Object[][] fourthMap = { 
            {0,0,0},
            {g,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,h,0},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,0,i},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {j,0,0},
            {0,0,0}
        };
        Map levelFour = new Map(fourthMap);
        
        Spider k = new Spider("k", 0,0,0); //level 5
        Spider l = new Spider("l", 0,0,0); //level 5 
        Spider m = new Spider("m", 0,0,0); //level 5 
        Spider n = new Spider("n", 0,0,0); //level 5
        Spider o = new Spider("o", 0,0,0); //level 5
        
        Object[][] fifthMap = { 
            {0,0,0},
            {k,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,l},
            {0,0,0}, 
            
            {0,0,0},
            {m,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,n,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,o,0},
            {0,0,0}
        };
        Map levelFive = new Map(fifthMap);
        
        
        Spider p = new Spider("p", 0,0,0); //level 6
        Spider q = new Spider("q", 0,0,0); //level 6 
        Spider r = new Spider("r", 0,0,0); //level 6 
        Spider s = new Spider("s", 0,0,0); //level 6
        Spider t = new Spider("t", 0,0,0); //level 6
        Spider u = new Spider("u", 0,0,0); //level 6
        
        Object[][] sixthMap = { 
            {0,0,0},
            {0,0,p},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {q,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,r},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {s,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,t,0},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,u,0},
            {0,0,0}, 
        };
        Map levelSix = new Map(sixthMap);
        
        
        Spider v = new Spider("v", 0,0,0); //level 7
        Spider w = new Spider("w", 0,0,0); //level 7 
        Spider x = new Spider("x", 0,0,0); //level 7 
        Spider y = new Spider("y", 0,0,0); //level 7
        Spider z = new Spider("z", 0,0,0); //level 7
        Spider aa = new Spider("aa", 0,0,0); //level 7
        Spider ab = new Spider("ab", 0,0,0); //level 7
        
        Object[][] seventhMap = { 
            {0,0,0},
            {0,v,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,w,0},
            {0,0,0},
            
            {0,0,0},
            {0,x,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,0},
            {0,y,0}, 
            
            {0,0,0},
            {z,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,aa},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {ab,0,0},
            {0,0,0}
        };
        Map levelSeven = new Map(seventhMap);
        
        Spider ac = new Spider("v", 0,0,0); //level 8
        Spider ad = new Spider("w", 0,0,0); //level 8 
        Spider ae = new Spider("x", 0,0,0); //level 8 
        Spider af = new Spider("y", 0,0,0); //level 8
        Spider ag = new Spider("z", 0,0,0); //level 8
        Spider ah = new Spider("aa", 0,0,0); //level 8
        Spider ai = new Spider("ab", 0,0,0); //level 8
        Spider aj = new Spider("ab", 0,0,0); //level 8
        
        Object[][] eighthMap = { 
            {0,0,0},
            {0,0,0},
            {ac,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,ad},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,ae,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,af,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {ag,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {ah,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,ai},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,aj,0},
            {0,0,0}
        };
        Map levelEight = new Map(eighthMap);
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/Settings.fxml"));
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
