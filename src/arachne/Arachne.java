
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
        Powerup ambrosia = new Powerup("Ambrosia", 0,0,0,50, "Increase max HP by 50.", "/images/powerupIcons/ambrosia.png", 245);      
        Powerup nectar = new Powerup("Nectar", 0,0,0,30, "Increases max HP by 30.", "/images/powerupIcons/nectar.png", 125); 
        Powerup goldenApple = new Powerup("Golden Apple", 0,0,0,20, "Increases max HP by 20", "/images/powerupIcons/goldenApple.png", 320);

        //heals
        Powerup pomegranate = new Powerup("Pomegranate", 15,0,0,0, "Heals 15 HP.", "/images/powerupIcons/pomegranate.png", 180); 
        Powerup wine = new Powerup("Wine", 20,0,0,0, "Heals 20 HP.", "/images/powerupIcons/wine.png", 45); 
        Powerup wheat = new Powerup("Wheat", 10,0,0,0, "Heals 10 HP.", "/images/powerupIcons/wheat.png", 80); 
        Powerup figs = new Powerup("Figs", 30,0,0,0, "Heals 30 HP.", "/images/powerupIcons/figs.png", 1);
        Powerup lotus = new Powerup("Lotus", 70,0,0,0, "Heals 70 HP.", "/images/powerupIcons/lotus.png", 10);
        
        //coat
        Coat ironhide = new Coat("Ironhide Coat", "/images/coat/1.png", "Increases defense by 50", 50);        
        Coat dragonhide = new Coat("Dragonhide Coat", "/images/coat/2.png", "Increases defense by 90", 90);
        Coat healing = new Coat("Healing Mantle", "/images/coat/3.png", "Increases defense by 20", 20);
        Coat stormbreaker = new Coat("Stormbreaker Coat", "/images/coat/4.png", "Increases defense by 60", 60);
        Coat alchemist = new Coat("Alchemist's Robe", "/images/coat/5.png", "Increases defense by 40", 40);        
        Coat berserker = new Coat("Berserker's Coat", "/images/coat/6.png", "Increases defense by 80", 80);
        Coat vampire = new Coat("Vampire's Coat", "/images/coat/7.png", "Increases defense by 70", 70);
        Coat warrior = new Coat("Warrior's Coat", "/images/coat/8.png", "Increases defense by 30", 30);
         
        //needle
        Needle caduceus = new Needle("Caduceus", "/images/needle/1.png","Increases attack by 30", 30);
        Needle arrow = new Needle("Arrow", "/images/needle/2.png", "Increases attack by 25", 25);
        Needle thyrsus = new Needle("Thyrsus", "/images/needle/3.png", "Increases attack by 40", 40);
        Needle sickle = new Needle("Sickle", "/images/needle/4.png", "Increases attack by 50", 50);
        Needle trident = new Needle("Trident", "/images/needle/5.png", "Increases attack by 60", 60);
        Needle bident = new Needle("Bident", "/images/needle/6.png", "Increases attack by 75", 75);
        Needle thunderbolt = new Needle("Thunderbolt", "/images/needle/7.png", "Increases attack by 90", 90);
        Needle scepter = new Needle("Scepter", "/images/needle/8.png", "Increases attack by 100", 100);
        
        Spider s1 = new Spider("Basic spider", 10,1,1, "/images/spiderIcons/basic.png"); //level 1 hp, atk, amt
        Human p1 = new Human("Priam", figs, "/images/human/1.png");
        Divine d1 = new Divine("Hermes", ironhide, caduceus, "/images/divine/hermes.png"); 
        
        Object[][] firstMap = {
            {0,0,p1},
            {0,s1,0},
            {0,0,0},
            {p1,d1,0}
        };
        Map levelOne = new Map(firstMap);
        
        Spider s2 = new Spider("Giant Tarantula", 25,3,5, "/images/spiderIcons/tarantula.png"); //level 2
        Human p2 = new Human("Atlanta", lotus, "/images/human/2.png"); 
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
        Human p3 = new Human("Silenus", wine, "/images/human/3.png");
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
        Human p4 = new Human("Celeus", wheat, "/images/human/4.png");
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
        Human p5 = new Human("Perseus", nectar, "/images/human/5.png");
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
        Human p6 = new Human("Charon", pomegranate, "/images/human/6.png");
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
        Human p7 = new Human("Heracles", ambrosia,"/images/human/7.png");
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
        Human p8 = new Human("Paris", goldenApple, "/images/human/8.png");
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
        
        Parent root = FXMLLoader.load(getClass().getResource("/screens/MainMenu.fxml"));
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
