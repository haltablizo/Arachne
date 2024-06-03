
package arachne;

public class Needle extends Equipment {
    private int atkBonus; 
    
    public Needle(String name, String fn, String desc, int x) {
        super(name, fn, desc); 
        this.atkBonus = Player.getAtk() * x; 
    }
    
    public int getAtkBonus() {
        return this.atkBonus; 
    }
}
