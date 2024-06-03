
package arachne;

public class Human extends NPC {
    private Powerup reward; 
    private String filename; 
    
    public Human(String name, Powerup p, String fn) {
        super(name); 
        this.reward = p;
        this.filename = fn; 
    }
    
    public String getFn() {
        return this.filename; 
    }
    
    public Powerup getReward() {
        return this.reward; 
    }
    
    /**
     * rewards player with their owned powerup 
     * they take the player's gained silk in return 
     */    
    public void reward() {
        Inventory.store(this.reward, 1); 
        Inventory.silk -= this.reward.getPrice(); 
    }
}
