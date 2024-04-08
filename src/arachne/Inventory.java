
package arachne;

import java.util.*;

public class Inventory {
    private static int maxNum = 16;  //max number of storeable items, array list 
    public static Map<Powerup, Integer> invPowerup = new Hashtable<>(); 
    public static Map<Equipment, Integer> invEquipment = new Hashtable<>(); 

    private static int silk;
    
    public void pickUpSilk(int amt) {
        silk += amt; 
    }
    
    public static void store(Powerup item, int amt) {
        invPowerup.put(item, amt); 
    }
    
    public static void store(Equipment item, int amt) {
        invEquipment.put(item, amt); 
    }
    
    public void discard(Powerup item, int amt) {
        invPowerup.put(item, (invPowerup.get(item)-amt)); 
    }
    public static void discard(Equipment item, int amt) {
        invEquipment.put(item, (invEquipment.get(item)-amt)); 
    }    
    
    public void use(Powerup n, int amt) {
        invPowerup.put(n, invPowerup.get(n)-amt); 
    }
    public static void use(Equipment n, int amt) {
        invEquipment.put(n, invEquipment.get(n)-amt); 
    }    
}
