
package arachne;

public class Divine extends NPC {
    private Equipment reward; 
    private Needle owned; 
    
    public Divine(String name, Equipment e) {
        super(name); 
        this.reward = e; 
    }
    
    public Equipment getReward() {
        return this.reward; 
    }
    
}
