
package arachne;

import java.util.*;
import java.util.Map.Entry;

public class Inventory {
    //public static Map<Powerup, Integer> invPowerup = new Hashtable<>(); 
    //public static Map<Equipment, Integer> invEquipment = new Hashtable<>(); 
    
    
    public static LinkedHashMap<Powerup, Integer> invPowerup = new LinkedHashMap<>(9, (float) 0.75, true);
    public static LinkedHashMap<Equipment, Integer> invEquipment = new LinkedHashMap<>(9, (float) 0.75, true);

    public static int silk;
    
    /**
     * 
     * @param amt adds silk of amount amt to player's silk storage 
     */
    public static void pickUpSilk(int amt) {
        silk += amt; 
    }
    
    /**
     * 
     * @param item stores powerup item in inventory 
     * @param amt amount of powerup stored 
     */
    public static void store(Powerup item, int amt) {
        invPowerup.put(item, amt); 
    }
    
    /**
     * 
     * @param item stores item of type equipment in inventory  
     */
    public static void store(Equipment item) {
        invEquipment.put(item, 1); 
    }
    
    /**
     * 
     * @param item discards item of class powerup 
     * @param amt discards amt items 
     */
    public void discard(Powerup item, int amt) {
        invPowerup.remove(item);
    }
    
    /**
     * 
     * @param item discards item of superclass equipment
     * @param amt discards amt items 
     */
    public static void discard(Equipment item, int amt) {
        invEquipment.remove(item); 
    }    
    
    /**
     * 
     * @param n consumes n powerups
     */
    public static void use(Powerup n) {
        if (invPowerup.get(n)-1==0) {
            invPowerup.remove(n);
        }
        else {
            invPowerup.put(n, invPowerup.get(n)-1) ; 
        } 
        Player.use(n, 1); 
        
    }
    
    /**
     * 
     * @param n uses equipment n
     * if previous coat or needle is equipped, it stores the previously equipped equipment 
     */
    public static void use(Equipment n) {

        if (Player.getCoat() != null && n instanceof Coat) { 
            Coat current = Player.getCoat(); 
            invEquipment.put(current, 1); 
            Player.setCoat((Coat) n);
            invEquipment.remove(n);
        }
        if (Player.getNeedle() != null && n instanceof Needle) {
            Needle current = Player.getNeedle(); 
            invEquipment.put(current, 1); 
            Player.setNeedle((Needle) n);
            invEquipment.remove(n);

        }
        
        else { 
            if (n instanceof Coat) {
                Player.setCoat((Coat) n);
                invEquipment.remove(n);
            }
            else if (n instanceof Needle) { 
                Player.setNeedle((Needle) n);
                invEquipment.remove(n);
            }
        }
    } 
}
