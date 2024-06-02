
package arachne;

public class Needle extends Equipment {
    private int atkBonus; 
    
    public Needle(String name, String fn, int x) {
        super(name, fn); 
        this.atkBonus = Player.getAtk() * x; 
    }
    
    public int getAtkBonus() {
        return this.atkBonus; 
    }
}
