
package arachne;

import java.util.ArrayList;

public class Map {
    //public static Object[][][] game = {{},{}}; 
    
    public static ArrayList<Object[][]> game = new ArrayList<>();
        
    private Object[][] layout; 
    
    public static boolean humanFirst = true;     
    public static boolean spider = false; 
    public static boolean divine = false; 
    public static boolean humanSecond = false; 
    public static boolean portal = false; 
    
    public static int spidCount = 0; 
    
    public Map(Object[][] arr) {
        this.layout = arr; 
        game.add(arr); 
    }
    
    public static void incSpid() {
        spidCount++; 
    }
    
    public static void humanFirstChecker() {
        if (humanFirst == true) {
            spider = true;
            humanFirst = false; 
        }
    }
    
    public static void spiderChecker() {
        if (spidCount == Player.level) {
            spider = false;
            divine = true;
        }
    }
    
    public static void divineChecker() {
        if (divine == true) {
            divine = false;
            portal = true;      
            humanSecond = true; 
        }
    }
    
    public static void reset() {
        if (portal == true) {
            humanFirst = false;     
            spider = false;
            divine = false;
            humanSecond = false;
            portal = false;
            spidCount = 0; 
        }
    }
}
