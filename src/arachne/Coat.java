
package arachne;

public class Coat extends Equipment {
    private int defBonus;  
    
    public Coat(String name, String fn, String desc, int x) {
        super(name, fn, desc);
        this.defBonus = Player.getDef()*x; 
    }
    
    public int getDefBonus(){
        return this.defBonus; 
    }
}
