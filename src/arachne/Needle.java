
package arachne;

public class Needle extends Equipment {
    private int atkBonus; 
    
    public Needle(String name, int atkBonus) {
        super(name); 
        this.atkBonus = atkBonus; 
    }
    
    public int getAtkBonus() {
        return this.atkBonus; 
    }
}
