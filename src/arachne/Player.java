
package arachne;

public class Player {
    private static String name; 
    private static float popMeter = 0; 
    private static int atk = 1; //attack with fists
    private static int def = 1; //default def  
    private static int hp; 
    private static int maxHp = 20; 
    private static Coat coat; 
    private static Needle needle; 
    private static boolean curDef = false; //checks if player is "defending" for this round 
    public Inventory pStorage; 
    
    //private Quest curQuest; 
    
    public Player(String n) {
        name = n; 
        hp = maxHp; 
    }
    
    public void setCoat(Coat c) {
        coat = c; 
        def = c.getDefBonus();
    }
    public void setNeedle(Needle n){
        needle = n; 
        atk = n.getAtkBonus(); 
    }
    
    public String getName() {
        return name; 
    }
    public float getPopMeter() {
        return popMeter; 
    }
    public int getAtk() {
        return atk; 
    }
    public int getDef() {
        return def; 
    }    
    public int getHp() {
        return hp; 
    }    
    public int getMaxHp() {
        return maxHp; 
    }
    public Coat getCoat() {
        return coat; 
    }
    
    public Needle getNeedle() {
        return needle; 
    }
    
    public boolean getCurDef() {
        return curDef; 
    }
    
    public void reduceHP(int i){
        hp-=i;
    }

    public void attack(Spider s) {
        if (this.getAtk() > s.getDef()) {

            s.reduceHP(this.getAtk()-s.getDef()); 
                 
            if (s.getHp() > 0); //still alive
            else {
                //dead 
                //this.pStorage.pickUpSilk(s.getAmtOfSilk()); 
            }
            
            
        }
        else {
            System.out.println(this.getName() + " did not do any damage!"); 
        }
    }
    public void defend() { 
        curDef = true; 
        System.out.println(this.getName() + " used defend! Damage will be reduced until next turn."); 
    }
    public void removeDef() {
        curDef = false; 
    }
    
    public void use(Powerup p, int amt) {
        pStorage.use(p, amt); 
        hp += p.getHpInc();         
        def += p.getDefInc(); 
        atk += p.getAtkInc(); 
        maxHp += p.getMaxHpInc(); 
    }
        
    public void setQuest(Quest q) {
        curQuest = q; 
    }
    
    public void pursueQuest() {
        curQuest.complete(); 
        this.popMeter += curQuest.getReward(); 
    }
    

}
