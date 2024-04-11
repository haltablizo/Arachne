
package arachne;

public class Powerup implements Storeable {
    private String name; 
    private int hpInc;     
    private int defInc; 
    private int atkInc; 
    private int maxHpInc;
    
    private String desc; 
    private String filename; 
    

    
    public Powerup(String n, int h, int d, int a, int m, String desc, String fn) {
        this.name = n; 
        this.hpInc = h;        
        this.defInc = d; 
        this.atkInc = a; 
        this.maxHpInc = m; 
        this.desc = desc; 
        this.filename = fn; 
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
    public String getDesc() {
        return this.desc; 
    }
    public String getFn() {
        return this.filename; 
    }
    
    @Override
    public void store() {
        System.out.println("Powerup " + name + " was stored."); 
    }
}
