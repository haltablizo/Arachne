
package arachne;

public class Powerup implements Storeable {
    private String name; 
    private int hpInc;     
    private int defInc; 
    private int atkInc; 
    private int maxHpInc;    
    private int popInc; 

    
    public Powerup(String n, int h, int d, int a, int m, int p) {
        this.name = n; 
        this.hpInc = h;        
        this.defInc = d; 
        this.atkInc = a; 
        this.maxHpInc = m; 
        this.popInc = p; 
    }
    
    public String getName() { 
        return this.name; 
    }
    public int getHpInc() {
        return this.hpInc; 
    }    
    public int getDefInc() {
        return this.defInc; 
    }    
    public int getAtkInc() {
        return this.atkInc; 
    }    
    public int getMaxHpInc() {
        return this.maxHpInc; 
    }    
    public int getPopInc() {
        return this.popInc; 
    }
    
    @Override
    public void store() {
        System.out.println("Powerup " + name + " was stored."); 
    }
}
