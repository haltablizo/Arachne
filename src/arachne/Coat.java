
package arachne;

public class Coat extends Equipment {
    private int defBonus;  
    
    public Coat(String name, int defBonus) {
        super(name);
        this.defBonus = defBonus; 
    }
    
    public int getDefBonus(){
        return this.defBonus; 
    }
}
