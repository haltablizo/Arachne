
package arachne;

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
    

}
