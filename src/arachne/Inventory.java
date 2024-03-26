
package arachne;

import java.util.*;

public class Inventory {
    private static int maxNum = 16;  //max number of storeable items, array list 
    private static Dictionary<Storeable, Integer> inventory = new Hashtable<>(); 

    private static int silk;
    private static int coins; 
    
    public void pickUpSilk(int amt) {
        silk += amt; 
    }
    
    public void coinInc (int amt) {
        coins += amt; 
    }
    
    public void store(Storeable item, int amt) {
        inventory.put(item, amt); 
    }
    
    public void discard(Storeable item, int amt) {
        inventory.put(item, (inventory.get(item)-amt)); 
    }
    public void use(Powerup n, int amt) {
        inventory.put(n, inventory.get(n)-amt); 
    }
}
