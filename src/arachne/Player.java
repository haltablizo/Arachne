
package arachne;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static String name; 
    private static float popMeter = 0; 
    private static int atk = 1; //attack with fists
    private static int def = 1; //default def  
    private static int hp = 20; 
    private static int maxHp = 20; 
    private static Coat coat; 
    private static Needle needle; 
    private static boolean curDef = false; //checks if player is "defending" for this round 
    public static Inventory pStorage; 
    
    private static Quest curQuest; 
    
    private static List<Integer> hand = new ArrayList(); 
    
    public Player(String n) {
        name = n; 
        hp = maxHp; 
    }
    
    public static void setCoat(Coat c) {
        coat = c; 
        def = c.getDefBonus();
    }
    public static void setNeedle(Needle n){
        needle = n; 
        atk = n.getAtkBonus(); 
    }
    
    public static String getName() {
        return name; 
    }
    public static float getPopMeter() {
        return popMeter; 
    }
    public static int getAtk() {
        return atk; 
    }
    public static int getDef() {
        return def; 
    }    
    public static int getHp() {
        return hp; 
    }    
    public static int getMaxHp() {
        return maxHp; 
    }
    public static Coat getCoat() {
        return coat; 
    }
    
    public static Needle getNeedle() {
        return needle; 
    }
    
    public static boolean getCurDef() {
        return curDef; 
    }
    
    public static void reduceHP(int i){
        hp-=i;
    }

    public static boolean attack(Spider s) {
        System.out.println("-----------------");
        if (atk > s.getDef()) {
            System.out.println("attacked"); 
            s.reduceHP(atk-s.getDef()); 
                 
            if (s.getHp() > 0) {
                System.out.println("spid not dead"); 
                s.attack(); 
                System.out.println("Spider: " + s.getHp()); 
                System.out.println("Player: " + hp); 
                return false; 
            } 
            else {
                System.out.println("spid dead"); 
                System.out.println("Spider: " + s.getHp()); 
                System.out.println("Player: " + hp); 
                //pStorage.pickUpSilk(s.getAmtOfSilk());  
                return true; 
            }       
        }
        else {
            System.out.println(name + " did not do any damage!"); 
            return false; 
        }
    }
    
    public static void defend(Spider s) { 
        curDef = true; 
        s.attack();
    }
    public static void removeDef() {
        curDef = false; 
    }
    
    public static void use(Powerup p, int amt) {
        pStorage.use(p, amt); 
        hp += p.getHpInc();         
        def += p.getDefInc(); 
        atk += p.getAtkInc(); 
        maxHp += p.getMaxHpInc(); 
    }
        
    public static void setQuest(Quest q) {
        curQuest = q; 
    }
    
    public static void pursueQuest() {
        curQuest.complete(); 
        popMeter += curQuest.getPopInc(); 
    }
    
    public static int getHandSum() {
        int s = 0; 
        for (int i : hand) s = s + i;
        return s; 
    }

    
    public static void hit(Divine d) {
        int charCardIndex = (int)(Math.random() * (d.deck.size()));
        hand.add(d.deck.get(charCardIndex));
        d.deck.remove(charCardIndex);
        
        int oppCardIndex = (int)(Math.random() * (d.deck.size()));
        d.hit(d.deck.get(oppCardIndex)); 
        d.deck.remove(oppCardIndex);
        
        //if player deck size == 5, or sum exceeds 21 
        if (hand.size() == 5 || Player.getHandSum() > 21) {
            endDivineGame(d); 
        }
    }
    
    public static void endDivineGame(Divine d) { //happens when stand, or number of cards == 5, or bust 
        if (Player.getHandSum() > 21 && d.getHandSum() > 21) System.out.println("draw"); //both bust, draw
        else if (d.getHandSum() > 21) System.out.println("opp bust, you win") ;//opp bust, char wins 
        else if (Player.getHandSum() > 21) System.out.println("you bust, you lose"); //chara bust, opp less than 21, opp wins 
        else { //both less than 21 
            if (Player.getHandSum() > d.getHandSum()) System.out.println("you are higher, win") ; //char has higher value, char wins
            else System.out.println("you are lower, lose") ; //opp has higher value, opp wins 
        }
                
        hand.clear();    
                
    }
    
}
