
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
    private static Coat coat = null; 
    private static Needle needle = null; 
    private static boolean curDef = false; //checks if player is "defending" for this round 
    public static Inventory pStorage; 
    public static int coordX = 0; 
    public static int coordY = 0; 
    
    
    public static int level = 1; 
    
    public static List<Integer> hand = new ArrayList();
    
    public static void setHp(int h) {
        hp = h; 
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
    
    /**
     * 
     * @param i reduce hp with amount i
     */
    public static void reduceHP(int i){
        hp-=i;
    }
    
    /**
     * 
     * @param s attacks spider s
     * @return boolean whether or not spider was defeated 
     */
    public static boolean[] attack(Spider s) {
        
        boolean spidState = false; 
        boolean playerState = false; 
        
        s.reduceHP(atk); 

        if (s.getHp() > 0) {
            s.attack(); 
            if (Player.getHp() == 0) {
                playerState = true; 
            }
        } 
        
        else {
            s.resetHp(); 
            //pStorage.pickUpSilk(s.getAmtOfSilk()); 
            spidState = true; 
        }      
        boolean[] a = {spidState, playerState}; 

        return a; 

    }
    
    /**
     * 
     * @param s defends against spider s 
     */
    public static void defend(Spider s) { 
        curDef = true; 
        s.attack();
    }
    
    /**
     * removes def status after defending for the previous turn
     */
    public static void removeDef() {
        curDef = false; 
    } 
    
    /**
     * 
     * @param p use powerup p 
     * @param amt uses amount amt of powerup p 
     */
    public static void use(Powerup p, int amt) {
        if (hp + p.getHpInc() >= maxHp) hp = maxHp;  
        else hp += p.getHpInc(); 
        def += p.getDefInc(); 
        atk += p.getAtkInc(); 
        maxHp += p.getMaxHpInc(); 
    }
    
    /**
     * 
     * @return returns the sum of the player's hand during divine battle
     */
    public static int getHandSum() {
        int s = 0; 
        for (int i : hand) s = s + i;
        return s; 
    }
 
    /**
     * 
     * @param d uses a hit against divine d during their divine battle
     * @return returns a integer array consisting of card value, current hand size, and bust status 
     */
    public static int[] hit(Divine d) {
        int charCardIndex = (int)(Math.random() * (d.deck.size()));
        int tempCardVal = d.deck.get(charCardIndex); 
        int bust = 3; //default 
        
        hand.add(tempCardVal);
        d.deck.remove(charCardIndex);
        
        int oppCardIndex = (int)(Math.random() * (d.deck.size()));
        d.hit(d.deck.get(oppCardIndex)); 
        d.deck.remove(oppCardIndex);

        
        //if player deck size == 5, or sum exceeds 21 
        if (hand.size() == 5 || Player.getHandSum() > 21) {
            int a = endDivineGame(d); 
            switch (a) {
            case 0: 
                bust = 0; 
                break;
            case 1: 
                bust = 1; 
                break; 
            case 2: 
                bust = 2; 
                break; 
            }
        }
        
        int[] state = {tempCardVal, hand.size(), bust}; 
        return state; 
    }
    
    /**
     * 
     * @param d ending the divine game with divine d
     * @return the status of the player. 2 for draw, 1 for win, and 0 for lose
     */
    public static int endDivineGame(Divine d) { //happens when stand, or number of cards == 5, or bust 
        int status; //2 -> draw , 1 -> win, 0 -> lose
        if (Player.getHandSum() > 21 && d.getHandSum() > 21) status =  2; //both bust, draw
        else if (d.getHandSum() > 21) status = 1;//opp bust, char wins 
        else if (Player.getHandSum() > 21) status = 0; //chara bust, opp less than 21, opp wins 
        else { //both less than 21 
            if (Player.getHandSum() > d.getHandSum()) status = 1; //char has higher value, char wins
            else if (Player.getHandSum() == d.getHandSum()) status = 2; 
            else status = 0; //opp has higher value, opp wins 
        }
        
                 
        return status; 
    }
        
    
}
