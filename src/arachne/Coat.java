
package arachne;

public class Coat extends Equipment {
    private int defBonus;  
    
    public Coat(String name, String fn, int defBonus) {
        super(name, fn);
        this.defBonus = defBonus; 
    }
    
    public int getDefBonus(){
        return this.defBonus; 
    }
}
