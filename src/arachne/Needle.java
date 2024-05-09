
package arachne;

public class Needle extends Equipment {
    private int atkBonus; 
    
    public Needle(String name, String fn, int atkBonus) {
        super(name, fn); 
        this.atkBonus = atkBonus; 
    }
    
    public int getAtkBonus() {
        return this.atkBonus; 
    }
}
