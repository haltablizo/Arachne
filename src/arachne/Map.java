
package arachne;

import java.util.ArrayList;

public class Map {
    //public static Object[][][] game = {{},{}}; 
    
    public static ArrayList<Object[][]> game = new ArrayList<>();
        
    private Object[][] layout; 
    
    public Map(Object[][] arr) {
        
        this.layout = arr; 
        game.add(arr); 
    }
}
