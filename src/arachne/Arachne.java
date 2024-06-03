
package arachne;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Arachne extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //n, hp, def, atk, maxhp, description, filename 
        Powerup ambrosia = new Powerup("Ambrosia", 0,0,0,10, "Increase max HP by 10.", "/images/powerupIcons/ambrosia.png");      
        Powerup nectar = new Powerup("Nectar", 0,0,0,5, "Increases max HP by 5.", "/images/placeholder.jpg"); 
        Powerup goldenApple = new Powerup("Golden Apple", 0,0,0,3, "Increases max HP by 3", "/images/powerupIcons/goldenApple.png");
        
        //heals
        Powerup pomegranate = new Powerup("Pomegranate", 5,0,0,0, "Heals 5 HP.", "/images/placeholder.jpg"); 
        Powerup wine = new Powerup("Wine", 2,0,0,0, "Heals 2 HP.", "/images/powerupIcons/wine.png"); 
        Powerup wheat = new Powerup("Wheat", 1,0,0,0, "Heals 1 HP.", "/images/powerupIcons/wheat.png"); 
        Powerup figs = new Powerup("Figs", 3,0,0,0, "Heals 3 HP.", "/images/placeholder.jpg");
        Powerup lotus = new Powerup("Lotus", 7,0,0,0, "Heals 7 HP.", "/images/powerupIcons/lotus.png"); 
        
        //hp reduction
        Powerup webcap = new Powerup("Webcap Mushroom", -3, 0, 0, 0, "Subtracts 3 HP.", "/images/placeholder.jpg");
        Powerup mulberry = new Powerup("Mulberry", -1, 0, 0, 0, "Subtracts 1 HP.", "/images/placeholder.jpg");
        Powerup narcissus = new Powerup("Narcissus Flower", -2, 0, 0, 0, "Subtracts 2 HP.", "/images/placeholder.jpg");
        Powerup daphne = new Powerup("Daphne Fruit", -3, 0, 0, 0, "Subtracts 3 HP.", "/images/placeholder.jpg");
        Powerup laurel = new Powerup("Laurel Leaves", -1, 0, 0, 0, "Subtracts 1 HP.", "/images/placeholder.jpg");

        //coat
        Coat ironhide = new Coat("Ironhide Coat", "/images/placeholder.jpg", "Increases defense by 50", 50);        
        Coat dragonhide = new Coat("Dragonhide Coat", "/images/placeholder.jpg", "Increases defense by 90", 90);
        Coat healing = new Coat("Healing Mantle", "/images/placeholder.jpg", "Increases defense by 20", 20);
        Coat stormbreaker = new Coat("Stormbreaker Coat", "/images/placeholder.jpg", "Increases defense by 60", 60);
        Coat alchemist = new Coat("Alchemist's Robe", "/images/placeholder.jpg", "Increases defense by 40", 40);        
        Coat berserker = new Coat("Berserker's Coat", "/images/placeholder.jpg", "Increases defense by 80", 80);
        Coat vampire = new Coat("Vampire's Coat", "/images/placeholder.jpg", "Increases defense by 70", 70);
        Coat warrior = new Coat("Warrior's Coat", "/images/placeholder.jpg", "Increases defense by 30", 30);
        
        //needle
        Needle caduceus = new Needle("Caduceus", "/images/placeholder.jpg","Increases attack by 30", 30);
        Needle arrow = new Needle("Arrow", "/images/placeholder.jpg", "Increases attack by 25", 25);
        Needle thyrsus = new Needle("Thyrsus", "/images/placeholder.jpg", "Increases attack by 40", 40);
        Needle sickle = new Needle("Sickle", "/images/placeholder.jpg", "Increases attack by 50", 50);
        Needle trident = new Needle("Trident", "/images/placeholder.jpg", "Increases attack by 60", 60);
        Needle bident = new Needle("Bident", "/images/placeholder.jpg", "Increases attack by 75", 75);
        Needle thunderbolt = new Needle("Thunderbolt", "/images/placeholder.jpg", "Increases attack by 90", 90);
        Needle scepter = new Needle("Scepter", "/images/placeholder.jpg", "Increases attack by 100", 100);
        
        Spider s1 = new Spider("Basic spider", 10,1,1, "/images/spiderIcons/basic.png"); //level 1 hp, atk, amt
        Human p1 = new Human("Priam", figs);
        Divine d1 = new Divine("Hermes", ironhide, caduceus, "/images/divine/hermes.png"); 
        
        Object[][] firstMap = {
            {0,0,p1},
            {0,s1,0},
            {0,0,0},
            {p1,d1,0}
        };
        Map levelOne = new Map(firstMap);
        
        Spider s2 = new Spider("Giant Tarantula", 25,3,5, "/images/spiderIcons/tarantula.png"); //level 2
        Human p2 = new Human("Atlanta", lotus); 
        Divine d2 = new Divine("Apollo", dragonhide, arrow, "/images/divine/apollo.png"); 
        
        Object[][] secondMap = { //level*4 - 1 
            {0,0,p2},
            {0,0,s2},
            {0,0,0},
            {0,0,0},
            {0,0,0},
            {s2,0,0},
            {0,0,0},
            {p2,d2,0}
        };
        Map levelTwo = new Map(secondMap);
        
        Spider s3 = new Spider("Venomous Widow", 30,3,15, "/images/spiderIcons/widow.png"); //level 3
        Human p3 = new Human("Silenus", wine);
        Divine d3 = new Divine("Dionysus", healing, thyrsus, "/images/divine/dionysus.png"); 
        
        Object[][] thirdMap = { 
            {0,0,p3},
            {0,s3,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {s3,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,0,s3},
            {p3,d3,0} 
        };
        Map levelThree = new Map(thirdMap);
        
        Spider s4 = new Spider("Shadow Crawler", 70,5,20, "/images/spiderIcons/shadow.png"); //level 4
        Human p4 = new Human("Celeus", wheat);
        Divine d4 = new Divine("Demeter", stormbreaker, sickle, "/images/divine/demeter.png"); 
        
        Object[][] fourthMap = { 
            {0,0,p4},
            {s4,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,s4,0},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,0,s4},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {s4,0,0},
            {p4,d4,0}
        };
        Map levelFour = new Map(fourthMap);
        
        Spider s5 = new Spider("Rock Spider", 100,1,25, "/images/spiderIcons/rock.png"); //level 5
        Human p5 = new Human("Perseus", nectar);
        Divine d5 = new Divine("Poseidon", alchemist, trident, "/images/divine/poseidon.png"); 
        
        Object[][] fifthMap = { 
            {0,0,p5},
            {s5,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,s5},
            {0,0,0}, 
            
            {0,0,0},
            {s5,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,s5,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,s5,0},
            {p5,d5,0}
        };
        Map levelFive = new Map(fifthMap);
        
        
        Spider s6 = new Spider("Ghost Spider", 10,50,30, "/images/spiderIcons/ghost.png"); //level 6
        Human p6 = new Human("Charon", pomegranate);
        Divine d6 = new Divine("Hades", berserker, bident, "/images/divine/hades.png"); 
        
        Object[][] sixthMap = { 
            {0,0,p6},
            {0,0,s6},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {s6,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,s6},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {s6,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,s6,0},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,s6,0},
            {p6,d6,0} 
        };
        Map levelSix = new Map(sixthMap);
        
        
        Spider s7 = new Spider("Ice Web Spider", 30,30,35, "/images/spiderIcons/ice.png"); //level 7
        Human p7 = new Human("Heracles", ambrosia);
        Divine d7 = new Divine("Zeus", vampire, thunderbolt, "/images/divine/zeus.png"); 
                
        Object[][] seventhMap = { 
            {0,0,p7},
            {0,s7,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,s7,0},
            {0,0,0},
            
            {0,0,0},
            {0,s7,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,0},
            {0,s7,0}, 
            
            {0,0,0},
            {s7,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,s7},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {s7,0,0},
            {p7,d7,0}
        };
        Map levelSeven = new Map(seventhMap);
        
        Spider s8 = new Spider("Acid Spider", 50,50,40, "/images/spiderIcons/acid.png"); //level 8
        Human p8 = new Human("Paris", goldenApple);
        Divine d8 = new Divine("Hera", warrior, scepter, "/images/divine/hera.png");         
        
        Object[][] eighthMap = { 
            {0,0,p8},
            {0,0,0},
            {s8,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,0,s8},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {0,s8,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,s8,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {s8,0,0},
            {0,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,0},
            {s8,0,0},
            {0,0,0},
            
            {0,0,0},
            {0,0,s8},
            {0,0,0},
            {0,0,0}, 
            
            {0,0,0},
            {0,0,0},
            {0,s8,0},
            {p8,d8,0}
        };
        Map levelEight = new Map(eighthMap);
        
        
        Divine d9 = new Divine("Athena"); 
        
        Object[][] ninthMap = { 
           {0,0,0},
           {0,0,0},
           {0,d9,0},
           {0,0,0}
        };
        Map levelNine = new Map(ninthMap);
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/Overworld.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        root.setFocusTraversable(true);
        root.requestFocus();
        stage.setResizable(false);
        stage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
