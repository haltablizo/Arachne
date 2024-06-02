
package arachne;

public class Human extends NPC {
    private Powerup reward; 
    
    public Human(String name, Powerup p) {
        super(name); 
        this.reward = p;
    }
    
    public void reward() {
        Inventory.store(this.reward, 1); 
    }
}
