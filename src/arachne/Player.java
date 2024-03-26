
package arachne;

public class Player {
    private String name; 
    private float popMeter = 0; 
    private int atk; //attack with fists
    private int def; //default def  
    private int hp; 
    private int maxHp = 20; 
    private Coat coat; 
    private Needle needle; 
    private boolean curDef = false; //checks if player is "defending" for this round 
    //public Storage pStorage; 
    
    //private Quest curQuest; 
    
    public Player(String name) {
        this.name = name; 
        this.hp = maxHp; 
    }   
    
    public void setCoat(Coat c) {
        this.coat = c; 
        this.def = c.getDefBonus();
    }
    public void setNeedle(Needle n){
        this.needle = n; 
        this.atk = n.getAtkBonus(); 
    }
    
    public String getName() {
        return this.name; 
    }
    public float getPopMeter() {
        return this.popMeter; 
    }
    public int getAtk() {
        return this.atk; 
    }
    public int getDef() {
        return this.def; 
    }    
    public int getHp() {
        return this.hp; 
    }    
    public int getMaxHp() {
        return this.maxHp; 
    }
    public Coat getCoat() {
        return this.coat; 
    }
    
    public Needle getNeedle() {
        return this.needle; 
    }
    
    public boolean getCurDef() {
        return this.curDef; 
    }
    
    public void reduceHP(int i){
        this.hp-=i;
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
        this.curDef = true; 
        System.out.println(this.getName() + " used defend! Damage will be reduced until next turn."); 
    }
    public void removeDef() {
        this.curDef = false; 
    }
    
//    public void use(Powerup p, int amt) {
//        //this.pStorage.use(p, amt); 
//        System.out.println(this.getName() + " used " + amt + " " + p.getName()); 
//        this.hp += p.getHpInc();         
//        this.def += p.getDefInc(); 
//        this.atk += p.getAtkInc(); 
//        this.maxHp += p.getMaxHpInc(); 
//        this.popMeter += p.getPopInc(); 
//        if (p.getHpInc()>0) System.out.println("hp was increased by " + p.getHpInc());         
//        if (p.getDefInc()>0) System.out.println("def was increased by " + p.getDefInc()); 
//        if (p.getAtkInc()>0) System.out.println("atk was increased by " + p.getAtkInc()); 
//        if (p.getMaxHpInc()>0) System.out.println("max hp was increased by " + p.getMaxHpInc()); 
//        if (p.getPopInc()>0) System.out.println("popularity was increased by " + p.getPopInc()); 
//
//    }
        
//    public void interact(Human h) {
//        System.out.println(h.getDialogue()); 
//    }
//    
//    public void setQuest(Quest q) {
//        curQuest = q; 
//    }
    
//    public void pursueQuest() {
//        curQuest.complete(); 
//        this.popMeter += curQuest.getReward(); 
//    }
    

}
