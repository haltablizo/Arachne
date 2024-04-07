
package arachne;

import java.util.*;

public class Inventory {
    private static int maxNum = 16;  //max number of storeable items, array list 
    public static Dictionary<Storeable, Integer> inventory = new Hashtable<>(); 

    private static int silk;
    
    public void pickUpSilk(int amt) {
        silk += amt; 
    }
    
    public static void store(Storeable item, int amt) {
        inventory.put(item, amt); 
    }
    
    public void discard(Storeable item, int amt) {
        inventory.put(item, (inventory.get(item)-amt)); 
    }
    public void use(Powerup n, int amt) {
        inventory.put(n, inventory.get(n)-amt); 
    }
}
