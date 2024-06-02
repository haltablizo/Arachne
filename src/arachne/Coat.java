
package arachne;

public class Coat extends Equipment {
    private int defBonus;  
    
    public Coat(String name, String fn, int x) {
        super(name, fn);
        this.defBonus = Player.getDef()*x; 
    }
    
    public int getDefBonus(){
        return this.defBonus; 
    }
}
